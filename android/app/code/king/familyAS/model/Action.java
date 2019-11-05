package king.familyAS.model;

public enum Action {
	LOGIN("login"),
	LIST_ALL_API("getAllApi"),
	UNDEFINED(null);

	private String value;

	private Action (String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}
}
