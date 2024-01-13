package ru.stqa.mantis.manager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class HelperBase {
    protected final ApplicationManager manager;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
    }

    protected void type(By locator, String text) {
        click(locator);
        manager.driver().findElement(locator).clear();
        manager.driver().findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {
        manager.driver().findElement(locator).click();
    }

    protected void attach(By locator, String file) {
        if (file != null) {
            manager.driver().findElement(locator).sendKeys(Paths.get(file).toAbsolutePath().toString());
        }
    }

    protected boolean isElementPresent(By locator){
       return manager.driver().findElements(locator).size() > 0;
    }
}
