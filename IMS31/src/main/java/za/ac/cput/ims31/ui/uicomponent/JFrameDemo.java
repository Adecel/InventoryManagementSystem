package za.ac.cput.ims31.ui.uicomponent;

/**
 *
 * @author cassy
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Date;
import java.sql.SQLException;
import za.ac.cput.ims31.entity.Breakage;
import za.ac.cput.ims31.entity.Product;
import za.ac.cput.ims31.repository.BreakageRepository;
import za.ac.cput.ims31.repository.ProductRepository;
import za.ac.cput.ims31.ui.BreakageUI;
public class JFrameDemo {
private JFrame parentJFrame;
private JFrame grandParentJFrame;
private int productId;
private int productQuantity;
private BreakageRepository repository;
private ProductRepository ProductRepository;
    
public void GetForm(JFrame jframeGrandFather, JFrame jFrame, Product product) throws SQLException{
parentJFrame = jFrame;
grandParentJFrame = jframeGrandFather;
repository = new BreakageRepository();
ProductRepository = new ProductRepository();
productId = product.getProductId();
productQuantity = product.getProductQuantityOnHand();
// Create frame with title Registration Demo
JFrame frame= new JFrame();
frame.setTitle("Breakage Form");
JPanel mainPanel = new JPanel();
mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
JPanel headingPanel = new JPanel();
JLabel headingLabel = new JLabel("Add New Breakage for "+product.getProductName());
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
JLabel productIdLabel      = new JLabel("Product iD :");
JLabel beakageQtyLabel     = new JLabel("Enter Breakage Qty :");
JLabel msgLabel        = new JLabel("Description :");
JTextField productName           = new JTextField(20);
JTextField breakageId           = new JTextField(20);
JTextField breakageQty          = new JTextField(20);
productName.setText(product.getProductName());
productName.setEditable(false);
breakageId.setText(""+product.getProductId());
breakageId.setEditable(false);
JTextArea textArea = new JTextArea(5, 20);
panel.add(productIdLabel, constr);
constr.gridx=1;
panel.add(breakageId, constr);
constr.gridx=0; constr.gridy=1;
panel.add( productNameLabel, constr);
constr.gridx=1;
panel.add( productName, constr);
constr.gridx=0; constr.gridy=2;
panel.add(beakageQtyLabel, constr);
constr.gridx=1;
panel.add(breakageQty, constr);
constr.gridx=0; constr.gridy=3;
panel.add(msgLabel, constr);
constr.gridx=1;
panel.add(textArea, constr);
constr.gridx=0; constr.gridy=4;
constr.gridwidth = 2;
constr.anchor = GridBagConstraints.CENTER;
// Button with text "Register"
JButton button = new JButton("Submit");
// add a listener to button
button.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
headingLabel.setText("Breakage submited successfully.");
Date date = new Date(Util.getDateNow());
int breakageNumber = Integer.parseInt(breakageQty.getText());
int breakId = Integer.parseInt(breakageId.getText());
boolean diductionresult=false;
    try {
            boolean result = checkToUpdate(productId,breakageNumber);
            if(result){
              diductionresult = ProductRepository.decreaseQuantity(productQuantity,breakageNumber,productId);
                if(breakId!=0||breakageNumber!=0||productId!=0||breakageNumber>productQuantity||diductionresult){
                    Breakage breakage = new Breakage(breakId,productId,date,breakageNumber,textArea.getText());
                    try {
                    boolean resultCreate = repository.create(breakage);
                    if(resultCreate){
                    JOptionPane.showMessageDialog(null, "Successfully created Breakage!");
                    productName.setText("");
                    breakageId.setText("");
                    breakageQty.setText("");
                    textArea.setText("");
                    grandParentJFrame.dispose();
                    new BreakageUI().setBreakage();
                    frame.dispose();
                    parentJFrame.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Failled to create Breakage!");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Failled to create Breakage!");
            }  
        }else{
            JOptionPane.showMessageDialog(null,"Missing Details!","Fail",JOptionPane.WARNING_MESSAGE);
        }
       }else{
          JOptionPane.showMessageDialog(null,"Creation failled.\nQty should be lower!","Fail",JOptionPane.WARNING_MESSAGE);
           }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"Update failled.\nTransaction error!","Fail",JOptionPane.WARNING_MESSAGE);
    }
}
});
panel.add(button, constr);
mainPanel.add(headingPanel);
mainPanel.add(panel);
frame.add(mainPanel);
frame.pack();
frame.setSize(500, 300);
frame.setLocationRelativeTo(null);
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame.setVisible(true);
}
boolean checkToUpdate(int productId,int brokenQty) throws SQLException{
    Product product = ProductRepository.read(productId);
    if(product!=null){
        if(product.getProductQuantityOnHand()>brokenQty) return true;
    }
    return false;
}

}
