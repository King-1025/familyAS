package king.familyAS.tool;

import king.max.utils.SharedPreferencesUtils;

import king.familyAS.model.Key;

public class DataTool extends SharedPreferencesUtils{

	public static String queryToken(){
                return get(Key.TOKEN.getValue(), "");
	}

	public static void updateToken(String value){
		put(Key.TOKEN.getValue(), value);
	}

	public static boolean queryLoginState(){
		return get(Key.LOGIN_STATE.getValue(), false);
	}

	public static void updateLoginState(boolean state){
                put(Key.LOGIN_STATE.getValue(), state);
	}
}
