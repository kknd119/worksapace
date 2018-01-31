package com.spring81.bbs.controller;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;

import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring81.bbs.common.PagingHelper;
import com.spring81.bbs.common.WebConstants;
import com.spring81.bbs.inf.IServiceBoard;
import com.spring81.bbs.model.ModelArticle;
import com.spring81.bbs.model.ModelArticleImage;
import com.spring81.bbs.model.ModelAttachFile;
import com.spring81.bbs.model.ModelBoard;
import com.spring81.bbs.model.ModelComments;

import aj.org.objectweb.asm.Attribute;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	IServiceBoard srvboard;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/board/boardlist", method = RequestMethod.GET)
	public String boardlist( Model model
	        ,@RequestParam(defaultValue="") String searchWord
	        ,@RequestParam(defaultValue="1") Integer curPage) {
		logger.info("boardlist");
		//페이징을 위한 코드 추가
		int totalRecord = srvboard.getBoardTotalRecord(searchWord);
		
		//페이징을 위한 코드 추가.
		PagingHelper pasing = new PagingHelper(totalRecord, curPage,5,5);
		
		int start = pasing.getStartRecord();
		int end   =   pasing.getEndRecord() ;    
		
		List<ModelBoard> result = srvboard.getBoardPaging("", searchWord,start ,end );
		//list
		model.addAttribute("list",result);
		//페이징을 위한 변수들 추가
		model.addAttribute("curPage",curPage);
		model.addAttribute("searchWord",searchWord);
		
		//페이징 처리하기 위한 변수 추가
		model.addAttribute("no",pasing.getListNo());
		model.addAttribute("prevLink",pasing.getPrevLink());
		model.addAttribute("pageLinks",pasing.getPageLinks());
		model.addAttribute("nextLink",pasing.getNextLink());
		
		return "/board/boardlist";
	}
	@RequestMapping(value = "/board/boardview", method = RequestMethod.GET)
    public String boardview( Model model,@RequestParam(defaultValue="free") String boardcd) {
        logger.info("boardview");
        
       ModelBoard result = srvboard.getBoardOne(boardcd);
       //boardNM,board 
       model.addAttribute("boardNm",result.getBoardnm());
       model.addAttribute("board",result);
        return "/board/boardview";
        
    }
	@RequestMapping(value = "/board/boardview/{boardcd}", method = RequestMethod.GET)
    public String boardviewp( Model model,@PathVariable String boardcd) {
        logger.info("boardview");
        
       ModelBoard result = srvboard.getBoardOne(boardcd);
       //boardNM,board 
       model.addAttribute("boardNm",result.getBoardnm());
       model.addAttribute("board",result);
        return "/board/boardview";
    }
	@RequestMapping(value = "/board/boardmodify", method = RequestMethod.GET)
    public String boardmodify( Model model,@RequestParam(defaultValue="free") String boardcd
            ,HttpServletRequest request) {
        logger.info("boardmodify");
        
       ModelBoard result = srvboard.getBoardOne(boardcd);
       //boardNM,board
       String actionurl =request.getRequestURL().toString();
       model.addAttribute("boardNm",result.getBoardnm());
       model.addAttribute("board",result);
       model.addAttribute("actionurl",actionurl);
        return "/board/boardmodify";
    }
	@RequestMapping(value = "/board/boardmodify/{boardcd}", method = RequestMethod.GET)
    public String boardmodifyp( Model model,@PathVariable(value="boardcd") String boardcd
            ,HttpServletRequest request) {
        logger.info("/board/boardmodify/{boardcd}");
        
       ModelBoard result = srvboard.getBoardOne(boardcd);
       //boardNM,board
       String actionurl =request.getRequestURL().toString();
       model.addAttribute("boardNm",result.getBoardnm());
       model.addAttribute("board",result);
       model.addAttribute("actionurl",actionurl);
        return "/board/boardmodify";
    }
	@RequestMapping(value = "/board/boardmodify", method = RequestMethod.POST)
    public String boardmodifym( Model model
            ,@ModelAttribute ModelBoard setValue
            ,RedirectAttributes rttr) {
        logger.info("/board/boardmodify");
        ModelBoard whereValue= new ModelBoard();
        whereValue.setBoardcd(setValue.getBoardcd());
        int result = srvboard.updateBoard(setValue, whereValue);
        
        if(result>0) {
            return "redirect:/board/boardlist";
        }
        else {
            //RedirectAttributes를이용하여 오류 메시지 전달. 
            rttr.addFlashAttribute("msg",WebConstants.MSG_FAIL_UPDATE_TABLE);
            rttr.addFlashAttribute("boardcd",setValue.getBoardcd());
            return "redirect:/board/boardmodify";
        }
            
        
    }
	@RequestMapping(value = "/board/boardwrite", method = RequestMethod.GET)
    public String boardwrite( Model model) {
           
        logger.info("/board/boardwrite");
        
        return "/board/boardwrite";
    }
	@RequestMapping(value = "/board/boardwrite", method = RequestMethod.POST)
    public String boardwritep( Model model,@ModelAttribute ModelBoard board
            ,RedirectAttributes rttr) {
           
        logger.info("/board/boardwrite");
        
        int result=srvboard.insertBoard(board);
        
        if(result>0)
            return "redirect:/board/boardview/"+board.getBoardcd();
        else {
            rttr.addFlashAttribute("msg",WebConstants.MSG_FAIL_INSERT_TABLE);
            rttr.addFlashAttribute("board",board);
            return "/board/boardwrite";
        }
            
    }
	
	@RequestMapping(value = "/board/boarddelete", method = RequestMethod.POST)
    public String delete( Model model 
            ,@RequestParam(value="boardcd")String boardcd
            ,RedirectAttributes rttr ) {
        
	    logger.info("/board/boarddelete");
	    ModelBoard board = new ModelBoard();
	    board.setBoardcd(boardcd);
	    
	    int result = srvboard.deleteBoard(board);
	    
	    if(result>0)
            return "redirect:/board/board"
                    + "/";
        else {
            rttr.addFlashAttribute("msg",WebConstants.MSG_FAIL_DELETE_TABLE);
            rttr.addFlashAttribute("board",board);
            return "redirect:/board/boardwrite";
        }
    }
	//board/articleist/free?
	//board/articleist/qna?
	@RequestMapping(value = "/board/articlelist/{boardcd}", method = RequestMethod.GET)
    public String articlelist( Model model
            ,@PathVariable String boardcd
            ,@RequestParam(defaultValue="1") Integer curPage
            ,@RequestParam(defaultValue="") String searchWord
            ,HttpServletRequest request){
        logger.info("articlelist");
        
        
        //List <ModelArticle> result = srvboard.getArticleList(boardcd, searchWord);
        
        //boardnm,articlelist,no,pageLinks,curpage,nextLink,boardcd,searchword,url jsp에 넘김
      
        //paging처리
        int totalRecord = srvboard.getArticleTotalRecord(boardcd, searchWord);
        
        PagingHelper paging = new PagingHelper(totalRecord,curPage);
        
        int start = paging.getStartRecord();
        int end   = paging.getEndRecord();
        
        List<ModelArticle> result = srvboard.getArticleList(boardcd, searchWord, start, end);
        
        model.addAttribute("boardnm",srvboard.getBoardName(boardcd));
        model.addAttribute("boardcd",boardcd);
        model.addAttribute("searchWord",searchWord);
        model.addAttribute("curPage",curPage);
        
        model.addAttribute("articleList",result);
        model.addAttribute("no",paging.getListNo());
        model.addAttribute("prevLink",paging.getPrevLink());
        model.addAttribute("pageLinks",paging.getPageLinks());
        model.addAttribute("nextLink",paging.getNextLink());
        model.addAttribute("url",request.getRequestURI().toString());
        
      
        return "/board/articlelist";
        
    }
	//board/articlelist
	@RequestMapping(value = "/board/articlelist", method = RequestMethod.GET)
    public String articlelist( Model model,@RequestParam(defaultValue="free") String boardcd){
            
        logger.info("/articlelist");
        
        return "redirect:/board/articlelist/"+boardcd;
	}
	//board/articleview/free17
	//board/articleview/free/17?curPage=1&searchWord=
	@RequestMapping(value = "/board/articleview/{boardcd}/{articleno}", method = RequestMethod.GET)
    public String articlelview( Model model
            ,@PathVariable String boardcd
            ,@PathVariable Integer articleno
            ,@RequestParam(defaultValue="1") Integer curPage
            ,@RequestParam(defaultValue="") String searchWord
            ,HttpServletRequest request){
            
        logger.info("/articleview");
        
               
        //articleno,boardcd,articleno
        model.addAttribute("boardcd",boardcd      );
        model.addAttribute("articleno",articleno  );
        model.addAttribute("curPage",curPage      );
        model.addAttribute("searchWord",searchWord);
        
        //boardnm 
        
        model.addAttribute("boardNm",srvboard.getBoardName(boardcd));
        
        //thisArticle
        
        ModelArticle thisArticle =srvboard.transArticle(articleno);
        model.addAttribute("thisArticle",thisArticle);
        
        //attachFileList
        List<ModelAttachFile> attachFileList=srvboard.getAttachFileList(articleno);
        model.addAttribute("attachFileList",attachFileList);
        
        List<ModelComments> commentList=srvboard.getCommentList(articleno);
        model.addAttribute("commentList",commentList);
        
        ModelArticle nextArticle = srvboard.getNextArticle(articleno, boardcd, searchWord);
        model.addAttribute("nextArticle",nextArticle);
        
        ModelArticle prevArticle = srvboard.getPrevArticle(articleno, boardcd, searchWord);
        model.addAttribute("prevArticle",prevArticle);
        
        
        
        //,articleno ,no, articlelist, prevpage,pageLinks,curpage,actionurl
        
        int totalRecord = srvboard.getArticleTotalRecord(boardcd, searchWord);
        PagingHelper paging = new PagingHelper(totalRecord,curPage);
        int start = paging.getStartRecord();
        int end   = paging.getEndRecord();
        
        List<ModelArticle> articlelist = srvboard.getArticleList(boardcd, searchWord, start, end);
        
        model.addAttribute("articleList",articlelist);
        model.addAttribute("no",paging.getListNo());
        model.addAttribute("prevLink",paging.getPrevLink());
        model.addAttribute("pageLinks",paging.getPageLinks());
        model.addAttribute("nextLink",paging.getNextLink());
        
        String actionurl =request.getRequestURL().toString();
        model.addAttribute("actionurl",actionurl);
        
        return "board/articleview";
    }

	@RequestMapping(value = "/board/articlewrite/{boardcd}", method = RequestMethod.GET)
    public String articlewrite( Model model
            ,@PathVariable String boardcd
            ,@RequestParam(defaultValue="1") Integer curPage
            ,@RequestParam(defaultValue="") String searchWord
            ,HttpServletRequest request){
            
        logger.info("/articlewrite:get");
        
        //boardnm ,boardcd 
        model.addAttribute("boardNm",srvboard.getBoardName(boardcd));
        model.addAttribute("boardcd",boardcd);
        
        return "board/articlewrite";
       
    }
	
	@RequestMapping(value = "/board/articlewrite", method = RequestMethod.POST)
    public String articlewritep( Model model
            ,@ModelAttribute ModelArticle article 
            ,@RequestParam(defaultValue="upload") MultipartFile upload
            ,@RequestParam(defaultValue="1") Integer curPage
            ,@RequestParam(defaultValue="") String searchWord ){
            
        logger.info("/articlewrite:post");
        
      //1.tb_bbs_artcle table insert. inserted pk 값을 반환 받는다.
       int insertedpk = srvboard.insertArticle(article);
      //2. client의 파일을 server로 upload
       java.io.File uploadDir = new java.io.File (WebConstants.UPLOAD_PATH);
        if(!uploadDir.exists())uploadDir.mkdirs();  
             
            // 클라이언트의 파일을 서버로 복사
           String fileName = upload.getOriginalFilename();
           String tempName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
           String newFile = WebConstants.UPLOAD_PATH+tempName;//c:/upload/20180707115415
           java.io.File serverfile = new java.io.File(newFile);
           
           //실제로 파일 카피 발생.
           try {
            upload.transferTo(serverfile);
        } catch (IllegalStateException e) {
            logger.error("articlewrite"+e.getMessage());
        } catch (IOException e) {
            logger.error("/articlewrite:post"+e.getMessage());
        }
          if(serverfile.exists()) {
         
              ModelAttachFile attachfile = new ModelAttachFile();
              attachfile.setArticleno(insertedpk);
              attachfile.setFilenameorig(fileName);
              attachfile.setFilenametemp(tempName);
              attachfile.setFilesize((int) serverfile.length());
              attachfile.setFiletype(upload.getContentType());
              
              int result =srvboard.insertAttachFile(attachfile);
        
              
          }
        
      //3. tb_bbs_attachfile 테이블에 insert. ;
        
        String url = String.format("board/articleview/%s/%d",article.getBoardcd(),insertedpk);
        //return url;
        return "redirect:/"+url;
    }
	@RequestMapping(value = "/board/articlemodify/{boardcd}/{articleno}", method = RequestMethod.GET)
    public String articlemodify( Model model
            ,@PathVariable String boardcd
            ,@PathVariable Integer articleno
            ,@RequestParam(defaultValue="1") Integer curPage
            ,@RequestParam(defaultValue="") String searchWord
            ,@RequestParam(defaultValue="") String msg
            ,HttpServletRequest request){
            
        logger.info("/articlemodify:get");
        
        //boardNm
        //articleno,boardcd,curPage,searchWord,thisArticle,attachfileList
        model.addAttribute("actionurl",request.getRequestURL().toString());
        
        model.addAttribute("boardNm",srvboard.getBoardName(boardcd));
        model.addAttribute("boardcd",boardcd);
        model.addAttribute("articleno",articleno);
        model.addAttribute("curPage",curPage);
        model.addAttribute("searchWord",searchWord);
        model.addAttribute("thisArticle",srvboard.getArticle(articleno));
        model.addAttribute("attachFileList",srvboard.getAttachFileList(articleno));
        
        return "board/articlemodify";
       
    }
	@RequestMapping(value = "/board/articlemodify/{boardcd}/{articleno}", method = RequestMethod.POST)
    public String articlemodifyp( Model model
            ,@ModelAttribute ModelArticle setValue 
            ,@RequestParam(defaultValue="upload") MultipartFile upload
            ,@RequestParam(defaultValue="1") Integer curPage
            ,@RequestParam(defaultValue="") String searchWord ){
            
        logger.info("/articlemodify:post");
       
      //1. client의 파일을 server로 upload
        if(!upload.getOriginalFilename().isEmpty()) {
            //서버의 업로드 폴더 존재 여부 체크 없으면 폴더생성
            java.io.File uploadDir = new java.io.File (WebConstants.UPLOAD_PATH);
            
            if(!uploadDir.exists())uploadDir.mkdirs();
            
            // 클라이언트의 파일을 서버로 복사
            String fileName = upload.getOriginalFilename();
            String tempName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            String newFile = WebConstants.UPLOAD_PATH+tempName;//c:/upload/20180707115415
            java.io.File serverfile = new java.io.File(newFile);
            
            //실제로 파일 카피 발생.
            try {
             upload.transferTo(serverfile);
         } catch (IllegalStateException e) {
             logger.error("articlewrite"+e.getMessage());
         } catch (IOException e) {
             logger.error("/articlewrite:post"+e.getMessage());
         }
            
            //파일을 서버로 복사 성공 여부 체크  
            //성공한 경우만 tb_attachfile 테이블에 insert
            if(serverfile.exists()) {
                
                ModelAttachFile attachfile = new ModelAttachFile();
                attachfile.setArticleno(setValue.getArticleno());
                attachfile.setFilenameorig(fileName);
                attachfile.setFilenametemp(tempName);
                attachfile.setFilesize((int) serverfile.length());
                attachfile.setFiletype(upload.getContentType());
                
                int result =srvboard.insertAttachFile(attachfile);
          
                
            }
            
        }
        //tb_bbs_article table update
        ModelArticle whereValue = new ModelArticle(setValue.getArticleno());
        int result = srvboard.updateArticle(setValue, whereValue);
            
        String url = String.format("redirect:/board/articleview/%s/%d",setValue.getBoardcd(),setValue.getArticleno() );
        return url;
        
        
    }
	
	@RequestMapping(value = "/board/articledelete/{boardcd}/{articleno}", method = RequestMethod.POST)
    @ResponseBody
    public String articledelete( Model model
            ,@PathVariable String boardcd
            ,@PathVariable Integer articleno
            ,@RequestParam(defaultValue="1") Integer curPage
            ,@RequestParam(defaultValue="") String searchWord
            ,RedirectAttributes rttr){
        logger.info("/articledelete:post");
        
       int result=srvboard.transDeleteArticle(articleno);
                
       String url ="";
       if(result==1) {
            url = String.format("redirect:/board/articlelist/%s?curPage=%d&searchWord=%s",boardcd,curPage,searchWord);
           
       }else {
           rttr.addFlashAttribute("msg",WebConstants.MSG_FAIL_DELETE_ARTICLE);
           rttr.addAttribute("curPage",curPage);
           rttr.addAttribute("searchWord",searchWord);
           url ="/board/articleview/%s/%d";
       }
      
        
        return url;
        
    }
	
	//REST 서비스:ajax 이용하여 호출해야한다.
	@RequestMapping(value = "/board/deleteattachfile", method = RequestMethod.POST)
	@ResponseBody
    public String deletattachfile( Model model
            ,@RequestParam Integer attachfileno){
        logger.info("/deletattachfile:post");
        
        ModelAttachFile attachfile=new ModelAttachFile(attachfileno);
                
        int result = srvboard.deleteAttachFile(attachfile);
        
        return "board/articlelist";
        
    }
	/////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/board/articleimagelist/{boardcd}", method = RequestMethod.GET)
    public String articleimagelist( Model model
            ,@PathVariable String boardcd
            ,@RequestParam(defaultValue="1") Integer curPage
            ,@RequestParam(defaultValue="") String searchWord
            ,HttpServletRequest request){
        logger.info("articleimagelist:get");
        
        
        //List <ModelArticle> result = srvboard.getArticleList(boardcd, searchWord);
        
        //boardnm,articlelist,no,pageLinks,curpage,nextLink,boardcd,searchword,url jsp에 넘김
      
        //paging처리
        int totalRecord = srvboard.getArticleImageTotalRecord(boardcd, searchWord);
        
        PagingHelper paging = new PagingHelper(totalRecord,curPage);
        
        int start = paging.getStartRecord();
        int end   = paging.getEndRecord();
        
        List<ModelArticleImage> result = srvboard.getArticleImageList(boardcd, searchWord, start, end);
        
        model.addAttribute("boardnm",srvboard.getBoardName(boardcd));
        model.addAttribute("boardcd",boardcd);
        model.addAttribute("searchWord",searchWord);
        model.addAttribute("curPage",curPage);
        
        model.addAttribute("articleImageList",result);
        model.addAttribute("no",paging.getListNo());
        model.addAttribute("prevLink",paging.getPrevLink());
        model.addAttribute("pageLinks",paging.getPageLinks());
        model.addAttribute("nextLink",paging.getNextLink());
        model.addAttribute("url",request.getRequestURI().toString());
        
      
        return "/board/articleimagelist";
        
    }
	
	@RequestMapping(value = "/board/articleimagelist", method = RequestMethod.GET)
    public String articleimagelist( Model model,@RequestParam(defaultValue="free") String boardcd){
            
        logger.info("/articleimagelist:get");
        
        return "redirect:/board/articleimagelist/"+boardcd;
    }
	
    
    @RequestMapping(value = "/board/articleimageview/{boardcd}/{articleno}", method = RequestMethod.GET)
    public String articleimageeview( Model model
            ,@PathVariable String boardcd
            ,@PathVariable Integer articleno
            ,@RequestParam(defaultValue="1") Integer curPage
            ,@RequestParam(defaultValue="") String searchWord
            ,HttpServletRequest request){
            
        logger.info("/articleimageeview:get");
        
               
        //articleno,boardcd,articleno
        model.addAttribute("boardcd",boardcd      );
        model.addAttribute("articleno",articleno  );
        model.addAttribute("curPage",curPage      );
        model.addAttribute("searchWord",searchWord);
        
        //boardnm 
        
        model.addAttribute("boardNm",srvboard.getBoardName(boardcd));
        
        //thisArticle
        
        //ModelArticle thisArticle =srvboard.transArticle(articleno);
        //model.addAttribute("thisArticle",thisArticle);
        
        ModelArticleImage result =srvboard.getArticleImage(articleno);
        model.addAttribute("thisArticleImage",result);
        //byte[] imageContent = result.getImageBytes();
        
        
        //attachFileList
        List<ModelAttachFile> attachFileList=srvboard.getAttachFileList(articleno);
        model.addAttribute("attachFileList",attachFileList);
        
        List<ModelComments> commentList=srvboard.getCommentList(articleno);
        model.addAttribute("commentList",commentList);
        
        ModelArticle nextArticle = srvboard.getNextArticle(articleno, boardcd, searchWord);
        model.addAttribute("nextArticle",nextArticle);
        
        ModelArticle prevArticle = srvboard.getPrevArticle(articleno, boardcd, searchWord);
        model.addAttribute("prevArticle",prevArticle);
        
        
        
        //,articleno ,no, articlelist, prevpage,pageLinks,curpage,actionurl
        
        int totalRecord = srvboard.getArticleImageTotalRecord(boardcd, searchWord);
        PagingHelper paging = new PagingHelper(totalRecord,curPage);
        int start = paging.getStartRecord();
        int end   = paging.getEndRecord();
        
        List<ModelArticleImage> articleimagelist = srvboard.getArticleImageList(boardcd, searchWord, start, end);
        
        model.addAttribute("articleImageList",articleimagelist);
        model.addAttribute("no",paging.getListNo());
        model.addAttribute("prevLink",paging.getPrevLink());
        model.addAttribute("pageLinks",paging.getPageLinks());
        model.addAttribute("nextLink",paging.getNextLink());
        
        String actionurl =request.getRequestURL().toString();
        model.addAttribute("actionurl",actionurl);
        
        return "board/articleimageview";
    }

    @RequestMapping(value = "/board/articleimagewrite/{boardcd}", method = RequestMethod.GET)
    public String articleimagewrite( Model model
            ,@PathVariable String boardcd
            ,@RequestParam(defaultValue="1") Integer curPage
            ,@RequestParam(defaultValue="") String searchWord
            ,HttpServletRequest request){
            
        logger.info("/articleimagewrite:get");
        
        //boardnm ,boardcd 
        model.addAttribute("boardNm",srvboard.getBoardName(boardcd));
        model.addAttribute("boardcd",boardcd);
        
        return "board/articleimagewrite";
       
    }
    
    @RequestMapping(value = "/board/articleimagewrite", method = RequestMethod.POST)
    public String articleimagewrite( Model model
            ,@ModelAttribute ModelArticleImage articleImage 
            ,@RequestParam(defaultValue="upload") MultipartFile upload
            ,@RequestParam(defaultValue="1") Integer curPage
            ,@RequestParam(defaultValue="") String searchWord ){
            
        logger.info("/articlewrite:post");
        
        Integer articleno = null;
        
        try {
            articleImage.setFileName(articleImage.getImage().getOriginalFilename());
            articleImage.setFileSize((Long) articleImage.getImage().getSize());
            articleImage.setContentType(articleImage.getImage().getContentType()); // 확장자
            articleImage.setImageBytes(articleImage.getImage().getBytes());
            articleImage.setImageBase64(Base64.getEncoder()
                    .encodeToString(articleImage.getImage().getBytes()));
            
          //1.tb_bbs_artcle table insert. inserted pk 값을 반환 받는다.
            articleno = srvboard.insertArticleImage(articleImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
      
      // int insertedpk = srvboard.insertArticleImage(articleImage);
      //2. client의 파일을 server로 upload
       java.io.File uploadDir = new java.io.File (WebConstants.UPLOAD_PATH);
        if(!uploadDir.exists())uploadDir.mkdirs();  
             
            // 클라이언트의 파일을 서버로 복사
           String fileName = upload.getOriginalFilename();
           String tempName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
           String newFile = WebConstants.UPLOAD_PATH+tempName;//c:/upload/20180707115415
           java.io.File serverfile = new java.io.File(newFile);
           
           //실제로 파일 카피 발생.
           try {
            upload.transferTo(serverfile);
        } catch (IllegalStateException e) {
            logger.error("articlewrite"+e.getMessage());
        } catch (IOException e) {
            logger.error("/articlewrite:post"+e.getMessage());
        }
          if(serverfile.exists()) {
         
              ModelAttachFile attachfile = new ModelAttachFile();
              attachfile.setArticleno(articleno);
              attachfile.setFilenameorig(fileName);
              attachfile.setFilenametemp(tempName);
              attachfile.setFilesize((int) serverfile.length());
              attachfile.setFiletype(upload.getContentType());
              
              int result =srvboard.insertAttachFile(attachfile);
        
              
          }
        
      //3. tb_bbs_attachfile 테이블에 insert. ;
        
        String url = String.format("board/articleimageview/%s/%d",articleImage.getBoardcd(),articleno);
        //return url;
        return "redirect:/"+url;
    }
    
    @RequestMapping(value = "/upload/imageupload", method = RequestMethod.POST)
    public String imageupload(Model model, @RequestParam String upDir,
            @ModelAttribute ModelArticleImage articleimage) {
        logger.info("imageupload");
        Integer articleno = null;
        try {
            articleimage.setFileName(articleimage.getImage().getOriginalFilename());
            articleimage.setFileSize((Long) articleimage.getImage().getSize());
            articleimage.setContentType(articleimage.getImage().getContentType()); // 확장자
            articleimage.setImageBytes(articleimage.getImage().getBytes());
            articleimage.setImageBase64(Base64.getEncoder()
                    .encodeToString(articleimage.getImage().getBytes()));
            articleno = srvboard.insertArticleImage(articleimage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/board/articleimageview/" + Integer.toString(articleno);
    }
    @RequestMapping(value = "/board/articleimagemodify/{boardcd}/{articleno}", method = RequestMethod.GET)
    public String articleimagemodify( Model model
            ,@PathVariable String boardcd
            ,@PathVariable Integer articleno
            ,@RequestParam(defaultValue="1") Integer curPage
            ,@RequestParam(defaultValue="") String searchWord
            ,@RequestParam(defaultValue="") String msg
            ,HttpServletRequest request){
            
        logger.info("/articleimagemodify:get");
        
        //boardNm
        //articleno,boardcd,curPage,searchWord,thisArticle,attachfileList
        model.addAttribute("actionurl",request.getRequestURL().toString());
        
        model.addAttribute("boardNm",srvboard.getBoardName(boardcd));
        model.addAttribute("boardcd",boardcd);
        model.addAttribute("articleno",articleno);
        model.addAttribute("curPage",curPage);
        model.addAttribute("searchWord",searchWord);
        model.addAttribute("thisArticle",srvboard.getArticle(articleno));
        model.addAttribute("attachFileList",srvboard.getAttachFileList(articleno));
        
        return "board/articleimagemodify";
       
    }
    @RequestMapping(value = "/board/articleimagemodify/{boardcd}/{articleno}", method = RequestMethod.POST)
    public String articleimagemodify( Model model
            ,@ModelAttribute ModelArticleImage setValue 
            ,@RequestParam(defaultValue="upload") MultipartFile upload
            ,@RequestParam(defaultValue="1") Integer curPage
            ,@RequestParam(defaultValue="") String searchWord ){
            
        logger.info("/articleimagemodify:post");
        
            
       
      //1. client의 파일을 server로 upload
        if(!upload.getOriginalFilename().isEmpty()) {
            //서버의 업로드 폴더 존재 여부 체크 없으면 폴더생성
            java.io.File uploadDir = new java.io.File (WebConstants.UPLOAD_PATH);
            
            if(!uploadDir.exists())uploadDir.mkdirs();
            
            // 클라이언트의 파일을 서버로 복사
            String fileName = upload.getOriginalFilename();
            String tempName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            String newFile = WebConstants.UPLOAD_PATH+tempName;//c:/upload/20180707115415
            java.io.File serverfile = new java.io.File(newFile);
            
            //실제로 파일 카피 발생.
            try {
             upload.transferTo(serverfile);
         } catch (IllegalStateException e) {
             logger.error("articlewrite"+e.getMessage());
         } catch (IOException e) {
             logger.error("/articlewrite:post"+e.getMessage());
         }
            
            //파일을 서버로 복사 성공 여부 체크  
            //성공한 경우만 tb_attachfile 테이블에 insert
            if(serverfile.exists()) {
                
                ModelAttachFile attachfile = new ModelAttachFile();
                attachfile.setArticleno(setValue.getArticleno());
                attachfile.setFilenameorig(fileName);
                attachfile.setFilenametemp(tempName);
                attachfile.setFilesize((int) serverfile.length());
                attachfile.setFiletype(upload.getContentType());
                
                int result =srvboard.insertAttachFile(attachfile);
          
                
            }
            
        }
        
        
        ////////////////////이미지 관련
        try {
            setValue.setFileName(setValue.getImage().getOriginalFilename());
            setValue.setFileSize((Long) setValue.getImage().getSize());
            setValue.setContentType(setValue.getImage().getContentType()); // 확장자
            setValue.setImageBytes(setValue.getImage().getBytes());
            setValue.setImageBase64(Base64.getEncoder()
                    .encodeToString(setValue.getImage().getBytes()));
            
          //1.tb_bbs_artcle table insert. inserted pk 값을 반환 받는다.
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //////////////////////////
        //tb_bbs_article table update
        ModelArticleImage whereValue = new ModelArticleImage(setValue.getArticleno());
        int result = srvboard.updateArticleImage(setValue, whereValue);
            
        String url = String.format("redirect:/board/articleimageview/%s/%d",setValue.getBoardcd(),setValue.getArticleno() );
        return url;
        
        
    }
    
    
    
    
    
	
}
