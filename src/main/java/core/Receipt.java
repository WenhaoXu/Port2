package core;

import java.util.Objects;
import java.util.UUID;

public class Receipt {
  private  String smallTicket;
    public  Receipt(){
        smallTicket=UUID.randomUUID().toString();
    }
    public  Receipt(String uuid){
        smallTicket=uuid;
    }

    public String getSmallTicket() {
        return smallTicket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return Objects.equals(smallTicket, receipt.smallTicket);
    }

    @Override
    public int hashCode() {

        return Objects.hash(smallTicket);
    }
}
