package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstname : List.of("", "firstname")) {
            for (var middlename : List.of("", "middlename")) {
                for (var lastname : List.of("", "lastname")) {
                    for (var nickname : List.of("", "nickname")) {
                        for (var title : List.of("", "title")) {
                            for (var company : List.of("", "company")) {
                                for (var address : List.of("", "address")) {
                                    for (var home : List.of("", "home")) {
                                        for (var mobile : List.of("", "mobile")) {
                                            for (var work : List.of("", "work")) {
                                                for (var fax : List.of("", "fax")) {
                                                    for (var email : List.of("", "email")) {
                                                        for (var email2 : List.of("", "email2")) {
                                                            for (var email3 : List.of("", "email3")) {
                                                                for (var homepage : List.of("", "homepage")) {
                                                                    for (var address2 : List.of("", "address2")) {
                                                                        for (var phone2 : List.of("", "phone2")) {
                                                                            for (var notes : List.of("", "notes")) {
                                                                                result.add(new ContactData(firstname, middlename, lastname,
                                                                                        nickname, title, company,
                                                                                        address, home, mobile, work, fax,
                                                                                        email, email2, email3, homepage, address2, phone2, notes));
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            result.add(new ContactData(randomString(i * 10), randomString(i * 10), randomString(i * 10), randomString(i * 10),
                    randomString(i * 10), randomString(i * 10), randomString(i * 10), randomString(i * 10),
                    randomString(i * 10), randomString(i * 10), randomString(i * 10), randomString(i * 10),
                    randomString(i * 10), randomString(i * 10), randomString(i * 10), randomString(i * 10),
                    randomString(i * 10), randomString(i * 10)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        int contactCount = app.contacts().getContactCount();
        app.contacts().createNewContact(contact);
        int newContactCount = app.contacts().getContactCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("firstname'", "", "", "", "", "", "",
                        "", "", "", "", "", "", "", "", "", "",
                        "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContacts(ContactData contact) {
        int contactCount = app.contacts().getContactCount();
        app.contacts().createNewContact(contact);
        int newContactCount = app.contacts().getContactCount();
        Assertions.assertEquals(contactCount, newContactCount);
    }
}