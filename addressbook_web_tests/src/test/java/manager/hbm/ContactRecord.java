package manager.hbm;

import jakarta.persistence.*;

@Entity
@Table(name = "addressbook")
public class ContactRecord {

    @Id
    @Column(name = "id")
    public int id;
    @Column(name = "firstname")
    public String firstname;
    @Column(name = "middlename")
    public String middlename;
    @Column(name = "lastname")
    public String lastname;
    @Column(name = "nickname")
    public String nickname;

    public String company = new String();
    public String title = new String();
    public String address = new String();
    public String home;
    public String mobile;
    public String work;
    public String fax = new String();
    public String email;
    public String email2;
    public String email3;
    public String homepage = new String();
    public String im = new String();
    public String im2 = new String();
    public String im3 = new String();
    public Integer bday = 0;
    public String bmonth = "-";
    public String byear = new String();
    public Integer aday = 0;
    public String amonth = "-";
    public String ayear = new String();
    public String address2 = new String();
    public String phone2;
    public String photo = new String();
    public String notes = new String();

    public ContactRecord() {
    }

    public ContactRecord(int i, String firstname, String middlename, String lastname,
                         String nickname, String home, String mobile, String work, String secondary,
                         String address, String email, String email2, String email3) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.home = home;
        this.mobile = mobile;
        this.work = work;
        this.phone2 = secondary;
        this.address = address;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
    }
}
