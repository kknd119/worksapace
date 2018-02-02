package com.spring81.bbs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring81.bbs.common.WebConstants;
import com.spring81.bbs.inf.IServiceUser;
import com.spring81.bbs.model.ModelUser;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
    
    @Autowired
    IServiceUser svruser;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String home( Model model) {
		logger.info("/user/");
		
		return "redirect:/user/login";
	}
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public String login( Model model,@RequestParam(value="url",defaultValue="") String url,HttpServletRequest request) {
        logger.info("/user/login:get");
        //로그인 후 이동할 페이지를 변수로  넘긴다.
        if(url.isEmpty())
            //url=request.getHeader("Refer");
            url="http://localhost:8080/company/index";
        model.addAttribute("url",url);
        return "/user/login";
    }
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String loginp( Model model,@RequestParam String url
            ,@RequestParam String userid
            ,@RequestParam String passwd
            ,HttpSession session
            ,RedirectAttributes rttr) {
        logger.info("/user/login:post");
        //로그인 후 이동할 페이지를 변수로  넘긴다.
        
        ModelUser user =new ModelUser();
        user.setUserid(userid);
        user.setPasswd(passwd);
        ModelUser result=svruser.login(user);
        
        if(result != null) {
            
            session.setAttribute(/*세션명*/WebConstants.SESSION_NAME,/*세션값*/result);
            if(url.isEmpty()) {
                return"redirect:/";// http://localhost 페이지가 열림.
            }
            else {
                //로그인 성공시 키값 부여함.
                String key ="key";
                model.addAttribute("key", key);
                //return "redirect:"+url;//로그인 성공
                return "shop/index";//로그인 성공
            }
        }
        else {
            //RedirectAttributesms redirect시 사용되는 
            rttr.addFlashAttribute("msg","로그인실패");//로그인 실패
            rttr.addFlashAttribute("url",url);
            
            return"redirect:/user/login";
        }
          
    }
	@RequestMapping(value = "/user/logout", method = RequestMethod.GET)
	public String logout(Model model,HttpSession session) {
	    logger.info("/user/logout :get");
	    //세션삭제
	session.removeAttribute(WebConstants.SESSION_NAME );
	
	return "redirect:/";
	}
	@RequestMapping(value = "/user/registerterm", method = RequestMethod.GET)
    public String registerterm(Model model,HttpSession session) {
        logger.info("/user/registerterm:get");
        //세션삭제
    session.removeAttribute(WebConstants.SESSION_NAME );
    
    return "shop/registerterm";
    }
	@RequestMapping(value = "/user/registerterm", method = RequestMethod.POST)
    public String registertermp(Model model,HttpSession session) {
        logger.info("/user/registerterm:post");
        //세션삭제
    session.removeAttribute(WebConstants.SESSION_NAME );
    
    return "shop/register";
    }
	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public String resister(Model model,HttpSession session) {
        logger.info("/user/resister");
        //세션삭제
    session.removeAttribute(WebConstants.SESSION_NAME );
    
    return "user/register";
    }
	//////////////////////////////////////////////
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public String resisterp(Model model,@ModelAttribute ModelUser user) {
        logger.info("/user/resister");
       int result = svruser.insertUser(user);
         
    return "user/register_post";
    }
	
	@RequestMapping(value = "/user/unregister", method = RequestMethod.GET)
    public String unregister(Model model ) {
        logger.info("/user/resister:get");
      
    return "user/unregister";
    }
	@RequestMapping(value = "/user/unregister", method = RequestMethod.POST)
    public String unregisterp(Model model
            ,@RequestParam String email
            ,@RequestParam String passwd
            ,HttpSession session) {
        logger.info("/user/resister:post");
        
        ModelUser user = (ModelUser)session.getAttribute(WebConstants.SESSION_NAME);
        if(user==null)
            throw new RuntimeException(WebConstants.NOT_LOGIN);
        
        user.setEmail(email);
        user.setPasswd(passwd);
      //DB에서 탈퇴 처리
        int result = svruser.updateRetire(user);
       
      //탈퇴처리 성공하면 세션삭제
        if(result==1) {
            session.removeAttribute(WebConstants.SESSION_NAME);
            return"user/unregister_post";
        }
        else {
            return"user/unregister";
        }
    }
	@RequestMapping(value = "/user/usermodify", method = RequestMethod.GET)//로그인이 되어 있다는 가정하에
    public String usermodify(Model model,HttpSession session) {
        logger.info("/user/usermodify:get");
        ////로그인이 되어 있다는 가정하에 세션정보 받음
    ModelUser user = (ModelUser)session.getAttribute(WebConstants.SESSION_NAME );
    //DB에서 회원 정보 조회
    //user=svruser.selectUserOne(user);
    if(user == null) {
        return "redirect:/user/login";
    }
    model.addAttribute("user",user);
    return "user/usermodify";
    }
	@RequestMapping(value = "/user/usermodify", method = RequestMethod.POST)
    public String usermodifyp(Model model,@ModelAttribute ModelUser setValue ,HttpSession session,RedirectAttributes rttr ) {
        logger.info("/user/usermodify:post");
    ////로그인이 되어 있다는 가정하에 세션정보 받음
        ModelUser user =(ModelUser) session.getAttribute(WebConstants.SESSION_NAME );
        
        //로그인 안되어 있는 경우
        if(user == null)
            throw new RuntimeException(WebConstants.NOT_LOGIN);
        //입력된 패스워드와 현재의 패스워드가  틀릴 경우
        //패스워드는 DB에 암호화 되어 저장되기때문에
        int r=svruser.checkpassword(setValue.getUserid(),setValue.getPasswd());
        if( r==0)
            throw new RuntimeException(WebConstants.ERROR_PASSWORD);
        
        //DB에서 회원 정보 수정.
        ModelUser whereValue = new ModelUser();
        whereValue.setUserid(user.getUserid());
        whereValue.setPasswd(setValue.getPasswd());
        
        setValue.setPasswd(null);//패스워드 변경하지 않기 위해 null 값 넣음.
        
        int result = svruser.updateUserInfo(setValue, whereValue);
        
        //세션정보 갱신
        user=svruser.selectUserOne(user);
        session.setAttribute(WebConstants.SESSION_NAME,user );       
        if(result>0) {
            return "user/changepassword";
        }
        else {
            rttr.addFlashAttribute("user",setValue);
          
            rttr.addFlashAttribute("msg",WebConstants.UPDATE_FAIL);
            return "redirect:/user/usermodify";        
        }
    
    }
	@RequestMapping(value = "/user/changepassword", method = RequestMethod.GET)
    public String changepassword(Model model,HttpSession session) {
        logger.info("/user/changepassword:get");
        //세션삭제
    ModelUser user=(ModelUser) session.getAttribute(WebConstants.SESSION_NAME );
    
    if(user == null)
        return "redirect:/user/login";
    else
        return "user/changepassword";
        
    }
	@RequestMapping(value = "/user/changepassword", method = RequestMethod.POST)
    public String changepasswordp(Model model
            ,HttpSession session
            ,@RequestParam String currentPasswd
            ,@RequestParam String newPasswd
            ,RedirectAttributes rttr) {
        logger.info("/user/changepassword:post");
        //세션삭제
        ModelUser user= (ModelUser)session.getAttribute(WebConstants.SESSION_NAME);
                
        int result = svruser.updatePasswd(user.getUserid(),currentPasswd,newPasswd);
        if(result==1)
            return"user/changepassword_post";
        else {
            rttr.addFlashAttribute("msg",WebConstants.MSG_FAIL_CHANGE_PASSWORD);
            return "redirect:/user/changepassword";
        }
 
    
    }
}
