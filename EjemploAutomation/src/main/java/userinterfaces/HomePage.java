package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {
    private HomePage() {
    }

    public static final Target CATEGORIA_SELECT = Target.the("Categoría select")
            .locatedBy("xpath=div[1]/div/div/div[1]/div[2]/div/span/select");
    public static final Target ORDENAR_POR_SELECT = Target.the("Ordenar por select")
            .locatedBy("xpath=div[1]/div/div/div[1]/div[2]/div/span/select/option[3]");
    public static final Target CESTA_LINK = Target.the("Cesta link")
            .locatedBy("xpath=//button[@id='add-to-cart-sauce-labs-bike-light']");

    public static final Target LISTA_PRODUCTOS = Target.the("Products")
            .locatedBy(".xpath=//span[contains(.,'Products')]"); // Reemplaza con el localizador correcto
}

