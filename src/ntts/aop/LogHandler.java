package ntts.aop;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.aspectj.lang.JoinPoint;


public class LogHandler
{
	private static Logger logger = LogManager.getLogger(LogHandler.class.getName());
	
	//切入点之前的动作
    public void printLog(JoinPoint jp) {
    	String str=jp.getTarget().getClass().getName() + "." + jp.getSignature().getName() + "()";
        System.out.println(str + " at " + new Date());
    }
    
    //切入点报错后的动作
    public void throwException(Throwable e) {
    	logger.error(e.getStackTrace()[0]);
    }
}
