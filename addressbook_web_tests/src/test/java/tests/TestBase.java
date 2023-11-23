package tests;

import manager.ApplicationManager;
import model.ContactData;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestBase {
    protected static ApplicationManager app;
    protected static WebDriver driver;

    protected static void returnToHomepage(By home_page) {
        initContactCreation(home_page);
    }

    protected static void clickSubmitBtnCreateContact(String cssSelector) {
        driver.findElement(By.cssSelector(cssSelector));
    }

    @BeforeEach
    public void setUp() {
        if (app == null) {
            app = new ApplicationManager();
        }
        app.init(System.getProperty("browser", "chrome"));

    }

    public void canFillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.first_name());
        type(By.name("middlename"), contact.middle_name());
        type(By.name("lastname"), contact.last_name());
        type(By.name("nickname"), contact.nick_name());
        type(By.name("title"), contact.title());
        type(By.name("company"), contact.company());
        type(By.name("address"), contact.address());
        type(By.name("home"), contact.home_phone());
        type(By.name("mobile"), contact.mobile_phone());
        type(By.name("work"), contact.work_phone());
        type(By.name("fax"), contact.fax_phone());
        type(By.name("email"), contact.email());
        type(By.name("email2"), contact.email2());
        type(By.name("email3"), contact.email3());
        type(By.name("homepage"), contact.homepage());
        type(By.name("address2"), contact.address_secondary());
        type(By.name("phone2"), contact.home());
        type(By.name("notes"), contact.notes());
    }
    public void createContact(ContactData contact) {
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }
    public void removeContact() {
        returnToHomePage();
        selectContact();
        removeSelectedContact();
        returnToHomePage();;
    }
    public void modifyContact(ContactData contact) {
        returnToHomePage();
        initContactModification();
        fillContactForm(contact);
        submitContactModification();
        returnToHomePage();
    }
    private void initContactCreation() {
        click(By.linkText("add new"));
    }

    private void initContactModification(){
        click(By.xpath("//img[@src='icons/pencil.png']"));
    }

    private void submitContactModification(){
        click(By.name("update"));
    }
    private void submitContactCreation() {
        click(By.name("submit"));
    }
    private void returnToHomePage() {
        click(By.linkText("home"));
    }
    private void selectContact() {
        click(By.name("selected[]"));
    }

    public boolean isContactPresent() {
        returnToHomePage();
        return manager.isElementPresent(By.name("selected[]"));
    }
    private void removeSelectedContact() {
        click(By.xpath("//input[@type='button'][@value='Delete']"));
        manager.driver.switchTo().alert().accept();
    }
}