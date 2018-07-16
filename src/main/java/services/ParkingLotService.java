package services;

import core.ParkingBoy;
import core.ParkingLot;

import java.util.stream.Collectors;

public class ParkingLotService {
    ParkingBoy boy;

    public ParkingLotService(ParkingBoy boy) {

        this.boy = boy;
    }

    public String searchLot() {
        String view="|停车场ID|名称|车位|已停车辆|剩余车位|\n" +
                "======================================";
        view= boy.getParkingList().stream().map(lot->"|"+lot.getId()+"|"+lot.getName()+"|"+lot.getSize()+"|"+lot.getIsPort()+"|"+(lot.getSize()-lot.getIsPort())+"|").collect(Collectors.joining("\n"));
        int size=0;
        int isPort=0;
     for (int i=0;i<boy.getParkingList().size();i++){
         size+=boy.getParkingList().get(i).getSize();
         isPort+=boy.getParkingList().get(i).getIsPort();
     }
       view +=view+"\n总车位："+size+"(个)\n" +
               "停车总量："+isPort+"（辆）\n" +
               "总剩余车位："+(size-isPort)+"（个）\n";
        return  view;
    }

    public boolean addLot(String[] mes) {
        boolean successful=false;
    String  id="00"+ boy.getParkingList().size();
    if(mes.length==2){
        ParkingLot parkingLot=new ParkingLot(Integer.parseInt(mes[1])  ,mes[0],id);
        successful=true;
    }
       return  successful ;
    }

    public String deleteLot(String inputId) {
        String view="";

        if(boy.getParkingList().stream().filter(lot->lot.getId()==inputId).count()==0){
             view+="停车场删除失败，原因：此停车场不存在！";
        }
        else{
            ParkingLot lot1 =boy.getParkingList().stream().filter(lot->lot.getId()==inputId).findFirst().get();
            if(lot1.getIsPort()==0){
                    boy.getParkingList().remove(lot1);
                    view="停车场删除成功！";
            }
            else{
                view+="停车场删除失败，原因：此停车场中，依然停有汽车，无法删除！";
            }
        }
        return view;
    }
}
