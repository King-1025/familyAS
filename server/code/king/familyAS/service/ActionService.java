package king.familyAS.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

import king.familyAS.action.Action;
import king.familyAS.action.Undefined;
import king.familyAS.action.Login;
import king.familyAS.action.GetAllApi;

import king.familyAS.model.ActionFlag;

import king.familyAS.tool.LogTool;

@Service
public class ActionService {

     @Autowired
     private Login login;
     
     @Autowired
     private GetAllApi getAllApi;

     @Autowired
     private Undefined undefined;

     public Action create(ActionFlag flag, HttpServletRequest request){
             
	     LogTool.info(this,"Action标志:"+flag.toString());

	     Action action = null;

	     switch(flag){
	       case LOGIN:
                  action = login.accept(request);
	  	  break;
	       case QUERY_ALL_API:
		  action = getAllApi;
		  break;
	       case UNDEFINED:
	       default:
		  action = undefined;
		  break;
	     }
	     return action;
     }
}
