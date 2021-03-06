package tody.secu.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	Logger log = Logger.getLogger(this.getClass());
	
    @RequestMapping(value="/interceptorTest")
    public ModelAndView interceptorTest() throws Exception{
         
        ModelAndView mv = new ModelAndView("");
        log.debug("인터셉터 테스트입니다!");
         
        return mv;
    }
    
    @RequestMapping(value="/admin/page")
    public String adminPage() throws Exception {
    	//ModelAndView mv = new ModelAndView("/admin/page");
    	return "/admin/page";
    }
    
    @RequestMapping(value="/user/page")
    public String userPage() throws Exception {
    	//ModelAndView mv = new ModelAndView("/user/page");
    	return "/user/page";
    }
    
    @RequestMapping(value="/page")
    public String page() throws Exception {
    	//ModelAndView mv = new ModelAndView("/page");
    	return "/page";
    }
    
    @RequestMapping(value="/logout")
    public ModelAndView logout(HttpServletRequest req, HttpSession session) throws Exception {
    	session.invalidate();
    	ModelAndView mv = new ModelAndView("/goIndex");
    	mv.addObject("msg", "로그아웃되었습니다.");
    	mv.addObject("url", "/");
    	return mv;
    }
    
    @RequestMapping(value="/access_denied")
    public ModelAndView accessDenied() throws Exception {
    	ModelAndView mv = new ModelAndView("/goIndex");
    	mv.addObject("msg", "접근 권한이 없습니다.");
    	mv.addObject("url", "/");
    	return mv;
    }
    
    @RequestMapping(value="/secu/loginPage")
    public String loginPage() throws Exception {
    	return "/secu/loginPage";
    }

    @RequestMapping(value="/loginFailure")
    public ModelAndView loginFailure() throws Exception {
    	ModelAndView mv = new ModelAndView("/secu/loginPage");
    	mv.addObject("fail", true);
    	return mv;
    }
    
    @RequestMapping(value="/loginDuplicate")
    public ModelAndView loginDuplicate() throws Exception {
    	ModelAndView mv = new ModelAndView("/goIndex");
    	mv.addObject("msg", "다른 브라우저에서 로그인이 감지되어 자동으로 로그아웃합니다.");
    	mv.addObject("url", "/");
    	return mv;
    }
    
}
