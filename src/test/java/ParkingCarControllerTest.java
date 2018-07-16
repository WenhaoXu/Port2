import com.google.inject.Injector;
import controllers.ParkingCarController;
import org.junit.jupiter.api.Test;
import views.ParkingLotModule;

import static com.google.inject.Guice.createInjector;

public class ParkingCarControllerTest {
    @Test
    public void should_return_beginUI_when_start(){
        Injector injector=createInjector(new ParkingLotModule());
        ParkingCarController controller=injector.getInstance(ParkingCarController.class);
        controller.beginUi();
    }



}
