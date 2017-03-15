package models;


import com.avaje.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="user_d")
public class UserD extends Model {


    @Id
    public Long Id;

    @Column(name = "user_name")
    public String userName;

    @Column(name = "user_email")
    public String userEmail;

    @Column(name = "user_password")
    public String userPassword;


    public static Finder<Long, UserD> find = new Finder<Long, UserD>(Long.class, UserD.class);
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public static UserD findById(java.lang.Long id){
        return find.where().eq("id",id).findUnique();
    }

    public static List<UserD> findByName(String userName){
        return find.where().eq("user_name",userName).findList();
    }

    public static List<UserD> findByEmail(String userEmail){
        return find.where().eq("user_email",userEmail).findList();
    }
}
