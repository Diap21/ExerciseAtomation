package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import tasks.HacerLogin;
import userinterfaces.HomePage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;

public class LoginStepDefinitions {

    private Actor standard_user;

    @Managed(driver = "firefox")
    private WebDriver navegador;

    @Dado("Oscar tiene una cuenta")
    public void oscarTieneUnaCuenta() {
        //standard_user = Actor.named("standard_user");
        WebDriver navegador = new FirefoxDriver();
        standard_user.can(BrowseTheWeb.with(navegador));
        standard_user.wasAbleTo(Open.browserOn(new HomePage()));
    }

    @Cuando("el ingresa sus credenciales validas")
    public void elIngresaSusCredencialesValidas() {
        standard_user.attemptsTo(
                HacerLogin.conCredenciales("standard_user", "secret_sauce") // Reemplaza con las credenciales válidas
        );
    }

    @Entonces("el deberia tener acceso a su cuenta")
    public void elDeberiaTenerAccesoASuCuenta() {
        standard_user.should(seeThat(HomePage.LISTA_PRODUCTOS, containsText("Products")));
    }
}
