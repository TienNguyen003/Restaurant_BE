package com.project.restaurantly.Service.restaurant;

import com.project.restaurantly.Entity.PageCustom;
import com.project.restaurantly.Entity.restaurant.Tables;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.restaurant.TablesMapper;
import com.project.restaurantly.dto.request.restaurant.TablesRequest;
import com.project.restaurantly.dto.response.restaurant.TablesResponse;
import com.project.restaurantly.repository.restaurant.TablesRepository;
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
public class TablesService {
    TablesRepository tableRepository;
    TablesMapper tableMapper;

    public TablesResponse create(TablesRequest request) {
        Tables table = tableMapper.toTables(request);

        return tableMapper.toTablesResponse(tableRepository.save(table));
    }

    public List<TablesResponse> getAll(int status) {
        var permission = tableRepository.findByStt(status);
        return permission.stream().map(tableMapper::toTablesResponse).toList();
    }

    public List<TablesResponse> searchAll(String name, int pageNumber, int pageSize, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return tableRepository.findByName(pageable, status)
                .stream()
                .map(tableMapper::toTablesResponse)
                .toList();
    }

    public PageCustom getPagination(int pageNumber, int size, String name, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, size);
        Page<Tables> page = tableRepository.findByName(pageable, status);
        return PageCustom.builder()
                .totalPages(String.valueOf(page.getTotalPages()))
                .totalItems(String.valueOf(page.getTotalElements()))
                .totalItemsPerPage(String.valueOf(page.getNumberOfElements()))
                .currentPage(String.valueOf(pageNumber))
                .build();
    }

    public TablesResponse get(Long id) {
        return tableMapper.toTablesResponse(tableRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED)));
    }

    public TablesResponse update(TablesRequest request, Long id) {
        Tables table = tableRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));

        tableMapper.updateTables(table, request);

        return tableMapper.toTablesResponse(tableRepository.save(table));
    }

    public void delete(Long id) {
        Tables table = tableRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));
        table.setStatus(0);
        tableRepository.save(table);
    }
}
