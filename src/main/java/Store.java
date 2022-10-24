import java.util.ArrayList;
import java.util.Comparator;
import java.util.UUID;

public class Store {

    private ArrayList<Product> stock;

    public Store() {
        this.stock = new ArrayList<Product>();
    }

    public ArrayList<Product> getStock() {
        return stock;
    }

    public void addProduct(Product product){
        this.stock.add(product);
    }

    public void removeProduct(UUID id){
        for(int i = 0; i < this.stock.size(); i++){
            if(this.stock.get(i).getId().equals(id)){
                this.stock.remove(i);
                break;
            }
        }
    }

    public void replaceProduct(UUID id, Product product){
        for(int i = 0; i < this.stock.size(); i++){
            if(this.stock.get(i).getId().equals(id)){
                this.stock.set(i,product);
                break;
            }
        }
    }

    public void lowerThan(double price){
        ArrayList<Product> newStock = new ArrayList<>();
        for(int i = 0; i < this.stock.size(); i++){
            if(this.stock.get(i).getCurrentPrice() < price){
                newStock.add(this.stock.get(i));
            }
        }
        display(newStock);
    }

    public void greaterThan(double price){
        ArrayList<Product> newStock = new ArrayList<>();
        for(int i = 0; i < this.stock.size(); i++){
            if(this.stock.get(i).getCurrentPrice() > price){
                newStock.add(this.stock.get(i));
            }
        }
       display(newStock);
    }

    public double getMedian(){
        double median;
        this.stock = this.sortByPrice(this.stock);
        if (this.stock.size() % 2 == 0) {
            median = (this.stock.get(this.stock.size() / 2).getCurrentPrice() + this.stock.get(this.stock.size() / 2 - 1).getCurrentPrice()) / 2;
        }else {
            median = this.stock.get(this.stock.size() / 2).getCurrentPrice();
        }
        return median;
    }

    public double getAverage(){
        double average = 0;
        for(int i = 0; i < this.stock.size(); i++){
            average += this.stock.get(i).getCurrentPrice();
        }
        average = average / this.stock.size();
        return average;
    }

    public void display(ArrayList<Product> productList){
        productList = sortByPrice(productList);
        for(int i = 0; i < productList.size(); i++){
            System.out.println("Id: " + productList.get(i).getId());
            System.out.println("Name: " + productList.get(i).getDisplay_name());
            System.out.printf("Current Price: $%.2f %n", productList.get(i).getCurrentPrice());
            System.out.printf("Original Price: $%.2f %n",productList.get(i).getPrice());
            System.out.println("");
        }
    }

    public ArrayList<Product> sortByPrice(ArrayList<Product> productList){
        //https://www.baeldung.com/java-8-comparator-comparing
        Comparator<Product> priceComparator = Comparator.comparing(Product::getCurrentPrice);
        productList.sort(priceComparator);
        return productList;
    }

    public void sale(double price, boolean onSale){
        for(int i = 0; i < this.stock.size(); i++){
            if(this.stock.get(i).getCurrentPrice() > price){
                this.stock.get(i).setOnSale(onSale);
            }
        }
    }
}
