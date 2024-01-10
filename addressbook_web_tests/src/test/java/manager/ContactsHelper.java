package manager;

import model.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;


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

    public void createNewContact(ContactData contact) {
        openHomePage();
        addNewContact();
        fillContactForm(contact);
        submitContact();
        openHomePage();
    }

    public void removeContact(ContactData contact) {
        openHomePage();
        selectedContact(contact);
        removedSelectedContacts();
        closeAlert();
        openHomePage();
    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openHomePage();
        initContactModification(contact);
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

    protected void selectedContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }


    public int getContactCount() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    private void initContactModification(ContactData contact) {
        click(By.cssSelector(String.format("a[href=\"edit.php?id=%s\"] > img", contact.id())));
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

    public List<ContactData> getList() {
        openHomePage();
        var contacts = new ArrayList<ContactData>();
        var entries = manager.driver.findElements(By.name("entry"));
        for (var entry : entries) {
            var firstname = entry.findElement(By.cssSelector("td:nth-child(3)")).getText();
            var lastname = entry.findElement(By.cssSelector("td:nth-child(2)")).getText();
            var checkbox = entry.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData()
                    .withId(id)
                    .withFirstName(firstname)
                    .withLastName(lastname));
        }
        return contacts;
    }
}