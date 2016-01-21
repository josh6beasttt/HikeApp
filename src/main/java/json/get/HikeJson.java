package json.get;

import json.BaseJson;

@SuppressWarnings("unused")
public class HikeJson extends BaseJson {
    private double latitude;
    private double longitude;
    private String name;
    private String description;

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}