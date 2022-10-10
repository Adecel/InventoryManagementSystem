package za.ac.cput.ims31.ui.uicomponent;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import za.ac.cput.ims31.entity.Breakage;
import za.ac.cput.ims31.entity.Product;
import za.ac.cput.ims31.repository.BreakageRepository;
import za.ac.cput.ims31.repository.ProductRepository;
import za.ac.cput.ims31.ui.BreakageUI;

/**
 *
 * @author cassy
 */
public class BreakageUpdateForm {
    
private JFrame parentJFrame;
private int productId;
private int breakageIdData;
private BreakageRepository repository;
private ProductRepository ProductRepository;
JFrame frame= new JFrame();
    
public void GetForm(JFrame jFrame, Breakage breakage) throws SQLException{
breakageIdData = breakage.getId();
parentJFrame = jFrame;
repository = new BreakageRepository();
ProductRepository = new ProductRepository();
Product product = ProductRepository.read(breakage.getProductId());
productId = breakage.getProductId();
// Create frame with title Registration Demo

frame.setTitle("Breakage Form");
JPanel mainPanel = new JPanel();
mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
JPanel headingPanel = new JPanel();
JLabel headingLabel = new JLabel("Edit Breakage for "+product.getProductName());
headingPanel.add(headingLabel);
JPanel panel = new JPanel(new GridBagLayout());
// Constraints for the layout
GridBagConstraints constr = new GridBagConstraints();
constr.insets = new Insets(5, 5, 5, 5);
constr.anchor = GridBagConstraints.WEST;
// Setting initial grid values to 0,0
constr.gridx=0;
constr.gridy=0;
JLabel productNameLabel      = new JLabel("Product Name :");
JLabel breakageQtyLabel      = new JLabel("Breakage Qty  :");
JLabel beakageDateLabel     = new JLabel("Breakage Date :");
JLabel msgLabel        = new JLabel("Description :");

JTextField productName = new JTextField(20);
JTextField breakageId  = new JTextField(20);
JTextField breakageQty = new JTextField(20);
JTextArea textArea = new JTextArea(5, 20);

try{
productName.setText(product.getProductName());
productName.setEditable(false);
breakageId.setText(""+breakage.getQuantity());
breakageQty.setText(""+breakage.getDate());
breakageQty.setEditable(false);
textArea.setText(breakage.getDescription()); 
}catch(NullPointerException nullPoint){
    
}

panel.add(productNameLabel, constr);
constr.gridx=1;
panel.add(productName, constr);
constr.gridx=0; constr.gridy=1;
panel.add(breakageQtyLabel, constr);
constr.gridx=1;
panel.add(breakageId, constr);
constr.gridx=0; constr.gridy=2;
panel.add(beakageDateLabel, constr);
constr.gridx=1;
panel.add(breakageQty, constr);
constr.gridx=0; constr.gridy=3;
panel.add(msgLabel, constr);
constr.gridx=1;
panel.add(textArea, constr);
constr.gridx=0; constr.gridy=4;
//constr.gridwidth = 2;
//constr.anchor = GridBagConstraints.CENTER;
// Button with text "Register"
JButton update = new JButton("Update");
JButton delete = new JButton("Delete");
JButton cancel = new JButton("Cancel");
// add a listener to button
update.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
headingLabel.setText("Breakage submited successfully.");
Date date = new Date(Util.getDateNow());
int breakageNumber = Integer.parseInt(breakageId.getText());
int breakId = Integer.parseInt(breakageId.getText());

    try {
        //Checking if can be updatable.
      boolean result = checkUpdate(breakageIdData,breakageNumber);
      
      if(result){
          toBeAdded(breakageIdData,breakageNumber);
          boolean  diductionresult = repository.updateQuantity(breakageNumber,breakageIdData,textArea.getText());
      if(diductionresult){
          JOptionPane.showMessageDialog(null,"Update successful","Success",JOptionPane.INFORMATION_MESSAGE);
          frame.dispose();
          parentJFrame.dispose();
          new BreakageUI().setBreakage();
      }else{
          JOptionPane.showMessageDialog(null,"Update failled.\nTransaction error!","Fail",JOptionPane.WARNING_MESSAGE);
      }
      }else{
          JOptionPane.showMessageDialog(null,"Update failled.\nQty should be lower!","Fail",JOptionPane.WARNING_MESSAGE);
      }
      
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"Update failled","Fail",JOptionPane.WARNING_MESSAGE);
    }

}
});

delete.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
boolean diductionresult = false;
    try {
        int brQty = Integer.parseInt(breakageId.getText());
        var productUpdateResult = ProductRepository.encreaseQuantity(brQty, productId);
        if(productUpdateResult){
           boolean result = repository.delete(breakageIdData);
        if(result){
          JOptionPane.showMessageDialog(null,"Delete successful","Success",JOptionPane.INFORMATION_MESSAGE);
          frame.dispose();
          parentJFrame.dispose();
          new BreakageUI().setBreakage();
        }else{
            JOptionPane.showMessageDialog(null,"Delete failled","Fail",JOptionPane.WARNING_MESSAGE);
        } 
        }else{
            JOptionPane.showMessageDialog(null,"Delete failled","Fail",JOptionPane.WARNING_MESSAGE);
        }
    } catch (SQLException ex) {
        Logger.getLogger(JFrameDemo.class.getName()).log(Level.SEVERE, null, ex);
    }
}
});
constr.gridx=0; constr.gridy=5;
panel.add(update, constr);
constr.gridx=1;
panel.add(delete, constr);
constr.gridx=2;
panel.add(delete, constr);
mainPanel.add(headingPanel);
mainPanel.add(panel);
frame.add(mainPanel);
frame.pack();
frame.setSize(500, 300);
frame.setLocationRelativeTo(null);
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame.setVisible(true);
}
public static void main(){
    new BreakageUpdateForm();
}
boolean checkUpdate(int breakageId,int newQty) throws SQLException{
   Breakage breakage =  repository.read(breakageId);
   if(breakage!=null){
       int oldQty = breakage.getQuantity();
       if(oldQty > newQty) return true;
   }
   return false;
}
boolean toBeAdded(int breakageId,int newQty) throws SQLException{
    Breakage breakage =  repository.read(breakageId);
    System.out.print("breakage:"+breakage);
    int toUpdate =  breakage.getQuantity()-newQty;
    return ProductRepository.encreaseQuantity(toUpdate, productId);
}
}

