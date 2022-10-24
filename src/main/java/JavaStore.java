public class JavaStore {

    public static void main(String[] args) {
        Store store = new Store();

        Product product1 = new Product("cheese","Cheese",3.99,20,false);
        Product product2 = new Product("bread","Bread",4.99,35,false);
        Product product3 = new Product("salami","Salami",5.99,50,false);
        Product product4 = new Product("tomato","Tomato",2.94,15,false);
        Product product5 = new Product("ham","Ham",5.54,5,false);

        System.out.println("-----------------------------------------------------");
        System.out.println("Original Products");
        System.out.println("-----------------------------------------------------");
        store.addProduct(product1);
        store.addProduct(product2);
        store.addProduct(product3);
        store.addProduct(product4);
        store.display(store.getStock());

        System.out.println("-----------------------------------------------------");
        System.out.println("Replace Salami with Ham");
        System.out.println("-----------------------------------------------------");
        store.replaceProduct(product3.getId(),product5);
        store.display(store.getStock());

        System.out.println("-----------------------------------------------------");
        System.out.println("Remove Tomato from Store");
        System.out.println("-----------------------------------------------------");
        store.removeProduct(product4.getId());
        store.display(store.getStock());

        System.out.println("-----------------------------------------------------");
        System.out.println("Show Products less than $4");
        System.out.println("-----------------------------------------------------");
        store.lowerThan(4D);

        System.out.println("-----------------------------------------------------");
        System.out.println("Show Products more than $4");
        System.out.println("-----------------------------------------------------");
        store.greaterThan(4D);

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Show Products less than $3.20 after putting items on sale (that are over $3)");
        System.out.println("------------------------------------------------------------------------------");
        store.sale(3D,true);
        store.lowerThan(3.20);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Show Products greater than $4 after putting items on sale (that are over $3)");
        System.out.println("------------------------------------------------------------------------------");
        store.greaterThan(4D);

        System.out.println("-----------------------------------------------------");
        System.out.println("Show Products");
        System.out.println("-----------------------------------------------------");
        store.display(store.getStock());

        System.out.println("-----------------------------------------------------");
        System.out.printf("Median: $%.2f %n",store.getMedian());
        System.out.println("-----------------------------------------------------");
        System.out.printf("Average: $%.2f %n",store.getAverage());
        System.out.println("-----------------------------------------------------");
    }
}
