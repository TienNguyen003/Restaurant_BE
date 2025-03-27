package com.project.restaurantly.Mapper.order;

import com.project.restaurantly.Entity.order.Favorites;
import com.project.restaurantly.dto.request.order.FavoritesRequest;
import com.project.restaurantly.dto.response.order.FavoritesResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class FavoritesMapperImpl implements FavoritesMapper {

    @Override
    public Favorites toFavorites(FavoritesRequest request) {
        if ( request == null ) {
            return null;
        }

        Favorites.FavoritesBuilder favorites = Favorites.builder();

        favorites.user_id( request.getUser_id() );
        favorites.create_at( request.getCreate_at() );
        favorites.status( request.getStatus() );

        return favorites.build();
    }

    @Override
    public FavoritesResponse toFavoritesResponse(Favorites favorites) {
        if ( favorites == null ) {
            return null;
        }

        FavoritesResponse.FavoritesResponseBuilder favoritesResponse = FavoritesResponse.builder();

        favoritesResponse.id( favorites.getId() );
        favoritesResponse.user_id( favorites.getUser_id() );
        favoritesResponse.product( favorites.getProduct() );
        favoritesResponse.create_at( favorites.getCreate_at() );
        favoritesResponse.status( favorites.getStatus() );

        return favoritesResponse.build();
    }

    @Override
    public void updateFavorites(Favorites favorites, FavoritesRequest request) {
        if ( request == null ) {
            return;
        }

        favorites.setUser_id( request.getUser_id() );
        favorites.setCreate_at( request.getCreate_at() );
        favorites.setStatus( request.getStatus() );
    }
}
