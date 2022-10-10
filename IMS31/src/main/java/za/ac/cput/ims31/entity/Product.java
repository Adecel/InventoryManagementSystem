package za.ac.cput.ims31.entity;

/**
 *
 * @author cassy
 */
public class Product {
    private int productId;
    private int suplyId;
    private String productName;
    private int productQuantityOnHand;
    private double productPrice;

    public Product(int productId, int suplyId, String productName, int productQuantityOnHand, double productPrice) {
        this.productId = productId;
        this.suplyId = suplyId;
        this.productName = productName;
        this.productQuantityOnHand = productQuantityOnHand;
        this.productPrice = productPrice;
    }

    public Product() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSuplyId() {
        return suplyId;
    }

    public void setSuplyId(int suplyId) {
        this.suplyId = suplyId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantityOnHand() {
        return productQuantityOnHand;
    }

    public void setProductQuantityOnHand(int productQuantityOnHand) {
        this.productQuantityOnHand = productQuantityOnHand;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", suplyId=" + suplyId + ", productName=" + productName + ", productQuantityOnHand=" + productQuantityOnHand + ", productPrice=" + productPrice + '}';
    }
    
    
}
