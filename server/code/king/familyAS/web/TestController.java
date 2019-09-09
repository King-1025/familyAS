package king.familyAS.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

import king.familyAS.model.Result;
import king.gen.entity.User;

import king.familyAS.tool.IPTool;
import king.familyAS.tool.TimeTool;
import king.familyAS.tool.UuidTool;

@Controller
@RequestMapping("/test")
public class TestController{

   @Autowired
   private HttpServletRequest request;
   
   @ResponseBody
   @RequestMapping("/add")
   public Result add(@RequestParam(value="name") String name,@RequestParam(value="password") String password){
        return new Result(1,true);
   }

   @ResponseBody
   @RequestMapping("/ip")
   public Result ip(){
       return new Result(0,IPTool.getRequestIP(request));
   }

   @ResponseBody
   @RequestMapping("/now")
   public Result now(){
       return new Result(0,TimeTool.now());
   }

   @ResponseBody
   @RequestMapping("/uuid")
   public Result uuid(){
       return new Result(0,UuidTool.obtainUUID().toString());
   }
}
