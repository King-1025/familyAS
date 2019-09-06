package king.familyAS.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.stereotype.Controller;

import king.familyAS.model.Result;
import king.gen.entity.User;

@Controller
@RequestMapping("/user")
public class UserController{

//   @Autowired
   
   @ResponseBody
   @RequestMapping("/add")
   public Result add(@RequestParam(value="name") String name,@RequestParam(value="password") String password){
        return new Result(1,true);
   }

}
