package controllers;

import com.google.inject.Inject;
import views.ParkingLotView;

import java.util.Scanner;

public class ParkingCarController {
    private final ParkingLotView  parkingLotView;

    @Inject
    public ParkingCarController(ParkingLotView  parkingLotView) {
        this.parkingLotView = parkingLotView;
    }


    public void beginUi() {
         parkingLotView.showBegin();
    }

    public void startParkingAndUnpack() {
        Scanner sc =new Scanner(System.in);
        int inputNumber=sc.nextInt();
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

    private void ParkingCar() {
    }

    private void unPack() {
    }
}
