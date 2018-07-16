package views;

import controllers.ParkingCarController;
import core.Request;

public class Route {
    ParkingCarController controller;
    String currentPage;


    public Route(ParkingCarController controller, String currentPage) {
        this.controller = controller;
        this.currentPage = currentPage;
        formatUI();
    }

    public void formatUI() {
        currentPage = controller.beginUi();
    }

    public void start(Request request) {

        switch (currentPage) {
            case "main":
                currentPage = controller.beginUi();
            case "manageView": {
                if (request.getInputId().equals("1"))
                    currentPage = controller.getParkingService();
                else if (request.getInputId().equals("2"))
                    currentPage = controller.getManageService();
                else {
                    currentPage = controller.getMainErrorView();
                }
                break;
            }
            case "ParkingServiceView":
                if (request.getInputId().equals("1"))
                    currentPage = controller.getParkCarService();
                else if (request.getInputId().equals("2"))
                    currentPage = controller.getUnparkCarService();
                else {
                    currentPage = controller.getMainErrorView();
                }
                break;
            case "ManageLotServiceView":
                if (request.getInputId().equals("1"))
                    currentPage = controller.getParkLotService();
                else if (request.getInputId().equals("2"))
                    currentPage = controller.addLotService();
                else if(request.getInputId().equals("3")){
                    currentPage = controller.deleteLotService();
                }
                else{
                    currentPage = controller.getMainErrorView();
                }
                break;
            case "park":
                currentPage = controller.ParkCarService(request.getInputId());
                break;
            case "unpark":
                currentPage = controller.UnparkCarService(request.getInputId());
                break;

            case"startAdd":
                    currentPage = controller.addParkLotService(request.getInputId());

            case "delete":
                currentPage = controller.deleteParkLotService(request.getInputId());

        }
    }
}
