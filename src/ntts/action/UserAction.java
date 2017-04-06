package ntts.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import ntts.entity.User;
import ntts.service.UserService;


@Component
public class UserAction extends ActionSupport{
	@Resource(name="userService")
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private String username;
	private String password;
	
	public UserAction(){
		System.out.println("fuck action");
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String userRegister() throws Exception{
		System.out.println("fuck1");
		System.out.println(username);
		System.out.println(password);
		//UserService userService=new UserService();
		System.out.println(userService);
		String result=userService.userCreate(username,password);
		return result;
		//System.out.println("fuck");
	}
	
	public String userLogin() throws Exception{
		String result=userService.userLogin(username,password);
		return result;
	}
}
