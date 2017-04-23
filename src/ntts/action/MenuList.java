package ntts.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.mysql.fabric.xmlrpc.base.Array;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

@Component
public class MenuList extends ActionSupport{
	private List menuList;
	
	public List getMenuList() {
		return menuList;
	}

	public void setMenuList(List menuList) {
		this.menuList = menuList;
	}

	public String menuList(){
		System.out.println("fuck menu");
		Map<String,String> json=new HashMap<String,String>();
		menuList=new ArrayList<HashMap<String,String>>();
		json.put("name", "a");
		menuList.add(json);
		json.put("name", "b");
		menuList.add(json);
		json.put("name", "c");
		menuList.add(json);
		System.out.println(menuList.size());
		return "success";
	}
}
