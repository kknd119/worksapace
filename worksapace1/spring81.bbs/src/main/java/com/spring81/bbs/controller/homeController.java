package com.spring81.bbs.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring81.bbs.common.PagingHelper;
import com.spring81.bbs.inf.IServiceBoard;
import com.spring81.bbs.model.ModelArticle;

/**
 * Handles requests for the application home page.
 */
@Controller
public class homeController {
	
	private static final Logger logger = LoggerFactory.getLogger(homeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Autowired
    IServiceBoard srvboard;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/company/index", method = RequestMethod.GET)
    public String index(Model model) {
        logger.info("index:get");
        
        return "shop/index";
    }
    @RequestMapping(value = "/company/index", method = RequestMethod.POST)
    public String indexp(Model model,@RequestParam String key) {
        logger.info("index:post");
        
        return "shop/index";
    }
    @RequestMapping(value = "/company/mycompany", method = RequestMethod.GET)
    public String mycompany(Model model) {
        logger.info("mycompany:company:get");
        
        return "shop/mycompany";
    }
    @RequestMapping(value = "/company/mything", method = RequestMethod.GET)
    public String mything(Model model) {
        logger.info("mycompany:mything:get");
        
        return "shop/mything";
    }
    @RequestMapping(value = "/company/contactus", method = RequestMethod.GET)
    public String contactus(Model model) {
        logger.info("contactus:get");
        
        return "shop/contactus";
    }
	///상품 관련///
    @RequestMapping(value = "/products/shirts", method = RequestMethod.GET)
    public String shirts(Model model) {
        logger.info("shirts:get");
        
        return "shop/shirts";
    }
    @RequestMapping(value = "/products/pants", method = RequestMethod.GET)
    public String pants(Model model) {
        logger.info("pants:get");
        
        return "shop/pants";
    }
    @RequestMapping(value = "/products/cap", method = RequestMethod.GET)
    public String cap(Model model) {
        logger.info("cap:get");
        
        return "shop/cap";
    }
    @RequestMapping(value = "/products/shoes", method = RequestMethod.GET)
    public String shoes(Model model) {
        logger.info("shoes:get");
        
        return "shop/shoes";
    }
    //장바구니
    @RequestMapping(value = "/company/my", method = RequestMethod.GET)
    public String my( Model model
            ,@RequestParam(defaultValue="1") Integer curPage
            ,@RequestParam(defaultValue="") String searchWord
            ,HttpServletRequest request){
        logger.info("articlelist");
    
        //List <ModelArticle> result = srvboard.getArticleList(boardcd, searchWord);
        
        //boardnm,articlelist,no,pageLinks,curpage,nextLink,boardcd,searchword,url jsp에 넘김
         
        String boardcd ="my";
        //paging처리
        int totalRecord = srvboard.getArticleTotalRecord(boardcd, searchWord);
        
        PagingHelper paging = new PagingHelper(totalRecord,curPage);
        
        int start = paging.getStartRecord();
        int end   = paging.getEndRecord();
        
        List<ModelArticle> result = srvboard.getArticleList(boardcd, searchWord, start, end);
        
        model.addAttribute("boardNm",srvboard.getBoardName(boardcd));
        model.addAttribute("boardcd",boardcd);
        model.addAttribute("searchWord",searchWord);
        model.addAttribute("curPage",curPage);
        
        model.addAttribute("articleList",result);
        model.addAttribute("no",paging.getListNo());
        model.addAttribute("prevLink",paging.getPrevLink());
        model.addAttribute("pageLinks",paging.getPageLinks());
        model.addAttribute("nextLink",paging.getNextLink());
        model.addAttribute("url",request.getRequestURI().toString());
        
      
        return "shop/my";
        
    }
    //구매내역
    @RequestMapping(value = "/company/mysale", method = RequestMethod.GET)
    public String mysale( Model model
            ,@RequestParam(defaultValue="1") Integer curPage
            ,@RequestParam(defaultValue="") String searchWord
            ,HttpServletRequest request){
        logger.info("articlelist");
    
        //List <ModelArticle> result = srvboard.getArticleList(boardcd, searchWord);
        
        //boardnm,articlelist,no,pageLinks,curpage,nextLink,boardcd,searchword,url jsp에 넘김
         
        String boardcd ="mysale";
        //paging처리
        int totalRecord = srvboard.getArticleTotalRecord(boardcd, searchWord);
        
        PagingHelper paging = new PagingHelper(totalRecord,curPage);
        
        int start = paging.getStartRecord();
        int end   = paging.getEndRecord();
        
        List<ModelArticle> result = srvboard.getArticleList(boardcd, searchWord, start, end);
        
        model.addAttribute("boardNm",srvboard.getBoardName(boardcd));
        model.addAttribute("boardcd",boardcd);
        model.addAttribute("searchWord",searchWord);
        model.addAttribute("curPage",curPage);
        
        model.addAttribute("articleList",result);
        model.addAttribute("no",paging.getListNo());
        model.addAttribute("prevLink",paging.getPrevLink());
        model.addAttribute("pageLinks",paging.getPageLinks());
        model.addAttribute("nextLink",paging.getNextLink());
        model.addAttribute("url",request.getRequestURI().toString());
        
      
        return "shop/mysale";
        
    }
      
    
    
    
    
}
