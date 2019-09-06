package king.familyAS.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
 
import king.familyAS.tool.CheckTool;
import king.familyAS.model.Result;
import king.gen.entity.ApiWithBLOBs;
import king.gen.entity.State;
import king.gen.entity.Token;

import king.familyAS.service.TypeService;
import king.familyAS.service.StateService;
import king.familyAS.service.TokenService;
import king.familyAS.service.ApiService;
import king.familyAS.service.ActionService;

@Controller
@RequestMapping("/api")
public class APIController{
   
   private final static int FAILED  = -1;
   private final static int SUCCESS = 0;

   private final static int API_STATE_NORMAL  = 0;
   private final static int API_STATE_DISABLE = 1;

   private final static int TOKEN_STATE_DISABLE = 11;

   @Autowired
   private HttpServletRequest request;
   
   @Autowired
   private TokenService tokenService;
   
   @Autowired
   private TypeService typeService;
   
   @Autowired
   private StateService stateService;

   @Autowired
   private ApiService apiService;
   
   @Autowired
   private ActionService actionService;

   @ResponseBody
   @RequestMapping("/{api_name}/{api_version}")
   public Result apiRoute(
        @PathVariable("api_name") String apiName,
	@PathVariable("api_version") String apiVersion,
        @RequestParam("action") String action
   ){
	Result result = new Result(FAILED,null);

	int order[] = {1,2,3,4,5,6,7,8,9};

	ApiWithBLOBs  api     = null;
	Date          nowTime = null;
	Token         token   = null;
	State         state   = null;
	String        type    = null;

	for(int i=0;i<order.length;i++){
            boolean ant=false;
	    switch(order[i]){
               case 1:
                 if(CheckTool.isLegal(apiName) && 
	            CheckTool.isLegal(apiVersion))
	         {
	             ant=true;	
	         }else{
                     result.setContent("URL路径不合法！");
	         }
	         break;
	       case 2:
	         if(CheckTool.isLegal(action)){
                    ant=true;
	         }else{
                    result.setContent("action不合法！");
	         }
	         break;
               case 3:
	         api = fetchAPI(action,apiName+":"+apiVersion);
		 if(api != null){
	            ant=true;
		 }else{
                    result.setContent("API不存在！");
		 }
		 break;
	       case 4:
                 type=typeService.queryItemTypeById(api.getTypeId());
		 if(type != null){
	            ant=true;
		 }else{
                    result.setContent("API类型为空！");
		 }
		 break;
               case 5:
		 if(type.equals(request.getMethod())){
                    ant=true;
		 }else{
                    result.setContent("API请求类型不匹配！");
		 } 
		 break;
	       case 6:
                 state=stateService.obtainStateById(api.getStateId());
		 if(state != null){
		    ant=true;
		 }else{
                    result.setContent("API状态为空！");
		 }
		 break;
	       case 7:
		 boolean isResetApiState=false;
		 if(state.getState() == API_STATE_NORMAL){
		    ant=true;
		 }else if(state.getState() == API_STATE_DISABLE){
                   Date lastTime = api.getLastTime();
		   if(lastTime == null){
                     nowTime = new Date();
		     isResetApiState=true;
		   }else{
                     nowTime = new Date();
		     long t=nowTime.getTime() - lastTime.getTime();
		     if( t > (1000 * 60 * 60 * 24)){ //one day
                         isResetApiState=true;
		     }else{
                         result.setContent(state.getProfile());
		     }
		   }
		 }
		 else{
                    result.setContent(state.getProfile());
		 }
		 if(isResetApiState){
                    int sid=stateService.queryId(API_STATE_NORMAL);
		    if(sid!=StateService.QUERY_STATE_ID_FAILED){
	              api.setCallCount(0);
		      api.setFailed(0);
		      api.setLastTime(nowTime);
		      api.setStateId(sid);
		      if(apiService.changeApi(api)){
		         ant=true;
		      }else{
                         result.setContent("重置API失败！");
		      }
		    }else{
                      result.setContent("重置API状态失败！");
		    }
		 }
		 break;
	       case 8:
	         if(api.getCheckToken()){
                   String tk=request.getParameter("token");
		   if(tk!=null){
	             if(CheckTool.isLegal(tk)){
		        token = tokenService.obtainToken(tk);
			if(token != null){
			   //TODO 判断是否过期，可用性
                          state = stateService.obtainStateById(token.getStateId());
			  if(state != null && state.getState() == TOKEN_STATE_DISABLE){                           
                            result.setContent("token禁用！"); 
			  }else{
			    Date liveTime = token.getLiveTime();
			    if(liveTime == null){
			      ant = true; //永久有效
			    }else{
                              Date createDate = token.getCreateDate();
			      if(createDate == null){
                                result.setContent("token异常！"); 
			      }else{
                                nowTime = new Date();
				long f= liveTime.getTime() - (nowTime.getTime() - createDate.getTime());
                                if(f > 0){
                                   ant = true;
				}else{
                                   result.setContent("token过期！"); 
				}
			      }
			    }
			  }
			}else{
                          result.setContent("token无效！"); 
			}
		     }else{
                        result.setContent("token不合法！");
		     }
		   }else{
                      result.setContent("token为空！");
		   }
		 }else{
                    ant=true;
		 }
	         break;
               case 9:
                 result = run(api);
	         break;
	    }
	    if(!ant) break;
	}
        return result;
   }

   private ApiWithBLOBs fetchAPI(String action,String basePath){
        return apiService.obtainApi(action,basePath);
   }
   
   private Result run(ApiWithBLOBs api){
	int flag = api.getFlag();
	return actionService.setFlag(flag)
		            .setRequest(request)
			    .create()
			    .perform();
   }
}
