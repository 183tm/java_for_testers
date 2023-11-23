package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;


public class ContactRemoveTests extends TestBase {
    @Test
    public void contactRemoveTests() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createNewContact(new ContactData("firstname",
                    "middlename", "lastname", "nickname", "title", "company",
                    "address", "home", "mobile", "work", "fax", "email", "email2",
                    "email3", "homepage", "address2", "phone2", "notes"));
        }
        app.contacts().removeContact();
    }
}