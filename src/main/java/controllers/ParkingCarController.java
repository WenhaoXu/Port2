package controllers;

import core.Car;
import core.ParkingBoy;
import core.Receipt;
import views.ParkingLotView;

public class ParkingCarController {
    private final ParkingLotView  parkingLotView;
      ParkingBoy boy;
    public ParkingCarController(ParkingLotView  parkingLotView ,ParkingBoy boy) {
        this.parkingLotView = parkingLotView;
        this.boy=boy;
    }


    public String beginUi() {
         parkingLotView.sendView("   1. 停车\n 2. 取车  \n请输入您要进行的操作：");
         return  "ParkingAndUnpark";
    }

    public String ParkingCar(String id) {
           Car car=new Car(id);
           String smallTicket=boy.park(car).getSmallTicket();
           parkingLotView.sendView("停车成功，您的小票是：\n"+smallTicket);
           parkingLotView.sendView("   1. 停车\n 2. 取车  \n请输入您要进行的操作：");

       return "main";
    }

    public String unPack(String id) {
        Receipt receipt=new Receipt(id);
         Car car= boy.unPark(receipt);
        if(car==null){
            parkingLotView.sendView("非法小票，无法取出车，请查证后再输");
            parkingLotView.sendView("   1. 停车\n 2. 取车  \n请输入您要进行的操作：");
        }
         else {
            parkingLotView.sendView("车已取出，您的车牌号是:"+car.getCarNumber());
        }

        return "main";
    }

    public String getErrorView(){
        parkingLotView.sendView("非法指令，请查证后再输");
        return "main";
    }
    public String getParkingView(){
        parkingLotView.sendView("停车\n");
        if(boy.isFull()) {
            parkingLotView.sendView("车已停满，请晚点再来");

        }
        else{ parkingLotView.sendView("请输入车牌号:");}
        return "park";
    }

    public String getUnparkView(){
        parkingLotView.sendView("取车\n请输入小票号:");
        return "unpark";
    }
}
