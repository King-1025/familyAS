package king.familyAS.ui;

import king.max.ui.base.BaseActivity;
import king.max.net.entity.Result;
import king.max.net.*;
import king.max.utils.*;

import android.view.KeyEvent;

import java.util.Map;

import com.hdl.logcatdialog.LogcatDialog;

import king.familyAS.model.Api;
import king.familyAS.model.Type;
import king.familyAS.model.Flag;
import king.familyAS.model.HTTPMethod;
import king.familyAS.tool.APITool;

public class BasedActivity extends BaseActivity implements APIResponse{

    protected LogcatDialog logcatDialog;

    private final BasedObserver basedObserver = new BasedObserver(this);

    protected void request(Api api, Map<String,Object> extra){
         APITool.request(
			 this,
			 api,
			 extra,
			 basedObserver.select(api)
			 );
    }

    @Override
    public void onResponse(Api api, Object result){
	   show(
	        "api:"+api.toString()+" "+
		"result:"+result
	   ,Type.NOTICE);
    }

    @Override
    protected int onLayout() {
        return 0;
    }

    @Override
    protected void onObject() {
        logcatDialog=new LogcatDialog(this);
    }

    @Override
    protected void onView() {

    }

    @Override
    protected void onData() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
	    finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
   
    protected void show(String message, Type type){
	    switch(type){
		case TOAST:
                     ToastUtils.show(message);
		     break;
		case NOTICE:
		     NoticeUtils.show(message);
		     break;
		case LOADING:
                     LoadingUtils.show(message);
		     break;
	    }
    }

    protected void hide(Type type){
	    switch(type){
	        case LOADING:
                    LoadingUtils.hide();
		    break;
	    }
    }
    
    private class BasedObserver<T> extends Subs<T> {

	    private Api api;
	    private APIResponse apiResponse;

	    public BasedObserver(APIResponse apiResponse){
                   this.apiResponse = apiResponse;
	    }

	    public BasedObserver select(Api api){
		   this.api = api;
		   return this;
	    }

	    public void onSuccess(T result){
                   apiResponse.onResponse(api,result);
	    }

/*	    public void onFailed(T result){
                   apiResponse.onResponse(api,result,false);
	    };
*/
	    public void onError(Throwable e){;
                   LoadingUtils.hide();
                   super.onError(e);
	    }

	    @Override
            public void onNext(Result<T> data) {
                LoadingUtils.hide();
                onCompleted();
		Flag status = Flag.from(data.getStatus());
		T content = data.getContent();
		switch(status){
                     case SUCCESS:
                        onSuccess(content);
			     break;
		     case FAILED:
		        NoticeUtils.show(content+"");
                        onFail();
			     break;
		     case UNDEFINED:
		     default:
   		        onError(new Exception("unknown status:"+status));
			     break;
		}
            }
    }
}
