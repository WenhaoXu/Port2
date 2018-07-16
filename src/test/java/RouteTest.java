import controllers.ParkingCarController;
import core.Request;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import views.Route;

public class RouteTest {

    @Test
    public void should_return_beginUi_when_start(){
        String currentPage="main";
        ParkingCarController controller=Mockito.mock(ParkingCarController.class);
        Mockito.when(controller.getParkingService()).thenReturn("ParkingServiceView");
        Mockito.when(controller.beginUi()).thenReturn("manageView");
        Route route=new Route(controller,currentPage);
        Request request= new Request("1");
        Mockito.verify(controller).beginUi();

    }

    @Test
    public void should_return_ParkingView_when_input_1(){
        String currentPage="main";
        ParkingCarController controller=Mockito.mock(ParkingCarController.class);
        Mockito.when(controller.getParkingService()).thenReturn("ParkingServiceView");
        Mockito.when(controller.beginUi()).thenReturn("manageView");
        Route route=new Route(controller,currentPage);
        Request request= new Request("1");
        route.start(request);
        Mockito.verify(controller).beginUi();
        Mockito.verify(controller).getParkingService();

    }

    @Test
    public void should_return_manageView_when_input_2(){
        String currentPage="main";
        ParkingCarController controller=Mockito.mock(ParkingCarController.class);
        Mockito.when(controller.getManageService()).thenReturn("ManageLotServiceView");
        Mockito.when(controller.beginUi()).thenReturn("manageView");
        Route route=new Route(controller,currentPage);
        Request request= new Request("2");
        route.start(request);
        Mockito.verify(controller).beginUi();
        Mockito.verify(controller).getManageService();

    }


}
