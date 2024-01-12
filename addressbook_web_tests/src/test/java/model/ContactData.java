package model;

public record ContactData(
        String id,
        String firstname,
        String middlename,
        String lastname,
        String nickname,
        String photo,
        String home,
        String mobile,
        String work,
        String secondary)
{
    public ContactData() {
        this("", "", "", "", "", "", "", "", "","");
    }

    public ContactData withFirstName(String firstname) {
        return new ContactData(this.id, firstname, this.middlename, this.lastname, this.nickname, this.photo, this.home,this.mobile , this.work, this.secondary);
    }

    public ContactData withMiddleName(String middlename) {
        return new ContactData(this.id, this.firstname, middlename, this.lastname, this.nickname, this.photo, this.home,this.mobile , this.work, this.secondary);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.firstname, this.middlename, lastname, this.nickname, this.photo, this.home,this.mobile , this.work, this.secondary);
    }

    public ContactData withNicknameName(String nickname) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, nickname, this.photo, this.home,this.mobile , this.work, this.secondary);
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.home,this.mobile , this.work, this.secondary);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, photo, this.home,this.mobile , this.work, this.secondary);
    }
    public ContactData withHome(String home) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.photo, home,this.mobile , this.work, this.secondary);
    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.home,mobile , this.work, this.secondary);
    }
    public ContactData withWork(String work) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.home,this.mobile , work, this.secondary);
    }
    public ContactData withSecondary(String secondary) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.home,this.mobile , this.work, secondary);
    }

}

