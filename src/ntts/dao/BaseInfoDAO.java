package ntts.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ntts.entity.BaseInfo;
import ntts.dao.myBaseDAO;

@Repository("baseInfoDAO")
public class BaseInfoDAO extends myBaseDAO<BaseInfo> {
	@Resource
	private SessionFactory sessionFactory; 
	private Session getSession() { 
		//return this.sessionFactory.openSession();  
		return sessionFactory.getCurrentSession();
	}
	public BaseInfoDAO(){
		System.out.println("fuck userDAO");
	}
	
	public void addBaseInfo(BaseInfo entity) {
		insert(entity);  
	}
	public void delBaseInfo(String idcard) {
		BaseInfo baseInfo = findBaseInfo(idcard);
		delete(baseInfo);
	}
	public BaseInfo findBaseInfo(String idcard) {
		Session s = this.getSession();
		String hql = "from BaseInfo where idCard=?";
		Query query = s.createQuery(hql);
		query.setParameter(0, idcard);
		List<BaseInfo> list=query.list();
		//System.out.println(list.get(0).getUserName());
		return list.size()==1?list.get(0):null;
	}
/*	public User userLogin(String name,String pass){
		List<User> obj=(List<User>) getHibernateTemplate().find("from User where userName=? and passWord=?",name,pass);
		return obj.size()>0?obj.get(0):null;
	}*/
}
