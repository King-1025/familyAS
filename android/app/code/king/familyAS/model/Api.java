package king.familyAS.model;

import king.familyAS.model.ApiName;
import king.familyAS.model.ApiVersion;
import king.familyAS.model.Action;
import king.familyAS.model.HTTPMethod;

public enum Api {
   LOGIN   (Action.LOGIN, HTTPMethod.POST), // 默认：base/v1
   ALL_API (Action.LIST_ALL_API, HTTPMethod.GET);

   private ApiName apiName;
   private ApiVersion apiVersion;
   private Action action;
   private HTTPMethod method;

   private Api(
	       ApiName    apiName,
	       ApiVersion apiVersion,
	       Action     action,
	       HTTPMethod method
	      ){
           this.apiName    = apiName;
	   this.apiVersion = apiVersion;
	   this.action     = action;
	   this.method     = method;
    }

   private Api(
	       Action     action,
	       HTTPMethod method
	      ){
	   this(ApiName.BASE,ApiVersion.V1,action,method);
    }

   private Api(
	       Action     action
	      ){
	   this(action,HTTPMethod.GET);
    }

   public void setAction(Action action){
	   this.action = action;
   }

   public ApiName getApiName(){
	   return this.apiName;
   }

   public String getApiNameValue(){
          return getApiName().getValue();
   }

   public ApiVersion getApiVersion(){
	   return this.apiVersion;
   }

   public String getApiVersionValue(){
          return getApiVersion().getValue();
   }

   public Action getAction(){
	   return this.action;
   }

   public String getActionValue(){
          return getAction().getValue();
   }

   public HTTPMethod getMethod(){
	   return this.method;
   }

}
