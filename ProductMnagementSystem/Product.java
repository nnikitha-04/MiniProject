package pack1;

import java.sql.Date;

public class Product {
    private int Pid;
    private String ProductName;
    private double Price;
    private Date DOM;

    public int getPid() {
        return Pid;
    }

    public void setPid(int pid) {
        Pid = pid;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public Date getDOM() {
        return DOM;
    }

    public void setDOM(Date DOM) {
        this.DOM = DOM;
    }

    @Override
    public String toString() {
        return "[Product Id : "+getPid()+" Product Name : "+getProductName()+" Price : "+getPrice()+" Date Of Manufacture : "+getDOM()+"]";
    }
}