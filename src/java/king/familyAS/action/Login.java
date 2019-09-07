package king.familyAS.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import king.familyAS.model.Result;
import king.familyAS.model.ActionResult;

import king.familyAS.service.LoginService;
import king.gen.entity.User;

import king.familyAS.tool.TokenTool;
import king.familyAS.tool.CheckTool;

@Component
public class Login extends Action{

   public final static int FLAG = 0;
   private final static String NAME = "name";
   private final static String PASSWORD = "password";

   @Autowired
   private LoginService loginService;

   private String loginName;
   private String loginPassword;

   public Action accept(HttpServletRequest request){
          return accept(request.getParameter(NAME),
	       request.getParameter(PASSWORD));
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
	  if(!CheckTool.isNull(token)){
             User user=new User();
             user.setName(name);
             user.setToken(token);
	     if(loginService.login(user)){
		result.setStatus(SUCCESS);
	        result.setContent("验证通过！");
		//TODO 更新状态
	     }else{
	        result.setContent("用户名或密码无效！");
	     }
	  }else{
	     result.setContent("token为空！");
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
