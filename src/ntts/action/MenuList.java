package ntts.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import ntts.entity.SysMenu;
import ntts.service.SysMenuService;

@Component
public class MenuList extends ActionSupport{
	@Autowired
	private SysMenuService sysMenuService;
	private List menulist;
	public List getMenuList() {
		return menulist;
	}

	public void setMenuList(List menuList) {
		this.menulist = menuList;
	}
	public SysMenuService getSysMenuService() {
		return sysMenuService;
	}
	public void setSysMenuService(SysMenuService sysMenuService) {
		this.sysMenuService = sysMenuService;
	}

	public String menuList(){
		System.out.println("fuck menu");
		menulist=new ArrayList<HashMap<String,String>>();
		
		List<SysMenu> sysMenuList=sysMenuService.findAll();
		
		for (int i=0;i<sysMenuList.size();i++){
			Map<String,String> json=new HashMap<String,String>();
			json.put("menuId", sysMenuList.get(i).getMenuId());
			json.put("menuName", sysMenuList.get(i).getMenuName());
			json.put("perentId", sysMenuList.get(i).getPerentId());
			menulist.add(json);
		}
		System.out.println(menulist.size());
		return "success";
	}


}
