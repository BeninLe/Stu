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
		//获取信息
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("key");
		//判断用户是否存在
		if(user==null) {
			//没有登陆
			response.sendRedirect("/StudentM/login.html");//跳转到主页面
		}
		else {
			String name =user.getUsername();
			String url="<a href='/StudentM/Search.html'>搜索学生信息</a>";
			String s_All="<a href='/StudentM/SearchAll'>显示全部学生</a>";
			String d="<a href='/StudentM/delete.html'>删除学生信息</a>";
			String add="<a href='/StudentM/add.html'>添加学生信息</a>";
			String out="<a href='/StudentM/loginOut'>退出登陆</a>";
			response.getWriter().print("<br/>"+"欢迎"+name+"登陆"+"<br/>"+"<br/>"+url+"<br/>"+"<br/>"+s_All+"<br/>"+"<br/>"+d+"<br/>"+"<br/>"+add+"<br/>"+"<br/>"+out);
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
