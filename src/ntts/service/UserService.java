package ntts.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ntts.entity.User;
import ntts.dao.*;
@Transactional
@Service("userService")
public class UserService {
	@Autowired
	private UserDAO userDAO;
/*	public UserDAO getUserDAO() {
		return userDAO;
	}*/
	public UserService(){
		System.out.println("fuck service");
	}
	public String createUser(String name,String pass){
		User user=new User();
		user.setUserName(name);
		user.setPassWord(pass);
		userDAO.addUser(user);
		return "success";
	}
	public String userLogin(String name,String pass){
		User user = userDAO.findUser(name,pass);
		return user!=null?"success":"error";
	}
	
	public String delUser(String name,String pass){
		userDAO.delUser(name,pass);
		return "success";
	}
/*	public User userLogin(String name,String pass){
		return userDAO.userLogin(name, pass);
	}*/
}
