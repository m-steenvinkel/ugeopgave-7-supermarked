import java.util.*;

public class DataLoader {

    public Map<Long, Item> loadItems(String path) {
        ArrayList<String> itemData = FileIO.readData(path, true);

        Map<Long, Item> items = new HashMap<>();

        for (String line : itemData) {
            String[] values = line.split(";");
            long id = Long.parseLong(values[0]);
            String name = values[1];
            String priceDate = values[2];
            double price = Double.parseDouble(values[3]);
            boolean isBudgetBrand = Boolean.parseBoolean(values[4]);
            double quantity = Double.parseDouble(values[5]);
            String unit = values[6];
            boolean isWeighted = Boolean.parseBoolean(values[7]);
            boolean isBio = Boolean.parseBoolean(values[4]);
            boolean isAvailable = Boolean.parseBoolean(values[4]);

            Item item = new Item(id, name, priceDate, price, isBudgetBrand, quantity, unit, isWeighted, isBio, isAvailable);

            items.put(id, item);
        }

        return items;
    }
}
