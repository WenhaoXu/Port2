import java.util.HashMap;

public class ParkingLot {
    int size;
    int isPort;
    HashMap<Receipt,Car> hashMap=new HashMap<>();
    public ParkingLot(int i) {
        size=i;
    }

    public Receipt park(Car car) {
        if(isPort!=size){
        isPort++;
        Receipt receipt=new Receipt();
        hashMap.put(receipt,car);
        return receipt;}
        else{
            throw new ParkingLotFullException();
        }

    }

    public Car unPark(Receipt receipt) {

     return    hashMap.remove(receipt);

    }

    public Boolean isFull() {
        if(isPort==size){
            return true;
        }
        else {
            return false;
        }
    }
}
