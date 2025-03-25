package com.project.restaurantly.Service.restaurant;

import com.project.restaurantly.Entity.PageCustom;
import com.project.restaurantly.Entity.restaurant.Branches;
import com.project.restaurantly.Exception.AppException;
import com.project.restaurantly.Exception.ErrorCode;
import com.project.restaurantly.Mapper.restaurant.BranchesMapper;
import com.project.restaurantly.dto.request.restaurant.BranchesRequest;
import com.project.restaurantly.dto.response.restaurant.BranchesResponse;
import com.project.restaurantly.repository.restaurant.BranchesRepository;
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
public class BranchesService {
    BranchesRepository branchesRepository;
    BranchesMapper branchesMapper;

    public BranchesResponse create(BranchesRequest request) {
        Branches branches = branchesMapper.toBranches(request);

        return branchesMapper.toBranchesResponse(branchesRepository.save(branches));
    }

    public List<BranchesResponse> getAll(int status) {
        var permission = branchesRepository.findByStt(status);
        return permission.stream().map(branchesMapper::toBranchesResponse).toList();
    }

    public List<BranchesResponse> searchAll(String name, int pageNumber, int pageSize, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return branchesRepository.findByName(pageable, status)
                .stream()
                .map(branchesMapper::toBranchesResponse)
                .toList();
    }

    public PageCustom getPagination(int pageNumber, int size, String name, int status) {
        Pageable pageable = PageRequest.of(pageNumber - 1, size);
        Page<Branches> page = branchesRepository.findByName(pageable, status);
        return PageCustom.builder()
                .totalPages(String.valueOf(page.getTotalPages()))
                .totalItems(String.valueOf(page.getTotalElements()))
                .totalItemsPerPage(String.valueOf(page.getNumberOfElements()))
                .currentPage(String.valueOf(pageNumber))
                .build();
    }

    public BranchesResponse get(Long id) {
        return branchesMapper.toBranchesResponse(branchesRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED)));
    }

    public BranchesResponse update(BranchesRequest request, Long id) {
        Branches branches = branchesRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));

        branchesMapper.updateBranches(branches, request);

        return branchesMapper.toBranchesResponse(branchesRepository.save(branches));
    }

    public void delete(Long id) {
        Branches branches = branchesRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MENU_NOT_EXISTED));
        branches.setStatus(0);
        branchesRepository.save(branches);
    }
}
