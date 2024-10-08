package com.klashz.place;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
@MongoEntity(collection = "place")
public class PlaceEntity extends PanacheMongoEntity {
    @NotNull
    @NotBlank
    private String name;
    @NotNull @NotBlank
    private String description;
    @NotNull
    private Double price;
    private List<String> location;
    @NotBlank
    private String image;
    @NotNull
    private CategoryPlace categoryPlace;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<String> getLocation() {
        return location;
    }

    public void setLocation(List<String> location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public CategoryPlace getCategoryPlace() {
        return categoryPlace;
    }

    public void setCategoryPlace(CategoryPlace categoryPlace) {
        this.categoryPlace = categoryPlace;
    }
}
