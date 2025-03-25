package com.project.restaurantly.Service.restaurant;

import com.project.restaurantly.Entity.PageCustom;
import com.project.restaurantly.Entity.restaurant.Locations;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.restaurant.LocationsMapper;
import com.project.restaurantly.dto.request.restaurant.LocationsRequest;
import com.project.restaurantly.dto.response.restaurant.LocationsResponse;
import com.project.restaurantly.repository.restaurant.LocationsRepository;
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
public class LocationsService {
    LocationsRepository locationRepository;
    LocationsMapper locationMapper;

    public LocationsResponse create(LocationsRequest request) {
        Locations locations = locationMapper.toLocations(request);

        return locationMapper.toLocationsResponse(locationRepository.save(locations));
    }

    public List<LocationsResponse> getAll(int status) {
        var permission = locationRepository.findByStt(status);
        return permission.stream().map(locationMapper::toLocationsResponse).toList();
    }

    public List<LocationsResponse> searchAll(String name, int pageNumber, int pageSize, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return locationRepository.findByName(name, pageable, status)
                .stream()
                .map(locationMapper::toLocationsResponse)
                .toList();
    }

    public PageCustom getPagination(int pageNumber, int size, String name, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, size);
        Page<Locations> page = locationRepository.findByName(name, pageable, status);
        return PageCustom.builder()
                .totalPages(String.valueOf(page.getTotalPages()))
                .totalItems(String.valueOf(page.getTotalElements()))
                .totalItemsPerPage(String.valueOf(page.getNumberOfElements()))
                .currentPage(String.valueOf(pageNumber))
                .build();
    }

    public LocationsResponse get(Long id) {
        return locationMapper.toLocationsResponse(locationRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED)));
    }

    public LocationsResponse update(LocationsRequest request, Long id) {
        Locations locations = locationRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));

        locationMapper.updateLocations(locations, request);

        return locationMapper.toLocationsResponse(locationRepository.save(locations));
    }

    public void delete(Long id) {
        Locations locations = locationRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));
        locations.setStatus(0);
        locationRepository.save(locations);
    }
}
