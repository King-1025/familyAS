package king.familyAS.model;

public enum ActionFlag {

   LOGIN(0);

   private int value;

   private ActionFlag(int value){
       this.value = value;
   }
   
   public void setValue(int value){
       this.value = value;
   }

   public int getValue(){
       return this.value;
   }
}
