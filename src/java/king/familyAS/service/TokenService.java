package king.familyAS.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import king.gen.entity.Token;
import king.gen.entity.TokenExample;
import king.gen.mapper.TokenMapper;

@Service
public class TokenService {
   
   @Autowired
   private TokenMapper tokenMapper;

   public boolean addToken(Token token){
     return (tokenMapper.insertSelective(token)>0);
   }
  
   public boolean deleteTokenById(int id){
     return (tokenMapper.deleteByPrimaryKey(id)>0);
   }

   public boolean changeToken(Token token){
     return (tokenMapper.updateByPrimaryKeySelective(token)>0);
   }

   public Token obtainTokenById(int id){
     return tokenMapper.selectByPrimaryKey(id);
   }

   public Token obtainToken(String token){
     TokenExample example=new TokenExample();
       example.
       createCriteria().
       andTokenEqualTo(token);
     List<Token> listToken = tokenMapper.selectByExample(example);
     if(listToken!=null && listToken.size() > 0){
        return listToken.get(0);
     }else{
        return null;
     }
   }
}
