package king.familyAS.model;

import king.familyAS.tool.LogTool;

public class Result{
   
   public final static int SUCCESS =  0;
   public final static int FAILED  = -1;

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
       LogTool.info(this,"Content:"+content);
       this.content=content;
   }
   
   public int getStatus(){
       return this.status;
   }
  
   public Object getContent(){
       return this.content;
   }
}
