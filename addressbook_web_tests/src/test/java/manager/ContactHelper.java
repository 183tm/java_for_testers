package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
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
        type(By.name("home"), contact.home());
        type(By.name("mobile"), contact.mobile());
        type(By.name("work"), contact.work());
        type(By.name("phone2"), contact.secondary());
        type(By.name("address"), contact.address());
        type(By.name("email"), contact.email());
        type(By.name("email2"), contact.email2());
        type(By.name("email3"), contact.email2());
    }

    private void removeSelectedContactFromGroup() {
        click(By.name("remove"));
    }

    public void createNewContact(ContactData contact) {
        openHomePage();
        addNewContact();
        fillContactForm(contact);
        submitContact();
        openHomePage();
    }

    public void createNewContact(ContactData contact, GroupData group) {
        addNewContact();
        fillContactForm(contact);
        selectGroup(group);
        submitContact();
        openHomePage();
    }

    private void selectGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
    }

    private void selectGroupForAdd(GroupData group) {
        new Select(manager.driver.findElement(By.name("to_group"))).selectByValue(group.id());
    }

    private void selectGroupFilter(GroupData group) {
        new Select(manager.driver.findElement(By.name("group"))).selectByValue(group.id());
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
        openHomePage();
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

    public void addContactInGroup(GroupData group, ContactData contact) {
        openHomePage();
        selectGroupForAdd(group);
        selectedContact(contact);
        submitAddContactInGroup();
        openHomePage();
    }

    private void submitAddContactInGroup() {
        click(By.xpath("//input[@name='add']"));
    }

    public void removeContactFromGroup(ContactData contact, GroupData group) {
        openHomePage();
        selectGroupFilter(group);
        selectedContact(contact);
        removeSelectedContactFromGroup();
    }

    public String getPhones(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[6]", contact.id()))).getText();
    }

    public Map<String, String> getPhones() {
        openHomePage();
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.ById.tagName("input")).getAttribute("id");
            var phones = row.findElements(By.tagName("td")).get(5).getText();
            result.put(id, phones);
        }
        return result;
    }

    public String getAddress(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[3]", contact.id()))).getText();
    }

    public Map<String, String> getAddress() {
        openHomePage();
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.ById.tagName("input")).getAttribute("id");
            var adress = row.findElements(By.tagName("td")).get(3).getText();
            result.put(id, adress);
        }
        return result;
    }


    public String getEmails(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[4]", contact.id()))).getText();
    }

    public Map<String, String> getEmails() {
        openHomePage();
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.ById.tagName("input")).getAttribute("id");
            var emails = row.findElements(By.tagName("td")).get(4).getText();
            result.put(id, emails);
        }
        return result;
    }
}