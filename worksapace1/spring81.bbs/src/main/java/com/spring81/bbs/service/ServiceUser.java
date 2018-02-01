package com.spring81.bbs.service;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring81.bbs.inf.IServiceUser;
import com.spring81.bbs.inf.IUser;
import com.spring81.bbs.model.ModelUser;

@Service("serviceuser")
public class ServiceUser implements IServiceUser {
    
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceUser.class);

    @Autowired
    @Qualifier("daouser")
    private IUser daouser;

    public ServiceUser() {
        super();
    }

    @Override
    public int insertUser(ModelUser user) {
        
        int result = -1;
        try {
            result = daouser.insertUser(user);
            //session.commit();
        } catch (Exception e) {
            logger.error("insertUser " + e.getMessage() );
        }
		
        return result;
    }

    @Override
    public ModelUser login(ModelUser user) {
        
        ModelUser result = null;
		
        try {
            result = daouser.login(user);
        } catch (Exception e) {
            logger.error("login " + e.getMessage() );
        }
        return result;
    }

    @Override
    public int logout(String userid) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateUserInfo(ModelUser setValue, ModelUser whereValue) {
        int result = -1;
        try {
            result = daouser.updateUserInfo(setValue, whereValue);
        } catch (Exception e) {
            logger.error("updateUserInfo" + e.getMessage() );
        }
        return result;
    }

    @Override
    public int updatePasswd(String userid, String currentPasswd, String newPasswd) {
        int result = -1;
        try {
            result = daouser.updatePasswd(userid,currentPasswd,newPasswd);
        } catch (Exception e) {
            logger.error("updateUserInfo" + e.getMessage() );
        }
        return result;
    }

    @Override
    public int deleteUser(ModelUser whereValue) {
        int result = -1;
        try {
            result = daouser.deleteUser(whereValue);
        } catch (Exception e) {
            logger.error("updateUserInfo " + e.getMessage() );
        }
        return result;
    }

    @Override
    public ModelUser selectUserOne(ModelUser user) {
        ModelUser result = null;
        try {
            result = daouser.selectUserOne(user);
        } catch (Exception e) {
            logger.error("selectUserOne " + e.getMessage() );
        }
        return result;
    }

    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
        List<ModelUser> result = null;
        try {
            result = daouser.selectUserList(user);
        } catch (Exception e) {
            logger.error("selectUserList " + e.getMessage() );
        }
        return result;
    }

    @Override
    public int checkuserid(String user) {
        
        int result = -1;
        try {
            result = daouser.checkuserid(user);
        } catch (Exception e) {
            logger.error("selectUserOne " + e.getMessage() );
        }
        return result;
    }

    @Override
    public int updateRetire(ModelUser user) {
        
        int result = -1;
        try {
            result = daouser.updateRetire(user);
        } catch (Exception e) {
            logger.error("updateRetire " + e.getMessage() );
        }
        return result;
    }

    @Override
    public int checkpassword(String id, String curpw) {
        int result = -1;
        try {
            result = daouser.checkpassword(id,curpw);
        } catch (Exception e) {
            logger.error("checkpassword " + e.getMessage() );
        }
        return result;
    }
}
