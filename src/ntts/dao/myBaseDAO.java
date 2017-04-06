package ntts.dao;

import java.lang.reflect.ParameterizedType;

import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ntts.entity.User;

@Repository("myBaseDAO")
public class myBaseDAO<T> {
	private Class<T> entityClazz; 
	@Resource
	private SessionFactory sessionFactory; 
/*	@Resource
	private HibernateTransactionManager htm;*/
	private Session getSession() { 
		//return this.sessionFactory.openSession();  
		return sessionFactory.getCurrentSession();
	}
	
	public myBaseDAO(){
		System.out.println("fuck myBaesDAO");
		//System.out.println(sessionFactory.getCurrentSession());
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
	
	public void insert(T entity) {
		System.out.println(sessionFactory);
		System.out.println(this.getSession());
		this.getSession().save(entity);  
	}
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public User findUser(String name,String pass) {
		Session s = this.getSession();
		String hql = "from User where userName=? and passWord=?";
		Query query = s.createQuery(hql);
		query.setParameter(0, name);
		query.setParameter(1, pass);
		List<User> list=query.list();
		
		return list.size()==1?list.get(0):null;
	}

/*	public void delete(T entity) {
		this.getSession().delete(entity);  
	}



	public void update(T entity) {
		this.getSession().update(entity);  
	}
	
	public void saveOrUpdate(T entity) {  
		this.getSession().saveOrUpdate(entity);  
	}  */
}
