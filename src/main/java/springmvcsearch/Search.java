package springmvcsearch;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class Search {
	@RequestMapping("/detail/{userid}")
	public String getUserDetails(@PathVariable("userid") int userid) {
		System.out.println(userid);
		return "home";
	}
	
	@RequestMapping("/home")
	public String search() {
		System.out.println("this is home view");
//		processing area
//		String str=null;
//		System.out.println(str.length());
		return "home";
	}
	
	@RequestMapping("/process")
	public RedirectView searchKey(@RequestParam("key") String keyword) {
		String url = "https://www.google.com/search?q="+keyword;
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(url);
		return redirectView;
	}
	
	@RequestMapping("/interceptorExample")
	public String example() {
		System.out.println("this is main handler");
		return "interceptorExample";
	}
	
	@RequestMapping("/welcome")
	public String welcome(@RequestParam("user")String user, Model m) {
		m.addAttribute("user", user);
		return "welcome";
	}
	
	
	
//	//handling exception in spring mvc
//	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler({NullPointerException.class,NumberFormatException.class})
//	public String exceptionHandler(Model m) {
//		m.addAttribute("msg", "Null Pointer Exception has occured");
//		return "null_page";
//	}
//	
//	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(value=Exception.class)
//	public String exceptionHandlerAll(Model m) {
//		m.addAttribute("msg", "Exception has occured");
//		return "null_page";
//	}
}	
