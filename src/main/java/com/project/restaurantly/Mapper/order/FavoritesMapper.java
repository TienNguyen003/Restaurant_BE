package com.project.restaurantly.Mapper.order;

import com.project.restaurantly.Entity.order.Favorites;
import com.project.restaurantly.dto.request.order.FavoritesRequest;
import com.project.restaurantly.dto.response.order.FavoritesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FavoritesMapper {
    Favorites toFavorites(FavoritesRequest request);

    FavoritesResponse toFavoritesResponse(Favorites favorites);

    void updateFavorites(@MappingTarget Favorites favorites, FavoritesRequest request);
}
