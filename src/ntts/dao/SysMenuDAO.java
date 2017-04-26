package ntts.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ntts.entity.BaseInfo;
import ntts.entity.SysMenu;

@Repository("sysMenuDAO")
public class SysMenuDAO extends MyBaseDAO<BaseInfo>{
	@Resource
	private SessionFactory sessionFactory; 
	private Session getSession() { 
		//return this.sessionFactory.openSession();  
		return sessionFactory.getCurrentSession();
	}
	
	public List<SysMenu> findAll(){
		Session s=this.getSession();
		List<SysMenu> menulist = new ArrayList<SysMenu>();
		String hql = "from SysMenu where isValid=1";
		Query query=s.createQuery(hql);
		menulist=query.list();
		return menulist;
	}
	
}
