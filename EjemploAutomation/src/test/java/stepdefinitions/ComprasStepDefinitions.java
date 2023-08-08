package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import tasks.AgregarProductoAlCarro;
import tasks.RealizarPago;
import userinterfaces.CheckOutOverviewPage;
import userinterfaces.HomePage;
import userinterfaces.CheckoutPage;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;

public class ComprasStepDefinitions {

    //private Actor actor;

    @Dado("que un nuevo cliente accede hasta la web de compras")
    public void queUnNuevoClienteAccedeHastaLaWebDeCompras(String standard_user) {
        //actor = Actor.named("nuevoCliente");
        WebDriver navegador = new FirefoxDriver();
        theActorCalled(standard_user).can(BrowseTheWeb.with(navegador));
        theActorCalled(standard_user).wasAbleTo(Open.browserOn(new HomePage()));
    }

    @Cuando("el agrega 1 producto de Bicicletas al carro")
    public void elAgregaProductoAlCarro(String standard_user, String tipoCategoria) {
        theActorCalled(standard_user).attemptsTo(
                AgregarProductoAlCarro.conCategoriaYOrden(tipoCategoria, "Price(low to high)")
        );
    }

    @Entonces("el ve los productos listados en el carro de compras")
    public void elVeLosProductosListadosEnElCarroDeCompras(String standard_user) {
        theActorCalled(standard_user).should(seeThat("Carrito contiene productos", CheckoutPage.PRODUCTS_IN_CART, containsText(true)));
    }

    @Cuando("agrega su información personal")
    public void agregaSuInformacionPersonal(List<Map<String, String>> data,String standard_user) {
        String firstName = data.get(0).get("FirstName");
        String lastName = data.get(0).get("LastName");
        String postalCode = data.get(0).get("PostalCode");

        theActorCalled(standard_user).attemptsTo(
                new RealizarPago(firstName, lastName, postalCode)
        );
    }

    @Cuando("realiza la orden del pedido con botón continuar")
    public void realizaLaOrdenDelPedidoConBotonContinuar(String standard_user) {
        theActorCalled(standard_user).attemptsTo(
                Click.on(CheckoutPage.BOTON_CONTINUAR)
        );
    }

    @Entonces("puede visualizarse el resultado exitoso de la compra")
    public void puedeVisualizarseElResultadoExitosoDeLaCompra(String standard_user) {
        theActorCalled(standard_user).should(
                seeThat("Resultado exitoso de la compra", CheckOutOverviewPage.SUCCESS_MESSAGE, containsText("successful"))
        );
    }
}