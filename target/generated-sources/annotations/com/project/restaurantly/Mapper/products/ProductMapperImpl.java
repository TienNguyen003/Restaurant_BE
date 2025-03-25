package com.project.restaurantly.Mapper.products;

import com.project.restaurantly.Entity.products.Product;
import com.project.restaurantly.dto.request.products.ProductRequest;
import com.project.restaurantly.dto.response.products.ProductResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toFoods(ProductRequest request) {
        if ( request == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.name( request.getName() );
        product.thumbnail( request.getThumbnail() );
        product.image( request.getImage() );
        product.price( request.getPrice() );
        product.discount_price( request.getDiscount_price() );
        product.discount_percentage( request.getDiscount_percentage() );
        product.des( request.getDes() );
        product.category( request.getCategory() );
        product.status( request.getStatus() );

        return product.build();
    }

    @Override
    public ProductResponse toFoodsRespone(Product menu) {
        if ( menu == null ) {
            return null;
        }

        ProductResponse.ProductResponseBuilder productResponse = ProductResponse.builder();

        productResponse.id( menu.getId() );
        productResponse.name( menu.getName() );
        productResponse.thumbnail( menu.getThumbnail() );
        productResponse.image( menu.getImage() );
        productResponse.price( menu.getPrice() );
        productResponse.discount_price( menu.getDiscount_price() );
        productResponse.discount_percentage( menu.getDiscount_percentage() );
        productResponse.des( menu.getDes() );
        productResponse.category( menu.getCategory() );
        productResponse.status( menu.getStatus() );

        return productResponse.build();
    }

    @Override
    public void updateFoods(Product menu, ProductRequest request) {
        if ( request == null ) {
            return;
        }

        menu.setName( request.getName() );
        menu.setThumbnail( request.getThumbnail() );
        menu.setImage( request.getImage() );
        menu.setPrice( request.getPrice() );
        menu.setDiscount_price( request.getDiscount_price() );
        menu.setDiscount_percentage( request.getDiscount_percentage() );
        menu.setDes( request.getDes() );
        menu.setCategory( request.getCategory() );
        menu.setStatus( request.getStatus() );
    }
}
