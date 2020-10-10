package cn.Stu.StudentM.one;

import java.beans.Statement;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.soap.Node;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String Sname =request .getParameter("SName");
		student s =new student();
		s.setSName(Sname);
		
		File file = new File("../Stu/WebContent/student.xml");
		SAXReader reader = new SAXReader();

		try {
			String name = null;
			String text = null;
			
			Document document = reader.read(file);
			Element root = document.getRootElement();//得到根节点
		//	System.out.println(document.getRootElement()+"**********-*-*-*-*");
			List<Element> list = root.elements();//得到属性值和id
		//	System.out.println(root.elements()+"**********-*-*-*-*");
			for (Element element : list) {//循环得到每一个stu的所有属性名称
				List<Element> child = element.elements();
			
				List<Attribute> attributes=element.attributes();
			System.out.println(element.attributes());
			
				for (Attribute attribute : attributes) {
					System.out.println(attribute);
					if (attribute.getName().equals("id")) {
						String id = attribute.getValue();
						System.out.println(id);
						
					 if(Sname.equals(id)) {

					for (Element element2 : child) {
						 name = element2.getName();
						 text = element2.getText();
		 
						 PrintWriter out = response.getWriter();
						 out .write("&nbsp;&nbsp;"+name+":"+text+"&nbsp;&nbsp;"+"<br/>");
						
					}//for3
					
				    }//iff
					else {
							System.out.println(name + ":" + text+"接收到："+Sname);
							System.out.print("\r\n");
						}//else
					}//idif
				}//for2**/
			   
				
			}//for1
	
		} catch (DocumentException e) {
			System.out.println("--------------错误-------------");
			e.printStackTrace();
		}
		
		 String url="<a href='/StudentM/Index'>返回</a>";
		 response.getWriter().print("<br/>"+"<br/>"+url+"<br/>"+"<br/>");
	
	//	response.sendRedirect("");
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
