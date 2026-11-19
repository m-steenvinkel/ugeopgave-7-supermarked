import java.util.Collection;
import java.util.Map;

public class Supermarket {

    private Map<Long, Item> itemsById;
    private Map<Long, Item> discountItemsById;
    private CashRegister cashRegister;
    private Robot robot;

    public Supermarket(Map<Long, Item> itemsById, Map<Long, Item> discountItemsById, CashRegister cashRegister, Robot robot) {
        this.itemsById = itemsById;
        this.discountItemsById = discountItemsById;
        this.cashRegister = cashRegister;
        this.robot = robot;
    }

    public void checkout() {
        Collection<Item> cart = robot.fillCart(itemsById.values());
        Map<Item, Integer> countByItem = cashRegister.scanItems(cart);

        double total = cashRegister.calculateTotal(countByItem, discountItemsById);
        double vat = cashRegister.calculateVAT(total);

        cashRegister.printReceipt(countByItem, discountItemsById, total, vat);
    }


}
