package king.familyAS.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

import king.familyAS.model.ActionFlag;

@Service
public class ActionService {
     
     public Action create(int flag, HttpServletRequest request){
	    Action action = null;
	    switch(flag){
	       case ActionFlag.LOGIN:
                 break;
	    }
	    return action;
     }
}
