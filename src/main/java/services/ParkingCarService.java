package services;

import core.Car;
import core.ParkingBoy;
import core.Receipt;


public class ParkingCarService {

    ParkingBoy boy;

    public ParkingCarService(ParkingBoy boy) {

        this.boy = boy;
    }

    public String ParkingCar(String id) {
        String view ="";
        Car car=new Car(id);
        String smallTicket=boy.park(car).getSmallTicket();
        view+="停车成功，您的小票是：\n"+smallTicket+"\n1.停车服务\n" +
                "2.停车场管理\n" +
                "请输入您要进入的页面：";
        return view;
    }

    public String unPack(String id) {
        String view="";
        Receipt receipt=new Receipt(id);
        Car car= boy.unPark(receipt);
        if(car==null){
            view+="非法小票，无法取出车，请查证后再输\n1.停车服务\n" +
                    "2.停车场管理\n" +
                    "请输入您要进入的页面：";
        }
        else {
            view+="车已取出，您的车牌号是:"+car.getCarNumber()+"\n1.停车服务\n" +
                    "2.停车场管理\n" +
                    "请输入您要进入的页面：";
        }
        return view;
    }

    public String getParkingView(){
        String view="停车\n";
        if(boy.isFull()) {
            view=view+"车已停满，请晚点再来";
        }
        else{
            view=view+"请输入车牌号:";
        }
        return view;
    }

    public String getUnparkView(){
        String view ="取车\n请输入小票号:";
        return view;
    }

}
