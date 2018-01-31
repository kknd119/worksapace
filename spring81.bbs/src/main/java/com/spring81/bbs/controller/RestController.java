package com.spring81.bbs.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring81.bbs.inf.IServiceBoard;
import com.spring81.bbs.inf.IServiceUser;
import com.spring81.bbs.model.ModelArticle;
import com.spring81.bbs.model.ModelAttachFile;
import com.spring81.bbs.model.ModelBoard;
import com.spring81.bbs.model.ModelComments;
import com.spring81.bbs.model.ModelUser;



/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/rest")
public class RestController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestController.class);
	
    //ServiceUser 인스턴스 만들기~~
	@Autowired
	IServiceUser usersvr;
	
	@RequestMapping(value = "/curtime", method = {RequestMethod.GET} )
	@ResponseBody
	public long curtime(Model model) {
	logger.info("/curtime");
	
	return new Date().getTime();
		
	}
	
	//
	@RequestMapping(value = "/selectuserlist", method = {RequestMethod.GET,RequestMethod.POST} )
	@ResponseBody
	public List<ModelUser> selectuserlist(Model model) {
	    
	    List<ModelUser> list =usersvr.selectUserList(null);
	    
		
		return list;
	}
	@RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
    public ModelUser login(String userid,String passwd) {
	    logger.info("/login");
	    ModelUser user = new ModelUser();
	    user.setUserid(userid);
	    user.setPasswd(passwd);
	    
        
        return usersvr.login(user);
    }
	@RequestMapping(value = "/logout", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
    public int logout(String userid) {
        logger.info("/logout");
       
          
        return usersvr.logout(userid);
    }
	@RequestMapping(value = "/checkuserid", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
    public int checkuserid(String userid) {
        //logger.info("/rest/checkuserid");
                  
        return usersvr.checkuserid(userid);
    }
	@RequestMapping(value = "/updatePasswd", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
    public int updatePasswd(String userid,String  currentPasswd, String newPassword) {
        logger.info("/updatePasswd");
           
        return usersvr.updatePasswd(userid,currentPasswd,newPassword);
    }
	
	@RequestMapping(value = "/insertUser", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
    public int insertUser(@ModelAttribute ModelUser user) {
        logger.info("/rest/insertUser");
        return usersvr.insertUser(user);
    }
	
	@RequestMapping(value = "/updateUserInfo", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
    public int updateUserInfo(@RequestBody Map<ModelUser,ModelUser>maps) {
        logger.info("/updateUserInfo");
        ModelUser setValue = maps.get("setValue");
        ModelUser whereValue = maps.get("whereValue");
              
          
        return usersvr.updateUserInfo(setValue, whereValue);
    }
	
	@RequestMapping(value = "/deleteUser", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
    public int deleteUser(ModelUser user) {
        logger.info("/rest/deleteUser");
        return usersvr.deleteUser(user);
    }
	@RequestMapping(value = "/selectUserOne", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
    public ModelUser selectUserOne(ModelUser user) {
        logger.info("/rest/deleteUser");
        return usersvr.selectUserOne(user);
    }
	@RequestMapping(value = "/updateRetire", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
    public int updateRetire(@RequestBody ModelUser user) {
        logger.info("/rest/updateRetire");
                  
        return usersvr.updateRetire(user);
    }
	
	/////////////////보드 관련 
	@Autowired
	IServiceBoard boardsvr;
	
	@RequestMapping(value = "/getBoardOne", method = {RequestMethod.GET,RequestMethod.POST} )
	@ResponseBody
	public ModelBoard getBoardOne ( @RequestParam("cd") String boardcd) {
	    logger.info("/getBoardOne");
	ModelBoard board = boardsvr.getBoardOne(boardcd);
	return board;
	}
	@RequestMapping(value = "/getBoardName", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
    public String getBoardName ( @RequestParam("cd") String boardcd) {
        logger.info("/rest/getBoardName");
    String board = boardsvr.getBoardName(boardcd);
    return board;
    }
	@RequestMapping(value = "/getBoardTotalRecord", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
    public int getBoardTotalRecord ( String searchWord) {
        logger.info("/rest/getBoardTotalRecord");
    int board = boardsvr.getBoardTotalRecord(searchWord);
    return board;
    }
	@RequestMapping(value = "/getBoardPaging", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
    public List<ModelBoard> getBoardPaging ( String boardcd, String searchWord,@RequestParam(defaultValue="0") int start, @RequestParam(defaultValue="10")int end) {
        logger.info("/rest/getBoardPaging");
    List<ModelBoard> board = boardsvr.getBoardPaging(searchWord, searchWord, start, end);
    return board;
    }
	@RequestMapping(value = "/getBoardList", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
    public List<ModelBoard> getBoardList ( String searchWord) {
        logger.info("/rest/getBoardList");
    List<ModelBoard> board = boardsvr.getBoardList(searchWord);
    return board;
    }
	@RequestMapping(value = "/getBoardSearch", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
	public List<ModelBoard> getBoardSearch ( ModelBoard board) {
        logger.info("/rest/getBoardSearch");
    List<ModelBoard> boardlist = boardsvr.getBoardSearch(board);
    return boardlist;
    }
	@RequestMapping(value = "/insertBoard", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
	public int insertBoard ( ModelBoard board) {
        logger.info("/rest/insertBoard");
    int result = boardsvr.insertBoard(board);
    return result;
    }
	@RequestMapping(value = "/deleteBoard", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
	public int deleteBoard ( ModelBoard board) {
        logger.info("/rest/deleteBoard");
    int result = boardsvr.deleteBoard(board);
    return result;
    }
	@RequestMapping(value = "/insertBoardList", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
	public int insertBoardList ( List<ModelBoard> list) {
        logger.info("/rest/insertBoardList");
    int result = boardsvr.insertBoardList(list);
    return result;
    }
	@RequestMapping(value = "/getArticleTotalRecord", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
	public int getArticleTotalRecord ( String boardcd, String searchWord) {
        logger.info("/rest/getArticleTotalRecord");
    int result = boardsvr.getArticleTotalRecord( boardcd,  searchWord);
    return result;
    }
	@RequestMapping(value = "/getArticleList", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
	public List<ModelArticle> getArticleList (String boardcd, String searchWord, int start, int end) {
        logger.info("/rest/getArticleList");
    List<ModelArticle> result = boardsvr.getArticleList( boardcd,  searchWord,start,end);
    return result;
    }
	@RequestMapping(value = "/getArticle", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody	
	public ModelArticle getArticle (int articleno) {
        logger.info("/rest/getArticle");
    ModelArticle result = boardsvr.getArticle(  articleno);
    return  result;
    }
	
	@RequestMapping(value = "/insertArticle", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody	
	public int insertArticle (ModelArticle article) {
        logger.info("/rest/insertArticle");
    int result = boardsvr.insertArticle(  article);
    return  result;
    }
	@RequestMapping(value = "/updateArticle", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody   
	public int updateArticle (ModelArticle setValue, ModelArticle whereValue) {
        logger.info("/rest/updateArticle");
    int result = boardsvr.updateArticle(  setValue,whereValue);
    return  result;
    }
	@RequestMapping(value = "/deleteArticle", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
	public int deleteArticle (ModelArticle article) {
        logger.info("/rest/deleteArticle");
    int result = boardsvr.deleteArticle( article);
    return  result;
    }
	@RequestMapping(value = "/increaseHit", method = {RequestMethod.POST} )
    @ResponseBody
	public int increaseHit (int articleno) {
        logger.info("/rest/increaseHit");
    int result = boardsvr.increaseHit( articleno);
    return  result;
    }
	@RequestMapping(value = "/getNextArticle", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
	public ModelArticle getNextArticle (int articleno, String boardcd, String searchWord) {
        logger.info("/rest/getNextArticle");
    ModelArticle result = boardsvr.getNextArticle( articleno,boardcd,searchWord);
    return  result;
    }
	@RequestMapping(value = "/getPrevArticle", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
	public ModelArticle getPrevArticle (int articleno, String boardcd, String searchWord) {
        logger.info("/rest/getPrevArticle");
    ModelArticle result = boardsvr.getPrevArticle( articleno,boardcd,searchWord);
    return  result;
    }
	@RequestMapping(value = "/getAttachFile", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
	public ModelAttachFile getAttachFile (int attachFileNo) {
        logger.info("/rest/getAttachFile");
    ModelAttachFile result = boardsvr.getAttachFile( attachFileNo);
    return  result;
    }
	@RequestMapping(value = "/getAttachFileList", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
	public List<ModelAttachFile> getAttachFileList (int articleno) {
        logger.info("/rest/getAttachFileList");
    List<ModelAttachFile> result = boardsvr.getAttachFileList( articleno);
    return  result;
    }
	@RequestMapping(value = "/insertAttachFile", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
	public int insertAttachFile (ModelAttachFile attachFile) {
        logger.info("/rest/insertAttachFile");
    int result = boardsvr.insertAttachFile( attachFile);
    return  result;
    }
	@RequestMapping(value = "/deleteAttachFile", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
	public int deleteAttachFile (ModelAttachFile attachFile) {
        logger.info("/rest/deleteAttachFile");
    int result = boardsvr.deleteAttachFile( attachFile);
    return  result;
    }
	@RequestMapping(value = "/getComment", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
	public ModelComments getComment (int commentNo) {
        logger.info("/rest/getComment");
    ModelComments result = boardsvr.getComment( commentNo);
    return  result;
    }
	@RequestMapping(value = "/getCommentList", method = {RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
	public List<ModelComments> getCommentList (int articleno) {
        logger.info("/rest/getCommentList");
    List<ModelComments> result = boardsvr.getCommentList( articleno);
    return  result;
    }
	@RequestMapping(value = "/insertComment", method = {RequestMethod.POST} )
    //@ResponseBody
	public String insertComment (Model model,@RequestBody ModelComments comment) {
        logger.info("/rest/insertComment");
        int commentno=boardsvr.insertComment(comment);
        if(commentno>0) {
            ModelComments result=boardsvr.getComment(commentno);
            model.addAttribute("comment",result);
            return  "board/articleview-commentlistbody";
        }
        else
            return"";
    }
	@RequestMapping(value = "/updateComment", method = {RequestMethod.POST} )
    @ResponseBody
	public int updateComment (@RequestBody ModelComments comment  ) {
        logger.info("/rest/updateComment");
        ModelComments setValue =new ModelComments();
        setValue.setMemo(comment.getMemo());
        
        ModelComments whereValue =new ModelComments();
        whereValue.setCommentno(comment.getCommentno());
        
    int result = boardsvr.updateComment( setValue,whereValue);
    return  result;
    }
	@RequestMapping(value = "/deleteComment", method = {RequestMethod.POST} )
    @ResponseBody
	public int deleteComment (@RequestBody ModelComments comment) {
        logger.info("/rest/deleteComment");
    int result = boardsvr.deleteComment( comment);
    return  result;
    }
	
	
	
	
	
}
