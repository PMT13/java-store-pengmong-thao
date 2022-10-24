import java.util.Locale;
import java.util.UUID;

public class Product {
    private UUID id;
    private String product_name;
    private String display_name;
    private double price;
    private double salePercent;
    private boolean onSale;
    private double currentPrice;
    public Product(String product_name, String display_name, double price, double salePercent, boolean onSale) {
        this.id = UUID.randomUUID();
        this.product_name = product_name.toLowerCase();
        this.display_name = display_name;
        this.price = price;
        this.salePercent = salePercent;
        this.onSale = onSale;
        this.setCurrentPrice();
    }

    public UUID getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public double getSalePercent() {
        return salePercent;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name.toLowerCase();
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSalePercent(double salePercent) {
        this.salePercent = salePercent;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
        this.setCurrentPrice();
    }

    public void setCurrentPrice(){
        if(this.isOnSale()){
            this.currentPrice = (this.getPrice() - (this.getPrice() * (this.getSalePercent()/100)));
        }else{
            this.currentPrice = this.getPrice();
        }
    }
}

