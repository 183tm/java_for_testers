package ru.stqa.mantis.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.model.DeveloperMailUser;

import java.time.Duration;

public class UserCreationTests extends TestBase {

    DeveloperMailUser user;

    @Test
    void canCreateUser() {
        var password = "password";
        user = app.developerMail().addUser();
        var email = String.format("%s@developermail.com", user.name());
        app.session().signup(user.name(), email);
        var message = app.developerMail().receive(user, Duration.ofSeconds(10));
        var url = CommonFunctions.extractUrl(message);
        app.session().endOfRegistration(url, user.name(), password);
        app.session().login(user.name(), password);
        Assertions.assertTrue(app.session().isLoggedIn());
    }

    @AfterEach
    void deleteMailUser() {
        app.developerMail().deleteUser(user);
    }
}