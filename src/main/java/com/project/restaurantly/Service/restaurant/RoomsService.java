package com.project.restaurantly.Service.restaurant;

import com.project.restaurantly.Entity.PageCustom;
import com.project.restaurantly.Entity.restaurant.Rooms;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.restaurant.RoomsMapper;
import com.project.restaurantly.dto.request.restaurant.RoomsRequest;
import com.project.restaurantly.dto.response.restaurant.RoomsResponse;
import com.project.restaurantly.repository.restaurant.RoomsRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoomsService {
    RoomsRepository roomRepository;
    RoomsMapper roomMapper;

    public RoomsResponse create(RoomsRequest request) {
        Rooms rooms = roomMapper.toRooms(request);

        return roomMapper.toRoomsResponse(roomRepository.save(rooms));
    }

    public List<RoomsResponse> getAll(int status) {
        var permission = roomRepository.findByStt(status);
        return permission.stream().map(roomMapper::toRoomsResponse).toList();
    }

    public List<RoomsResponse> searchAll(String name, int pageNumber, int pageSize, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return roomRepository.findByName(name, pageable, status)
                .stream()
                .map(roomMapper::toRoomsResponse)
                .toList();
    }

    public PageCustom getPagination(int pageNumber, int size, String name, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, size);
        Page<Rooms> page = roomRepository.findByName(name, pageable, status);
        return PageCustom.builder()
                .totalPages(String.valueOf(page.getTotalPages()))
                .totalItems(String.valueOf(page.getTotalElements()))
                .totalItemsPerPage(String.valueOf(page.getNumberOfElements()))
                .currentPage(String.valueOf(pageNumber))
                .build();
    }

    public RoomsResponse get(Long id) {
        return roomMapper.toRoomsResponse(roomRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED)));
    }

    public RoomsResponse update(RoomsRequest request, Long id) {
        Rooms rooms = roomRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));

        roomMapper.updateRooms(rooms, request);

        return roomMapper.toRoomsResponse(roomRepository.save(rooms));
    }

    public void delete(Long id) {
        Rooms rooms = roomRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));
        rooms.setStatus(0);
        roomRepository.save(rooms);
    }
}
