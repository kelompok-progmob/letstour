package com.progmob.letstour.model;

public class ModelTour {
    String id, id_country, name, image, location, subtitle, description, price, overview, activities, preparation;
    int is_popular, id_category;

    public ModelTour() {
    }

    public ModelTour(String id, String id_country, String name, String image, String location, String subtitle, String description, String price, String overview, String activities, String preparation, int is_popular, int id_category) {
        this.id = id;
        this.id_country = id_country;
        this.name = name;
        this.image = image;
        this.location = location;
        this.subtitle = subtitle;
        this.description = description;
        this.price = price;
        this.overview = overview;
        this.activities = activities;
        this.preparation = preparation;
        this.is_popular = is_popular;
        this.id_category = id_category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_country() {
        return id_country;
    }

    public void setId_country(String id_country) {
        this.id_country = id_country;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public int getIs_popular() {
        return is_popular;
    }

    public void setIs_popular(int is_popular) {
        this.is_popular = is_popular;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
}
