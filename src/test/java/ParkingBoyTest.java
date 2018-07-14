import core.*;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class ParkingBoyTest {

    @Test
    public void should_let_parkingBoy_park_car_when_car_Park_in_Lot_1(){
        ParkingLot parkingLot = mock(ParkingLot.class);
        when(parkingLot.isFull()).thenReturn(false);

        LinkedList<ParkingLot> parkinglist =new LinkedList<>();
        parkinglist.add(parkingLot);

        ParkingBoy boy=new ParkingBoy(parkinglist);
        Car car1=new Car("ex1234");
        boy.park(car1);


    }

    @Test
    public void should_not__parkingBoy_park_car_when_parkLot_isfull(){
        LinkedList<ParkingLot> parkinglist =new LinkedList<>();
        ParkingLot parkingLot = mock(ParkingLot.class);
        when(parkingLot.isFull()).thenReturn(true);


        parkinglist.add(parkingLot);

        ParkingBoy boy=new ParkingBoy(parkinglist);
        Car car1=new Car("ex1234");
        try{boy.park(car1);
            fail("should park successfully");}
        catch (ParkingLotFullException exception){
        }

//       ver
    }
    @Test
    public void should_get_car_By_boy_when_car_parked(){
        LinkedList<ParkingLot> parkinglist = new LinkedList<>();
        ParkingLot parkingLot = mock(ParkingLot.class);

        Car car1 = new Car("ex1234");
        Receipt receipt = new Receipt();
        when(parkingLot.isFull()).thenReturn(false);
        when(parkingLot.isConstains(receipt)).thenReturn(true);
        when(parkingLot.unPark(receipt)).thenReturn(car1);
        parkinglist.add(parkingLot);

        ParkingBoy boy = new ParkingBoy(parkinglist);


        boy.park(car1);

        boy.unPark(receipt);

        assertThat(boy.unPark(receipt), is(car1));

    }

    @Test
    public void should_can_not_get_car_By_boy_when_car_not_parked(){
        LinkedList<ParkingLot> parkinglist =new LinkedList<>();
        ParkingLot parkingLot = mock(ParkingLot.class);
        parkinglist.add(parkingLot);
        Car car1 = new Car("ex1234");
        Receipt receipt = new Receipt();
        when(parkingLot.isConstains(receipt)).thenReturn(false);

        ParkingBoy boy=new ParkingBoy(parkinglist);

      Car car=  boy.unPark(receipt);

       assertThat(car==null,is(true));

    }
    @Test
    public void should_be_true_when_parkLot_is_full(){
        LinkedList<ParkingLot> parkinglist =new LinkedList<>();
        ParkingLot parkingLot = mock(ParkingLot.class);
        when(parkingLot.isFull()).thenReturn(true);
        parkinglist.add(parkingLot);

        ParkingBoy boy=new ParkingBoy(parkinglist);
        assertThat(boy.isFull(),is(true));
    }

    @Test
    public void should_park_inorder_when_parkingBoy_park_cars() {

        LinkedList<ParkingLot> parkinglist =new LinkedList<>();
        ParkingLot parkingLot = Mockito.mock(ParkingLot.class);
        ParkingLot parkingLot1 = Mockito.mock(ParkingLot.class);
        parkinglist.add(parkingLot);
        parkinglist.add(parkingLot1);

        Mockito.when(parkingLot.isFull()).thenReturn(false, false, true);
        Mockito.when(parkingLot1.isFull()).thenReturn(false);

        ParkingBoy boy = new ParkingBoy(parkinglist);

        Car car1 = new Car("ex1234");
        Car car2 = new Car("ex1234");
        Car car3 = new Car("ex1234");
         boy.park(car1);
         boy.park(car2);
        boy.park(car3);
        InOrder inOrder=inOrder(parkingLot,parkingLot1);
        inOrder.verify(parkingLot).park(car1);
        inOrder.verify(parkingLot1).park(car3);

    }


}
