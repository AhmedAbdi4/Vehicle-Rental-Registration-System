
public class Rental {
    private double pricePerDay;
    private int numberOfDays;
    private int numberOfMiles;
    private int passenger;

    public Rental() {
        setPricePerDay(0);
        setNumberOfDays(0);
        setNumberOfMiles(0);
        setPassenger(0);
    }

    public Rental(double p,int d,int m, int g) {
        setPricePerDay(p);
        setNumberOfDays(d);
        setNumberOfMiles(m);
        setPassenger(g);
    }

    public void setPricePerDay (double p) {
        pricePerDay= p;
    }

    public void setNumberOfDays (int d){
        numberOfDays= d;
    }

    public void setNumberOfMiles (int m){
        numberOfMiles= m;
    }

    public void setPassenger (int g){
        passenger= g;
    }

    public double getPricePerDay(){
        return pricePerDay;
    }

    public int getNumberOfDays(){
        return numberOfDays;
    }

    public int getNumberOfMiles(){
        return numberOfMiles;
    }

    public int getPassenger(){
        return passenger;
    }

    public String toString(){
        return("Price" + pricePerDay+ "Days" + numberOfDays + "Mile" + numberOfMiles+ "passenger"+passenger );
    }
}