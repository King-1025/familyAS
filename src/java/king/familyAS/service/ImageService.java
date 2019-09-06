package king.familyAS.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import king.gen.entity.Image;
import king.gen.entity.ImageExample;
import king.gen.mapper.ImageMapper;

@Service
public class ImageService {
   
   public final static int ADD_IMAGE_FAILED=-1;
   public final static int QUERY_IMAGE_ID_FAILED=-2;
   
   @Autowired
   private ImageMapper imageMapper;

   public boolean addImage(Image image){
     return (imageMapper.insertSelective(image)>0);
   }
  
   public int addImage(String imagePath){
     Image image = new Image();
     image.setImagePath(imagePath);
     if(this.addImage(image)){
        return this.queryId(imagePath);
     }else{
        return ADD_IMAGE_FAILED;
     }
   }
  
   public boolean deleteImageById(int id){
     return (imageMapper.deleteByPrimaryKey(id)>0);
   }

   public boolean changeImage(Image image){
     return (imageMapper.updateByPrimaryKeySelective(image)>0);
   }

   public Image obtainImageById(int id){
     return imageMapper.selectByPrimaryKey(id);
   }

   public Image obtainImage(String imagePath){
     ImageExample example=new ImageExample();
       example.
       createCriteria().
       andImagePathEqualTo(imagePath);
     List<Image> listImage = imageMapper.selectByExample(example);
     if(listImage!=null && listImage.size() > 0){
        return listImage.get(0);
     }else{
        return null;
     }
   }

   public String queryImagePathById(int id){
	 Image image=this.obtainImageById(id);
	 if (image!=null){
             return image.getImagePath();
	 }else{
             return null;
	 }
   }

   public int queryId(String imagePath){
     Image image=this.obtainImage(imagePath);
     if(image!=null){
	return image.getId();
     }else{
        return QUERY_IMAGE_ID_FAILED;
     }
   }

}
