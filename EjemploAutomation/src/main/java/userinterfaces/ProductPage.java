package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.saucedemo.com/") // Esto debe corresponder a la URL de la página del producto
public class ProductPage extends PageObject {

    // Definimos los elementos de la interfaz de usuario de la página del producto
    public static final Target CHECKUOT_BUTTON = Target.the("Botón Checkout")
            .locatedBy("xpath=//*[@id=\"checkout\"");


}