package king.familyAS.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

import king.familyAS.action.Action;
import king.familyAS.action.Undefined;
import king.familyAS.action.Login;

import king.familyAS.model.ActionFlag;

@Service
public class ActionService {

     @Autowired
     private Login login;

     @Autowired
     private Undefined undefined;

     public Action create(int flag, HttpServletRequest request){
	     Action action = null;
	     switch(flag){
	       case Login.FLAG:
                  action = login.accept(request);
	  	  break;
	       default:
		  action = undefined;
		  break;
	     }
	     return action;
     }
}
