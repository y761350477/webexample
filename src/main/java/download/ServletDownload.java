package download;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class ServletDownload extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/msword");

		String file = new String("条款.docx".getBytes(),"iso8859-1");
		response.addHeader("Content-disposition", "attachment;filename="+file);

		InputStream is = request.getServletContext().getResourceAsStream("file/文件.docx");

		int read = 0;
		byte[] bytes = new byte[1024];
		OutputStream os = response.getOutputStream();
		if((read=is.read(bytes))!=-1){
			os.write(bytes,0,read);
		}

		os.flush();
		os.close();
		is.close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A ServletDemo</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
