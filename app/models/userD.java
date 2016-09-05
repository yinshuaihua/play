package models;

import play.db.ebean.Model;

import javax.persistence.*;

@Entity
@Table(name = "user_d")
public class UserD extends Model {

    public static Finder<Long, UserD> find = new Finder<Long, User>(Long.class, UserD.class);
    @Id
    public Long id;

    @Column(name = "user_name")
    public String userName;

    @Column(name = "user_email")
    public String userEmail;

    @Column(name = "user_password")
    public String userPassword;



    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
