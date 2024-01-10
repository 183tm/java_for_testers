package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTest extends TestBase {

    @Test
    void canModifyContact() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "firstname",
                    "middlename", "lastname", "nickname"));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testData = new ContactData().withFirstName("modified first name");
        app.contacts().modifyContact(oldContacts.get(index), testData);
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData.withId(oldContacts.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @Test
    public void canCreateContactInGroup() {
        app.groups().removeAllGroups();
        app.contacts().removeAllContact();
        app.hbm().createContact(new ContactData("", "firstname'", "", "", ""));
        app.hbm().createGroup(new GroupData("", "group name'", "", ""));
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var contact = oldContacts.get(index);
        var group = app.hbm().getGroupList().get(0);
        var expectedContactListInGroup = new ArrayList<>(oldContacts);
        if (app.hbm().checkContactInGroup(group, contact)) {
            app.contacts().removeContactFromGroup(contact, group);
        }
        app.contacts().addContactInGroup(group, contact);
        var newContacts = app.hbm().getContactList();
        var newContactListInGroup = new ArrayList<>(newContacts);
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        expectedContactListInGroup.sort(compareById);
        newContactListInGroup.sort(compareById);
        Assertions.assertEquals(expectedContactListInGroup, newContactListInGroup);
    }

    @Test
    public void canRemoveContactFromGroup() {
        app.groups().removeAllGroups();
        app.contacts().removeAllContact();
        app.hbm().createContact(new ContactData("", "firstname'", "", "", ""));
        app.hbm().createGroup(new GroupData("", "group name'", "", ""));
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var contact = oldContacts.get(index);
        var group = app.hbm().getGroupList().get(0);
        var expectedContactListInGroup = new ArrayList<>(oldContacts);
        if (!app.hbm().checkContactInGroup(group, contact)) {
            app.contacts().addContactInGroup(group, contact);
        }
        app.contacts().removeContactFromGroup(contact, group);
        var newContacts = app.hbm().getContactList();
        var newContactListInGroup = new ArrayList<>(newContacts);
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        expectedContactListInGroup.sort(compareById);
        newContactListInGroup.sort(compareById);
        Assertions.assertEquals(expectedContactListInGroup, newContactListInGroup);
    }
}
