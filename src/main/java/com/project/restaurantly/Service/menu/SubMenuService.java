package com.project.restaurantly.Service.menu;

import com.project.restaurantly.Entity.PageCustom;
import com.project.restaurantly.Entity.menu.Submenu;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.menu.SubMenuMapper;
import com.project.restaurantly.dto.request.menu.SubMenuRequest;
import com.project.restaurantly.dto.response.menu.SubMenuResponse;
import com.project.restaurantly.repository.menu.SubMenuRepository;
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
public class SubMenuService {
    SubMenuRepository subMenuRespository;
    SubMenuMapper subMenuMapper;

    public SubMenuResponse create(SubMenuRequest request) {
        if(subMenuRespository.existsByName(request.getName()))
            throw new AppException(ErrorCode.ROLE_EXISTED);


        Submenu submenu = subMenuMapper.toSubMenu(request);
        submenu = subMenuRespository.save(submenu);

        return subMenuMapper.toSubMenuResponse(submenu);
    }

    public List<SubMenuResponse> getAll(){
        return subMenuRespository.findAll()
                .stream()
                .map(subMenuMapper::toSubMenuResponse)
                .toList();
    }

    public List<SubMenuResponse> searchAll(String name, int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return subMenuRespository.findByName(name, pageable)
                .stream()
                .map(subMenuMapper::toSubMenuResponse)
                .toList();
    }

    public PageCustom getPagination(int pageNumber, int size, String name){
        Pageable pageable = PageRequest.of(pageNumber - 1, size);
        Page<Submenu> page = subMenuRespository.findByName(name, pageable);
        return PageCustom.builder()
                .totalPages(String.valueOf(page.getTotalPages()))
                .totalItems(String.valueOf(page.getTotalElements()))
                .totalItemsPerPage(String.valueOf(page.getNumberOfElements()))
                .currentPage(String.valueOf(pageNumber))
                .build();
    }

    public SubMenuResponse get(long id){
        return subMenuMapper.toSubMenuResponse(subMenuRespository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.SUB_MENU_NOT_EXISTED)));
    }

    public SubMenuResponse update(SubMenuRequest request, long id){
        Submenu subMenu = subMenuRespository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.SUB_MENU_NOT_EXISTED));
        subMenuMapper.updateSubMenu(subMenu, request);

        return subMenuMapper.toSubMenuResponse(subMenuRespository.save(subMenu));
    }

    public void delete(long id){
        Submenu subMenu = subMenuRespository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.SUB_MENU_NOT_EXISTED));
        subMenu.setStatus(0);
        subMenuRespository.save(subMenu);
    }
}
