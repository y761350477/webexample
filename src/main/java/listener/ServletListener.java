package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by YC on 2017/7/9.
 */
public class ServletListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("创建Listener时调用");
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer count = (Integer)servletContext.getAttribute("count");
        System.out.println("判断前:\t"+count);
        if (count == null) {
            servletContext.setAttribute("count", 1);
        } else {
            count++;
            servletContext.setAttribute("count", count);
        }
//        System.out.println("判断后:\t"+(Integer)servletContext.getAttribute("count"));
        System.out.println("判断后:\t"+count);
     }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("销毁Listener时调用");
    }
}
