// Base class
class Vehicle {
    void startEngine() {
        System.out.println("Vehicle engine started");
    }

    void stopEngine() {
        System.out.println("Vehicle engine stopped");
    }
}

// Subclass: Car
class Car extends Vehicle {
    @Override
    void startEngine() {
        System.out.println("Car engine started with key ignition");
    }

    @Override
    void stopEngine() {
        System.out.println("Car engine stopped safely");
    }
}

// Subclass: Motorcycle
class Motorcycle extends Vehicle {
    @Override
    void startEngine() {
        System.out.println("Motorcycle engine started with self-start button");
    }

    @Override
    void stopEngine() {
        System.out.println("Motorcycle engine stopped");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        Vehicle myBike = new Motorcycle();

        // Car operations
        myCar.startEngine();
        myCar.stopEngine();

        // Motorcycle operations
        myBike.startEngine();
        myBike.stopEngine();
    }
}
