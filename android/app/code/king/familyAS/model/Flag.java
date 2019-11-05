package king.familyAS.model;

public enum Flag {
	SUCCESS(0),
	FAILED(-1),
	UNDEFINED(-99);

	private int value;

	public static Flag from(int value){
           for (Flag flag : Flag.values()) {  
             if(flag.getValue() == value) {  
                return flag;  
             }  
           }  
           return UNDEFINED;  
        }

	private Flag (int value){
		this.value = value;
	}

	public int getValue(){
		return value;
	}
}
