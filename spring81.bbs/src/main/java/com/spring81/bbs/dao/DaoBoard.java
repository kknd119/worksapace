package com.spring81.bbs.dao;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Qualifier;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.StringUtils;
import com.spring81.bbs.inf.IBoard;
import com.spring81.bbs.model.ModelArticle;
import com.spring81.bbs.model.ModelArticleImage;
import com.spring81.bbs.model.ModelAttachFile;
import com.spring81.bbs.model.ModelBoard;
import com.spring81.bbs.model.ModelComments;

@Repository("daoboard")
public class DaoBoard implements IBoard {
    
    @Autowired
    //@Qualifier("sqlSession");
    private SqlSession session;    

    @Override
    public String getBoardName(String boardcd) {
        return  session.selectOne("mapper.mapperBoard.getBoardName", boardcd);        
    }

    @Override
    public ModelBoard getBoardOne(String boardcd) {
        return  session.selectOne("mapper.mapperBoard.getBoardOne", boardcd);        
    }

    @Override
    public int getBoardTotalRecord(String boardnm) {
        return  session.selectOne("mapper.mapperBoard.getBoardTotalRecord", boardnm); 
    }

    @Override
    public List<ModelBoard> getBoardList(String searchWord) {
        return  session.selectList("mapper.mapperBoard.getBoardList", searchWord);        
    }

    @Override
    public int insertBoard(ModelBoard board) {
        return  session.insert("mapper.mapperBoard.insertBoard", board);        
    }

    @Override
    public int updateBoard(ModelBoard setValue, ModelBoard whereValue) {
        Map<String, ModelBoard> map = new HashMap<String, ModelBoard>();
        map.put("setValue", setValue);
        map.put("whereValue", whereValue);
        return  session.update("mapper.mapperBoard.updateBoard", map);        
    }

    @Override
    public int deleteBoard(ModelBoard board) {
        return  session.delete("mapper.mapperBoard.deleteBoard", board);        
    }

    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) {
        return  session.selectList("mapper.mapperBoard.getBoardSearch", board);        
    }

    @Override
    public List<ModelBoard> getBoardPaging(String boardcd, String searchWord, int start, int end) {
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardcd"   , boardcd.isEmpty()    ?  null : boardcd            );
        map.put("searchWord", searchWord.isEmpty() ?  null : "%"+searchWord+"%" );
        map.put("start"     , start      );
        map.put("end"       , end        );
        
        return  session.selectList("mapper.mapperBoard.getBoardPaging", map); 
    }

    @Override
    public int insertBoardList(List<ModelBoard> list) {
        return  session.insert("mapper.mapperBoard.insertBoardList", list);        
    }

    @Override
    public int getArticleTotalRecord(String boardcd, String searchWord) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("boardcd"   , boardcd    );
        map.put("searchWord", searchWord );
        
        return  session.selectOne("mapper.mapperBoard.getArticleTotalRecord", map);        
    }

    @Override
    public List<ModelArticle> getArticleList(String boardcd, String searchWord, int start, int end) {
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardcd"   , boardcd    );
        map.put("searchWord", searchWord );
        map.put("start"     , start      );
        map.put("end"       , end        );
        
        return  session.selectList("mapper.mapperBoard.getArticleList", map);        
    }

    @Override
    public ModelArticle getArticle(int articleno) {
        return  session.selectOne("mapper.mapperBoard.getArticle", articleno);        
    }

    @Override
    public int insertArticle(ModelArticle article) {
          session.insert("mapper.mapperBoard.insertArticle", article );      
          
          return article.getArticleno();
    }

    @Override
    public int updateArticle(ModelArticle setValue, ModelArticle whereValue) {
        
        Map<String, ModelArticle> map = new HashMap<String, ModelArticle>();
        map.put("setValue", setValue);
        map.put("whereValue", whereValue);
        
        return  session.update("mapper.mapperBoard.updateArticle", map );    
    }

    @Override
    public int deleteArticle(ModelArticle article) {
        return  session.delete("mapper.mapperBoard.deleteArticle", article ); 
    }

    @Override
    public int increaseHit(int articleno) {
        return  session.update("mapper.mapperBoard.increaseHit", articleno ); 
    }

    @Override
    public ModelArticle getNextArticle(int articleno, String boardcd, String searchWord) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardcd"   , boardcd    );
        map.put("articleno" , articleno  );
        map.put("searchWord", searchWord );
        
        return  session.selectOne("mapper.mapperBoard.getNextArticle", map);        
    }

    @Override
    public ModelArticle getPrevArticle(int articleno, String boardcd, String searchWord) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardcd"   , boardcd    );
        map.put("articleno" , articleno  );
        map.put("searchWord", searchWord );
        return  session.selectOne("mapper.mapperBoard.getPrevArticle", map);        
    }

    @Override
    public ModelAttachFile getAttachFile(int attachFileNo) {
        return  session.selectOne("mapper.mapperBoard.getAttachFile", attachFileNo);        
    }

    @Override
    public List<ModelAttachFile> getAttachFileList(int articleno) {
        return  session.selectList("mapper.mapperBoard.getAttachFileList", articleno);        
    }

    @Override
    public int insertAttachFile(ModelAttachFile attachFile) {
        return  session.insert("mapper.mapperBoard.insertAttachFile", attachFile );        
    }

    @Override
    public int deleteAttachFile(ModelAttachFile attachFile) {
        return  session.delete("mapper.mapperBoard.deleteAttachFile", attachFile );        
    }

    @Override
    public int insertComment(ModelComments comment) {
        //inserted된 primary key 값,commentno를 반환 
        session.insert("mapper.mapperBoard.insertComment", comment );     
        int result = comment.getCommentno();
        return result;
    }

    @Override
    public int updateComment(ModelComments setValue, ModelComments whereValue) {
        
        Map<String, ModelComments> map = new HashMap<>();
        map.put("setValue", setValue);
        map.put("whereValue", whereValue);
        
        return  session.update("mapper.mapperBoard.updateComment", map );        
    }

    @Override
    public int deleteComment(ModelComments comment) {
        return  session.delete("mapper.mapperBoard.deleteComment", comment );        
    }

    @Override
    public ModelComments getComment(int commentNo) {
        return  session.selectOne("mapper.mapperBoard.getComment", commentNo);        
    }

    @Override
    public List<ModelComments> getCommentList(int articleno) {
        return  session.selectList("mapper.mapperBoard.getCommentList", articleno);        
    }
    
    @Override
    public ModelArticleImage getArticleImage(int articleImageno) {
        return  session.selectOne("mapper.mapperBoard.getArticleImage", articleImageno);   
    }

    @Override
    public int insertArticleImage(ModelArticleImage articleImage) {
        session.insert("mapper.mapperBoard.insertArticleImage", articleImage );      
        
        return articleImage.getArticleno();
    }

    @Override
    public int getArticleImageTotalRecord(String boardcd, String searchWord) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("boardcd"   , boardcd    );
        map.put("searchWord", searchWord );
        
        return  session.selectOne("mapper.mapperBoard.getArticleImageTotalRecord", map);   
    }

    @Override
    public List<ModelArticleImage> getArticleImageList(String boardcd,
            String searchWord, int start, int end) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("boardcd"   , boardcd    );
        map.put("searchWord", searchWord );
        map.put("start"     , start      );
        map.put("end"       , end        );
        
        return  session.selectList("mapper.mapperBoard.getArticleImageList", map); 
    }

    @Override
    public int updateArticleImage(ModelArticleImage setValue,
            ModelArticleImage whereValue) {
        Map<String, ModelArticleImage> map = new HashMap<String, ModelArticleImage>();
        map.put("setValue", setValue);
        map.put("whereValue", whereValue);
        
        return  session.update("mapper.mapperBoard.updateArticleImage", map );    
    }

    @Override
    public int deleteArticleImage(ModelArticleImage article) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ModelArticleImage getNextArticleImage(int articleno, String boardcd,
            String searchWord) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ModelArticleImage getPrevArticleImage(int articleno, String boardcd,
            String searchWord) {
        // TODO Auto-generated method stub
        return null;
    }
  
    
}
