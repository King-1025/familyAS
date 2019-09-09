package king.familyAS.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class  LogTool{
        private final static LogTool THIS = new LogTool();

	public static void system(String message){
	       System.out.println(message);
	}

	public static void info(String message){
               info(THIS,message);
	}

	public static void debug(String message){
               debug(THIS,message);
	}

	public static void error(String message){
               error(THIS,message);
	}

	public static void trace(String message){
               trace(THIS,message);
	}

	public static void warn(String message){
               warn(THIS,message);
	}

	public static void info(Object object,String message){
               route(0,object,message);
	}

	public static void debug(Object object,String message){
               route(1,object,message);
	}

	public static void error(Object object,String message){
               route(2,object,message);
	}

	public static void trace(Object object,String message){
               route(3,object,message);
	}

	public static void warn(Object object,String message){
               route(4,object,message);
	}

	private static void route(int flag,Object object,String message){
	       Logger logger = LoggerFactory. getLogger(object.getClass());
	       switch(flag){
			case 0:
	                   logger.info(message);
			   break;
			case 1:
	                   logger.debug(message);
			   break;
			case 2:
	                   logger.error(message);
			   break;
			case 3:
	                   logger.trace(message);
			   break;
			case 4:
	                   logger.warn(message);
			   break;
			default:
			   system(message);
			   break;
		}
	}
}
