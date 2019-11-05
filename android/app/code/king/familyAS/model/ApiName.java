package king.familyAS.model;

public enum ApiName {
	BASE("base");

	private String value;

	private ApiName (String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}
}
