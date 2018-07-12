import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;

public class PortTest {
  @Test
  public void should_park_successfully_given_parking_lot_is_not_full() {
    ParkingLot parkingLot = new ParkingLot(1);

    try {
      parkingLot.park(new Car());
    } catch (ParkingLotFullException exception) {
      fail("should park successfully");
    }

  }

  @Test
  public void should_park_failed_given_parking_lot_is_full(){
    ParkingLot parkingLot = new ParkingLot(0);

    try {
      parkingLot.park(new Car());
      fail("should park successfully");
    } catch (ParkingLotFullException exception) {

    }
  }

  @Test
  public void should_get_specific_car_when_call_unPark_given_receipt_is_right(){
    ParkingLot parkingLot = new ParkingLot(1);

    Car theCar = new Car();
    Receipt receipt = parkingLot.park(theCar);

    assertThat(parkingLot.unPark(receipt), is(theCar));

  }
  @Test
  public void should_be_true_when_call_isFull_given_parking_lot_is_full(){
    ParkingLot parkingLot = new ParkingLot(0);

    assertThat(parkingLot.isFull(), is(true));
  }

  @Test
  public void should_be_false_when_call_isFull_given_parking_lot_is_not_full(){
    ParkingLot parkingLot = new ParkingLot(1);

    assertThat(parkingLot.isFull(), is(false));
  }

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

}
