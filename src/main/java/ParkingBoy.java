import java.util.LinkedList;
import java.util.Optional;

public class ParkingBoy {
    LinkedList<ParkingLot> parkingList ;
    public ParkingBoy(LinkedList<ParkingLot> parkinglist) {
        this.parkingList=parkinglist;
    }

    public void park(Car car1) {
        if(parkingList.stream().filter(parkingLot -> !parkingLot.isFull()).count()!=0)
        parkingList.stream().filter(parkingLot -> !parkingLot.isFull()).findFirst().get().park(car1);
        else{
            throw new ParkingLotFullException();
        }
    }
}
