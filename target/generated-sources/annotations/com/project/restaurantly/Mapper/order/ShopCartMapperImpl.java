package com.project.restaurantly.Mapper.order;

import com.project.restaurantly.Entity.order.ShopCart;
import com.project.restaurantly.dto.request.order.ShopCartRequest;
import com.project.restaurantly.dto.response.order.ShopCartResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class ShopCartMapperImpl implements ShopCartMapper {

    @Override
    public ShopCart toCart(ShopCartRequest request) {
        if ( request == null ) {
            return null;
        }

        ShopCart.ShopCartBuilder shopCart = ShopCart.builder();

        shopCart.user_id( request.getUser_id() );
        shopCart.quantity( request.getQuantity() );
        shopCart.create_at( request.getCreate_at() );
        shopCart.status( request.getStatus() );

        return shopCart.build();
    }

    @Override
    public ShopCartResponse toCartResponse(ShopCart cart) {
        if ( cart == null ) {
            return null;
        }

        ShopCartResponse.ShopCartResponseBuilder shopCartResponse = ShopCartResponse.builder();

        shopCartResponse.id( cart.getId() );
        shopCartResponse.user_id( cart.getUser_id() );
        shopCartResponse.product( cart.getProduct() );
        shopCartResponse.quantity( cart.getQuantity() );
        shopCartResponse.create_at( cart.getCreate_at() );
        shopCartResponse.status( cart.getStatus() );

        return shopCartResponse.build();
    }

    @Override
    public void updateCart(ShopCart cart, ShopCartRequest request) {
        if ( request == null ) {
            return;
        }

        cart.setUser_id( request.getUser_id() );
        cart.setQuantity( request.getQuantity() );
        cart.setCreate_at( request.getCreate_at() );
        cart.setStatus( request.getStatus() );
    }
}
