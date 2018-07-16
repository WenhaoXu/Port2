package views;

import controllers.ParkingCarController;
import core.ParkingBoy;
import core.ParkingLot;
import core.Request;
import services.ParkingCarService;
import services.ParkingLotService;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        String currentPage="main";
        ParkingLot parkingLot=new ParkingLot(3,"ali","001");
        LinkedList <ParkingLot>linkedList=new LinkedList<>();
        linkedList.add(parkingLot);
        ParkingBoy boy= new ParkingBoy(linkedList);
        ParkingCarService service=new ParkingCarService(boy);
        ParkingLotService service1=new ParkingLotService(boy);
        ParkingCarController controller=new ParkingCarController(new ParkingLotView(),service,service1);
        Route route=new Route(controller,currentPage);
//        RouteLot routeLot=new RouteLot(boy,currentPage);
//        RouteManage routeManage=new RouteManage(route,routeLot,currentPage);
//        route.formatUI();
        Request request=new Request();

//        route.
        while (true){
            request.setInputId();
             route.start(request);
        }
    }


}
