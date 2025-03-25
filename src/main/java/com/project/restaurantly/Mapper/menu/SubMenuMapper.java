package com.project.restaurantly.Mapper.menu;

import com.project.restaurantly.Entity.menu.Submenu;
import com.project.restaurantly.dto.request.menu.SubMenuRequest;
import com.project.restaurantly.dto.response.menu.SubMenuResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SubMenuMapper {
    Submenu toSubMenu(SubMenuRequest request);

    SubMenuResponse toSubMenuResponse(Submenu user);

    void updateSubMenu(@MappingTarget Submenu user, SubMenuRequest request);
}
