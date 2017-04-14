package ntts.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sf.json.JSONArray;
import ntts.entity.BaseInfo;
import ntts.entity.User;
import ntts.dao.*;
@Transactional
@Service("baseInfoService")
public class BaseInfoService {
	@Autowired
	private BaseInfoDAO baseInfoDAO;
	public BaseInfoService(){
		System.out.println("fuck service");
	}
	public String saveBaseInfo(BaseInfo baseInfo){
		baseInfoDAO.addBaseInfo(baseInfo);
		//baseInfoDAO.insert(baseInfo);
		BaseInfo result=baseInfoDAO.findBaseInfo(baseInfo.getIdCard());
		return result==null?"error":"success";
	}
	public JSONArray getBaseInfoJsonArray(){
		String sql = "select idCard,name,age,birthdate,sex,companyName,phone,writedate from base_Info";
		return baseInfoDAO.findBySQL(sql, "idCard,name,age,birthdate,sex,companyName,phone,writedate");
		
	}

/*	public User userLogin(String name,String pass){
		return userDAO.userLogin(name, pass);
	}*/
}
