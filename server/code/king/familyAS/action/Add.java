package king.familyAS.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import king.familyAS.model.Result;
import king.familyAS.model.ActionFlag;
import king.familyAS.model.ActionResult;

import king.familyAS.service.ApiService;

import king.gen.entity.ApiWithBLOBs;

import java.util.List;

@Component
public class Add extends Action{

//   private final static ActionFlag flag = ActionFlag.ADD;

   private String where;
   @Autowired
   private ApiService apiService;

   public ActionResult perform(){
          Result result=new Result(FAILED,null);

	    result.setStatus(SUCCESS);
  //          result.setContent(all);
          return new ActionResult(result);
   }
}
