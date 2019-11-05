package king.familyAS.ui;

import android.view.View;

import java.util.Map;
import java.util.HashMap;

import butterknife.BindView;

import com.youth.template.LoginTemplateView;
import com.youth.template.LoginTemplateView.LoginListener;
import com.youth.template.LoginTemplateView.ForgotListener;
import com.youth.template.LoginTemplateView.RegisterListener;

import king.familyAS.R;
import king.familyAS.model.Api;
import king.familyAS.model.Key;
import king.familyAS.model.Type;
import king.familyAS.ui.BasedActivity;
import king.familyAS.tool.DataTool;

public class LoginActivity extends BasedActivity implements 
       LoginListener,
       ForgotListener,
       RegisterListener
{
    
    @BindView(R.id.login_view)
    LoginTemplateView loginView;
     
    @Override
    protected int onLayout() {
        return R.layout.activity_access;
    }
    
    @Override
    protected void onData() {
	loginView.setLoginBackgroundColor(
	        getResources().
		//getColor(R.color.app_orange)
		getColor(R.color.app_white)
		//getColor(R.color.app_main)
	);
	//setLoginButtonTextColor(
	//        getResources().
	//	getColor(R.color.app_main)
	//);
	loginView.setLoginButtonBackground(R.color.app_main);
        loginView.setLoginListener(this);
        loginView.setForgotListener(this);
        loginView.setRegisterListener(this);
    }

    @Override
    public void login(View v){
        show("",Type.LOADING);
        String name = loginView.getLoginName();
	String password = loginView.getLoginPassword();
	Map<String, Object> extra = new HashMap<>();
        extra.put(Key.NAME.getValue(), name);
        extra.put(Key.PASSWORD.getValue(), password);
	request(Api.LOGIN,extra);
    }

    @Override
    public void onResponse(Api api, Object result){
	     switch(api){
                 case LOGIN:
                      DataTool.updateToken(String.valueOf(result));
		      DataTool.updateLoginState(true);
                      show("登录成功！", Type.NOTICE);
		      break;
                 case ALL_API:
                      show(result+"", Type.NOTICE);
		      break;
	     }
    }

    @Override
    public void forgot(View v){
       //show("忘记密码",Type.NOTICE);
       logcatDialog.show();
    }

    @Override
    public void register(View v){
      // show("注册用户",Type.TOAST);
      request(Api.ALL_API,null);
    }

}
