import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class parkingBoyParkCar {

    @Test
    public void should_let_parkingBoy_park_car_when_car_Park_in_Lot_1(){
        LinkedList<ParkingLot> parkinglist =new LinkedList<>();
        ParkingLot  lot1=new ParkingLot(2);
        ParkingLot lot2=new ParkingLot(2);
        parkinglist.add(lot1);
        ParkingBoy boy=new ParkingBoy(parkinglist);
        Car car1=new Car();
        boy.park(car1);

    }

    @Test
    public void should_not__parkingBoy_park_car_when_parkLot_isfull(){
        LinkedList<ParkingLot> parkinglist =new LinkedList<>();
        ParkingLot  lot1=new ParkingLot(0);
        ParkingLot lot2=new ParkingLot(0);
        parkinglist.add(lot1);
        ParkingBoy boy=new ParkingBoy(parkinglist);
        Car car1=new Car();
        try{boy.park(car1);
            fail("should park successfully");}
        catch (ParkingLotFullException exception){


        }


    }
    @Test
    public void should_get_car_By_boy_when_car_parked(){
        LinkedList<ParkingLot> parkinglist =new LinkedList<>();
        ParkingLot  lot1=new ParkingLot(1);
        ParkingLot lot2=new ParkingLot(1);
        parkinglist.add(lot1);
        ParkingBoy boy=new ParkingBoy(parkinglist);
        Car car1=new Car();
        Receipt receipt=  boy.park(car1);
        assertThat(boy.unPark(receipt), is(car1));

    }
}
