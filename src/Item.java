public class Item {
    private long id;
    private String name;
    private String priceDate;
    private double price;
    private boolean isBudgetBrand;
    private double quantity;
    private String unit;
    private boolean isWeighted;
    private boolean isBio;
    private boolean isAvailable;

    public Item(long id, String name, String priceDate, double price, boolean isBudgetBrand, double quantity, String unit, boolean isWeighted, boolean isBio, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.priceDate = priceDate;
        this.price = price;
        this.isBudgetBrand = isBudgetBrand;
        this.quantity = quantity;
        this.unit = unit;
        this.isWeighted = isWeighted;
        this.isBio = isBio;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
}
