package array_queue;

/**
 *
 * @author Polis
 */
public class Car {
    private int license_plate;
    private String brand,colour,driver;

    public Car() {}
    
    public Car(int license_plate, String brand, String colour, String driver) {
        this.license_plate = license_plate;
        this.brand = brand;
        this.colour = colour;
        this.driver = driver;
    }

    public int getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(int license_plate) {
        this.license_plate = license_plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
    
    @Override
    public String toString() {
      String str;
      str="Car \n";
      str+="Arithmos Pinakidas :"+license_plate+"\n";
      str+="Odhgos :"+driver+"\n";
      str+="Marka :"+brand+"\n";
      str+="Xrwma :"+colour+"\n";
      
      return str;
    }
    
    public static Car readCar() {
        int license_plate;
        String driver,brand,colour;
        
        System.out.println("Dwse ton arithmo pinakidas:");
        license_plate = UserInput.getInteger();
        System.out.println("Dwse ta stoixeia odhgou:");
        driver = UserInput.getString();
        System.out.println("Dwse tin marka:");
        brand = UserInput.getString();
        System.out.println("Dwse to xrwma:");
        colour = UserInput.getString();
        
        return new Car(license_plate,driver,brand,colour);
    }
}
