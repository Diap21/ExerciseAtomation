package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import userinterfaces.LoginForm;

public class HacerLogin implements Performable {

    private final String username;
    private final String password;

    public HacerLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static HacerLogin conCredenciales(String username, String password) {
        return instrumented(HacerLogin.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(LoginForm.USERNAME_FIELD),
                Enter.theValue(password).into(LoginForm.PASSWORD_FIELD),
                Click.on(LoginForm.LOGIN_BUTTON)
        );
    }
}