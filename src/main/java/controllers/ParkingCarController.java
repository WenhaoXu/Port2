package controllers;

import services.ParkingCarService;
import services.ParkingLotService;
import views.ParkingLotView;

public class ParkingCarController {
    private final ParkingLotView  parkingLotView;
//      ParkingBoy boy;

    ParkingCarService parkingCarService;
    ParkingLotService parkingLotService;
    public ParkingCarController(ParkingLotView  parkingLotView ,ParkingCarService parkingCarService, ParkingLotService parkingLotService) {
        this.parkingLotView = parkingLotView;
        this.parkingCarService=parkingCarService;
        this.parkingLotService=parkingLotService;
    }


    public String beginUi() {
         parkingLotView.sendView("1.停车服务\n" +
                 "2.停车场管理\n" +
                 "请输入您要进入的页面：");

         return  "manageView";
    }

//    public String ParkingCar(String id) {
//
//
//           Car car=new Car(id);
//           String smallTicket=boy.park(car).getSmallTicket();
//           parkingLotView.sendView("停车成功，您的小票是：\n"+smallTicket);
//           parkingLotView.sendView("   1. 停车\n 2. 取车  \n请输入您要进行的操作：");
//
//       return "ParkingAndUnpark";
//    }

    public String ParkCarService(String id){
        String view ="";
     view=   parkingCarService.ParkingCar(id);
     parkingLotView.sendView(view);
        return  "manageView";
    }
//    public String unPack(String id) {
//        Receipt receipt=new Receipt(id);
//         Car car= boy.unPark(receipt);
//        if(car==null){
//            parkingLotView.sendView("非法小票，无法取出车，请查证后再输");
//            parkingLotView.sendView("   1. 停车\n 2. 取车  \n请输入您要进行的操作：");
//        }
//         else {
//            parkingLotView.sendView("车已取出，您的车牌号是:"+car.getCarNumber());
//            parkingLotView.sendView("   1. 停车\n 2. 取车  \n请输入您要进行的操作：");
//        }
//
//        return "ParkingAndUnpark";
//    }

    public String UnparkCarService(String id){
        String view="";
     view=   parkingCarService.unPack(id);
     parkingLotView.sendView(view);
     return "manageView";
    }

    public String getMainErrorView (){

        parkingLotView.sendView("非法指令，请查证后再输");
        parkingLotView.sendView("1.停车服务\n" +
                "2.停车场管理\n" +
                "请输入您要进入的页面：");
        return "manageView";
    }

//    public String getParkingView(){
//        parkingLotView.sendView("停车\n");
//        if(boy.isFull()) {
//            parkingLotView.sendView("车已停满，请晚点再来");
//
//        }
//        else{ parkingLotView.sendView("请输入车牌号:");}
//        return "park";
//    }
//
//    public String getUnparkView(){
//        parkingLotView.sendView("取车\n请输入小票号:");
//        return "unpark";
//    }

    public String getParkingService() {
        parkingLotView.sendView("1. 停车\n 2. 取车  \n请输入您要进行的操作：");

        return  "ParkingServiceView";
    }

    public String getManageService() {

      parkingLotView.sendView("1.查看停车场详情\n" +
              "2.添加停车场\n" +
              "3.删除停车场");
        return  "ManageLotServiceView";
    }


    public String getParkCarService(){
       String result="";
     result=   parkingCarService.getParkingView();
        parkingLotView.sendView(result);
        return "park";
    }

    public String getUnparkCarService(){
        String result="";
        result=   parkingCarService.getUnparkView();
        parkingLotView.sendView(result);
        return "unpark";
    }

    public String getParkLotService() {
      parkingLotView.sendView(parkingLotService.searchLot()+"1.停车服务\n" +
              "2.停车场管理\n" +
              "请输入您要进入的页面：");
        return "manageView";
    }

    public String addLotService() {
        parkingLotView.sendView("请输入你套添加的停车场信息（格式为：名称，车位）：");
        return "startAdd";
    }

    public String deleteLotService() {
        parkingLotView.sendView("请输入需要删除的被管理停车场ID:");
        return "delete";
    }

    public String addParkLotService(String inputId) {
        String [] mes=inputId.split(",");
      boolean success=  parkingLotService.addLot(mes);
      if(success){
          parkingLotView.sendView("停车场添加成功！\n1.停车服务\n" +
                  "2.停车场管理\n" +
                  "请输入您要进入的页面：");
      }
      else{
          parkingLotView.sendView("停车场添加失败哦！\n1.停车服务\n" +
                  "2.停车场管理\n" +
                  "请输入您要进入的页面：");
      }
        return "manageView";
    }

    public String deleteParkLotService(String inputId) {
         parkingLotView.sendView( parkingLotService.deleteLot(inputId));
        return "manageView";
    }
}
