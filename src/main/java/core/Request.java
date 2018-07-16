package core;

import java.util.Scanner;

public class Request {
    String inputId;

    public Request(String id) {
        inputId=id;
    }

    public Request() {

    }

    public String getInputId() {
        return inputId;
    }

    public void setInputId(){
        Scanner sc =new Scanner(System.in);
        inputId= sc.nextLine();
    }

}
