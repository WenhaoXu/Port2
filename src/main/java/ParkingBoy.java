import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParkingBoy {

    LinkedList<ParkingLot> parkingList;

    public ParkingBoy(LinkedList<ParkingLot> parkinglist) {
        this.parkingList = parkinglist;
    }

    public Receipt park(Car car1) {
        if (!isFull())
            return parkingList.stream().filter(parkingLot -> !parkingLot.isFull()).findFirst().get().park(car1);
        else {
            throw new ParkingLotFullException();
        }
    }

    public Car unPark(Receipt receipt) {

        if (parkingList.stream().filter(parkingLot -> parkingLot.isConstains(receipt)).collect(Collectors.toList()).size() != 0) {
            Car car = parkingList.stream().filter(parkingLot -> parkingLot.isConstains(receipt)).collect(Collectors.toList()).get(0).unPark(receipt);
            return car;
        } else {
            return null;
        }
//        Car car=new Car();

    }

    public Boolean isFull() {
        return parkingList.stream().filter(parkingLot -> !parkingLot.isFull()).count() == 0;
    }
}
