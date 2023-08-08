package tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import userinterfaces.HomePage;

public class AgregarProductoAlCarro implements Task {

    private String tipoCategoria;
    private String ordenarPor;

    // Constructor con parámetros
    private AgregarProductoAlCarro(String tipoCategoria, String ordenarPor) {
        this.tipoCategoria = tipoCategoria;
        this.ordenarPor = ordenarPor;
    }

    // Método estático para crear una instancia de la tarea
    public static AgregarProductoAlCarro conCategoriaYOrden(String tipoCategoria, String ordenarPor) {
        return new AgregarProductoAlCarro(tipoCategoria, ordenarPor);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Abre la página de compras
                Open.url("https://www.abc.com"),
                // Filtrar por precio y seleccionar categoría
                SelectFromOptions.byVisibleText(tipoCategoria).from(HomePage.CATEGORIA_SELECT),
                // Seleccionar ordenar por
                SelectFromOptions.byVisibleText(ordenarPor).from(HomePage.ORDENAR_POR_SELECT),
                // Ir a la cesta
                Click.on(HomePage.CESTA_LINK)
        );
    }
}