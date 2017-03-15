package ntts.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import ntts.entity.User;
import ntts.dao.

@Repository
public class UserDAO {
	public UserDAO(){
		System.out.println("fuck DAO");
	}
	
	public User userLogin(String name,String pass){
		List<User> obj=(List<User>) getHibernateTemplate().find("from User where userName=? and passWord=?",name,pass);
		return obj.size()>0?obj.get(0):null;
	}
}
