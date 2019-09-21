package king.familyAS.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import king.familyAS.model.Result;
import king.familyAS.model.Location;
import king.familyAS.model.ActionFlag;
import king.familyAS.model.ActionResult;

import king.familyAS.tool.LogTool;

import king.familyAS.service.iterf.StorageService;

@Component
public class Upload extends Action{

   private final static ActionFlag flag = ActionFlag.UPLOAD;

   private final StorageService storageService;

   private Location location;

   private List<MultipartFile> listFile;

   @Autowired
   private MultipartResolver resolver;

   @Autowired
   public Upload(StorageService storageService) {
        this.storageService = storageService;
   }

   public Action accept(
		   HttpServletRequest request 
		   ){
	  Location loc = 
		  Location.from(request.getParameter(flag.getKeys()[0]));

          List<MultipartFile> list = 
           	  resolver.resolveMultipart(request).getFiles(flag.getKeys()[1]);
          
          return accept(loc,list);
   }

   public Action accept(Location location, List<MultipartFile> listFile){
	  this.location = location;
	  this.listFile = listFile;

	  LogTool.info(this,"location:"+location);
	  LogTool.info(this,"listFile:"+listFile);

	  return this;
   }

   public ActionResult perform(){
	  if(location != Location.NOT_EXISTEN) { 
	    if(listFile != null && listFile.size() > 0) {
              return new ActionResult(handleFileUpload(
	             location.getPath(),
		     listFile
	             ));
	    } else {
              return new ActionResult(
	             new Result(FAILED,"文件为空!"));
	    }
	  } else {
              return new ActionResult(
		     new Result(FAILED,"位置不存在!"));
	  }
    }

    private Result handleFileUpload(
		    String path,
		    List<MultipartFile> files
		    ) {
	
        Result result=new Result(FAILED,null);
        
	try {
	      List<String> fna = new ArrayList<>();
	      Map<String,Object> content = new HashMap<>();

              for(MultipartFile file : files){
                 storageService.store(file,path);
		 fna.add(file.getOriginalFilename());
	      }

	      content.put("count",fna.size());
	      content.put("file_name",fna);

              result.setStatus(SUCCESS);
	      result.setContent(content);
	} catch (Exception e){
              e.printStackTrace();	      
	      result.setContent(e.toString());
	}

        return result;
    }
}
