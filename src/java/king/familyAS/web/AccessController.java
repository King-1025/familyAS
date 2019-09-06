package king.familyAS.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.stereotype.Controller;

import king.familyAS.model.Result;
import king.familyAS.service.LoginService;
import king.gen.entity.User;

import king.familyAS.tool.TokenTool;
import king.familyAS.tool.CheckTool;

@Controller
@RequestMapping("/access")
public class AccessController{
   
   private final static int FAILED=-1;
   private final static int SUCCESS=0;

   @Autowired
   private LoginService loginService;
 
   @ResponseBody
   @RequestMapping("/userLogin")
   public Result login(@RequestParam(value="name") String name,@RequestParam(value="password") String password){
          Result result=new Result(FAILED,null);
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
  
        return result;
   }

}
