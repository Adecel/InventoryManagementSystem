package za.ac.cput.ims31.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import za.ac.cput.ims31.entity.Breakage;

/**
 *
 * @author cassy
 */
public class BreakageRepository {
            String url = "jdbc:derby://localhost:1527/IMPRT3_DB";
            String user = "ADMINISTRATION";
            String pass = "password";
            Connection con = null;

    public BreakageRepository() throws SQLException {
         con = DriverManager.getConnection(url, user, pass);
    }
    
    public boolean create(Breakage breakage) throws SQLException{
//        String query = "INSERT INTO  BREAKAGES ( BREA_ID, PROD_ID, BREA_DATE, BREA_TOTAL, BREA_REASON)  " + "VALUES(?,?,?,?,?)";
        String query = "INSERT INTO  BREAKAGES ( PROD_ID, BREA_DATE, BREA_TOTAL, BREA_REASON)  " + "VALUES(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
//        ps.setInt(1,breakage.getId());
        ps.setInt(1, breakage.getProductId());
        ps.setDate(2, breakage.getDate());
        ps.setInt(3, breakage.getQuantity());
        ps.setString(4, breakage.getDescription());
        int result = ps.executeUpdate();
        return (result == 1);
    }
    public Breakage read(int id) throws SQLException{
        Breakage breakage = null;
        String query = "SELECT BREA_ID, PROD_ID, BREA_DATE, BREA_TOTAL, BREA_REASON FROM  BREAKAGES WHERE BREA_ID = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
              breakage = new Breakage(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getInt(4),rs.getString(5));
            }
        return breakage;
    }
    public boolean updateQuantity( int number, int productId, String reason) throws SQLException{
        String query = "UPDATE BREAKAGES SET BREA_TOTAL =?,BREA_REASON=? WHERE BREA_ID =?";
        PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, number);
        ps.setString(2, reason); 
        ps.setInt(3, productId);
        int result = ps.executeUpdate();
        return (result == 1);
    }
    public boolean update(Breakage breakage) throws SQLException{
        String query = "UPDATE BREAKAGES SET PROD_ID =?, BREA_DATE =?, BREA_TOTAL =?, BREA_REASON =? WHERE BREA_ID = ?";
        PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
//        ps.setInt(1,breakage.getId());
        ps.setInt(1, breakage.getProductId());
        ps.setDate(2, breakage.getDate());
        ps.setInt(3, breakage.getQuantity());
        ps.setString(4, breakage.getDescription());
        ps.setInt(5,breakage.getId());
        int result = ps.executeUpdate();
        return (result == 1);
    }
    public boolean delete(int id) throws SQLException{
        String query = "DELETE FROM  BREAKAGES WHERE BREA_ID = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,id);
        int rs = ps.executeUpdate();
        return (rs == 1);
    }
    public List<Breakage> readAll() throws SQLException{
        List<Breakage> breakage = new ArrayList();
        String query = "SELECT * FROM  BREAKAGES";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
              breakage.add(new Breakage(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getInt(4),rs.getString(5)));
            }
        return breakage;
    }
    public List<Breakage> readAgregation() throws SQLException{
        List<Breakage> breakage = new ArrayList();
        String query = "SELECT PROD_ID, SUM(BREA_TOTAL) FROM  BREAKAGES GROUP BY PROD_ID";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int productId = rs.getInt(1);
            int quantity = rs.getInt(2);
              breakage.add(new Breakage(0,productId,null,quantity,""));
            }
        return breakage;
    }
            
}
