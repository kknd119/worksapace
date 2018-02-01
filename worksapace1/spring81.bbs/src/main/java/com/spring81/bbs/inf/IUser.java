package com.spring81.bbs.inf;

import java.util.List;

import com.spring81.bbs.model.ModelUser;



public interface IUser {
   
   int checkuserid(String user); 

   int insertUser(ModelUser user);
   
   ModelUser login(ModelUser user );
   
   int logout(String userid);
   
   int updateUserInfo(ModelUser setValue, ModelUser whereValue);
   
   int updatePasswd(String userid, String currentPasswd, String newPasswd);
   
   int updateRetire(ModelUser user);
   
   int deleteUser(ModelUser user);
   
   ModelUser selectUserOne(ModelUser user);
   
   List<ModelUser> selectUserList(ModelUser user);
   
   //패스워드 확인 :패스워드는  암호화 되기때문 직접 비교 불가하여.
   int checkpassword(String id,String curpw);   
   
}
