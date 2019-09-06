package king.familyAS.model;

public class Result{
   private int status;
   private Object content;

   public Result(){
       this(0,null);
   }

   public Result(int status,Object content){
       this.status=status;
       this.content=content;
   }

   public void setStatus(int status){
       this.status=status; 
   }

   public void setContent(Object content){
       this.content=content;
   }
   
   public int getStatus(){
       return this.status;
   }
  
   public Object getContent(){
       return this.content;
   }
}
