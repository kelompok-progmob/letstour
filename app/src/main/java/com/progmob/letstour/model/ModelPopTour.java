package com.progmob.letstour.model;

public class ModelPopTour {
    String id, id_country, name, image, location, subtitle, description;
    int is_popular;

    public ModelPopTour() {
    }

    public ModelPopTour(String id, String id_country, String name, String image, String location, int is_popular, String subtitle, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.location = location;
        this.id_country = id_country;
        this.is_popular = is_popular;
        this.subtitle = subtitle;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getId_country() {
        return id_country;
    }

    public void setId_country(String id_country) {
        this.id_country = id_country;
    }

    public int getIs_popular() {
        return is_popular;
    }

    public void setIs_popular(int is_popular) {
        this.is_popular = is_popular;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
