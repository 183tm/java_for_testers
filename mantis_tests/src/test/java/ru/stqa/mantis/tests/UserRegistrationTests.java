package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;

import java.time.Duration;
import java.util.regex.Pattern;

public class UserRegistrationTests extends TestBase {

    /*@Test
    void canRegisterUser(){
        var username = CommonFunctions.randomString(5);
        var password = "password";
        var email = String.format("%s@localhost", username);
        app.jamesCli().addUser(email,password);
        app.session().signup(username, email);
        var messages = app.mail().receive(email, password, Duration.ofSeconds(60));
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);
        var url = "";
        if (matcher.find()) {
            url = text.substring(matcher.start(), matcher.end());
            System.out.println(url);
        }
        app.session().endOfRegistration(url,username,password);
        app.http().login(username, password);
        Assertions.assertTrue(app.http().isLoggedIn());
        //создать пользователя адрес на почтовом сервере) (JamesHelper)
        //аолняем форму создания (браузер)
        //ждем почту(MailHelper)
        //извлекаем ссылку из письма
        //проходим по ссылке и завершаем регистрацию пользователя (браузер)
        //проверяем что пользователь может залогиниться(HttpSessionHelper)
    }*/

    @Test
    void canRegisterUser() {
        var username = CommonFunctions.randomString(8);
        var password = "password";
        var email = String.format("%s@localhost", username);
        app.jamesCli().addUser(email, password);
        app.session().signup(username, email);
        var messages = app.mail().receive(email, password, Duration.ofSeconds(10));
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);
        if (matcher.find()) {
            var url = text.substring(matcher.start(), matcher.end());
            app.driver().get(url);
        }
        var realName = "My_real_name";
        app.session().endOfRegistration(realName, password);
        app.http().login(username, password);
        Assertions.assertTrue(app.http().isLoggedIn());
    }
}


