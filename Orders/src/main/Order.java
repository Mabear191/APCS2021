package main;

public class Order {
    private String product;
    private String buyer;
    private int amount;
    //contructor class for order object
    public Order(String p, String b, int a) {
        product = p;
        buyer = b;
        amount = a;
    }
    //getter methods for all the products
    public String getProduct() { return product; }
    public String getBuyer() { return buyer; }
    public int getAmount() { return amount; }

    //public void setProduct(String p) { product = p; }
    //public void setBuyer(String b) { buyer = b; }
    //public void setAmount(int a) { amount = a; }
    public String toString(){
        return "" + buyer + " ordered " + amount + " of " + product + " ";
    }
}