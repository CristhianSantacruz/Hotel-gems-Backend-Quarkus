package com.klashz.place;

import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface IPlaceService {
    Optional<PlaceEntity> getPlaceById(ObjectId id);
    List<PlaceEntity> getAllPlaces();
    Optional<PlaceEntity> getPlacesByName(String name);
    List<PlaceEntity> getAllPlaceByCategory(String category);
    List<PlaceEntity> getPlaceByPriceLessThan(Double price);
    List<PlaceEntity> getPlaceByPriceGreaterThan(Double price);
    void savePlace(PlaceEntity place);
}
