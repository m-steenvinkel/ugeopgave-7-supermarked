import java.util.*;

public class Robot {

    private int min = 5; // minimum antal (slags) varer i kurven
    private int max = 25; // maximum antal (slags) varer i kurven
    private int chanceForOnly1Item = 70; // procents sandsynlighed for at der kun er et styk af hver slags vare
    private int maxAmount = 5; // maximalt antal af samme slags vare

    public Robot() {

    }

    /**
     * Denne robot fylder nogle tilfældige varer i kurven.
     * <p>
     * Den tager mellem 'min' og 'max' varer - som regel kun en af hver
     * men nogle gange op til 'maxStyk'.
     * 
     * Og den smider varerne i kurven fuldstændig tilfældig rækkefølge.
     *
     * @param allItems
     * @return en kurv med varer i vilkårlig rækkefølge
     */
    public Collection<Item> fillCart(Collection<Item> allItems) {
        // hav en god random klar!
        Random random = new Random();

        // lav en kurv til varerne
        List<Item> cart = new ArrayList<>();

        // find på et tilfældigt antal varer, mellem 5 og 25
        int amountOfItems = random.nextInt(min, max);
        for (int i = 0; i < amountOfItems; i++) {
            // find et tilfældigt styktal - med % sandsynlighed for at der kun er 1
            int amount = (random.nextInt(100) > chanceForOnly1Item) ? random.nextInt(2, maxAmount) : 1;

            // find en tilfældig vare i samlingen af alleVarer
            Item item = allItems.stream().skip(random.nextInt(allItems.size())).findFirst().get();
            // og put det antal styk i kurven
            while (amount > 0) {
                cart.add(item);
                amount--;
            }
        }

        // ryst kurven godt, så ens varer ikke ligger lige ved siden af hinanden
        Collections.shuffle(cart);

        // og returner den fyldte kurv
        return cart;
    }

}
