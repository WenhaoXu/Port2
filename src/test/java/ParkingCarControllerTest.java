import controllers.ParkingCarController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import services.ParkingCarService;
import services.ParkingLotService;
import views.ParkingLotView;

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



}
