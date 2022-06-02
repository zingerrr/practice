package AbstractFactory;

public class AbstractFactory {
    public static void main(String[] args) {
        Factory factory = new AbstractFactoryCreate().createFactory("Car");
        Car car = factory.createCar("Bmw");
        car.fourwheel();
    }
}

interface Car {
    void fourwheel();
}

interface Motorcycle {
    void twowheel();
}

class Ducati implements Motorcycle {

    @Override
    public void twowheel() {
        System.out.println("It's Ducati");
    }
}

class Harley implements Motorcycle {

    @Override
    public void twowheel() {
        System.out.println("It's Harley");
    }
}

class Bmw implements Car {

    @Override
    public void fourwheel() {
        System.out.println("It's BMW");
    }
}

class Mercedes implements Car {

    @Override
    public void fourwheel() {
        System.out.println("It's Mercedes");
    }
}

class CarFactory implements Factory {
    public Car createCar(String model) {
        return switch (model) {
            case ("Bmw") -> new Bmw();
            case ("Mercedes") -> new Mercedes();
            default -> null;
        };
    }

    @Override
    public Motorcycle createMotorcycle(String model) {
        return null;
    }
}

class MotorcycleFactory implements Factory {
    public Motorcycle createMotorcycle(String model) {
        return switch (model) {
            case ("Ducati") -> new Ducati();
            case ("Harley") -> new Harley();
            default -> null;
        };
    }

    @Override
    public Car createCar(String model) {
        return null;
    }
}

interface Factory {
    Car createCar(String model);

    Motorcycle createMotorcycle(String model);
}

class AbstractFactoryCreate {
    Factory createFactory(String typeOfFactory) {
        return switch (typeOfFactory) {
            case ("Motorcycle") -> new MotorcycleFactory();
            case ("Car") -> new CarFactory();
            default -> null;
        };
    }
}