package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactsHelper extends HelperBase {

    public ContactsHelper(ApplicationManager manager) {
        super(manager);
    }


    public boolean isContactPresent() {
        openHomePage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    private void openHomePage() {
        manager.driver.findElement(By.linkText("home")).click();
    }

    private void addNewContact() {
        manager.driver.findElement(By.linkText("add new")).click();
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        type(By.name("nickname"), contact.nickname());
        type(By.name("company"), contact.company());
        type(By.name("title"), contact.title());
        type(By.name("address"), contact.address());
        type(By.name("home"), contact.home());
        type(By.name("mobile"), contact.mobile());
        type(By.name("work"), contact.work());
        type(By.name("fax"), contact.fax());
        type(By.name("email"), contact.email());
        type(By.name("email2"), contact.email2());
        type(By.name("email3"), contact.email3());
        type(By.name("homepage"), contact.homepage());
        type(By.name("address2"), contact.address2());
        type(By.name("phone2"), contact.phone2());
        type(By.name("notes"), contact.notes());
    }

    public void createNewContact(ContactData contacts) {
        addNewContact();
        fillContactForm(contacts);
        submitContact();
        openHomePage();
    }

    public void removeContact() {
        openHomePage();
        canSelectedSmthng();
        canRemoveContact();
        openHomePage();
    }

    private void canRemoveContact() {
        manager.driver.findElement(By.xpath("//input[contains(@value,'Delete')]")).click();
        manager.driver.switchTo().alert().accept();
    }

    public void submitContact() {
        click(By.xpath("(//input[@name=\'submit\'])"));
    }

    protected void canSelectedSmthng() {
        click(By.name("selected[]"));
    }


}