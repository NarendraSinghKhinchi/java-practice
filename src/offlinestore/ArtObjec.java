package offlinestore;

public class ArtObjec extends ProductForSale{

    public ArtObjec(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println("This" + type + " is a beautiful art for Rs. " + price);
    }
}
