package king.familyAS.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import king.gen.entity.User;
import king.gen.entity.UserExample;
import king.gen.mapper.UserMapper;

@Service
public class LoginService{

  @Autowired
  private UserMapper userMapper;

  public boolean login(User user){
     UserExample example=new UserExample();
     example.
     createCriteria().
     andNameEqualTo(user.getName()).
     andTokenEqualTo(user.getToken());
     return (userMapper.countByExample(example)>0);
  }
}
