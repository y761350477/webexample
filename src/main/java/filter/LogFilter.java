package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by YC on 2017/7/9.
 */
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter:\tinit");
        System.out.println(filterConfig.getInitParameter("ip"));    //获取过滤器的初始化参数;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter:\tdoFilter");
        /*默认：对目标资源进行了拦截，目标资源没有被访问，如果访问请求调用链下一个资源，这样就不会拦截该web资源*/
//        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("Filter:\tdestroy");
    }
}
