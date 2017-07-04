import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Product</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Product e=ProductDao.getProductById(id);
		
		out.print("<form action='EditProduct2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value="+e.getId()+"></td></tr>");
		out.print("<tr><td>Productname:</td><td><input type='text' name='name' value='"+e.getProductname()+"'/></td></tr>");
		out.print("<tr><td>Price:</td><td><input type='text' name='price' value='"+e.getPrice()+"'/></td></tr>");
		out.print("<tr><td>Description:</td><td><input type='text' name='description' value='"+e.getDescription()+"'/></td></tr>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
