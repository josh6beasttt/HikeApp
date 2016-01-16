package json.get;

import json.BaseJson;

public class PersonJson extends BaseJson {
    private String firstName;
    private String lastName;
    private String picture;
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
