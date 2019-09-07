package king.familyAS.action;

import king.familyAS.model.ActionResult;

public abstract class Action{
     protected final static int FAILED=-1;
     protected final static int SUCCESS=0;

     public abstract ActionResult perform();
}
