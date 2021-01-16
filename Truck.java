
public class Truck extends Rental {
    private double rental;
    private double tonSize;

    public Truck() {
        super();
        this.tonSize = tonSize;
    }

    public Truck(double ppd, int nod, int nom, double ts) {
        super(ppd,nod,nom);
        this.tonSize = ts;
    }

    public void setTonSize(double tonSize) {
        if (tonSize < 0.0)
            throw new IllegalArgumentException ("Ton size must be bigger than 0.0");
        this.tonSize = tonSize;
    }

    public double getTonSize() {
        return tonSize;
    }

}
