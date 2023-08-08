package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterfaces.CheckoutPage;

public class RealizarPago implements Task {

    private String firstName;
    private String lastName;
    private String postalCode;

    public RealizarPago(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(firstName).into(CheckoutPage.FIRST_NAME_INPUT),
                Enter.theValue(lastName).into(CheckoutPage.LAST_NAME_INPUT),
                Enter.theValue(postalCode).into(CheckoutPage.POSTAL_CODE_INPUT),
                Click.on(CheckoutPage.BOTON_CONTINUAR) // Clic al botón Continuar
        );
    }

    public static RealizarPago withPersonalInformation(String firstName, String lastName, String postalCode) {
        return new RealizarPago(firstName, lastName, postalCode);
    }
}