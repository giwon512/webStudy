package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ThirdController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("result").addObject("msg", "ThirdController");
	}

}


//@Controller
//public class ThirdController {
//	
//	@GetMapping("/third")
//	public ModelAndView thirdPage() {
//		return new ModelAndView("/WEB-INF/view/result.jsp").addObject("msg", "ThirdController");
//	}
//}