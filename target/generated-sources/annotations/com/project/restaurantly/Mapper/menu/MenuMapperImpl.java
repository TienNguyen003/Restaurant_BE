package com.project.restaurantly.Mapper.menu;

import com.project.restaurantly.Entity.menu.Menu;
import com.project.restaurantly.Entity.menu.Submenu;
import com.project.restaurantly.dto.request.menu.MenuRequest;
import com.project.restaurantly.dto.response.menu.MenuResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class MenuMapperImpl implements MenuMapper {

    @Override
    public Menu toMenu(MenuRequest request) {
        if ( request == null ) {
            return null;
        }

        Menu.MenuBuilder menu = Menu.builder();

        menu.name( request.getName() );
        menu.status( request.getStatus() );

        return menu.build();
    }

    @Override
    public MenuResponse toMenuRespone(Menu menu) {
        if ( menu == null ) {
            return null;
        }

        MenuResponse.MenuResponseBuilder menuResponse = MenuResponse.builder();

        menuResponse.id( menu.getId() );
        menuResponse.name( menu.getName() );
        menuResponse.status( menu.getStatus() );
        List<Submenu> list = menu.getListSub();
        if ( list != null ) {
            menuResponse.listSub( new ArrayList<Submenu>( list ) );
        }

        return menuResponse.build();
    }

    @Override
    public void updateMenu(Menu menu, MenuRequest request) {
        if ( request == null ) {
            return;
        }

        menu.setName( request.getName() );
        menu.setStatus( request.getStatus() );
    }
}
