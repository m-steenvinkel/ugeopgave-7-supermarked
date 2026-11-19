import java.util.Map;

public class Main {

    public static void main(String[] args) {
        DataLoader dataLoader = new DataLoader();
        Map<Long, Item> itemById = dataLoader.loadItems("data/varer.csv");
        Map<Long, Item> discountItemsById = dataLoader.loadItems("data/tilbud.csv");

        CashRegister cashRegister = new CashRegister();
        Robot robot = new Robot();

        Supermarket supermarket = new Supermarket(itemById, discountItemsById, cashRegister, robot);

        supermarket.checkout();
    }
}
