package za.ac.cput.ims31.entity;

import java.sql.Date;


/**
 *
 * @author cassy
 */
public class Breakage {
    private int id;
    private int productId;
    private Date date;
    private int quantity;
    private String description;

    public Breakage(int id, int productId, Date date, int quantity, String description) {
        this.id = id;
        this.productId = productId;
        this.date = date;
        this.quantity = quantity;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Breakage{" + "id=" + id + ", productId=" + productId + ", date=" + date + ", quantity=" + quantity + ", description=" + description + '}';
    }
     
    
}
