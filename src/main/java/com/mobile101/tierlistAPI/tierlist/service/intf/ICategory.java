package com.mobile101.tierlistAPI.tierlist.service.intf;

import java.util.List;
import java.util.Optional;

import com.mobile101.tierlistAPI.tierlist.model.Category;

public interface ICategory {
    List<Category> findAllCategories();
    Category findById(long id);
    Category findByName(String name);
    Category save(Category category);
    void deleteById(long id);
    Optional<Category> findOptionalById(long id);
}
