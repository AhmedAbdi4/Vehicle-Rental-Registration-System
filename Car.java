import java.lang.Enum;

public class Car extends Rental {
    public enum CarType{SEDAN, COUPE, CONVERTIBLE, SPORTS};
    private CarType carType;
    private int passenger;

    public Car() {
        super();
        this.carType = carType;
        this.passenger = passenger;
    }

    public Car(double ppd, int nod, int nom, CarType carType, int passenger) {
        super(ppd, nod, nom);
        this.carType = carType;
        this.passenger = passenger;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public int getPassenger() {
        return passenger;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    public String toString() {
        return ("Car type" + carType + "Passenger" + passenger + super.toString());
    }

}