package king.familyAS.action;

import king.familyAS.model.Result;
import king.familyAS.model.ActionResult;

public abstract class Action{
     protected final static int FAILED  = Result.FAILED;
     protected final static int SUCCESS = Result.SUCCESS;

     public abstract ActionResult perform();
}
