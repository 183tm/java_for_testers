package model;

public record ContactData(String firstname, String middlename, String lastname, String nickname, String title,
                          String company, String address, String home, String mobile, String work, String fax,
                          String email, String email2, String email3, String homepage, String address2, String phone2,
                          String notes) {
    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withFirstName(String firstname) {
        return new ContactData(firstname, this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.address2,
                this.phone2, this.notes);
    }

    public ContactData withMiddleName(String middlename) {
        return new ContactData(this.firstname, middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.address2,
                this.phone2, this.notes);
    }

    public ContactData withLastnameName(String lastname) {
        return new ContactData(this.firstname, this.middlename, lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.address2,
                this.phone2, this.notes);
    }

    public ContactData withNicknameName(String nickname) {
        return new ContactData(this.firstname, this.middlename, this.lastname, nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.address2,
                this.phone2, this.notes);
    }

    public ContactData withTitleName(String title) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.address2,
                this.phone2, this.notes);
    }

    public ContactData withCompanyName(String company) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.title, company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.address2,
                this.phone2, this.notes);
    }

    public ContactData withAddressName(String address) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.company, address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.address2,
                this.phone2, this.notes);
    }

    public ContactData withHomeName(String home) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.address2,
                this.phone2, this.notes);
    }

    public ContactData withMobileName(String mobile) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.address2,
                this.phone2, this.notes);
    }

    public ContactData withWorkName(String work) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, work, this.fax, this.email, this.email2, this.email3, this.homepage, this.address2,
                this.phone2, this.notes);
    }

    public ContactData withFaxName(String fax) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, fax, this.email, this.email2, this.email3, this.homepage, this.address2,
                this.phone2, this.notes);
    }

    public ContactData withEmailName(String email) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, email, this.email2, this.email3, this.homepage, this.address2,
                this.phone2, this.notes);
    }

    public ContactData withEmail2Name(String email2) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, email2, this.email3, this.homepage, this.address2,
                this.phone2, this.notes);
    }

    public ContactData withEmail3Name(String email3) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, email3, this.homepage, this.address2,
                this.phone2, this.notes);
    }

    public ContactData withHomepageName(String homepage) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, homepage, this.address2,
                this.phone2, this.notes);
    }

    public ContactData withAddress2Name(String address2) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, address2,
                this.phone2, this.notes);
    }

    public ContactData withPhone2Name(String phone2) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.address2,
                phone2, this.notes);
    }

    public ContactData withNotesName(String notes) {
        return new ContactData(this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.address2,
                this.phone2, notes);
    }
}

