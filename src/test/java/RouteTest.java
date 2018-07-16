import controllers.ParkingCarController;
import core.Request;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import views.Route;

public class RouteTest {

    @Test
    public void should_return_parkingPage_when_input_1(){
        String currentPage="main";
        ParkingCarController controller=Mockito.mock(ParkingCarController.class);
        Mockito.when(controller.getParkingService()).thenReturn("ParkingServiceView");
        Mockito.when(controller.beginUi()).thenReturn("manageView");
        Route route=new Route(controller,currentPage);
        Request request= new Request("1");
        Mockito.verify(controller).beginUi();
//        Mockito.verify(controller).getParkCarService();
    }
}
