package za.ac.cput.ims31.ui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import za.ac.cput.ims31.entity.Breakage;
import za.ac.cput.ims31.entity.Product;
import za.ac.cput.ims31.repository.BreakageRepository;
import za.ac.cput.ims31.repository.ProductRepository;
import za.ac.cput.ims31.ui.uicomponent.BreakageTable;
import za.ac.cput.ims31.ui.uicomponent.ProductView;

/**
 *
 * @author cassy
 */
public class BreakageUI extends JFrame implements ActionListener {

    private JFrame mainFrame;
    private JPanel panelNorth, panelWest, panelSouth, panelCenter,newPaneCenter;

    private JLabel lblPicture;

    private JLabel lblCompanyName;

    private JButton btnAdd;
    private JButton btnView;
    private JButton btnSchedule;
    private JButton btnUpdate;
    private JButton btnDeletes;

    private JPanel panelBlank1, panelBlank2, panelBlank3, panelBlank4, panelBlank5, panel6, panelcheck;

    private Font font1;

    Insets btnInsets = new Insets(5, 5, 5, 5);
    
    Thread th;
    

    private JFrame MainFrame;
    private JLabel Victime;
    private JLabel cboVictime;
    private JLabel lblErrorVictime;

    private JLabel lblSearchID;
    private JComboBox Search;
    private JButton btnsearch;

    private JLabel ComplainID;
    private JTextField txtComplainID;
    private JLabel cboComplainID;

    private JLabel prodId;
    private JTextField txtProdId;
    private JLabel lblErrorProdId;

    private JComboBox cboReason;

    private JLabel date;
    private JTextField txtDate;
    private JLabel lblErrorDate;

    private JLabel total;
    private JTextField txtTotal;
    private JLabel lblErrorTotal;

    private JLabel lblOptinal;


    private JLabel lblEmail;
    private JTextField txtEmail;
    private JLabel lblErrorEmail;

    private JLabel lblMobile;
    private JTextField txtMobile;
    private JLabel lblErrorMobile;

    private JLabel lblAdress;
    private JTextField cboAdress;
    private JLabel lblErrorAdress;

    private JLabel Complain;
    private JLabel cboComplain;
    private JLabel lblErrorComplain;

    private JLabel ComplainV;
    private JTextField txtComplainV;
    private JLabel cboComplainV;
    private JLabel lblReason;
    private JTextField txtReason;
    private JLabel lblErrortxtReason;
    private TextArea infoArea;

//    private JLabel InvenstigationOfficerID;
//    private JTextField txtInvenstigationOfficerID;
//    private JLabel lblErrorInvenstigationOfficerID;

    private JLabel OfficerName;
    private JTextField txtOfficerName;
    private JLabel lblErrorOfficerName;

    private JLabel RegistractionDate;
    private JTextField txtRegistractionDate;
    private JLabel lblErrorRegistractionDate;

    private JLabel CrimeDate;
    private JTextField txtCrimeDate;
    private JLabel lblErrorCrimeDate;

    private JButton btnDelete;
    private JButton btnSave;
    private JButton btnreset;
    private JButton btnbtnView;
    private JButton btk;
    private Font ft1;

    private JLabel lblmember;
    private JCheckBox chkStaff;
    BreakageTable pt = null;
    BreakageRepository repository;
    ProductRepository proRepository;

    public BreakageUI() throws SQLException {
        repository = new BreakageRepository();
        proRepository = new ProductRepository();
        pt = new BreakageTable();
        infoArea = new TextArea(5,100);
        infoArea.setEditable(false);
        mainFrame = new JFrame();
        panelNorth = new JPanel();
        panelNorth.setBackground(new  Color(179, 205, 224));
        panelWest = new JPanel();
        panelWest.setBackground(new  Color(100, 157, 177));
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelCenter.setBackground(new  Color(100, 157, 177));
        newPaneCenter = new JPanel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height * 2 / 3;
        int width = screenSize.width * 2 / 3;
        mainFrame.setPreferredSize(new Dimension(width, height));

        font1 = new Font("Impact", Font.PLAIN, 40);

        lblPicture = new JLabel(new ImageIcon("bread1.jpg"), SwingConstants.LEFT);
        lblPicture.setPreferredSize(new Dimension(150, 100));
        lblPicture.setOpaque(false);

        lblCompanyName = new JLabel("BINDYBREAD BREAKAGES");
        lblCompanyName.setFont(font1);
        lblCompanyName.setForeground(new Color(100, 157, 177));

        btnAdd = new JButton("ADD");
        btnAdd.setForeground(Color.BLACK);
        btnAdd.setMargin(btnInsets);

        btnView = new JButton("VIEW PRODUCT");
        btnView.setForeground(Color.BLACK);
        btnView.setMargin(btnInsets);

        btnSchedule = new JButton("SCHEDULE");
        btnSchedule.setForeground(Color.BLACK);
        btnSchedule.setMargin(btnInsets);
        btnSchedule.setVisible(false);

        btnUpdate = new JButton("");
        btnUpdate.setForeground(Color.BLACK);
        btnUpdate.setMargin(btnInsets);
        btnUpdate.setBackground(new  Color(179, 205, 224));

        btnDeletes = new JButton("");
        btnDeletes.setForeground(Color.BLACK);
        btnDeletes.setMargin(btnInsets);
        btnDeletes.setBackground(new  Color(179, 205, 224));

        panelBlank1 = new JPanel();
        panelBlank1.setBackground(new  Color(179, 205, 224));
        panelBlank2 = new JPanel();
        panelBlank2.setBackground(new  Color(179, 205, 224));
        panelBlank3 = new JPanel();
        panelBlank3.setBackground(new  Color(179, 205, 224));
        panelBlank4 = new JPanel();
        panelBlank4.setBackground(new  Color(179, 205, 224));
        panelBlank5 = new JPanel();
        panelBlank5.setBackground(new  Color(100, 157, 177));
        panel6 = new JPanel();
        panelcheck = new JPanel();
        panelcheck.setBackground(new java.awt.Color(179, 205, 224));
        panel6.setBackground(new java.awt.Color(179, 205, 224));
        MainFrame = new JFrame("");
        MainFrame.setSize(300, 200);
        ft1 = new Font("Arial", Font.BOLD, 16);

        lblSearchID = new JLabel();
        Search = new JComboBox();
        btnsearch = new JButton("Search");
        btnsearch.setForeground(new Color(27, 78, 164));
        
        ComplainID = new JLabel("    ");
        ComplainID.setVisible(false);
        txtComplainID = new JTextField(15);
        txtComplainID.setVisible(false);
        cboComplainID = new JLabel("*required");
        cboComplainID.setForeground(Color.red);
        cboComplainID.setVisible(false);
        ComplainID.setForeground(Color.BLACK);
        
        
        prodId = new JLabel("PRODUCT ID: ");
        prodId.setHorizontalAlignment(JLabel.RIGHT);
        txtProdId = new JTextField(15);
        txtProdId.setEditable(false);
        lblErrorProdId = new JLabel("*required");
        lblErrorProdId.setForeground(Color.red);
        lblErrorProdId.setVisible(false);
        prodId.setForeground(Color.BLACK);

        date = new JLabel(" Entry date: ");
        date.setHorizontalAlignment(JLabel.RIGHT);
        txtDate = new JTextField(15);
        lblErrorDate = new JLabel("*required");
        lblErrorDate.setForeground(Color.red);
        lblErrorDate.setVisible(false);
        date.setForeground(Color.BLACK);

        total = new JLabel("   Total: ");
        total.setHorizontalAlignment(JLabel.RIGHT);
        txtTotal = new JTextField(15);
        lblErrorTotal = new JLabel("*required");
        lblErrorTotal.setForeground(Color.red);
        lblErrorTotal.setVisible(false);
        total.setForeground(Color.BLACK);

        lblReason = new JLabel("   Reason:");
        lblReason.setHorizontalAlignment(JLabel.RIGHT);
        txtReason = new JTextField(15);
        txtReason.setVisible(false);
        lblErrortxtReason = new JLabel("*required");
        lblErrortxtReason.setForeground(Color.red);
        lblErrortxtReason.setVisible(false);

        lblOptinal = new JLabel("  Optional");
        lblOptinal.setVisible(false);
        lblReason.setForeground(Color.BLACK);  
        cboReason = new JComboBox(new String[]{"<--Select Reason -->", "Stolen", "Missing", "Broken"});

        //do not erase
        lblEmail = new JLabel("   ");
        lblEmail.setVisible(false);
        txtEmail = new JTextField(15);
        txtEmail.setVisible(false);
        lblErrorEmail = new JLabel("*Require");
        lblErrorEmail.setForeground(Color.red);
        lblErrorEmail.setVisible(false);
        lblEmail.setBackground(Color.WHITE);
        lblEmail.setForeground(Color.BLACK);

        lblMobile = new JLabel(" ");
        lblMobile.setVisible(false);
        txtMobile = new JTextField(15);
        txtMobile.setVisible(false);
        lblErrorMobile = new JLabel("*Require");
        lblErrorMobile.setForeground(Color.red);
        lblErrorMobile.setVisible(false);
        lblMobile.setBackground(Color.WHITE);
        lblMobile.setForeground(Color.BLACK);
        lblMobile.setBounds(10, 119, 159, 20);

        lblAdress = new JLabel("    ");
        lblAdress.setVisible(false);
        cboAdress = new JTextField(15);
        cboAdress.setVisible(false);
        lblErrorAdress = new JLabel("*required");
        lblErrorAdress.setForeground(Color.red);
        lblErrorAdress.setVisible(false);
        lblAdress.setForeground(Color.BLACK);

        ft1 = new Font("Arial", Font.BOLD, 18);
        lblmember = new JLabel("PRODUCT ID");
        lblmember.setForeground(new java.awt.Color(100, 157, 177));
        chkStaff = new JCheckBox();
        panelcheck.add(lblmember);
        panelcheck.add(chkStaff);
        btnDelete = new JButton(" ");
        btnSave = new JButton(" ");
        btnreset = new JButton(" ");
        btnbtnView = new JButton(" ");
        btk = new JButton("");
        btk.setVisible(false);
        panel6.add(btnsearch);
        panel6.add(btk);

        th= new Thread(rr);
        th.start();
        btnDelete.setBackground(new java.awt.Color(100, 157, 177));
        btnSave.setBackground(new java.awt.Color(100, 157, 177));
        btnreset.setBackground(new java.awt.Color(100, 157, 177));
        btnbtnView.setBackground(new java.awt.Color(100, 157, 177));
      
        btnsearch.addActionListener(this);
        btnbtnView.addActionListener(this);
        chkStaff.addActionListener(this);
        btnAdd.addActionListener(this);
        //btnDeletes.addActionListener(this);
        btnView.addActionListener(this);
    }

    
    public void setBreakage() throws SQLException {
        newPaneCenter.setLayout(new GridLayout(2,1));
        newPaneCenter.add(pt.getTable(mainFrame));
        newPaneCenter.add(infoArea);
        getInfo();
        panelNorth.setLayout(new FlowLayout());
        panelWest.setLayout(new GridLayout(10, 1));
        panelSouth.setLayout(new GridLayout(1, 4));
        mainFrame.add(panelNorth, BorderLayout.NORTH);
        mainFrame.add(panelWest, BorderLayout.WEST);
        mainFrame.add(newPaneCenter, BorderLayout.CENTER);
//        mainFrame.add(pt.getTable(mainFrame), BorderLayout.CENTER);
        mainFrame.add(panelSouth, BorderLayout.SOUTH);
//        mainFrame.add(infoArea, BorderLayout.SOUTH);
        panel6.setLayout(new GridLayout(1, 2));
        panelNorth.add(lblPicture);
        panelNorth.add(lblCompanyName);
        panelWest.add(panelBlank1);
        panelWest.add(btnAdd);
        panelWest.add(panelBlank2);
        panelWest.add(btnUpdate);
        panelWest.add(panelBlank3);
        panelWest.add(btnDeletes);
        panelWest.add(panelBlank4);
        panelWest.add(btnView);
        panelWest.add(panelBlank5);
        panelWest.add(btnSchedule);

        panelcheck.setLayout(new GridLayout(1, 2));
        
        panelCenter.setLayout(new GridLayout(11, 3));
        panelCenter.add(panelcheck);
        panelCenter.add(Search);
        panelCenter.add(panel6);

        panelCenter.add(ComplainID);
        panelCenter.add(txtComplainID);
        panelCenter.add(cboComplainID);

        panelCenter.add(prodId);
        panelCenter.add(txtProdId);
        panelCenter.add(lblErrorProdId);

        panelCenter.add(date);
        panelCenter.add(txtDate);
        panelCenter.add(lblErrorDate);

        panelCenter.add(total);
        panelCenter.add(txtTotal);
        panelCenter.add(lblErrorTotal);

        panelCenter.add(lblReason);
        panelCenter.add(cboReason);
        panelCenter.add(lblErrortxtReason);
        panelCenter.add(txtReason);

        panelCenter.add(lblMobile);
        panelCenter.add(txtMobile);
        panelCenter.add(lblErrorMobile);

        panelCenter.add(lblAdress);
        panelCenter.add(cboAdress);
        panelCenter.add(lblErrorAdress);

        panelSouth.add(btnDelete);
        panelSouth.add(btnSave);
        panelSouth.add(btnreset);
        panelSouth.add(btnbtnView);

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
     Runnable rr=()->{
       try{
           while(true){
           ImageIcon icon1 = new ImageIcon(new ImageIcon("bread1.jpg").getImage().getScaledInstance(150, 100, Image.SCALE_AREA_AVERAGING));
               th.sleep(3000);
               lblPicture.setIcon(icon1);
                
               ImageIcon icon2 = new ImageIcon(new ImageIcon("bread2.jpg").getImage().getScaledInstance(150, 100, Image.SCALE_AREA_AVERAGING));
               th.sleep(3000);
               lblPicture.setIcon(icon2);
               
               ImageIcon icon3 = new ImageIcon(new ImageIcon("bread3.jpg").getImage().getScaledInstance(150, 100, Image.SCALE_AREA_AVERAGING));
               th.sleep(3000);
               lblPicture.setIcon(icon3);
               
               ImageIcon icon4 = new ImageIcon(new ImageIcon("bread4.jpg").getImage().getScaledInstance(150, 100, Image.SCALE_AREA_AVERAGING));
               th.sleep(3000);
               lblPicture.setIcon(icon4);
                
           }
           
           
       }catch(Exception x){
       
       
       }
   };
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnsearch) {
          
           if(chkStaff.isSelected()){
                 
                
             }if(!chkStaff.isSelected()){
               
               
             }
        }
        if (e.getSource() == btnAdd) {
           try {
                new ProductView().setBreakage(mainFrame);
            } catch (SQLException ex) {
                Logger.getLogger(BreakageUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         if (e.getSource() == btnDeletes) {
            
    }
         if (e.getSource() == btnView) {
            try {
                new ProductView().setBreakage(mainFrame);
            } catch (SQLException ex) {
                Logger.getLogger(BreakageUI.class.getName()).log(Level.SEVERE, null, ex);
            }
             //new BreakageView().setBreakage();
             //new BreakageView().setBreakage();
    }
         
          if (e.getSource() == chkStaff) {
            
             if(chkStaff.isSelected()){
                 prodId.setText("PRODUCT ID ");
                
             }
             if(!chkStaff.isSelected()){
                
                 prodId.setText("BREAKAGES ID ");
                 
             }
    }
    }
    public static void main(String[] args) throws SQLException {
        new BreakageUI().setBreakage();
    }
    public void getInfo() throws SQLException{
        List<Breakage> breakages = repository.readAgregation();
        infoArea.setText("");
        infoArea.append("Breakage Statistics:\n-------------------------\n");
        infoArea.append("ProductId\tProduct Name\tQuantity\n-----------\t\t---------------\t------------\n");
        int counter=0;
        for(Breakage breakage: breakages){
            Product product = proRepository.read(breakage.getProductId());
            counter++;
            if(product!=null){
               // product = proRepository.read(breakage.getProductId());
                infoArea.append(counter+")  "+breakage.getProductId()+"\t\t"+product.getProductName()+"\t\t"+breakage.getQuantity()+"\n");

            }else{
                 infoArea.append(counter+")  "+breakage.getProductId()+"\t\t\t"+"\t\t"+breakage.getQuantity()+"\n");

            }
        }
    }

}
