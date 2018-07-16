package views;

import controllers.ParkingCarController;
import core.Request;

public class Route {
    ParkingCarController controller;
    String currentPage;

    public Route(ParkingCarController controller, String currentPage) {
        this.controller=controller;
        this.currentPage=currentPage;
    }
   public  void formatUI(){
        currentPage=controller.beginUi();
   }

    public void start(Request request) {

            switch (currentPage) {
                case "ParkingAndUnpark":
                {   if(request.getInputId().equals("1"))
                         currentPage= controller.getParkingView();
                   else if(request.getInputId().equals("2"))
                          currentPage=controller.getUnparkView();
                    else
                    {  currentPage=  controller.getErrorView();}
                    break;
                }
                case"park":
                    currentPage=controller.ParkingCar(request.getInputId());
                    break;
                case "unpark":
                    currentPage=controller.unPack(request.getInputId());
                    break;

            }
    }
}
