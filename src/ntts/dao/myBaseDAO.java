package ntts.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class myBaseDAO<T> {
	private Class<T> entityClazz; 
	@Resource
	private SessionFactory sessionFactory; 
	Session getSession() { 
		//return this.sessionFactory.openSession();  
		return this.sessionFactory.getCurrentSession();
	}
	
/*	public myBaseDAO(){
		Type type = getClass().getGenericSuperclass();  
        if (type instanceof ParameterizedType) {  
            this.entityClazz = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];  
        } else {  
            this.entityClazz = null;  
        }  
	}*/
	
	  
/*    public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    }*/

	public void delete(T entity) {
		this.getSession().delete(entity);  
	}

	public void insert(T entity) {
		this.getSession().save(entity);  
	}

	public void update(T entity) {
		this.getSession().update(entity);  
	}
	
	public void saveOrUpdate(T entity) {  
		this.getSession().saveOrUpdate(entity);  
	}  
}
