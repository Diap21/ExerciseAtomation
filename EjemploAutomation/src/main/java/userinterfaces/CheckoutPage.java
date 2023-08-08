package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {
    private CheckoutPage() {
    }

    public static final Target PRODUCTS_IN_CART = Target.the("First Name input")
            .locatedBy("xpath=//button[@id='add-to-cart-sauce-labs-bike-light']");
    public static final Target FIRST_NAME_INPUT = Target.the("First Name input")
            .locatedBy("css=*[data-test=\"firstName\"]");

    public static final Target LAST_NAME_INPUT = Target.the("Last Name input")
            .locatedBy("css=*[data-test=\"lastName\"]");

    public static final Target POSTAL_CODE_INPUT = Target.the("Postal Code input")
            .locatedBy("css=*[data-test=\"postalCode\"]");

    public static final Target BOTON_CONTINUAR = Target.the("Botón Continuar")
            .locatedBy("xpath=//input[@id='continue']");

}