package king.familyAS.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import king.gen.entity.Api;
import king.gen.entity.ApiWithBLOBs;
import king.gen.entity.ApiExample;
import king.gen.mapper.ApiMapper;

@Service
public class ApiService {
   
   @Autowired
   private ApiMapper apiMapper;

   @Autowired
   private PathService pathService; 

   public boolean addApi(ApiWithBLOBs api){
     return (apiMapper.insertSelective(api)>0);
   }
  
   public boolean deleteApiById(int id){
     return (apiMapper.deleteByPrimaryKey(id)>0);
   }

   public boolean changeApi(ApiWithBLOBs api){
     return (apiMapper.updateByPrimaryKeySelective(api)>0);
   }

   public ApiWithBLOBs obtainApiById(int id){
     return apiMapper.selectByPrimaryKey(id);
   }

   public ApiWithBLOBs obtainApi(String action,String basePath){
     ApiExample example=new ApiExample();
       example.
       createCriteria().
       andPathIdEqualTo(pathService.queryId(basePath)).
       andActionEqualTo(action);
     List<ApiWithBLOBs> listApi = apiMapper.selectByExampleWithBLOBs(example);
     if(listApi!=null && listApi.size() > 0){
        return listApi.get(0);
     }else{
        return null;
     }
   }
}
