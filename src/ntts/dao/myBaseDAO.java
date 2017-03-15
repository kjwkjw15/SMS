package ntts.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class myBaseDAO<T> {
	protected Class<T> entityClazz; 
	@Resource
	protected SessionFactory sessionFactory; 
	
	public myBaseDAO(){
		Type type = getClass().getGenericSuperclass();  
        if (type instanceof ParameterizedType) {  
            this.entityClazz = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];  
        } else {  
            this.entityClazz = null;  
        }  
	}
	
	  
/*    public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    }*/
	protected Session getSession() {  
		//return this.sessionFactory.openSession();  
		return this.sessionFactory.getCurrentSession();
	}
	
	

}
