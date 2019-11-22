package king.familyAS.tool;

import king.max.net.Subs;
import king.max.net.Network;
import king.max.net.Scheduler;
import king.max.net.map.ApiService;
import king.max.net.entity.Result;

import com.trello.rxlifecycle3.android.ActivityEvent;

import java.util.Map;
import java.util.HashMap;

import io.reactivex.Observable;

import king.familyAS.model.Api;
import king.familyAS.model.Key;
import king.familyAS.model.HTTPMethod;
import king.familyAS.ui.BasedActivity;
import king.familyAS.tool.DataTool;

public class APITool {


    public static void request(
		BasedActivity activity,
		Api api, 
		Map<String,Object> extra,
		Subs observer
		){
           obtainObservable(
			   activity,
			   api,
			   extra
			   ).subscribe(observer);
    }

    public static Observable<Result> obtainObservable(
		BasedActivity activity,
		Api api, 
		Map<String,Object> extra
		){
       return obtainObservable(
		       api,
		       extra
		       ).
	      compose(Scheduler.apply(
     	               activity.bindUntilEvent(ActivityEvent.DESTROY)
              ));
    }

    public static Observable<Result> obtainObservable(
		Api api, 
		Map<String,Object> extra
		){
       ApiService apiService = Network.api();

       String     name    = api.getApiNameValue();
       String     version = api.getApiVersionValue();
       String     action  = api.getActionValue();
       HTTPMethod method  = api.getMethod();

       Map<String,Object> args = extra;
       
       Observable<Result> obs = null;

       if(args == null){
          args = new HashMap<>();
       }

       if(Api.LOGIN != api && args.get(Key.TOKEN.getValue()) == null){
	  args.put(Key.TOKEN.getValue(), DataTool.queryToken());
       }

       switch(method){
	    case GET:
    	       obs = apiService.getRequest(name,version,action,args);
               break;
 	    case POST:
	       obs = apiService.postRequest(name,version,action,args);
               break;
       }

       return obs;
    }

}
