package com.project.restaurantly.Mapper.category;

import com.project.restaurantly.Entity.category.Category;
import com.project.restaurantly.dto.request.category.CategoryRequest;
import com.project.restaurantly.dto.response.category.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(CategoryRequest request);

    CategoryResponse toCategoryResponse(Category category);

    void updateCategory(@MappingTarget Category category, CategoryRequest request);
}
