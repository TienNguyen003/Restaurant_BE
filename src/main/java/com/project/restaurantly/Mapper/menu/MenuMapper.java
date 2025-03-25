package com.project.restaurantly.Mapper.menu;

import com.project.restaurantly.Entity.menu.Menu;
import com.project.restaurantly.dto.request.menu.MenuRequest;
import com.project.restaurantly.dto.response.menu.MenuResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MenuMapper {
    @Mapping(target = "listSub", ignore = true)
    Menu toMenu(MenuRequest request);

    MenuResponse toMenuRespone(Menu menu);

    @Mapping(target = "listSub", ignore = true)
    void updateMenu(@MappingTarget Menu menu, MenuRequest request);
}
