import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class ParkingBoyTest {

    @Test
    public void should_let_parkingBoy_park_car_when_car_Park_in_Lot_1(){
        LinkedList<ParkingLot> parkinglist =new LinkedList<>();
        ParkingLot  lot1=new ParkingLot(2);
        ParkingLot lot2=new ParkingLot(2);
        parkinglist.add(lot1);
        parkinglist.add(lot2);
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
        parkinglist.add(lot2);
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
        parkinglist.add(lot2);
        ParkingBoy boy=new ParkingBoy(parkinglist);
        Car car1=new Car();
        Receipt receipt=  boy.park(car1);
        assertThat(boy.unPark(receipt), is(car1));

    }

    @Test
    public void should_can_not_get_car_By_boy_when_car_not_parked(){
        LinkedList<ParkingLot> parkinglist =new LinkedList<>();
        ParkingLot  lot1=new ParkingLot(1);
        ParkingLot lot2=new ParkingLot(1);
        parkinglist.add(lot1);
        parkinglist.add(lot2);
        ParkingBoy boy=new ParkingBoy(parkinglist);
        Car car1=new Car();
        Receipt receipt=  boy.park(car1);
        assertThat(boy.unPark(receipt), is(car1));

    }
    @Test
    public void should_be_true_when_parkLot_is_full(){
        LinkedList<ParkingLot> parkinglist =new LinkedList<>();
        ParkingLot  lot1=new ParkingLot(0);
        ParkingLot lot2=new ParkingLot(0);
        parkinglist.add(lot1);
        parkinglist.add(lot2);
        ParkingBoy boy=new ParkingBoy(parkinglist);
        assertThat(boy.isFull(),is(true));
    }

    @Test
    public void should_be_order_parking_when_parkBoy_parking_car_one_by_one(){
        LinkedList<ParkingLot> parkinglist =new LinkedList<>();
        ParkingLot  lot1=new ParkingLot(1);
        ParkingLot lot2=new ParkingLot(1);
        parkinglist.add(lot1);
        parkinglist.add(lot2);
        ParkingBoy boy=new ParkingBoy(parkinglist);
        Car car1=new Car();
        Receipt receipt=  boy.park(car1);
        Car car2= lot1.unPark(receipt);
        assertThat(car2,is(car1));
    }

    @Test
    public void should_not_get_car_parking_when_car_is_not_parked(){
        LinkedList<ParkingLot> parkinglist =new LinkedList<>();
        ParkingLot  lot1=new ParkingLot(1);
        ParkingLot lot2=new ParkingLot(1);
        parkinglist.add(lot1);
        parkinglist.add(lot2);
        ParkingBoy boy=new ParkingBoy(parkinglist);
        Receipt receipt=new Receipt();

       Car car=     boy.unPark(receipt) ;
       assert car==null;



    }

}
