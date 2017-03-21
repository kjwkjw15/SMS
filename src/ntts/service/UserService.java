package ntts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ntts.entity.User;
import ntts.dao.*;

@Service("userService")
public class UserService {
	@Autowired
	private UserDAO userDAO;
	public UserService(){
		System.out.println("fuck service");
	}
	public String userCreate(String name,String pass){
		System.out.print("fuck2");
		User user=new User(name,pass);
		userDAO.insert(user);
		return "success";
	}
/*	public User userLogin(String name,String pass){
		return userDAO.userLogin(name, pass);
	}*/
}
