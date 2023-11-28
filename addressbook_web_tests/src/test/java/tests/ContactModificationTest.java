package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactModificationTest extends TestBase {

    @Test
    void canModifyContact() {
        if (app.contacts().getContactCount() == 0) {
            app.contacts().createNewContact(new ContactData("firstname",
                    "middlename", "lastname", "nickname", "title", "company",
                    "address", "home", "mobile", "work", "fax", "email", "email2",
                    "email3", "homepage", "address2", "phone2", "notes"));
        }
        app.contacts().modifyContact(new ContactData().withFirstName("modified name"));
    }
}
