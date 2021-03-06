

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditProduct2")
public class EditProduct2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String description=request.getParameter("description");
		
		
		Product e=new Product();
		e.setId(id);
		e.setProductname(name);
		e.setPrice(price);
		e.setDescription(description);
		
		int status=ProductDao.update(e);
		if(status>0){
			response.sendRedirect("ViewProduct");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}
