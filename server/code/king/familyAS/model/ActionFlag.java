package king.familyAS.model;

public enum ActionFlag {

   UPLOAD       ( 2 , "upload"    ,  new String []{"location","file"}),
   QUERY_ALL_API( 1 , "getAllApi",  null),
   LOGIN        ( 0 , "login"    ,  new String []{"name","password"}),
   UNDEFINED    (-1 , "undefined",  null);

   private int value;
   private String name;
   private String []keys; 

   private ActionFlag(int value,String name,String []keys){
       this.value = value;
       this.name  = name;
       this.keys  = keys;
   }
  
   public static ActionFlag from(int value,String name) {  
       for (ActionFlag flag : ActionFlag.values()) {  
         if (flag.getValue() == value && flag.getName().equals(name)) {  
                return flag;  
            }  
       }  
       return UNDEFINED;  
    }

   public int getValue(){
       return this.value;
   }

   public String getName(){
        return this.name;
   }

   public String[] getKeys(){
	return this.keys;
   }
}
