package cn.Stu.StudentM.one;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * Servlet implementation class tianjian
 */
@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
	
	
		File file = new File("../Stu/WebContent/student.xml");
		SAXReader reader = new SAXReader();
		
        String Aname =request .getParameter("SName");
			student asn =new student();
			asn.setSName(Aname);
			
			String Ano =request .getParameter("Sno");
			student asno =new student();
			asno.setSName(Ano);

			String Asex =request .getParameter("sex");
			student asex =new student();
			asex.setSName(Asex);

		try {
			String name = null;
			String text = null;
			
			 Document doc = DocumentHelper.createDocument();//here
				
		        //添加并得到根元素
		        Element root1 =  doc.addElement("student");
		        //为根元素添加子元素
		
			
			Document document = reader.read(file);
			Element root = document.getRootElement();//得到根节点
		//	System.out.println(document.getRootElement()+"**********-*-*-*-*");
			List<Element> list = root.elements();//得到属性值和id
			Element ast = root1.addElement("stu");
	        if(Aname.equals(null)==false) {
			     // Element Astu = root1.addElement("stu");
		          //为子元素添加属性
			        ast.addAttribute("id",Aname);
			        
	            Element ae = ast.addElement("姓名");
		        ae.addText(Aname);
		        
		        if(Ano.equals(null)==false){
		        	Element ao = ast.addElement("学号");
			        ao.addText(Ano);
			       
			        if(Asex.equals(null)==false){
			        	Element ax = ast.addElement("性别");
				        ax.addText(Asex);
				     
				 }else {}
		        }else {}
			   }else {}
			 
		//	System.out.println(root.elements()+"**********-*-*-*-*");
			for (Element element : list) {//循环得到每一个stu的所有属性名称
				List<Element> child = element.elements();
			
				List<Attribute> attributes=element.attributes();
			
				for (Attribute attribute : attributes) {
					 
					if (attribute.getName().equals("id")) {
						String id = attribute.getValue();
						//System.out.println(id+"33333333333333333333");				
						
					      Element stu = root1.addElement("stu");
				          //为子元素添加属性
					        stu.addAttribute("id",id);
					        //添加子元素
				
						for (Element element2 : child) {
							
			
							
							name = element2.getName();
							 text = element2.getText();
							 
						        Element stud = stu.addElement(name);
						        stud.addText(text);
	        
						          
				        	  OutputFormat format =  OutputFormat.createPrettyPrint();
				        	  format.setEncoding("utf-8");
						        XMLWriter write =  new XMLWriter(new FileOutputStream(new File("../Stu/WebContent/student.xml")),format);
						        write.write(doc);
						        //关闭流
					

					       
						        write.close();
					        
						//************
		 
					//	 PrintWriter out = response.getWriter();
					//	 out .write("&nbsp;&nbsp;"+name1+":"+text+"&nbsp;&nbsp;"+"<br/>");
					
						        
					
						}//hopefor
					  
				
						for (Element element2 : child) {
							name = element2.getName();
							 text = element2.getText();
							//System.out.println(name + ":" + text+"接收到："+Aname+"**name****"+Ano+"**sno****"+Asex+"**sex****");
							System.out.print("\r\n");
						
						}//for
	
					}//idif
				}//for2
			   
				
			}//for1
			String back="<a href='/StudentM/Index'>返回</a>";
			
			response.getWriter().print("<br/>"+"学生"+"&nbsp;&nbsp;"+Aname+"&nbsp;&nbsp;"+"的信息已经添加成功"+"<br/>");
			response.getWriter().print("<br/>"+"<br/>"+"<br/>"+back);

	
		} catch (DocumentException stu) {
			System.out.println("--------------错误-------------");
			stu.printStackTrace();
		
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
