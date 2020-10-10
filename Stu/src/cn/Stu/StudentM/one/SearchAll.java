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
 * Servlet implementation class SearchAll
 */
@WebServlet("/SearchAll")
public class SearchAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		File file = new File("../Stu/WebContent/student.xml");
		SAXReader reader = new SAXReader();
		
		try {
			String name = null;
			String text = null;
			
			Document document = reader.read(file);
			Element root = document.getRootElement();
			List<Element> list = root.elements();
			for (Element element : list) {
				List<Element> child = element.elements();
				//得到当前节点的属性对象
				List<Attribute> attributes=element.attributes();
			System.out.println(element.attributes());
			
				for (Attribute attribute : attributes) {
					System.out.println(attribute);
					if (attribute.getName().equals("id")) {
						String id = attribute.getValue();
						System.out.println(attribute.getValue());
						
					 if(id!=null) {//分割线
						 PrintWriter out = response.getWriter();
						 out .write("----------------"+"<br/>");
					 }
						 
					

					for (Element element2 : child) {
						 name = element2.getName();
						 text = element2.getText();
		 
						 PrintWriter out = response.getWriter();
						 out .write("&nbsp;&nbsp;"+name+":"+text+"&nbsp;&nbsp;"+"<br/>");
						 System.out.println(name + ":" + text);
							System.out.print("\r\n");
						
					}//for3
				    }//iff
					
							
						
					
				}//for2**/
			   
				
			}//for1
	
		} catch (DocumentException e) {
			System.out.println("--------------错误-------------");
			e.printStackTrace();
		}
		
		 String url="<a href='/StudentM/Index'>返回</a>";
		 response.getWriter().print("<br/>"+"<br/>"+url+"<br/>"+"<br/>");
		
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
