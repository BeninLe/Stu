package cn.Stu.StudentM.one;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import java.sql.SQLException;


import javax.sql.RowSetInternal;
import javax.sql.rowset.WebRowSet;
import javax.sql.rowset.spi.XmlWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.dom4j.Attribute;
import org.dom4j.Branch;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.junit.platform.commons.function.Try.Transformer;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String Dname =request .getParameter("SName");
		student s =new student();
		s.setSName(Dname);
	
		File file = new File("../Stu/WebContent/student.xml");
		SAXReader reader = new SAXReader();
		
       

		try {
			String name = null;
			String text = null;
			
			 Document doc = DocumentHelper.createDocument();//here
				
		        //��Ӳ��õ���Ԫ��
		        Element root1 =  doc.addElement("student");
		        //Ϊ��Ԫ�������Ԫ��
		
			
			Document document = reader.read(file);
			Element root = document.getRootElement();//�õ����ڵ�
		//	System.out.println(document.getRootElement()+"**********-*-*-*-*");
			List<Element> list = root.elements();//�õ�����ֵ��id
			
		
			 
		//	System.out.println(root.elements()+"**********-*-*-*-*");
			for (Element element : list) {//为什么
				List<Element> child = element.elements();
			
				List<Attribute> attributes=element.attributes();
			
				for (Attribute attribute : attributes) {
					 
					if (attribute.getName().equals("id")) {
						String id = attribute.getValue();
						//System.out.println(id+"33333333333333333333");				
						
						if(Dname.equals(id)==false) {
                    	
				           Element stu = root1.addElement("stu");
				          //Ϊ��Ԫ���������
					        stu.addAttribute("id",id);
					        //�����Ԫ��

						for (Element element2 : child) {
							name = element2.getName();
							 text = element2.getText();
							 
						        Element stud = stu.addElement(name);
						        stud.addText(text);

				        	  OutputFormat format =  OutputFormat.createPrettyPrint();
				        	  format.setEncoding("utf-8");
						        XMLWriter write =  new XMLWriter(new FileOutputStream(new File("../Stu/WebContent/student.xml")),format);
						        write.write(doc);
						        //�ر���
						        write.close();

					       

					        
						//************
		 
					//	 PrintWriter out = response.getWriter();
					//	 out .write("&nbsp;&nbsp;"+name1+":"+text+"&nbsp;&nbsp;"+"<br/>");
						
					
						}//hopefor
					  
				    }//iff
					else {
						for (Element element2 : child) {
							name = element2.getName();
							 text = element2.getText();
							System.out.println(name + ":" + text+"乱码"+Dname);
							System.out.print("\r\n");
						}
						}//else
	
					}//idif
				}//for2
			   
				
			}//for1
			String back="<a href='/StudentM/Index'>����</a>";
			
			response.getWriter().print("<br/>"+"ѧ��"+"&nbsp;&nbsp;"+Dname+"&nbsp;&nbsp;"+"����Ϣ�Ѿ�ɾ���ɹ�"+"<br/>");
			response.getWriter().print("<br/>"+"<br/>"+"<br/>"+back);

	
		} catch (DocumentException stu) {
			System.out.println("--------------����-------------");
			stu.printStackTrace();
		}
		
		// String url="<a href='/StudentM/Index'>����</a>";
		// response.getWriter().print("<br/>"+"<br/>"+url+"<br/>"+"<br/>");
		
		
		
		
		
		
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

  
	private void callDomWriter(Document doc, OutputStreamWriter osw, String string) {
		// TODO Auto-generated method stub
		
	}


	private void remove(List<Attribute> attributes) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
