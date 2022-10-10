package za.ac.cput.ims31.ui.uicomponent;

import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import za.ac.cput.ims31.entity.Product;
import za.ac.cput.ims31.repository.ProductRepository;

/**
 *
 * @author cassy
 */
public class ProductTable {
    // frame
    JPanel mainPanel;
    // Table
    JTable j;
    ProductRepository repository = null;
    
 
    // Constructor
    public ProductTable() throws SQLException{
        // Frame initialization
        mainPanel = new JPanel();
        repository = new ProductRepository();
 
        // Data to be displayed in the JTable
        String[] columnNames = { "ProductId", "SupplyId","Product Name","Quantity", "Price" };
        Object[][] object = new Object[20][20];
        var brakages = repository.readAll();
        int i = 0;
        if(!brakages.isEmpty()){
            for(Product product: repository.readAll()){
            object[i][0] = product.getProductId();
            object[i][1] = product.getSuplyId();
            object[i][2] = product.getProductName();
            object[i][3] = product.getProductQuantityOnHand();
            object[i][4] = product.getProductPrice();
            i++;
            j = new JTable(object, columnNames);
        }
        }else{
             j = new JTable(object, columnNames);
        }
 
        // Initializing the JTable
        j = new JTable(object, columnNames);
        j.setBounds(30, 40, 200, 300);
 
        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        mainPanel.add(sp);
    }
    public JPanel getTable(){
        return mainPanel;
    }
 
    // Driver  method
//    public static void main(String[] args)
//    {
//        new ProductTable();
//    }
}
