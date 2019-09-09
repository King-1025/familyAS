package king.familyAS.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import king.gen.entity.User;
import king.gen.entity.UserExample;
import king.gen.mapper.UserMapper;

@Service
public class UserService{

  public final static int ADD_USER_FAILED=-1;
  public final static int QUERY_USER_ID_FAILED=-2;

  @Autowired
  private UserMapper userMapper;

  public boolean addUser(User user){
    return (userMapper.insertSelective(user)>0);
  }
  
  public int addUser(String name, String token){
    User user=new User();
    user.setName(name);
    user.setToken(token);
    if(this.addUser(user)){
       return this.queryId(name,token);
    }else{
       return ADD_USER_FAILED;
    }
  }

  public int addUser(List<User> listUser){
      int count=0;
      for(User user : listUser){
	   if(this.addUser(user)){
               count++;
	   }
      }
      return count;
  }

  public boolean changeUser(User user){
    return (userMapper.updateByPrimaryKeySelective(user)>0);
  }

  public User obtainUserById(int id){
    return userMapper.selectByPrimaryKey(id);
  }

  public User obtainUser(String name,String token){
    UserExample example=new UserExample();
       example.
       createCriteria().
       andNameEqualTo(name).
       andTokenEqualTo(token);
    List<User> listUser = userMapper.selectByExample(example);
    if(listUser!=null && listUser.size() > 0){
       return listUser.get(0);
    }else{
       return null;
    }
  }

  public String queryNameById(int id){
    User user=this.obtainUserById(id);
    if(user!=null){
       return user.getName();
    }else{
       return null;
    }
  }

  public int queryId(String name,String token){
     User user=this.obtainUser(name,token);
     if(user!=null){
	return user.getId();
     }else{
        return QUERY_USER_ID_FAILED;
     }
  }
  
  public boolean isExists(int id){
    UserExample example=new UserExample();
        example.
        createCriteria().
        andIdEqualTo(id);
    return (userMapper.countByExample(example)>0);
  }

  public boolean isExists(String name,String token){
    UserExample example=new UserExample();
        example.
        createCriteria().
        andNameEqualTo(name).
        andTokenEqualTo(token);
    return (userMapper.countByExample(example)>0);
  }

  public boolean isExists(User user){
    if(user!=null){
        return isExists(user.getName(),user.getToken());
    }else{
        return false;
    }
  }

}
