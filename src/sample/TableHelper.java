package sample;

import javafx.scene.control.TableView;

public class TableHelper {

    private String firstName;
    private String lastName;
    private String homePhone;
    private String workPhone;
    private String mobilePhone;

    public TableHelper() {
        this.firstName = "";
        this.lastName = "";
        this.homePhone = "";
        this.workPhone = "";
        this.mobilePhone = "";
    }

    public TableHelper(String firstName, String lastName, String homePhone, String workPhone, String mobilePhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhone = homePhone;
        this.workPhone = workPhone;
        this.mobilePhone = mobilePhone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
