package springmvcsearch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyPreHandler extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String userName = request.getParameter("user");
		if(userName.startsWith("A")) {
			response.setContentType("text/html");
			response.getWriter().write("<h3> Invallid username ..... Your name should not starts with letter 'A'</h3>");
			return false;
		}
		System.out.println("this is pre handler");
		return true;
	}
	
}
