package com.ty.sms.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.ty.sms.entity.BaseInfo;
import com.ty.sms.service.BaseInfoService;

import net.sf.json.JSONArray;


@Component
public class BaseInfoAction extends ActionSupport{
	@Autowired
	private BaseInfoService baseInfoService;
	private JSONArray baseInfoJsonArray;
	
	private BaseInfo baseInfo;
	public BaseInfo getBaseInfo() {
		return baseInfo;
	}
	public void setBaseInfo(BaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}
	
	public String saveBaseInfo() throws Exception{
		String result=baseInfoService.saveBaseInfo(baseInfo);
		return result;
	}
	
	public String query_BaseInfo_JsonArray() {
		try {			
			//baseInfoJsonArray = baseInfoService.getBaseInfoJsonArray();
			baseInfoJsonArray = baseInfoService.getBaseInfoJsonArray();
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
