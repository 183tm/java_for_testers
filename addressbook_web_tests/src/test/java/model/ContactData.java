package model;

public record ContactData(String firstname, String middlename, String lastname, String nickname) {
    public ContactData() {
        this("", "", "", "");
    }

    public ContactData withFirstName(String firstname) {
        return new ContactData(firstname, this.middlename, this.lastname, this.nickname);
    }

    public ContactData withMiddleName(String middlename) {
        return new ContactData(this.firstname, middlename, this.lastname, this.nickname);
    }

    public ContactData withLastnameName(String lastname) {
        return new ContactData(this.firstname, this.middlename, lastname, this.nickname);
    }

    public ContactData withNicknameName(String nickname) {
        return new ContactData(this.firstname, this.middlename, this.lastname, nickname);
    }

}

