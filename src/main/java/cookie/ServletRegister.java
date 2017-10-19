package cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletRegister extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");

		Cookie cookie = new Cookie("name", java.net.URLEncoder.encode(name,"utf-8"));
		Cookie cookie1 = new Cookie("pwd",pwd);

		response.addCookie(cookie);
		response.addCookie(cookie1);

		if(cookie != null){
			request.getSession().setAttribute("注册结果", "注册成功");
			response.sendRedirect("index.jsp");
		}else{
			request.getSession().setAttribute("注册结果", "注册失败");
			response.sendRedirect("jsp/Register.jsp");
		}

	}

}
