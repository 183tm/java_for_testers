package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactsHelper extends HelperBase {

    public ContactsHelper(ApplicationManager manager) {
        super(manager);
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
    }

    public void createNewContact(ContactData contacts) {
        addNewContact();
        fillContactForm(contacts);
        submitContact();
        openHomePage();
    }

    public void removeContact() {
        openHomePage();
        selectedContact();
        removedSelectedContacts();
        closeAlert();
        openHomePage();
    }

    public void modifyContact(ContactData modifiedContact) {
        openHomePage();
        selectedContact();
        initContactModification();
        fillContactForm(modifiedContact);
        submitContactModification();
        openHomePage();
    }

    private void removedSelectedContacts() {
        manager.driver.findElement(By.xpath("//input[contains(@value,'Delete')]")).click();
    }

    private void closeAlert() {
        manager.driver.switchTo().alert().accept();
    }

    public void submitContact() {
        click(By.xpath("(//input[@name=\'submit\'])"));
    }

    protected void selectedContact() {
        click(By.name("selected[]"));
    }


    public int getContactCount() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    private void initContactModification() {
        click(By.xpath("(//img[@alt='Edit'])"));
    }

    private void submitContactModification() {
        click(By.name("update"));
    }

    public void removeAllContact() {
        openHomePage();
        selectAllContacts();
        removedSelectedContacts();
        closeAlert();
    }

    private void selectAllContacts() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }
}