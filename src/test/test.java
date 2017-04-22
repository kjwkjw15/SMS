package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.sf.json.JSONArray;
import ntts.entity.User;

import org.apache.commons.lang.exception.*;

public class test {
/*	@BeforeClass
    public static void enter()
	{
        System.out.println("进来了！");
    }
	@Before
    public void init()
	{
        System.out.println("正在初始化。。");
        System.out.println("初始化完毕！");
    }
	@After
    public void destroy()
	{
        System.out.println("销毁对象。。。");
        System.out.println("销毁完毕！");
    }
	@AfterClass
    public static void leave()
	{
        System.out.println("离开了！");
    }*/

	public void fuck() {
		
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("123");
		JSONArray jsonArray = net.sf.json.JSONArray.fromObject(list);
		System.out.println(jsonArray.toString());
		System.out.println("fuck");
	}
	

	@Test
    public void inteceptorTest(){  
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User) ctx.getBean("user");
		user.setUserName("kjw");
		user.setId(1);
		user.setPassWord("abc");
		System.out.println("===========");

	} 

}
