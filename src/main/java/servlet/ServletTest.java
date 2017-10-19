package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by YC on 2017/7/8.
 */
public class ServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("ServletTest:\tdoGet");
        System.out.println(req.getAttribute("name"));
        PrintWriter pw =  resp.getWriter();
        pw.print("222");
        System.out.println("Demo执行的代码");
        HttpSession httpSession = req.getSession();
        System.out.println(httpSession.getAttribute("u"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletTest:\tdePost");
    }

}
