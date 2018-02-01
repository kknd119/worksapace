package com.spring81.bbs.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring81.bbs.inf.IUser;
import com.spring81.bbs.model.ModelUser;

@Repository("daouser")
public class DaoUser implements IUser {

    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;    
    
    @Override
    public int insertUser(ModelUser user) {
        return session.insert("mapper.mapperUser.insertUser", user);   
    }

    @Override
    public ModelUser login(ModelUser user) {
        return session.selectOne("mapper.mapperUser.login", user);
    }

    @Override
    public int logout(String userid) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateUserInfo(ModelUser setValue, ModelUser whereValue) {
        
        Map<String, ModelUser> parameter = new HashMap<String, ModelUser>(); 
        parameter.put("setValue"  ,      setValue);
        parameter.put("whereValue",      whereValue);

        return session.update("mapper.mapperUser.updateUserInfo", parameter);
    }

    @Override
    public int updatePasswd(String userid, String currentPasswd, String newPasswd) {
        Map<String,String> parameter = new HashMap<String,String>();
        parameter.put("userid", userid);
        parameter.put("currentPasswd", currentPasswd);
        parameter.put("newPasswd", newPasswd);
        
        return session.update("mapper.mapperUser.updatePasswd", parameter);
    }

    @Override
    public int deleteUser(ModelUser user) {
        return session.delete("mapper.mapperUser.deleteUser", user);
    }

    @Override
    public ModelUser selectUserOne(ModelUser user) {
        return session.selectOne("mapper.mapperUser.selectUserOne", user);
    }

    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
        return session.selectList("mapper.mapperUser.selectUserList", user);
    }

    @Override
    public int checkuserid(String user) {
        return session.selectOne("mapper.mapperUser.checkuserid", user);
        
    }

    @Override
    public int updateRetire(ModelUser user) {
         int result=session.update("mapper.mapperUser.updateRetire", user);
         return result;
    }

    @Override
    public int checkpassword(String id, String curpw) {
        Map<String, String> map = new HashMap<String,String>();
        map.put("id",id);
        map.put("pw",curpw);
        return session.selectOne("mapper.mapperUser.checkpassword", map);
    }
    
}
