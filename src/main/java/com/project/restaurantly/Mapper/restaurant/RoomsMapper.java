package com.project.restaurantly.Mapper.restaurant;

import com.project.restaurantly.Entity.restaurant.Rooms;
import com.project.restaurantly.dto.request.restaurant.RoomsRequest;
import com.project.restaurantly.dto.response.restaurant.RoomsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoomsMapper {
    Rooms toRooms(RoomsRequest request);

    RoomsResponse toRoomsResponse(Rooms rooms);

    void updateRooms(@MappingTarget Rooms rooms, RoomsRequest request);
}
