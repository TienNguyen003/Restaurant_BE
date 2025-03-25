package com.project.restaurantly.Mapper.menu;

import com.project.restaurantly.Entity.menu.Submenu;
import com.project.restaurantly.dto.request.menu.SubMenuRequest;
import com.project.restaurantly.dto.response.menu.SubMenuResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class SubMenuMapperImpl implements SubMenuMapper {

    @Override
    public Submenu toSubMenu(SubMenuRequest request) {
        if ( request == null ) {
            return null;
        }

        Submenu.SubmenuBuilder submenu = Submenu.builder();

        submenu.name( request.getName() );
        submenu.status( request.getStatus() );

        return submenu.build();
    }

    @Override
    public SubMenuResponse toSubMenuResponse(Submenu user) {
        if ( user == null ) {
            return null;
        }

        SubMenuResponse.SubMenuResponseBuilder subMenuResponse = SubMenuResponse.builder();

        subMenuResponse.id( user.getId() );
        subMenuResponse.name( user.getName() );
        subMenuResponse.status( user.getStatus() );

        return subMenuResponse.build();
    }

    @Override
    public void updateSubMenu(Submenu user, SubMenuRequest request) {
        if ( request == null ) {
            return;
        }

        user.setName( request.getName() );
        user.setStatus( request.getStatus() );
    }
}
