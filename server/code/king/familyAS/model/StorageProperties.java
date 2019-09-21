package king.familyAS.model;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Value;

@Repository 
public class StorageProperties{
  
   @Value("${storage-location:}")
   private String location;

   public final static String DEFAULT_STORAGE_LOCATION = "upload-dir";

   public String getLocation(){
      if(location != null && !location.equals("")){
         return location;
      }else{
	 return DEFAULT_STORAGE_LOCATION;
      }
   }
}
