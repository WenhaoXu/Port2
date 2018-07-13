package views;

import com.google.inject.Injector;
import controllers.ParkingCarController;

import static com.google.inject.Guice.createInjector;

public class Main {
    public static void main(String[] args) {
        Injector injector=createInjector(new ParkingLotModule());
        ParkingCarController  controller=injector.getInstance(ParkingCarController.class);
        controller.beginUi();
        controller.startParkingAndUnpack();


    }
}
