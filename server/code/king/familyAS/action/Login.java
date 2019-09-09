package king.familyAS.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import king.familyAS.model.Result;
import king.familyAS.model.ActionFlag;
import king.familyAS.model.ActionResult;
import king.familyAS.model.StateGuide;

import king.familyAS.service.UserService;
import king.familyAS.service.TokenService;
import king.familyAS.service.StateService;

import king.gen.entity.User;
import king.gen.entity.Token;

import king.familyAS.tool.TokenTool;
import king.familyAS.tool.CheckTool;
import king.familyAS.tool.UuidTool;
import king.familyAS.tool.TimeTool;
import king.familyAS.tool.LogTool;

@Component
public class Login extends Action{

   private final static ActionFlag flag = ActionFlag.LOGIN;

   private final static long liveTime = 10*60*1000;

   @Autowired
   private UserService userService;

   @Autowired
   private TokenService tokenService;
   
   @Autowired
   private StateService stateService;

   private String loginName;
   private String loginPassword;

   public Action accept(HttpServletRequest request){
          return accept(request.getParameter(flag.getKeys()[0]),
   	                request.getParameter(flag.getKeys()[1]));
   }

   public Action accept(String loginName,String loginPassword){
          this.loginName = loginName;
	  this.loginPassword = loginPassword;
	  return this;
   }

   public ActionResult perform(){
          Result result=new Result(FAILED,null);
	  String name = this.loginName;
	  String password = this.loginPassword;

	  if(!(CheckTool.isNull(name) || CheckTool.isNull(password))){
	      if(CheckTool.isBetween(name,5,30,CheckTool.CL_OR)){
	        if(CheckTool.isBetween(password,8,30,CheckTool.CL_OR)){
		   if(CheckTool.isLegal(name)){
		     if(CheckTool.isLegal(password)){
	  String token = TokenTool.createToken(
	  	         name,
		         password,
		         TokenTool.FLAG_PLAIN_TEXT);

	  LogTool.info("验证token:"+token);

	  if(!CheckTool.isNull(token)){

            // int uid=userService.queryId(name,token);
	     //if(uid != UserService.QUERY_USER_ID_FAILED) {
             
	     User user= userService.obtainUser(name,token);
	     if(user != null ){
		int uid  = user.getId();

		Date now = TimeTool.now();
		LogTool.info(this,"now:"+now);

                int sid=stateService.queryId(StateGuide.TOKEN_NORMAL);
		LogTool.info(this,"sid:"+sid);

		//访问token
		token = TokenTool.createToken(
		          UuidTool.obtainUUID().toString(),
	  	          token,
		          TokenTool.FLAG_SIMPLE_MD5);
		LogTool.info(this,"访问token:"+token);

                Date lt = new Date(liveTime);
		LogTool.info(this,"liveTime:"+lt.getTime());
		
		if(uid   != UserService.QUERY_USER_ID_FAILED  &&
		   sid   != StateService.QUERY_STATE_ID_FAILED &&
		   token != null &&
		   now   != null &&
		   lt    != null
		  ){
                  Token tk= new Token();
                  tk.setToken(token);
		  tk.setLiveTime(lt);
                  tk.setCreateDate(now);
                  tk.setUserId(uid);
                  tk.setStateId(sid);
                  
		  tokenService.deleteTokenByUserId(uid);

		  if(tokenService.addToken(tk)){
                     result.setStatus(SUCCESS);
//		     Map plus = new HashMap();
//		     plus.put("user",user);
//		     plus.put("token",token);
//   	             result.setContent(plus);
   	             result.setContent(tk.getToken());
		  }else{
                     result.setContent("token添加失败！");
		  }
		}else{
	           result.setContent("token初始化失败！");
		}
	     }else{
	        result.setContent("用户名或密码无效！");
	     }
	  }else{
	     result.setContent("验证token为空！");
	  }
		     }else{
	               result.setContent("密码包含非法字符！");
		     }
		   }else{
	             result.setContent("用户名包含非法字符！");
		   }
	         }else{
	           result.setContent("密码长度不合法！");
	         }
	      }else{
	        result.setContent("用户名长度不合法！");
	      }
	  }else{
	     result.setContent("用户名或密码为空！");
	  }
  
        return new ActionResult(result);
   }

}
