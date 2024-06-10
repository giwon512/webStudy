package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.User;

@Controller
public class SecondController {

	@RequestMapping("/first")
	protected ModelAndView firstPage() {
		return new ModelAndView("/WEB-INF/view/first.jsp");
	}
	
	@RequestMapping("/second")
	protected ModelAndView secondPage(HttpServletRequest req) {
		String p1 = req.getParameter("p1");
		String p2 = req.getParameter("p2");
		ModelAndView mv = new ModelAndView("/WEB-INF/view/second.jsp");
		mv.addObject("param1", p1);
		mv.addObject("param2", p2);
		return mv;
	}

	//@RequestMapping(value="/third", method=RequestMethod.POST)
//	@PostMapping("/third")
//	protected ModelAndView thirdPage(HttpServletRequest req) throws UnsupportedEncodingException {
//		req.setCharacterEncoding("utf-8");
//		
//		String name = req.getParameter("name");
//		String age = req.getParameter("age");
//		String point = req.getParameter("point");
//		
//		System.out.println(name + ", " + age + ", " + point);
//		return new ModelAndView("/WEB-INF/view/third.jsp");
//	}
	@PostMapping("/third")
//	protected ModelAndView thirdPage(String name, int age, double point) {
	protected ModelAndView thirdPage(@RequestParam("name") String ireum, 
									 @RequestParam int age, 
									 @RequestParam double point) {
		System.out.println(ireum + ", " + age + ", " + point);
		return new ModelAndView("/WEB-INF/view/third.jsp");
	}
	
//	@RequestMapping("/fourth")
//	protected ModelAndView fourthPage(String name, int age, double point) {
//		User user = new User();
//		user.setName(name);
//		user.setAge(age);
//		user.setPoint(point);
//		
//		ModelAndView mv = new ModelAndView("/WEB-INF/view/fourth.jsp");
//		mv.addObject(user);
//		
//		return mv;
//	}
	
	@GetMapping("/fourth")
	public ModelAndView fourthPage(@ModelAttribute User user, @RequestParam String chk) {
		ModelAndView mv = new ModelAndView("/WEB-INF/view/fourth.jsp");
		mv.addObject("user", user);
		mv.addObject("chk", chk);
		return mv;
	}
	
	@GetMapping("/fifth")
	public ModelAndView fifthPage(ModelAndView mv) {
		List list = new ArrayList();
		list.add("김치찌개");
		list.add("삼겹살");
		list.add("치킨");
		list.add("국밥");
		
		Map<String, String> map = new HashMap<>();
		map.put("f1", "사과");
		map.put("f2", "포도");
		map.put("f3", "수박");
		
		List<String> listDay = new ArrayList<>();
		listDay.add("월요일");
		listDay.add("화요일");
		listDay.add("수요일");
		listDay.add("목요일");
		
		List<String> listMovie = new ArrayList<>();
		listMovie.add("파묘");
		listMovie.add("어벤져스");
		listMovie.add("쿵푸팬더");
		listMovie.add("범죄도시");
		
		Map<String, List> maps = new HashMap<>();
		maps.put("day", listDay);
		maps.put("movie", listMovie);
		
		mv.setViewName("/WEB-INF/view/fifth.jsp");
		mv.addObject("foods", list);
		mv.addAllObjects(map);
		mv.addAllObjects(maps);
		return mv;
	}
}
