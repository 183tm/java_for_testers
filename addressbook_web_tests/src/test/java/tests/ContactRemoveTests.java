package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ContactRemoveTests extends TestBase {
    @Test
    public void canRemoveContact() {
        if (app.contacts().getContactCount()==0) {
            app.contacts().createNewContact(new ContactData("firstname",
                    "middlename", "lastname", "nickname", "title", "company",
                    "address", "home", "mobile", "work", "fax", "email", "email2",
                    "email3", "homepage", "address2", "phone2", "notes"));
        }
        int contactCount = app.contacts().getContactCount();
        app.contacts().removeContact();
        int newContactCount = app.contacts().getContactCount();
        Assertions.assertEquals(contactCount - 1, newContactCount);
    }
    @Test
    public void canRemoveAllContactAtOnce() {
        if (app.contacts().getContactCount()==0) {
            app.contacts().createNewContact(new ContactData("firstname",
                    "middlename", "lastname", "nickname", "title", "company",
                    "address", "home", "mobile", "work", "fax", "email", "email2",
                    "email3", "homepage", "address2", "phone2", "notes"));
        }
    app.contacts().removeAllContact();
        Assertions.assertEquals(0,app.contacts().getContactCount());
    }
}