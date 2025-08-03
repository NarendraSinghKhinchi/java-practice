package offlinestore;

import java.util.ArrayList;

record OrderItem(int qty, ProductForSale product){}

public class Store {

    private static final ArrayList<ProductForSale> storeProducts = new ArrayList<>();

    public static void main(String[] args){

        storeProducts.add(new ArtObjec("Oil Painting", 1250, "Impressionistic work by ABF painted in 2010"));
        storeProducts.add(new ArtObjec("Mud Painting", 1350, "Impressionistic work by ABF painted in 2010"));
        storeProducts.add(new ArtObjec("Milk Painting", 1450, "Impressionistic work by ABF painted in 2010"));
        storeProducts.add(new ArtObjec("Curd Painting", 1550, "Impressionistic work by ABF painted in 2010"));

        listProducts();
        System.out.println("\nOrder 1");

        var order1 = new ArrayList<OrderItem>();
        addItemToOrder(order1, 1, 2);
        addItemToOrder(order1, 0, 1);
        printOrder(order1);
    }

    public static void listProducts(){
        for(var item: storeProducts){
            System.out.println("-".repeat(30));
            item.showDetails();
        }
    }
    public static void addItemToOrder(ArrayList<OrderItem> order, int orderIndex, int qty){
        order.add(new OrderItem(qty, storeProducts.get(orderIndex)));
    }
    public static void printOrder(ArrayList<OrderItem> order){

        double salesTotal = 0;
        for(var item: order){
            item.product().printPricedItem(item.qty());
            salesTotal += item.product().getSalesPrice(item.qty());
        }
        System.out.printf("Sales Total = $%6.2f %n", salesTotal);
    }
}
