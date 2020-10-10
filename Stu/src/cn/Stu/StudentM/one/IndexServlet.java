package cn.Stu.StudentM.one;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPException;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/Index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ��Ϣ
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("key");
		//�ж��û��Ƿ����
		if(user==null) {
			//û�е�½
			response.sendRedirect("/StudentM/login.html");//��ת����ҳ��
		}
		else {
			String name =user.getUsername();
			String url="<a href='/StudentM/Search.html'>����ѧ����Ϣ</a>";
			String s_All="<a href='/StudentM/SearchAll'>��ʾȫ��ѧ��</a>";
			String d="<a href='/StudentM/delete.html'>ɾ��ѧ����Ϣ</a>";
			String add="<a href='/StudentM/add.html'>���ѧ����Ϣ</a>";
			String out="<a href='/StudentM/loginOut'>�˳���½</a>";
			response.getWriter().print("<br/>"+"��ӭ"+name+"��½"+"<br/>"+"<br/>"+url+"<br/>"+"<br/>"+s_All+"<br/>"+"<br/>"+d+"<br/>"+"<br/>"+add+"<br/>"+"<br/>"+out);
		}
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
