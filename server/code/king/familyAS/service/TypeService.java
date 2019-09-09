package king.familyAS.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import king.gen.entity.Type;
import king.gen.entity.TypeExample;
import king.gen.mapper.TypeMapper;

@Service
public class TypeService{

  public final static int ONLY_USE_ID=0x01;
  public final static int ONLY_USE_ITEM_TYPE=0x02;
  public final static int ALL_USE=0x03;
  public final static int ADD_TYPE_FAILED=-1;
  public final static int QUERY_TYPE_ID_FAILED=-2;

  @Autowired
  private TypeMapper typeMapper;

  public boolean addType(Type type){
    return (typeMapper.insertSelective(type)>0);
  }
  
  public int addType(String itemType){
    Type type=new Type();
    type.setItemType(itemType);
    if(this.addType(type)){
       return this.queryId(itemType);
    }else{
       return ADD_TYPE_FAILED;
    }
  }

  public int addType(List<Type> listType){
      int count=0;
      for(Type type : listType){
	   if(this.addType(type)){
               count++;
	   }
      }
      return count;
  }

  public boolean deleteType(Type type,int flag){
	  boolean is = false;
          TypeExample example=null;
	  switch(flag){
		  case ONLY_USE_ID:
                    is = (typeMapper.deleteByPrimaryKey(type.getId())>0);
                  break;
		  case ONLY_USE_ITEM_TYPE:
                    example=new TypeExample();
                    example.
                    createCriteria().
                    andItemTypeEqualTo(type.getItemType());
                    is = (typeMapper.deleteByExample(example)>0);
	          break;
                  case ALL_USE:
                    example=new TypeExample();
                    example.
                    createCriteria().
                    andIdEqualTo(type.getId()).
                    andItemTypeEqualTo(type.getItemType());
                    is = (typeMapper.deleteByExample(example)>0);
		  break;
                  default:
		    //Todo throw exception of not founding flag.
		  break;
	  }
	  return is;
  }
  
  public boolean changeType(Type type){
    return (typeMapper.updateByPrimaryKeySelective(type)>0);
  }

  public Type obtainTypeById(int id){
    return typeMapper.selectByPrimaryKey(id);
  }

  public Type obtainType(String itemType){
    TypeExample example=new TypeExample();
       example.
       createCriteria().
       andItemTypeEqualTo(itemType);
    List<Type> listType = typeMapper.selectByExample(example);
    if(listType!=null && listType.size() > 0){
       return listType.get(0);
    }else{
       return null;
    }
  }

  public String queryItemTypeById(int id){
    Type type=this.obtainTypeById(id);
    if(type!=null){
       return type.getItemType();
    }else{
       return null;
    }
  }

  public int queryId(String itemType){
     Type type=this.obtainType(itemType);
     if(type!=null){
	return type.getId();
     }else{
        return QUERY_TYPE_ID_FAILED;
     }
  }
  
  public boolean isExists(int id){
    TypeExample example=new TypeExample();
        example.
        createCriteria().
        andIdEqualTo(id);
    return (typeMapper.countByExample(example)>0);
  }

  public boolean isExists(String itemType){
    TypeExample example=new TypeExample();
        example.
        createCriteria().
        andItemTypeEqualTo(itemType);
    return (typeMapper.countByExample(example)>0);
  }

  public boolean isExists(Type type){
    TypeExample example=new TypeExample();
        example.
        createCriteria().
        andIdEqualTo(type.getId()).
        andItemTypeEqualTo(type.getItemType());
    return (typeMapper.countByExample(example)>0);
  }

}
