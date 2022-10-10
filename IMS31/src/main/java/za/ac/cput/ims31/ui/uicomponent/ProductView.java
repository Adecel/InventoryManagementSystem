package za.ac.cput.ims31.ui.uicomponent;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import za.ac.cput.ims31.entity.Product;
import za.ac.cput.ims31.repository.ProductRepository;

/**
 *
 * @author cassy
 */
public class ProductView extends JFrame implements ActionListener {
private List<Product> breaList = new ArrayList<>();
private List<Product> productList = new ArrayList<>();
private ProductRepository repository;
    private JFrame mainFrame;
    private JFrame parent;
    private JPanel panelNorth, panelWest,panelSouth, panelCenter,panelEast; 

    private JLabel lblPicture;

    private JLabel lblCompanyName;

    //private JButton btnInventory;
    private JButton btnPersonnel;
    private JButton btnSchedule;
    private JButton btnCriminal;
    private JButton btnJailCell;

    private JPanel panelBlank1, panelBlank2, panelBlank3, panelBlank4, panelBlank5;
    
    private Font font1;

    Insets btnInsets = new Insets(5, 5, 5, 5);

    private JFrame MainFrame;
    private JLabel Victime;
    private JLabel cboVictime,btnInventory;
    private JLabel lblErrorVictime;
     
    private JLabel lblSearchID;
    private JComboBox Search;
    private JButton btnsearch;

    private JLabel ComplainID;
    private JTextField txtComplainID;
    private JLabel cboComplainID;

    private JLabel VictimeID;
    private JTextField txtVictimeID;
    private JLabel lblErrorVictimeID;
    
    private JComboBox cboTitle;
    private JComboBox cboNumber;
    
    private JLabel Name;
    private JTextField txtName;
    private JLabel lblErrorName;

    private JLabel Surname;
    private JTextField txtSurname;
    private JLabel lblErrorSurname;
    private JLabel lblOptinal;

    private JLabel lblGender;
    private JPanel panelGender;
    private JRadioButton radMale;
    private JRadioButton radFemale;
    private JLabel lblErrorGender;
    private ButtonGroup GenderGroup;

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
    private JLabel lblDob;
    private JTextField txtDob;
    private JLabel lblErrortxtDob;
    
    private JLabel InvenstigationOfficerID;
    private JTextField txtInvenstigationOfficerID;
    private JLabel lblErrorInvenstigationOfficerID;

    private JLabel OfficerName;
    private JTextField txtOfficerName;
    private JLabel lblErrorOfficerName;

    private JLabel RegistractionDate;
    private JTextField txtRegistractionDate;
    private JLabel lblErrorRegistractionDate;

    private JLabel CrimeDate;
    private JTextField txtCrimeDate;
    private JLabel lblErrorCrimeDate;

    private JButton btnBack;
    private JButton btnSave;
    private JButton btnreset;
    private JButton btnbtnView;
    private Font ft1;
    private JTable table;
    DefaultTableModel tableModel;
    JScrollPane spTable;
    

    public ProductView() throws SQLException {
        repository = new ProductRepository();
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        mainFrame = new JFrame("");
        panelNorth = new JPanel();
        panelNorth.setBackground(new Color(179, 205, 224));
        panelWest = new JPanel();
        panelWest.setBackground(new Color(100, 157, 177));
        panelCenter = new JPanel();
        panelEast= new JPanel();
        panelEast.setBackground(new Color(100, 157, 177));
        panelSouth= new JPanel();
        panelCenter.setBackground(new Color(100, 157, 177));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setPreferredSize(new Dimension(600,300));
        font1 = new Font("Impact", Font.PLAIN, 40);
        

        lblCompanyName = new JLabel(" PRODUCT LIST    ");
        lblCompanyName.setHorizontalAlignment(JLabel.CENTER);
        lblCompanyName.setFont(font1);
        lblCompanyName.setForeground(new Color(100, 157, 177));

        btnInventory = new JLabel();
        btnInventory.setForeground(Color.BLACK);
        btnInventory.setVisible(false);
        btnPersonnel = new JButton("PERSONNEL");
        btnPersonnel.setVisible(false);
        btnPersonnel.setForeground(Color.BLACK);
        btnPersonnel.setMargin(btnInsets);

        btnSchedule = new JButton("SCHEDULE");
        btnSchedule.setForeground(Color.BLACK);
        btnSchedule.setVisible(false);
        btnSchedule.setMargin(btnInsets);

        btnCriminal = new JButton("CRIMINAL");
        btnCriminal.setForeground(Color.BLACK);
        btnCriminal.setMargin(btnInsets);
        btnCriminal.setVisible(false);
        btnJailCell = new JButton("Search");
        btnJailCell.setForeground(Color.BLACK);
        btnJailCell.setMargin(btnInsets);

        panelBlank1 = new JPanel();
        panelBlank1.setBackground(new Color(179, 205, 224));
        panelBlank2 = new JPanel();
        panelBlank2.setBackground(new Color(179, 205, 224));
        panelBlank3 = new JPanel();
        panelBlank3.setBackground(new Color(179, 205, 224));
        panelBlank4 = new JPanel();
        panelBlank4.setBackground(new Color(179, 205, 224));
        panelBlank5 = new JPanel();
        panelBlank5.setBackground(new Color(179, 205, 224));
        
        MainFrame = new JFrame("");
        MainFrame.setSize(300, 200);
        ft1 = new Font("Arial", Font.BOLD, 16);

        Victime = new JLabel();
        cboVictime = new JLabel("Victime Details",SwingConstants.CENTER);
        lblErrorVictime = new JLabel ();
        
        lblSearchID= new JLabel();
        Search= new JComboBox();
        btnsearch= new JButton("Search");
        
        ComplainID = new JLabel("   Complain ID: ");
        txtComplainID = new JTextField(15);
        cboComplainID = new JLabel("*required");
        cboComplainID.setForeground(Color.red);
        cboComplainID.setVisible(false);
        ComplainID.setForeground(Color.BLACK);
        VictimeID = new JLabel("   Victime ID: ");
        txtVictimeID = new JTextField(15);
        lblErrorVictimeID = new JLabel("*required");
        lblErrorVictimeID.setForeground(Color.red);
        lblErrorVictimeID.setVisible(false);
        VictimeID.setForeground(Color.BLACK);

        Name = new JLabel("   Names: ");
        txtName = new JTextField(15);
        lblErrorName = new JLabel("*required");
        lblErrorName.setForeground(Color.red);
        lblErrorName.setVisible(false);
        Name.setForeground(Color.BLACK);
        Name.setHorizontalAlignment(JLabel.LEFT);

        Surname = new JLabel("   Surname: ");
        txtSurname = new JTextField(15);
        lblErrorSurname = new JLabel("*required");
        lblErrorSurname.setForeground(Color.red);
        lblErrorSurname.setVisible(false);
        Surname.setForeground(Color.BLACK);

        lblDob = new JLabel("   Date Of Birth");
        txtDob= new JTextField(15);
        lblErrortxtDob = new JLabel("*required");
        lblErrortxtDob.setForeground(Color.red);
        lblErrortxtDob.setVisible(false);
        
        lblOptinal = new JLabel("  Opitional");
        lblOptinal.setVisible(false);
        lblDob.setForeground(Color.BLACK);

        lblMobile = new JLabel("   Mobile:");
        txtMobile = new JTextField(15);
        lblErrorMobile = new JLabel("*Require");
        lblErrorMobile.setForeground(Color.red);
        lblErrorMobile.setVisible(false);
        lblMobile.setBackground(Color.WHITE);
        lblMobile.setForeground(Color.BLACK);
        lblMobile.setBounds(10, 119, 159, 20);

        lblAdress = new JLabel("   Adress: ");
        cboAdress = new JTextField(15);
        lblErrorAdress = new JLabel("*required");
        lblErrorAdress.setForeground(Color.red);
        lblErrorAdress.setVisible(false);
        lblAdress.setForeground(Color.BLACK);

        Complain = new JLabel();
        cboComplain = new JLabel("Complaints",SwingConstants.CENTER);
        lblErrorComplain = new JLabel();
        lblErrorComplain.setForeground(Color.red);
        lblErrorComplain.setVisible(false);
        Complain.setForeground(Color.BLACK);
        cboComplain.setFont(ft1);

        ComplainV = new JLabel("   Complaint : ");
        txtComplainV = new JTextField(15);
        cboComplainV = new JLabel("*required");
        cboComplainV.setForeground(Color.red);
        cboComplainV.setVisible(false);
        ComplainV.setForeground(Color.BLACK);

        InvenstigationOfficerID = new JLabel("   Invenstigation Officer ID: ");
        txtInvenstigationOfficerID = new JTextField(15);
        lblErrorInvenstigationOfficerID = new JLabel("*required");
        lblErrorInvenstigationOfficerID.setForeground(Color.red);
        lblErrorInvenstigationOfficerID.setVisible(false);
        InvenstigationOfficerID.setForeground(Color.BLACK);

        OfficerName = new JLabel("   Officer Name: ");
        txtOfficerName = new JTextField(15);
        lblErrorOfficerName = new JLabel("*required");
        lblErrorOfficerName.setForeground(Color.red);
        lblErrorOfficerName.setVisible(false);
        OfficerName.setForeground(Color.BLACK);

        RegistractionDate = new JLabel("   Registration Date: ");
        txtRegistractionDate = new JTextField(15);
        lblErrorRegistractionDate = new JLabel("*required");
        lblErrorRegistractionDate.setForeground(Color.red);
        lblErrorRegistractionDate.setVisible(false);
        RegistractionDate.setForeground(Color.BLACK);

        CrimeDate = new JLabel("   Crime Date: ");
        txtCrimeDate = new JTextField(15);
        lblErrorCrimeDate = new JLabel("*required");
        lblErrorCrimeDate.setForeground(Color.red);
        lblErrorCrimeDate.setVisible(false);
        CrimeDate.setForeground(Color.BLACK);

        ft1 = new Font("Arial", Font.BOLD, 18);

        btnBack= new JButton("Back");
        btnSave = new JButton("Save");
        btnreset = new JButton("Display");
        btnbtnView= new JButton("Reset");
                
        btnBack.setForeground(new Color(27, 78, 164));
        btnBack.setBackground(new Color (179, 205, 224));
        btnBack.setFont(ft1);

        btnSave.setForeground(new Color(25, 197, 189));
        btnSave.setBackground(new Color (179, 205, 224));
        btnSave.setFont(ft1);

        btnreset.setForeground(Color.white);
        btnreset.setBackground(new Color (179, 205, 224));
        btnreset.setFont(ft1);
        
        btnbtnView.setForeground(new Color(27, 78, 164));
        btnbtnView.setBackground(new Color (179, 205, 224));
        btnbtnView.setFont(ft1);
        //Table
        String[] columnNames = { "ProductId","Product Name","Price","Quantity", "Supplyier" };
        Object[][] object = new Object[100][5];
        productList = repository.readAll();
        int i = 0;
        if(!productList.isEmpty()){
            for(Product product: productList){
            object[i][0] = product.getProductId();
            object[i][1] = product.getProductName();
            object[i][2] = product.getProductPrice();
            object[i][3] = product.getProductQuantityOnHand();
            object[i][4] = product.getSuplyId();
            i++;
            table = new JTable(object, columnNames);
        }
        }
        //SET SELECTION MODE
    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    ListSelectionModel model=table.getSelectionModel();
    //add listener
    model.addListSelectionListener((ListSelectionEvent e) -> {
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
            try{
                Product product = productList.get(selectedRow);
            if(product!=null){
                JFrameDemo jfd = new JFrameDemo();
                jfd.GetForm(parent,mainFrame,productList.get(selectedRow));
            }else{
                JOptionPane.showMessageDialog(null, "No selection");
            }
            }catch(IndexOutOfBoundsException ind){
                JOptionPane.showMessageDialog(null, "No selection considered.");
            } catch (SQLException ex) {
                Logger.getLogger(ProductView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //JOptionPane.showMessageDialog(null, "Selected Row "+productList.get(selectedRow).toString());
        }
        });

  
        // Initializing the JTable
        
        table.setBounds(30, 40, 200, 300);
 
        btnBack.addActionListener(this);
        btnSave.addActionListener(this);
        btnreset.addActionListener(this);
        btnsearch.addActionListener(this);
        btnbtnView.addActionListener(this);
    }
     
    public void setBreakage(JFrame jframe) {
        parent = jframe;
        panelNorth.setLayout(new FlowLayout());
        panelCenter.setLayout(new FlowLayout());
        panelSouth.setLayout(new GridLayout(1, 3));
        mainFrame.add(panelNorth, BorderLayout.NORTH);
        mainFrame.add(panelCenter, BorderLayout.CENTER);
        mainFrame.add(panelSouth, BorderLayout.SOUTH);
        mainFrame.add(panelEast, BorderLayout.EAST);
        panelNorth.add(lblCompanyName);
        panelCenter.add(new JScrollPane(table));
        tableModel.addColumn("Id");
        tableModel.addColumn("Product Id");
        tableModel.addColumn("Date");
        tableModel.addColumn("Total");
        tableModel.addColumn("Reason");
        
        panelSouth.add(btnBack);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.dispose();
            }
        });
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    } 
  
  public void actionPerformed(ActionEvent e){
       if (e.getSource() == btnBack){
         mainFrame.dispose();
        }
        
    } 
//  public static void main(String[] args) throws SQLException {
//        //new ProductView().setBreakage();
//        
//    }
}
