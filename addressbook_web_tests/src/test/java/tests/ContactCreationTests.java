package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstname : List.of("", "firstname")) {
            for (var middlename : List.of("", "middlename")) {
                for (var lastname : List.of("", "lastname")) {
                    for (var nickname : List.of("", "nickname")) {
                        for (var photo : List.of("src/test/resources/images/avatar.png")) {

                            result.add(new ContactData().withFirstName(firstname).withMiddleName(middlename)
                                    .withLastName(lastname).withNicknameName(nickname).withPhoto(photo));

                        }
                    }
                }
            }
        }
                for (int i = 0; i < 5; i++) {
                    result.add(new ContactData()
                            .withFirstName(randomString(i * 10))
                            .withMiddleName(randomString(i * 10))
                            .withLastName(randomString(i * 10))
                            .withNicknameName(randomString(i * 10))
                            .withPhoto("src/test/resources/images/avatar.png"));
                }
                return result;
            }

            @ParameterizedTest
            @MethodSource("contactProvider")
            public void canCreateMultipleContacts (ContactData contact){
                var oldContacts = app.contacts().getList();
                app.contacts().createNewContact(contact);
                var newContacts = app.contacts().getList();
                Comparator<ContactData> compareById = (o1, o2) -> {
                    return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
                };
                newContacts.sort(compareById);
                var expectedList = new ArrayList<>(oldContacts);
                expectedList.add(contact.withId(newContacts.get(newContacts.size() - 1).id()).withMiddleName("").withNicknameName("").withPhoto(""));
                expectedList.sort(compareById);
                Assertions.assertEquals(newContacts, expectedList);
            }

            public static List<ContactData> negativeContactProvider () {
                var result = new ArrayList<ContactData>(List.of(
                        new ContactData("", "firstname'", "", "", "", "src/test/resources/images/avatar.png")));
                return result;
            }

            @ParameterizedTest
            @MethodSource("negativeContactProvider")
            public void canNotCreateContacts (ContactData contact){
                var oldContacts = app.contacts().getList();
                app.contacts().createNewContact(contact);
                var newContacts = app.contacts().getList();
                Assertions.assertEquals(newContacts, oldContacts);
            }
        }