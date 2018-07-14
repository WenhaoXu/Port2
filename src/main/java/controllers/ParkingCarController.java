package controllers;

import com.google.inject.Inject;
import core.Car;
import core.ParkingBoy;
import core.Receipt;
import views.ParkingLotView;

import java.util.Scanner;

public class ParkingCarController {
    private final ParkingLotView  parkingLotView;
    ParkingBoy  boy =ParkingBoy.createParkingBoy(3,2);
    @Inject
    public ParkingCarController(ParkingLotView  parkingLotView ) {
        this.parkingLotView = parkingLotView;
    }


    public void beginUi() {
         parkingLotView.showBegin();
    }

    public void startParkingAndUnpack(int inputNumber) {
        switch (inputNumber){
            case  1:
                parkingLotView.getParkingView();
                ParkingCar();
                break;
            case 2:
                parkingLotView.getUnparkView();
                unPack();
                break;
                default:
                    parkingLotView.getErrorView();
        }

    }

    public int getInputNumber() {
        Scanner sc =new Scanner(System.in);
        return sc.nextInt();
    }

    public String getStringId(){
        Scanner sc =new Scanner(System.in);
        return sc.next();
    }

    private void ParkingCar() {
       if(boy.isFull()) {
           parkingLotView.getLotIsFullView();
           startParkingAndUnpack(getInputNumber());
       }
       else{
           parkingLotView.getParkingCarView();
           Car car=new Car(getStringId());
        String smallTicket=boy.park(car).getSmallTicket();
        parkingLotView.getReceptView(smallTicket);
        parkingLotView.showBegin();
           startParkingAndUnpack(getInputNumber());
       }

    }

    private void unPack() {
        parkingLotView.getsShowIdview();
        Receipt receipt=new Receipt(getStringId());
         Car car= boy.unPark(receipt);
        if(car==null){
            parkingLotView.getCarIsNonexistent();
            parkingLotView.showBegin();
            startParkingAndUnpack(getInputNumber());
        }
         else {
            parkingLotView.getCarView(car.getCarNumber());
            startParkingAndUnpack(getInputNumber());
        }
    }
}
