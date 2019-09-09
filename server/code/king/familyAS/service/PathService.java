package king.familyAS.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import king.gen.entity.Path;
import king.gen.entity.PathExample;
import king.gen.mapper.PathMapper;

@Service
public class PathService {

  public final static int ONLY_USE_ID=0x01;
  public final static int ONLY_USE_BASE_PATH=0x02;
  public final static int ALL_USE=0x03;
  public final static int ADD_PATH_FAILED=-1;
  public final static int QUERY_PATH_ID_FAILED=-2;

  @Autowired
  private PathMapper pathMapper;

  public boolean addPath(Path path){
    return (pathMapper.insertSelective(path)>0);
  }
  
  public int addPath(String basePath){
    Path path=new Path();
    path.setBasePath(basePath);
    if(this.addPath(path)){
       return this.queryId(basePath);
    }else{
       return ADD_PATH_FAILED;
    }
  }

  public int addPath(List<Path> listPath){
      int count=0;
      for(Path path : listPath){
	   if(this.addPath(path)){
               count++;
	   }
      }
      return count;
  }

  public boolean deletePath(Path path,int flag){
	  boolean is = false;
          PathExample example=null;
	  switch(flag){
		  case ONLY_USE_ID:
                    is = (pathMapper.deleteByPrimaryKey(path.getId())>0);
                  break;
		  case ONLY_USE_BASE_PATH:
                    example=new PathExample();
                    example.
                    createCriteria().
                    andBasePathEqualTo(path.getBasePath());
                    is = (pathMapper.deleteByExample(example)>0);
	          break;
                  case ALL_USE:
                    example=new PathExample();
                    example.
                    createCriteria().
                    andIdEqualTo(path.getId()).
                    andBasePathEqualTo(path.getBasePath());
                    is = (pathMapper.deleteByExample(example)>0);
		  break;
                  default:
		    //Todo throw exception of not founding flag.
		  break;
	  }
	  return is;
  }
  
  public boolean changePath(Path path){
    return (pathMapper.updateByPrimaryKeySelective(path)>0);
  }

  public Path obtainPathById(int id){
    return pathMapper.selectByPrimaryKey(id);
  }

  public Path obtainPath(String basePath){
    PathExample example=new PathExample();
       example.
       createCriteria().
       andBasePathEqualTo(basePath);
    List<Path> listPath = pathMapper.selectByExample(example);
    if(listPath!=null && listPath.size() > 0){
       return listPath.get(0);
    }else{
       return null;
    }
  }

  public String queryBasePathById(int id){
    Path path=this.obtainPathById(id);
    if(path!=null){
       return path.getBasePath();
    }else{
       return null;
    }
  }

  public int queryId(String basePath){
     Path path=this.obtainPath(basePath);
     if(path!=null){
	return path.getId();
     }else{
        return QUERY_PATH_ID_FAILED;
     }
  }
  
  public boolean isExists(int id){
    PathExample example=new PathExample();
        example.
        createCriteria().
        andIdEqualTo(id);
    return (pathMapper.countByExample(example)>0);
  }

  public boolean isExists(String basePath){
    PathExample example=new PathExample();
        example.
        createCriteria().
        andBasePathEqualTo(basePath);
    return (pathMapper.countByExample(example)>0);
  }

  public boolean isExists(Path path){
    PathExample example=new PathExample();
        example.
        createCriteria().
        andIdEqualTo(path.getId()).
        andBasePathEqualTo(path.getBasePath());
    return (pathMapper.countByExample(example)>0);
  }

}
