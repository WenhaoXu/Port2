package views;

public class ParkingLotView {

    public void showBegin() {
        System.out.println("******************************");
        System.out.println("****     1. 停车      ********");
        System.out.println("****     2. 取车      ********");
        System.out.println("******************************");
        System.out.println("");
        System.out.println("请输入您要进行的操作：");

    }

    public void getParkingView() {
        System.out.println("停车");
    }

    public void getUnparkView() {
        System.out.println("取车");
    }

    public void getErrorView() {
        System.out.println("非法指令，请查证后再输");
    }
}
