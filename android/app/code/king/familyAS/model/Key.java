package king.familyAS.model;

public enum Key {

	//LoginActivity
	NAME("name"),PASSWORD("password"),

	TOKEN("token"),
	LOGIN_STATE("login_state");

	private String value;

	private Key (String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}
}
