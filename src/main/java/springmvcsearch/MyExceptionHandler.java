package springmvcsearch;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyExceptionHandler {
	//handling exception in spring mvc
		@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
		@ExceptionHandler({NullPointerException.class,NumberFormatException.class})
		public String exceptionHandler(Model m) {
			m.addAttribute("msg", "Null Pointer Exception has occured");
			return "null_page";
		}
//		
//		@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
//		@ExceptionHandler(value=Exception.class)
//		public String exceptionHandlerAll(Model m) {
//			m.addAttribute("msg", "Exception has occured");
//			return "null_page";
//		}
}
