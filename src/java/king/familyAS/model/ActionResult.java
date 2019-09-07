package king.familyAS.model;

import king.familyAS.model.Result;

public class ActionResult {
       private Result result;
       private boolean isFinish=true;

       public ActionResult(Result result){
             this.result = result;
       }

       public ActionResult(Result result,boolean isFinish){
             this.result = result;
	     this.isFinish = isFinish;
       }

       public Result getResult(){
	      return result;
       }

       public boolean isFinish(){
              return isFinish;
       }
} 
