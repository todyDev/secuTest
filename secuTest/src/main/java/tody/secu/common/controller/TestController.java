package tody.secu.common.controller;

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

}
