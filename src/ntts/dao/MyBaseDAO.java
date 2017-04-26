package ntts.dao;

import java.lang.reflect.ParameterizedType;

import java.lang.reflect.Type;
import java.util.ArrayList;
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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import ntts.entity.User;

@Repository("MyBaseDAO")
public class MyBaseDAO<T> {
	private Class<T> entityClazz; 
	@Resource
	private SessionFactory sessionFactory; 
/*	@Resource
	private HibernateTransactionManager htm;*/
	private Session getSession() { 
		//return this.sessionFactory.openSession();  
		return sessionFactory.getCurrentSession();
	}
	
	public MyBaseDAO(){
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
	
	public void insert(T entity) {
		System.out.println(sessionFactory);
		System.out.println(this.getSession());
		this.getSession().save(entity);
	}
	
    public void delete(T entity) {
    	System.out.print("delete");
		this.getSession().delete(entity);  
	}
    
    public JSONArray findBySQL(String sql, String jsonFieldsString, Object... propertyValues) {
    	Query queryObject = this.getSession().createQuery(sql);
    	for (int i=0;propertyValues !=null && i<propertyValues.length;i++ ){
    		queryObject.setParameter(i,propertyValues[i]);
    	}
    	List<Object[]> list = queryObject.list();
    	String[] jsonFieldArray = jsonFieldsString.split(",");
		if(list==null || list.size()==0) {
			return new JSONArray();
		}
    	for(int i=0; i<jsonFieldArray.length; i++) {
			jsonFieldArray[i]= jsonFieldArray[i].trim(); 
		}
    	JSONArray jsonArray= new JSONArray();
		for (int i=0;i<list.size();i++){
			JSONObject jsonObject = new JSONObject();
			for(int j=0;j<jsonFieldArray.length;i++){
				jsonObject.put(jsonFieldArray[j], list.get(i)[j]);
			}
			jsonArray.add(jsonObject);
		}
		return jsonArray;
    }

/*	public List<T> findByProperty(Class<T> entity, Object propertyValue) {
		 this.getSession().find(entity, propertyValue);
	}*/
	
/*
	public void update(T entity) {
		this.getSession().update(entity);  
	}
	
	public void saveOrUpdate(T entity) {  
		this.getSession().saveOrUpdate(entity);  
	}  */
}
