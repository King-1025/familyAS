package king.familyAS.action;

import org.springframework.stereotype.Component;

import king.familyAS.model.Result;
import king.familyAS.model.ActionResult;

@Component
public class Undefined extends Action {
	
	public ActionResult perform(){
           return new ActionResult(new Result(FAILED,"action未定义！"));
	}
}
