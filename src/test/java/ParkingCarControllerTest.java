import controllers.ParkingCarController;
import core.ParkingBoy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import services.ParkingCarService;
import services.ParkingLotService;
import views.ParkingLotView;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ParkingCarControllerTest {
    @Test
    public void should_return_manageView_when_ParkCarService_is_start(){
        ParkingCarService parkingCarService=Mockito.mock(ParkingCarService.class) ;
        ParkingLotService parkingLotService=Mockito.mock(ParkingLotService.class);
        ParkingLotView parkingLotView=Mockito.mock(ParkingLotView.class);
        Mockito.when(parkingCarService.ParkingCar("1321421")).thenReturn("停车成功，您的小票是：\n");
        ParkingCarController parkingCarController=new ParkingCarController(parkingLotView,parkingCarService,parkingLotService);
        parkingCarController.ParkCarService("1321421");
        Mockito.verify(parkingCarService).ParkingCar("1321421");

    }

    @Test
    public void should_return_manageView_when_getParkCarService_is_start(){
        ParkingCarService parkingCarService=Mockito.mock(ParkingCarService.class) ;
        ParkingLotService parkingLotService=Mockito.mock(ParkingLotService.class);
        ParkingBoy boy=Mockito.mock(ParkingBoy.class);
        ParkingLotView parkingLotView=Mockito.mock(ParkingLotView.class);
        Mockito.when(boy.isFull()).thenReturn(false);
        Mockito.when(parkingCarService.getParkingView()).thenReturn("停车\n请输入车牌号:");
        ParkingCarController parkingCarController=new ParkingCarController(parkingLotView,parkingCarService,parkingLotService);
       String result=  parkingCarController.getParkCarService();
       assertThat(result,is("park"));
    }

    @Test
    public void should_return_manageView_when_addParkLotService_is_start(){
        ParkingCarService parkingCarService=Mockito.mock(ParkingCarService.class) ;
        ParkingLotService parkingLotService=Mockito.mock(ParkingLotService.class);
        ParkingBoy boy=Mockito.mock(ParkingBoy.class);
        ParkingLotView parkingLotView=Mockito.mock(ParkingLotView.class);
        Mockito.when(boy.isFull()).thenReturn(false);
        String [] input={"qeqr","3"};
        Mockito.when(parkingLotService.addLot(input)).thenReturn(true);
        ParkingCarController parkingCarController=new ParkingCarController(parkingLotView,parkingCarService,parkingLotService);
        String result=  parkingCarController.addParkLotService("qeqr,3");
        Mockito.verify(parkingLotService).addLot(input);
        assertThat(result,is("manageView"));
    }


}
