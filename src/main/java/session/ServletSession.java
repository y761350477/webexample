package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by YC on 2017/7/9.
 * Session会话：
 * 1、web.xml设置session会话超时时间的方法；
 * 2、编程中设置session会话超时时间的方法；
 * 3、在session中存入数据和取出数据的方法(Session设置的参数是全局的);
 * 4、注销session的方法；
 * 5、session设置之后，只要先访问session设置的路径之后，就可以在其他Servlet获取session的信息；
 * 注意：
 * 创建session对象的两种方法的区别：
 * getSession（false），如果存在则返回session信息，如果不存在就返回null做判断用；
 * 注：只要有访问就会有Session自动生成，就算是默认加载的首页jsp页面也是会自动生成。
 * getSession（true），如果没有session就创建；
 */
@WebServlet("/ServletSession")
public class ServletSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        System.out.println("判断Session会话是否存在:\t"+httpSession);
        httpSession.invalidate();   //注销Session
        HttpSession httpSessionAgin = req.getSession(false);
        System.out.println("判断Session会话的注销效果:\t"+httpSessionAgin);
        HttpSession creatSession = req.getSession();
        System.out.println("获取会话超时时间，以秒计:\t"+creatSession.getMaxInactiveInterval());//获取会话超时时间，以秒计
        httpSession.setMaxInactiveInterval(10);//设置会话超时时间，以秒计，优先级大于web.xml中的配置失效时间
        System.out.println(creatSession.getMaxInactiveInterval());
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.print("<h1>我是杨晨</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
