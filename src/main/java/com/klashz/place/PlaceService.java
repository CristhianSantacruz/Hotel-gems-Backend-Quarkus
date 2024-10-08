package com.klashz.place;

import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PlaceService implements IPlaceService {
    @Override
    public Optional<PlaceEntity> getPlaceById(ObjectId id) {
        return PlaceEntity.findByIdOptional(id);
    }
    @Override
    public List<PlaceEntity> getAllPlaces() {
        return PlaceEntity.listAll();
    }
    @Override
    public Optional<PlaceEntity> getPlacesByName(String name) {
        return PlaceEntity.find("name").firstResultOptional();
    }
    @Override
    public List<PlaceEntity> getAllPlaceByCategory(String category) {
        CategoryPlace categoryPlace = CategoryPlace.valueOf(category);
        return PlaceEntity.list("category",categoryPlace);
    }
    @Override
    public List<PlaceEntity> getPlaceByPriceLessThan(Double price) {
        return PlaceEntity.find("price >= ?1",price).list();
    }
    @Override
    public List<PlaceEntity> getPlaceByPriceGreaterThan(Double price) {
        return PlaceEntity.find("price <= ?1",price).list();
    }

    @Override
    public void savePlace(PlaceEntity place) {
        place.persist();
    }
}
