package ntts.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import ntts.entity.User;
import ntts.service.UserService;
import org.apache.struts2.ServletActionContext;


@Component
public class UserAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private String loginJsonObj;
	public UserAction(){
		System.out.println("fuck action");
	}
	public String getLoginJsonObj() {
		return loginJsonObj;
	}
	public void setLoginJsonObj(String loginJsonObj) {
		this.loginJsonObj = loginJsonObj;
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
		String result=userService.createUser(username,password);
		return "success";
		//System.out.println("fuck");
	}
	
	public String userLogin() throws Exception{
		//this.result=userService.userLogin(username,password);
		HttpServletRequest request = ServletActionContext.getRequest();
		
		username = request.getParameter("name");
		password = request.getParameter("password");
		
		String result = userService.userLogin(username,password);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name","kjw,"+username);
		map.put("password","123,"+password);
		JSONObject obj = JSONObject.fromObject(map);
		loginJsonObj=obj.toString();
		
		return result;
	}
	public String userDel() throws Exception{
		String result=userService.delUser(username,password);
		return result;
	}
	
}
