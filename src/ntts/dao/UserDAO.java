package ntts.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ntts.entity.User;
import ntts.dao.myBaseDAO;

@Repository("userDAO")
public class UserDAO extends myBaseDAO<User> {
	
	public UserDAO(){
		System.out.println("fuck userDAO");
	}
	public String insertUser(String name,String password){
		User user=new User();
		user.setUserName(name);
		user.setPassWord(password);
		insert(user);
		return "success";
	}
	
/*	public User userLogin(String name,String pass){
		List<User> obj=(List<User>) getHibernateTemplate().find("from User where userName=? and passWord=?",name,pass);
		return obj.size()>0?obj.get(0):null;
	}*/
}
