package ntts.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ntts.entity.User;
import ntts.dao.myBaseDAO;

@Repository("userDAO")
public class UserDAO extends myBaseDAO<User> {
	@Resource
	private SessionFactory sessionFactory; 
	private Session getSession() { 
		//return this.sessionFactory.openSession();  
		return sessionFactory.getCurrentSession();
	}
	public UserDAO(){
		System.out.println("fuck userDAO");
	}
	
	public void delUser(String name,String pass) {
		User user = findUser(name,pass);
		super.delete(user);
	}
	public User findUser(String name,String pass) {
		Session s = this.getSession();
		String hql = "from User where userName=? and passWord=?";
		Query query = s.createQuery(hql);
		query.setParameter(0, name);
		query.setParameter(1, pass);
		List<User> list=query.list();
		//System.out.println(list.get(0).getUserName());
		return list.size()==1?list.get(0):null;
	}
/*	public User userLogin(String name,String pass){
		List<User> obj=(List<User>) getHibernateTemplate().find("from User where userName=? and passWord=?",name,pass);
		return obj.size()>0?obj.get(0):null;
	}*/
}
