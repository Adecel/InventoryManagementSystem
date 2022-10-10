package za.ac.cput.ims31.ui.uicomponent;

import java.awt.Component;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import za.ac.cput.ims31.entity.Breakage;
import za.ac.cput.ims31.repository.BreakageRepository;

/**
 *
 * @author cassy
 */
public class BreakageTable {
    // frame
    JPanel mainPanel;
    // Table
    JTable j;
    BreakageRepository repository;
    List<Breakage> breakageList = null;
    JFrame parent ;
    
 
    // Constructor
    public BreakageTable() throws SQLException{
        // Frame initialization
        mainPanel = new JPanel();
        repository = new BreakageRepository();
 
        // Data to be displayed in the JTable
        
        // Column Names
        String[] columnNames = { "Breakage Id", "ProductId","Date","Quantity", "Description" };
        Object[][] object = new Object[200][5];
        breakageList = repository.readAll();
        int i = 0;
        if(!breakageList.isEmpty()){
            for(Breakage breakage: breakageList){
            object[i][0] = breakage.getId();
            object[i][1] = breakage.getProductId();
            object[i][2] = breakage.getDate();
            object[i][3] = breakage.getQuantity();
            object[i][4] = breakage.getDescription();
            i++;
            j = new JTable(object, columnNames);
        }
        }else{
            j = new JTable(object, columnNames);
        }
        //SET SELECTION MODE
    j.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    ListSelectionModel model=j.getSelectionModel();
    //add listener
    model.addListSelectionListener(new ListSelectionListener() {

      @Override
      public void valueChanged(ListSelectionEvent e) {

        // JUST IGNORE WHEN USER HAS ATLEAST ONE SELECTION
        if(e.getValueIsAdjusting())
        {
          return;
        }
        ListSelectionModel lsm=(ListSelectionModel) e.getSource();

        if(lsm.isSelectionEmpty())
        {
          JOptionPane.showMessageDialog(null, "No selection");
        }else
        {
          int selectedRow=lsm.getMinSelectionIndex();
          //JOptionPane.showMessageDialog(null, "Selected Row "+breakageList.get(selectedRow).toString()); 
          if(breakageList.get(selectedRow)!=null){
              var breakageData = breakageList.get(selectedRow);
              System.out.println(breakageData.toString());
              try {
                  new BreakageUpdateForm().GetForm(parent, breakageData);
              } catch (SQLException ex) {
                  Logger.getLogger(BreakageTable.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
        }
      }
    });

  
        // Initializing the JTable
        
        //j.setBounds(30, 40, 200, 400);
 
        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        mainPanel.setLayout(new GridLayout(1,1));
        mainPanel.add(sp);
    }
    public JPanel getTable(JFrame jframe){
        parent = jframe;
        return mainPanel;
    }
 
//     Driver  method
//    public static void main(String[] args) throws SQLException
//    {
//        JFrame jf = new JFrame();
//        jf.add(new ProductTable().mainPanel);
//        jf.setSize(600, 600);
//        jf.setLocationRelativeTo(null);
//        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        jf.setVisible(true);
//    }
}
