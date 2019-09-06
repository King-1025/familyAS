package king.familyAS.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import king.gen.entity.State;
import king.gen.entity.StateExample;
import king.gen.mapper.StateMapper;

@Service
public class StateService {
   
   public final static int ADD_STATE_FAILED=-1;
   public final static int QUERY_STATE_ID_FAILED=-2;
   public final static int QUERY_STATE_FAILED=-3;
   
   @Autowired
   private StateMapper stateMapper;

   public boolean addState(State state){
     return (stateMapper.insertSelective(state)>0);
   }
  
   public int addState(int status,String profile){
     State state = new State();
     state.setState(status);
     state.setProfile(profile);
     if(this.addState(state)){
        return this.queryId(status,profile);
     }else{
        return ADD_STATE_FAILED;
     }
   }
  
   public boolean deleteState(int id){
     return (stateMapper.deleteByPrimaryKey(id)>0);
   }

   public boolean changeState(State state){
     return (stateMapper.updateByPrimaryKeySelective(state)>0);
   }

   public State obtainStateById(int id){
     return stateMapper.selectByPrimaryKey(id);
   }

   public State obtainState(int status){
     return obtainState(status,null,-1);
   }

   public State obtainState(String profile){
     return obtainState(0,profile,1);
   }

   public State obtainState(int status,String profile){
     return obtainState(status,profile,0);
   }

   private State obtainState(int status,String profile,int flag){
     StateExample example=new StateExample();
     if(flag < 0){
       example.
       createCriteria().
       andStateEqualTo(status);
     }else if(flag == 0){
       example.
       createCriteria().
       andStateEqualTo(status).
       andProfileEqualTo(profile);
     }else{
       example.
       createCriteria().
       andProfileEqualTo(profile);
     }
     List<State> listState = stateMapper.selectByExample(example);
     if(listState!=null && listState.size() > 0){
        return listState.get(0);
     }else{
        return null;
     }
   }

   public int queryState(int id){
	 State state=this.obtainStateById(id);
	 if (state!=null){
             return state.getState();
	 }else{
             return QUERY_STATE_FAILED;
	 }
   }

   public String queryProfile(int id){
	 State state=this.obtainStateById(id);
	 if (state!=null){
             return state.getProfile();
	 }else{
             return null;
	 }
   }

   public int queryId(int status){
       return queryId(status,null,-1);
   }
   
   public int queryId(String profile){
       return queryId(0,profile,1);
   }

   public int queryId(int status,String profile){
       return queryId(status,profile,0);
   }

   private int queryId(int status,String profile,int flag){
     State state=this.obtainState(status,profile,flag);
     if(state!=null){
	return state.getId();
     }else{
        return QUERY_STATE_ID_FAILED;
     }
   }

}
