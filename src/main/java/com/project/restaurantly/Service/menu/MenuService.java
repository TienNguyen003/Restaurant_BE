package com.project.restaurantly.Service.menu;

import com.project.restaurantly.Entity.PageCustom;
import com.project.restaurantly.Entity.menu.Menu;
import com.project.restaurantly.Entity.menu.Submenu;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.menu.MenuMapper;
import com.project.restaurantly.dto.request.menu.MenuRequest;
import com.project.restaurantly.dto.response.menu.MenuResponse;
import com.project.restaurantly.repository.menu.MenuRepository;
import com.project.restaurantly.repository.menu.SubMenuRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MenuService {
    MenuRepository menuRespository;
    SubMenuRepository subMenuRepository;
    MenuMapper menuMapper;

    public MenuResponse create(MenuRequest request) {
        if (menuRespository.existsByName(request.getName()))
            throw new AppException(ErrorCode.MENU_EXISTED);

        var menu = menuMapper.toMenu(request);

        if (request.getListIdSub().isEmpty()) return menuMapper.toMenuRespone(menuRespository.save(menu));
        var submenu = subMenuRepository.findAllById(request.getListIdSub());
        menu.setListSub((List<Submenu>) new HashSet<>(submenu));

        menu = menuRespository.save(menu);

        return menuMapper.toMenuRespone(menu);
    }

    public List<MenuResponse> getAll(int status) {
        var permission = menuRespository.findByStt(status);
        return permission.stream().map(menuMapper::toMenuRespone).toList();
    }

    public List<MenuResponse> searchAll(String name, int pageNumber, int pageSize, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return menuRespository.findByName(name, pageable, status)
                .stream()
                .map(menuMapper::toMenuRespone)
                .toList();
    }

    public PageCustom getPagination(int pageNumber, int size, String name, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, size);
        Page<Menu> page = menuRespository.findByName(name, pageable, status);
        return PageCustom.builder()
                .totalPages(String.valueOf(page.getTotalPages()))
                .totalItems(String.valueOf(page.getTotalElements()))
                .totalItemsPerPage(String.valueOf(page.getNumberOfElements()))
                .currentPage(String.valueOf(pageNumber))
                .build();
    }

    public MenuResponse get(long id) {
        return menuMapper.toMenuRespone(menuRespository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED)));
    }

    public MenuResponse update(MenuRequest request, long id) {
        Menu menu = menuRespository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));

        menuMapper.updateMenu(menu, request);

        if (request.getListIdSub().isEmpty()) return menuMapper.toMenuRespone(menuRespository.save(menu));
        var submenu = subMenuRepository.findAllById(request.getListIdSub());
        menu.setListSub((List<Submenu>) new HashSet<>(submenu));

        return menuMapper.toMenuRespone(menuRespository.save(menu));
    }

    public void delete(long id) {
        Menu menu = menuRespository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));
        menu.setStatus(0);
        menuRespository.save(menu);
    }
}
