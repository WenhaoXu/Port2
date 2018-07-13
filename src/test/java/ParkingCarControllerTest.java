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
    @Test
    public void should_return_parkUI_when_input_1(){
        int input=1;

    }
    @Test
    public void should_return_UnparkUI_when_input_2(){

    }
    @Test
    public void should_return_ErrorUi_when_input_3(){

    }

}
