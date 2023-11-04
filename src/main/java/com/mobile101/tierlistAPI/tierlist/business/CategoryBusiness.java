package com.mobile101.tierlistAPI.tierlist.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile101.tierlistAPI.tierlist.json.CategoryJson;
import com.mobile101.tierlistAPI.tierlist.model.Category;
import com.mobile101.tierlistAPI.tierlist.payload.CategoryPayload;
import com.mobile101.tierlistAPI.tierlist.service.CategoryService;

@Service
public class CategoryBusiness {
    @Autowired
    CategoryService categoryService;

    public List<CategoryJson> getListCategory() {
        return CategoryJson.packJsons(categoryService.findAllCategories());
    }

    public CategoryJson getCategoryId(long id) {
        return CategoryJson.packJson(categoryService.findById(id));
    }

    public Long saveCategory(CategoryPayload categoryPayload) {
        Category category = new Category(
                categoryPayload.getName(),
                categoryPayload.getImage());
        categoryService.save(category);
        return category.getId();
    }

    public void updateCategory(long id, CategoryPayload categoryPayload) {
        Category categoryData = categoryService.findById(id);
        categoryData.setName(categoryPayload.getName());
        categoryService.save(categoryData);
    }

    public void deleteCategory(long id) {
        categoryService.deleteById(id);
    }
}