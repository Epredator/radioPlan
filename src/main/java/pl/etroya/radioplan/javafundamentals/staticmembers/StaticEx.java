package pl.etroya.radioplan.javafundamentals.staticmembers

public class StaticEx {

}

class Flight{
    static int allPassengers;
    static int getAllPassengers(){
        return allPassengers;
    }

    static int resetAllPassengers(){
        allPassengers = 0;
    }



    int passengers;
    void add1Passenger(){
        if(hasSeating()) {
            passengers += 1;
        }else{
            handleTooMany();
        }
    }

    private boolean hasSeating() {
    }

    private boolean handleTooMany() {
    }
}
