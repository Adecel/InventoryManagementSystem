package za.ac.cput.ims31.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import za.ac.cput.ims31.entity.Product;

/**
 *
 * @author cassy
 */
public class ProductRepository {
    String url = "jdbc:derby://localhost:1527/IMPRT3_DB";
            String user = "ADMINISTRATION";
            String pass = "password";
            Connection con = null;

    public ProductRepository() throws SQLException {
         con = DriverManager.getConnection(url, user, pass);
    }
    public boolean create(Product product) throws SQLException{
        String query = "INSERT INTO  PRODUCT (  SUPP_ID, PROD_NAME, PROD_QTYONHAND, PROD_PRICE)  " + "VALUES(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
//        ps.setInt(1,product.getProductId());
        ps.setInt(1, product.getSuplyId());
        ps.setString(2, product.getProductName());
        ps.setInt(3, product.getProductQuantityOnHand());
        ps.setDouble(4, product.getProductPrice());
        int result = ps.executeUpdate();
        return (result == 1);
    }
    public boolean updateQuantity( int number, int productId) throws SQLException{
        String query = "UPDATE PRODUCT SET PROD_QTYONHAND =? WHERE PROD_ID =?";
        PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, number);
        ps.setInt(2, productId); 
        int result = ps.executeUpdate();
        return (result == 1);
    }
    public boolean decreaseQuantity(int currentQty, int number, int productId) throws SQLException{
        int qty = currentQty - number;
        String query = "UPDATE PRODUCT SET PROD_QTYONHAND =? WHERE PROD_ID =?";
        PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, qty);
        ps.setInt(2, productId); 
        int result = ps.executeUpdate();
        return (result == 1);
    }
    public boolean encreaseQuantity(int number, int productId) throws SQLException{
        Product product = read(productId);
        int qty = product.getProductQuantityOnHand() + number;
        String query = "UPDATE PRODUCT SET PROD_QTYONHAND =? WHERE PROD_ID =?";
        PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, qty);
        ps.setInt(2, productId); 
        int result = ps.executeUpdate();
        return (result == 1);
    }
    public Product read(int id) throws SQLException{
        Product product = null;
        String query = "SELECT PROD_ID, SUPP_ID, PROD_NAME, PROD_QTYONHAND, PROD_PRICE FROM  PRODUCT WHERE PROD_ID = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
              product = new Product(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getDouble(5));
            }
        return product;
    }
    public boolean update(Product product) throws SQLException{
        String query = "UPDATE PRODUCT SET SUPP_ID =?, PROD_NAME =?, PROD_QTYONHAND =?, PROD_PRICE=? WHERE PROD_ID =?";
        PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, product.getSuplyId());
        ps.setString(2, product.getProductName());
        ps.setInt(3, product.getProductQuantityOnHand());
        ps.setDouble(4, product.getProductPrice());
        ps.setInt(5,product.getProductId());
        int result = ps.executeUpdate();
        return (result == 1);
    }
    public boolean delete(int id) throws SQLException{
        String query = "DELETE FROM  PRODUCT WHERE PROD_ID = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,id);
        int rs = ps.executeUpdate();
        return (rs == 1);
    }
    public List<Product> readAll() throws SQLException{
        List<Product> product = new ArrayList();
        String query = "SELECT * FROM  PRODUCT";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
              product.add(new Product(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getDouble(5)));
            }
        return product;
    }
}
