package ntts.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import ntts.entity.User;
import ntts.service.UserService;
@Controller
public class UserAction extends ActionSupport{
	@Autowired
	private UserService userService;
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

	public String userLogin() throws Exception{
		System.out.println("fuck1");
		System.out.println(username);
		System.out.println(password);
		System.out.println(userService);
		String result=userService.userCreate(username,password);
		return result;
		//System.out.println("fuck");
	}
}
