package com.klashz.place;

import io.netty.handler.codec.http.HttpResponseStatus;
import jakarta.enterprise.inject.build.compatible.spi.Validation;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.bson.types.ObjectId;

import java.util.Optional;

@Path("/place")
public class PlaceController {

    @Inject
    IPlaceService iPlaceService;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPlaceService(){
        return "Place Service found";
    }

    @POST
    @Path("/save")
    public Response savePlace(@Valid PlaceEntity place){
        iPlaceService.savePlace(place);
        return Response.status(201).build();
    }
    @GET
    @Path("/all")
    public Response getAllPlaces() {
        return Response.ok(iPlaceService.getAllPlaces()).build();
    }
    @GET
    @Path("/{id}")
    public Response getPlaceById(@PathParam("id") ObjectId id) {

        Optional<PlaceEntity> placeOptional = iPlaceService.getPlaceById(id);
        if(placeOptional.isPresent()){
            return Response.ok(placeOptional.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/name/{name}")
    public Response getPlaceByName(@PathParam("name") String name) {
        Optional<PlaceEntity> placeOptional = iPlaceService.getPlacesByName(name);
        if(placeOptional.isPresent()){
            return Response.ok(placeOptional.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/category/{category}")
    public Response getPlacesByCategory(@PathParam("category") String category) {
        return Response.ok(iPlaceService.getAllPlaceByCategory(category)).build();
    }

    @GET
    @Path("/price/less/{price}")
    public Response getPlacesByPrice(@PathParam("price") double price) {
        return Response.ok(iPlaceService.getPlaceByPriceLessThan(price)).build();
    }

    @GET
    @Path("/price/more/{price}")
    public Response getPlacesByPriceMore(@PathParam("price") double price) {
        return Response.ok(iPlaceService.getPlaceByPriceGreaterThan(price)).build();
    }
}
