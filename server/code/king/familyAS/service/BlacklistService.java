package king.familyAS.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import king.gen.entity.Blacklist;
import king.gen.entity.BlacklistExample;
import king.gen.mapper.BlacklistMapper;

@Service
public class BlacklistService{

  public final static int ONLY_USE_ID=0x01;
  public final static int ONLY_USE_IP=0x02;
  public final static int ALL_USE=0x03;
  public final static int ADD_BLACKLIST_FAILED=-1;
  public final static int QUERY_BLACKLIST_ID_FAILED=-2;

  @Autowired
  private BlacklistMapper blacklistMapper;

  public boolean addBlacklist(Blacklist blacklist){
    return (blacklistMapper.insertSelective(blacklist)>0);
  }
  
  public int addBlacklist(String ip){
    Blacklist blacklist=new Blacklist();
    blacklist.setIp(ip);
    if(this.addBlacklist(blacklist)){
       return this.queryId(ip);
    }else{
       return ADD_BLACKLIST_FAILED;
    }
  }

  public int addBlacklist(List<Blacklist> listBlacklist){
      int count=0;
      for(Blacklist blacklist : listBlacklist){
	   if(this.addBlacklist(blacklist)){
               count++;
	   }
      }
      return count;
  }

  public boolean deleteBlacklist(Blacklist blacklist,int flag){
	  boolean is = false;
          BlacklistExample example=null;
	  switch(flag){
		  case ONLY_USE_ID:
                    is = (blacklistMapper.deleteByPrimaryKey(blacklist.getId())>0);
                  break;
		  case ONLY_USE_IP:
                    example=new BlacklistExample();
                    example.
                    createCriteria().
                    andIpEqualTo(blacklist.getIp());
                    is = (blacklistMapper.deleteByExample(example)>0);
	          break;
                  case ALL_USE:
                    example=new BlacklistExample();
                    example.
                    createCriteria().
                    andIdEqualTo(blacklist.getId()).
                    andIpEqualTo(blacklist.getIp());
                    is = (blacklistMapper.deleteByExample(example)>0);
		  break;
                  default:
		    //Todo throw exception of not founding flag.
		  break;
	  }
	  return is;
  }
  
  public boolean changeBlacklist(Blacklist blacklist){
    return (blacklistMapper.updateByPrimaryKeySelective(blacklist)>0);
  }

  public Blacklist obtainBlacklistById(int id){
    return blacklistMapper.selectByPrimaryKey(id);
  }

  public Blacklist obtainBlacklist(String ip){
    BlacklistExample example=new BlacklistExample();
       example.
       createCriteria().
       andIpEqualTo(ip);
    List<Blacklist> listBlacklist = blacklistMapper.selectByExample(example);
    if(listBlacklist!=null && listBlacklist.size() > 0){
       return listBlacklist.get(0);
    }else{
       return null;
    }
  }

  public String queryIpById(int id){
    Blacklist blacklist=this.obtainBlacklistById(id);
    if(blacklist!=null){
       return blacklist.getIp();
    }else{
       return null;
    }
  }

  public int queryId(String ip){
     Blacklist blacklist=this.obtainBlacklist(ip);
     if(blacklist!=null){
	return blacklist.getId();
     }else{
        return QUERY_BLACKLIST_ID_FAILED;
     }
  }
  
  public boolean isExists(int id){
    BlacklistExample example=new BlacklistExample();
        example.
        createCriteria().
        andIdEqualTo(id);
    return (blacklistMapper.countByExample(example)>0);
  }

  public boolean isExists(String ip){
    BlacklistExample example=new BlacklistExample();
        example.
        createCriteria().
        andIpEqualTo(ip);
    return (blacklistMapper.countByExample(example)>0);
  }

  public boolean isExists(Blacklist blacklist){
    BlacklistExample example=new BlacklistExample();
        example.
        createCriteria().
        andIdEqualTo(blacklist.getId()).
        andIpEqualTo(blacklist.getIp());
    return (blacklistMapper.countByExample(example)>0);
  }

}
