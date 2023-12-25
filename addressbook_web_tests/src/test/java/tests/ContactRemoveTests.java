package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;


public class ContactRemoveTests extends TestBase {
    @Test
    public void canRemoveContact() {
        if (app.contacts().getContactCount() == 0) {
            app.contacts().createNewContact(new ContactData("", "firstname",
                    "middlename", "lastname", "nickname","photo"));
        }
        var oldContacts = app.contacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.contacts().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }


    @Test
    public void canRemoveAllContactAtOnce() {
        if (app.contacts().getContactCount() == 0) {
            app.contacts().createNewContact(new ContactData("", "firstname",
                    "middlename", "lastname", "nickname","photo"));
        }
        app.contacts().removeAllContact();
        Assertions.assertEquals(0, app.contacts().getContactCount());
    }
}