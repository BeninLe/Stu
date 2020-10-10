package cn.Stu.StudentM.one;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		// ��ȡ�û���������
		String name =request .getParameter("username");
		String psw =request .getParameter("password");
		//ģ�����ݿ�
		if("BeLevy".equals(name)&&"2020".equals(psw)||"Levy".equals(name)&&"123456".equals(psw)) {
			User u =new User();
			u.setUsername(name);
			u.setPassword(psw);
			
			HttpSession session = request.getSession();
			session.setAttribute("key", u);
			
			Cookie c = new Cookie("JESSIONID",session.getId());
			c.setMaxAge(3600*24*7);
			c.setPath("/StudentM");
			response.sendRedirect("/StudentM/Index");//��½�ɹ���ʾ��ҳ��
		}
		else {
			response.getWriter().print("��½ʧ��");
			String relogin="<a href='/StudentM/login.html'>���µ�½</a>";
			response.getWriter().print("<br/>"+"<br/>"+"<br/>"+relogin);
		}
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
