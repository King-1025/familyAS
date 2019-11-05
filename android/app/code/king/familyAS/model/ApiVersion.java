package king.familyAS.model;

public enum ApiVersion {
	V1("v1");

	private String value;

	private ApiVersion (String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}
}
