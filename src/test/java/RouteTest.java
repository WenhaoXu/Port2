import controllers.ParkingCarController;
import core.ParkingBoy;
import org.junit.jupiter.api.Test;
import views.ParkingLotView;
import views.Route;

public class RouteTest {
    @Test
    public void should_return_parkingPage_when_input_1(){
        String currentPage="park";
        ParkingBoy boy= ParkingBoy.createParkingBoy(3,2);
        ParkingCarController controller=new ParkingCarController(new ParkingLotView(),boy);
        Route route=new Route(controller,currentPage);

    }
}
