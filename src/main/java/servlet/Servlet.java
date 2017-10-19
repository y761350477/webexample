package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * 使用注解描述Servlet
 * Created by YC on 2017/8/6.
 */

/**
 * 注解WebServlet用来描述一个Servlet
 * 属性name描述Servlet的名字,可选
 * 属性urlPatterns定义访问的URL,或者使用属性value定义访问的URL.(定义访问的URL是必选属性)
 * 验证：
 * 1、Servlet注解，可以不声明name，直接通过@WebServlet("/Servlet")进行访问，
 * 也可以之声明url的@WebServlet(value="/Servlet") 或者
 * value的@WebServlet(urlPatterns="/Servlet") 进行访问;
 * 2、Sevlet注解可以设置多个路径访问，如：@WebServlet(name="Servlet",urlPatterns={"/Servlet","/Servlet22"});
 */

@WebServlet(
        name = "Servlet",   //当前类的名称，同web.xml中的Servlet名称;
        urlPatterns = {"/Servlet", "/Servlet22"},  //设置访问的url的映射路径，同web.xml中的Servlet映射;
        loadOnStartup = 1,  //设置tomcat启动时加载当前类的init方法;

        /*设置初始化参数，同Servlet中的init-param*/
        initParams = {@WebInitParam(name = "username", value = "张三"),@WebInitParam(name = "username1", value = "李四")}
        )
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**设置请求的编码格式*/
        request.setCharacterEncoding("utf-8");
        String getInputName = request.getParameter("inputName");
        System.out.println("getInputName:\t"+getInputName);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**设置响应的编码格式*/
        response.setCharacterEncoding("UTF-8");

        /**设置响应的内容*/
        PrintWriter printWriter = response.getWriter();
        printWriter.print("<h1>Hello World!我是杨晨</h1>");
        /**获取web.xml中配置的参数信息，使用了ServletConfig接口的
         * 四个方法：
         * getInitParameter("参数名")获取Servlet初始化参数名的value值；
         * getInitParameterNames()获取Servlet所有的初始化参数名；
         * getServletName()获取Servlet的名字；
         * getServletContext()获取Servlet上下文对象；
         * 注意：this代表当前类；因为HttpServlet继承了ServletConfig这个接口；
         */
        String initParamsValue = this.getInitParameter("username");
        System.out.println("ServletDemo:initParamsValue:\t"+initParamsValue);
        Enumeration initParamsNames = this.getInitParameterNames();
        while(initParamsNames.hasMoreElements()) {
            System.out.print("ServletDemo:initParamsNames:\t"+initParamsNames.nextElement()+"\t");
        }

        System.out.println();
        System.out.println("ServletDemo:获取Servlet上下文对象\t"+this.getServletContext());
        System.out.println("ServletDemo:获取Servlet的名字:\t"+this.getServletName());

        /**获取输入框的值*/
        String getInputName = request.getParameter("inputName");
        System.out.println("getInputName:\t"+getInputName);

        request.setAttribute("name", "YangChen");//设置参数(不是全局的，只在当前的请求中有效，ServletContext是上下文对象)
        request.setAttribute("username", "YC");//设置参数(不是全局的，只在当前的请求中有效，ServletContext是上下文对象)
//        request.removeAttribute("name");//清除指定的参数
        System.out.println("ServletDemo:request.getAttribute:\t"+request.getAttribute("name"));//输出参数
        /**获取所有的Attribute参数的名字*/
        Enumeration getAttributeNames = request.getAttributeNames();
        while(getAttributeNames.hasMoreElements()) {
            System.out.println("ServletDemo:getAttributeNames:\t"+getAttributeNames.nextElement());
        }
        /* 转发（可以携带数据，即被转发的方法内可以获取request.setAttribute的内容）
         * 转发先进入到要执行到被转发的方法内，然后执行完被转发的方法还会回到这个方法并执行完当前方法
         */
//        request.getRequestDispatcher("seconddemo").forward(request,response);

        /*从Servlet传值到jsp页面*/
        request.setAttribute( "ServletInfo","TestInfo");
        request.getRequestDispatcher("jsp/Test.jsp").forward(request,response);

        /* forward和include的区别：
         * forward的方式，转发的方法中的响应信息会和被转发的响应信息不会合并，只会响应的转发的响应信息;
         * include的方法，转发的方法中的响应信息会和被转发的响应信息合并;
         */
//        request.getRequestDispatcher("seconddemo").include(request,response);
//        System.out.println("还会执行吗？我想是会的");

        /* 重定向执行完当前方法后进入到要重定向的方法内，然后执行完被重定向的方法
         * 重定向（不可以携带数据，即被重定向的方法内不可以获取request.setAttribute的内容）
         */
//        response.sendRedirect("seconddemo");
//        System.out.println("还会执行吗？我想是会的");

        /*Context的一些方法*/
        ServletContext servletContext = this.getServletContext();
        String name = servletContext.getInitParameter("name");
        System.out.println("获取Context的参数:\t"+name);

        /*设置全局参数
        * 获取ServletContext的对象，可以通过：
        * 1、this.getServletContext();
        * 2、request.getServletContext();
        */
        request.getServletContext().setAttribute("test","ContextTest");
        System.out.println(request.getServletContext().getAttribute("test"));

        System.out.println(this.getServletContext().getAttribute("test"));
        /*获取web.xml中设置的Context的所有参数名*/
        Enumeration<String> eContext = servletContext.getInitParameterNames();
        while(eContext.hasMoreElements()) {
            System.out.println(eContext.nextElement());
        }

        System.out.println("获取项目名:\t"+servletContext.getContextPath());
        System.out.println("获取tomcat项目根目录:\t"+servletContext.getRealPath("/"));

    }

    @Override
    public void init() throws ServletException {
        System.out.println("ServletDemo:仅测试Servlet注解的loadOnStartup的设置");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("ServletDemo:tomcat服务关闭的时候调用：\tdestroy()方法");
    }
}
