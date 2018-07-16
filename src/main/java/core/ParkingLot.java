package core;

import java.util.HashMap;

public class ParkingLot {
    int size;
    int isPort;
    String name;
    String id;
    HashMap<Receipt, Car> hashMap = new HashMap<>();

    public ParkingLot(int i,String name,String id) {
        size = i;
        this.name=name;
        this.id=id;
    }

    public Receipt park(Car car) {
        if (isPort != size) {
            isPort++;
            Receipt receipt = new Receipt();
            hashMap.put(receipt, car);
            return receipt;
        } else {
            throw new ParkingLotFullException();
        }

    }

    public Car unPark(Receipt receipt) {

        return hashMap.remove(receipt);

    }

    public Boolean isFull() {
        if (isPort == size) {
            return true;
        } else {
            return false;
        }
    }

    public HashMap<Receipt, Car> getHashMap() {
        return hashMap;
    }


    public boolean isConstains(Receipt receipt) {
        return hashMap.containsKey(receipt);
    }

    public void setHashMap(HashMap<Receipt, Car> hashMap) {
        this.hashMap = hashMap;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getIsPort() {
        return isPort;
    }

    public void setIsPort(int isPort) {
        this.isPort = isPort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
