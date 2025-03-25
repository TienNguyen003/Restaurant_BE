package com.project.restaurantly.Service.restaurant;

import com.project.restaurantly.Entity.PageCustom;
import com.project.restaurantly.Entity.restaurant.Floors;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.restaurant.FloorsMapper;
import com.project.restaurantly.dto.request.restaurant.FloorsRequest;
import com.project.restaurantly.dto.response.restaurant.FloorsResponse;
import com.project.restaurantly.repository.restaurant.FloorsRepository;
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
public class FloorsService {
    FloorsRepository floorRepository;
    FloorsMapper floorMapper;

    public FloorsResponse create(FloorsRequest request) {
        Floors floors = floorMapper.toFloors(request);

        return floorMapper.toFloorsResponse(floorRepository.save(floors));
    }

    public List<FloorsResponse> getAll(int status) {
        var permission = floorRepository.findByStt(status);
        return permission.stream().map(floorMapper::toFloorsResponse).toList();
    }

    public List<FloorsResponse> searchAll(String name, int pageNumber, int pageSize, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return floorRepository.findByName(name, pageable, status)
                .stream()
                .map(floorMapper::toFloorsResponse)
                .toList();
    }

    public PageCustom getPagination(int pageNumber, int size, String name, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, size);
        Page<Floors> page = floorRepository.findByName(name, pageable, status);
        return PageCustom.builder()
                .totalPages(String.valueOf(page.getTotalPages()))
                .totalItems(String.valueOf(page.getTotalElements()))
                .totalItemsPerPage(String.valueOf(page.getNumberOfElements()))
                .currentPage(String.valueOf(pageNumber))
                .build();
    }

    public FloorsResponse get(Long id) {
        return floorMapper.toFloorsResponse(floorRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED)));
    }

    public FloorsResponse update(FloorsRequest request, Long id) {
        Floors floors = floorRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));

        floorMapper.updateFloors(floors, request);

        return floorMapper.toFloorsResponse(floorRepository.save(floors));
    }

    public void delete(Long id) {
        Floors floors = floorRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));
        floors.setStatus(0);
        floorRepository.save(floors);
    }
}
