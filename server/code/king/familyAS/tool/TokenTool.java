package king.familyAS.tool;

import king.familyAS.tool.MD5Utils;
import king.familyAS.tool.Base64Utils;

public class TokenTool{
   public final static int FLAG_PLAIN_TEXT=0x00;
   public final static int FLAG_SIMPLE_MD5=0x01;
   private static int MIN_LENGTH=6;
   private static int LIMIT_LENGTH=100;

   public static String createToken(String p0,String p1,int flag){
        String token=null;
        if(p0 != null && p1 != null){
	   if(p0.length() > 2            && p1.length() > MIN_LENGTH && 
              p0.length() < LIMIT_LENGTH && p1.length() < LIMIT_LENGTH){
	        switch(flag){
                    case FLAG_PLAIN_TEXT:
                         token = plainText(p0,p1);
	            break;
		    case FLAG_SIMPLE_MD5:
		         token = simpleMD5(p0,p1);
	            break;
		}
	   }
	}
	return token;
   }

   private static String plainText(String p0,String p1){
        return new String(Base64Utils.encoder(new StringBuffer(p1+p0).
		                 reverse().
				 toString().
				 getBytes()));
   }

   private static String simpleMD5(String p0,String p1){
        return MD5Utils.convert32(p1+new StringBuffer(p0).reverse().toString());
   }
}
