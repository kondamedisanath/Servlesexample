import java.util.*;
import java.sql.*;

public class ProductDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "sanath");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int save(Product e) {
		int status = 0;
		try {
			Connection con = ProductDao.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into Product(id,Productname,price,description) values (?,?,?,?)");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getProductname());
			ps.setString(3, e.getPrice());
			ps.setString(4, e.getDescription());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(Product e) {
		int status = 0;
		try {
			Connection con = ProductDao.getConnection();
			PreparedStatement ps = con.prepareStatement("update Product set Productname=?,price=?,description=? where id=?");
			ps.setString(1, e.getProductname());
			ps.setString(2, e.getPrice());
			ps.setString(3, e.getDescription());
			ps.setInt(4, e.getId());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = ProductDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from Product where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static Product getProductById(int id) {
		Product e = new Product();

		try {
			Connection con = ProductDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Product where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setProductname(rs.getString(2));
				e.setPrice(rs.getString(3));
				e.setDescription(rs.getString(4));

			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	public static List<Product> getAllProducts() {
		List<Product> list = new ArrayList<Product>();

		try {
			Connection con = ProductDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Product");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product e = new Product();
				e.setId(rs.getInt(1));
				e.setProductname(rs.getString(2));
				e.setPrice(rs.getString(3));
				e.setDescription(rs.getString(4));

				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}

