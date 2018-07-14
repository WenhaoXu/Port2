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

    public void getLotIsFullView() {
        System.out.println("车已停满，请晚点再来");
        showBegin();
    }

    public void getParkingCarView(){
        System.out.println("请输入车牌号:");
    }

    public void getReceptView(String ticket){
        System.out.println(" 停车成功，您的小票是：\n"+ticket);
    }

   public void getsShowIdview(){
       System.out.println("请输入小票号:");
   }

    public void getCarIsNonexistent() {
        System.out.println("非法小票，无法取出车，请查证后再输");
    }

    public void getCarView(String id) {

        System.out.println("车已取出，您的车牌号是:");
        System.out.println(id);
    }
}
