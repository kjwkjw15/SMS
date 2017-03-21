package ntts.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import ntts.entity.User;
import ntts.dao.myBaseDAO;

@Repository("userDAO")
public class UserDAO extends myBaseDAO<User> {
	public UserDAO(){
		System.out.println("fuck DAO");
	}
	public String insertUser(User user){
		insert(user);
		return "success";
	}
	
/*	public User userLogin(String name,String pass){
		List<User> obj=(List<User>) getHibernateTemplate().find("from User where userName=? and passWord=?",name,pass);
		return obj.size()>0?obj.get(0):null;
	}*/
}
