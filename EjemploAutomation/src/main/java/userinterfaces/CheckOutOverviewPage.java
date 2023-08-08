package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CheckOutOverviewPage {

    private CheckOutOverviewPage() {
    }

    public static final Target BOTON_FINALIZAR = Target.the("Botón Finish")
            .locatedBy("css=*[data-test=\"finish\"]");

    public static final Target SUCCESS_MESSAGE = Target.the("Mensaje Gracias por su compra")
            .locatedBy("xpath=/html/body/div[1]/div/div/div[2]/h2");
}
