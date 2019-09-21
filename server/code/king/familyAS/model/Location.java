package king.familyAS.model;

public enum Location {

   COMMON_FILE("common_file", "common"),
   NOT_EXISTEN("",null);

   private String value;
   private String path;

   private Location(String value, String path){
       this.value = value;
       this.path  = path;
   }
   
   public static Location from(String value) {  
       for (Location loc : Location.values()) {  
         if (loc.getValue().equals(value)) {  
                return loc;  
            }  
       }  
       return NOT_EXISTEN;
    }

   public String getValue(){
       return this.value;
   }

   public String getPath(){
       return this.path;
   }

}
