import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewProduct")
public class ViewProduct extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='Index.html'>Add New Product</a>");
		out.println("<h1>Products List</h1>");
		
		List<Product> list=ProductDao.getAllProducts();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Productname</th><th>Price</th><th>Description</th><th>Edit</th><th>Delete</th></tr>");
		for(Product e:list){
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getProductname()+"</td><td>"+e.getPrice()+"</td><td>"+e.getDescription()+"</td><td><a href='EditProduct?id="+e.getId()+"'>edit</a></td><td><a href='DeleteProduct?id="+e.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
