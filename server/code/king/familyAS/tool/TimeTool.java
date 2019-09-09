package king.familyAS.tool;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

import java.util.Date;
import java.util.TimeZone;

import java.net.InetAddress;
import java.text.SimpleDateFormat;

import king.familyAS.tool.LogTool;

public class TimeTool {

	private final static TimeTool THIS = new TimeTool();

	private final static String aliyun = "ntp1.aliyun.com";
	private final static String sjtu = "ntp.sjtu.edu.cn";

        private final static String DEFAULT_NTP_SERVER = aliyun;

	private final static NTPUDPClient timeClient = new NTPUDPClient();
	private final static SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SS");

	public static Date now(){
           return now(null);
	}

	public static Date now(String ntpServer){
           Date date = null;

	   String timeServerUrl = ntpServer;
           if(timeServerUrl == null){
               timeServerUrl = DEFAULT_NTP_SERVER;
	   }

	   try {
                 InetAddress timeServerAddress = InetAddress.getByName(timeServerUrl);
                 TimeInfo timeInfo = timeClient.getTime(timeServerAddress);
                 date = timeInfo.getMessage().getTransmitTimeStamp().getDate();
                 LogTool.info(THIS,"NTP服务器时间获取成功:"+formatTime(date.getTime(),"Asia/Shanghai"));
           } catch (Exception e) {
                 e.printStackTrace();
           }
	   return date;
        }

	public static String formatTime(long time,String zone){
		 format.setTimeZone(TimeZone.getTimeZone(zone)); 
	         return format.format(time);
	}
}
