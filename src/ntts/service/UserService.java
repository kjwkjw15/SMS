package ntts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ntts.entity.User;
import ntts.dao.*;

@Service
public class UserService {
	@Autowired
	private UserDAO userDAO;
	public UserService(){
		System.out.println("fuck service");
	}
	public User userLogin(String name,String pass){
		return userDAO.userLogin(name, pass);
	}
}
