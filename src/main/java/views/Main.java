package views;

import controllers.ParkingCarController;
import core.ParkingBoy;
import core.Request;

public class Main {
    public static void main(String[] args) {
        String currentPage="main";
        ParkingBoy boy= ParkingBoy.createParkingBoy(3,2);
        ParkingCarController controller=new ParkingCarController(new ParkingLotView(),boy);
        Route route=new Route(controller,currentPage);
        route.formatUI();
        Request request=new Request();

//        route.
        while (true){
            request.setInputId();
             route.start(request);
        }
    }


}
