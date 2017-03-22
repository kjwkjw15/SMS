package ntts.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import ntts.entity.User;

@Repository
public class BaomingDAO extends HibernateDaoSupport{
	public BaomingDAO(){
		System.out.println("fuck BaomingDAO");
	}

	public User userQuery(String name,String pass){
		List<User> obj=(List<User>) getHibernateTemplate().find("from User where userName=? and passWord=?",name,pass);
		return obj.size()>0?obj.get(0):null;
	}
}
