package com.project.restaurantly.Service.order;

import com.project.restaurantly.Entity.PageCustom;
import com.project.restaurantly.Entity.order.Favorites;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.order.FavoritesMapper;
import com.project.restaurantly.dto.request.order.FavoritesRequest;
import com.project.restaurantly.dto.response.order.FavoritesResponse;
import com.project.restaurantly.repository.order.FavoritesRepository;
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
public class FavoritesService {
    FavoritesRepository favoriteRepository;
    FavoritesMapper favoriteMapper;

    public FavoritesResponse create(FavoritesRequest request) {
        Favorites favorites = favoriteMapper.toFavorites(request);

        return favoriteMapper.toFavoritesResponse(favoriteRepository.save(favorites));
    }

    public List<FavoritesResponse> getAll(int status) {
        var permission = favoriteRepository.findByStt(status);
        return permission.stream().map(favoriteMapper::toFavoritesResponse).toList();
    }

    public List<FavoritesResponse> searchAll(String name, int pageNumber, int pageSize, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return favoriteRepository.findByName(pageable, status)
                .stream()
                .map(favoriteMapper::toFavoritesResponse)
                .toList();
    }

    public PageCustom getPagination(int pageNumber, int size, String name, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, size);
        Page<Favorites> page = favoriteRepository.findByName(pageable, status);
        return PageCustom.builder()
                .totalPages(String.valueOf(page.getTotalPages()))
                .totalItems(String.valueOf(page.getTotalElements()))
                .totalItemsPerPage(String.valueOf(page.getNumberOfElements()))
                .currentPage(String.valueOf(pageNumber))
                .build();
    }

    public FavoritesResponse get(Long id) {
        return favoriteMapper.toFavoritesResponse(favoriteRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED)));
    }

    public FavoritesResponse update(FavoritesRequest request, Long id) {
        Favorites favorites = favoriteRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));

        favoriteMapper.updateFavorites(favorites, request);

        return favoriteMapper.toFavoritesResponse(favoriteRepository.save(favorites));
    }

    public void delete(Long id) {
        Favorites favorites = favoriteRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));
        favorites.setStatus(0);
        favoriteRepository.save(favorites);
    }
}
