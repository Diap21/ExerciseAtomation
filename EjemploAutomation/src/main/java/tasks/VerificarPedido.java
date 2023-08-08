package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import userinterfaces.CheckOutOverviewPage;

public class VerificarPedido implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CheckOutOverviewPage.BOTON_FINALIZAR) // Clic al botón Finish
        );

        String mensaje = Text.of(CheckOutOverviewPage.SUCCESS_MESSAGE).viewedBy(actor).asString();
    }
}

//Gracias me diverti
//Elabora Diana Cardozo