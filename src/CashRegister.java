import java.util.*;

public class CashRegister {

    public Map<Item, Integer> scanItems (Collection<Item> cart) {
        Map<Item, Integer> countByItem = new HashMap<>();

        for (Item item : cart) {
            if (countByItem.containsKey(item)) {
                countByItem.put(item, countByItem.get(item) + 1);
            } else {
                countByItem.put(item, 1);
            }
        }

        return countByItem;
    }

    public void printReceipt(Map<Item, Integer> countByItem, Map<Long, Item> discountItemsById, double total, double vat) {
        System.out.println("==================== Kvittering ====================");
        System.out.printf("%-60s %-50s %n", "Vare", "Pris");

        for (Item item : countByItem.keySet()) {
            int amount = countByItem.get(item);
            double price = item.getPrice();
            String name = item.getName();
            long id = item.getId();
            System.out.printf("%-60s %-2d x %7.2f = %7.2f %n", name, amount, price, (amount * price));
            if (discountItemsById.containsKey(id)) {
                double priceAfterDiscount = discountItemsById.get(id).getPrice();
                double discount = priceAfterDiscount - price;
                System.out.printf("%-60s %-2d x %7.2f = %7.2f %n", "Rabat",amount, discount, (amount * discount));
            }
        }

        System.out.println();
        System.out.printf("%-75s %7.2f %n", "At betale", total);
        System.out.printf("%-75s %7.2f %n", "Heraf moms", vat);

    }

    public double calculateVAT(double total) {
        return total * 0.2;
    }

    public double calculateTotal(Map<Item, Integer> countByItem, Map<Long, Item> discountItemsById) {
        double total = 0;
        for (Item item : countByItem.keySet()) {
            total += discountItemsById.getOrDefault(item.getId(), item).getPrice();
        }

        return total;
    }

}
