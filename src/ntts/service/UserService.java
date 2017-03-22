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
	private myBaseDAO myBaseDAO;
/*	public UserDAO getUserDAO() {
		return userDAO;
	}*/
	public UserService(){
		System.out.println("fuck service");
	}
	public String userCreate(String name,String pass){
		System.out.println("fuck2");
		User user=new User();
		user.setUserName(name);
		user.setPassWord(pass);
		myBaseDAO.insert(user);
		return "success";
	}
/*	public User userLogin(String name,String pass){
		return userDAO.userLogin(name, pass);
	}*/
}
