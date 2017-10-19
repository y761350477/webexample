package cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by YC on 2017/7/9.
 */
public class ServletCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] remember = req.getParameterValues("remember");
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        if (remember != null) {
            Cookie cname = new Cookie("username",name);
            cname.setMaxAge(60*60*24*7);
            cname.setPath("/");

            Cookie cpwd = new Cookie("password",pwd);
            cname.setMaxAge(60*60*24*7);
            cname.setPath("/");

            resp.addCookie(cname);
            resp.addCookie(cpwd);
        }
        req.getRequestDispatcher("jsp/Show.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
