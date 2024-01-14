package ru.stqa.mantis.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.model.DeveloperMailUser;
import ru.stqa.mantis.model.UserData;

import java.time.Duration;

public class UserRegistrationTests extends TestBase {

    DeveloperMailUser user;

    @Test
    void canRegisterUserApi() {
        String username = CommonFunctions.randomString(5);
        var email = String.format("%s@localhost", username);
        app.jamesApi().addUser(email, "password");
        app.session().signup(username, email);
        app.rest().newRegistration(new UserData()
                .withUserName(username)
                .withEmail(email));
        var messages = app.mail().receive(email, "password", Duration.ofSeconds(10));
        var text = messages.get(0).content();
        var url = CommonFunctions.extractUrl(text);
        app.session().endOfRegistration(url, username, "password");
        app.http().login(username, "password");
        Assertions.assertTrue(app.http().isLoggedIn());
    }

    @Test
    void canRegisterUser() {
        String username = CommonFunctions.randomString(5);
        var email = String.format("%s@localhost", username);
        app.jamesCli().addUser(email, "password");
        app.session().signup(username, email);
        var messages = app.mail().receive(email, "password", Duration.ofSeconds(10));
        var text = messages.get(0).content();
        var url = CommonFunctions.extractUrl(text);
        app.session().endOfRegistration(url, username, "password");
        app.session().login(username, "password");
        Assertions.assertTrue(app.session().isLoggedIn());
    }

    /*@AfterEach
    void deleteMailUser(){
        app.developerMail().deleteUser(user);
    }*/
}


