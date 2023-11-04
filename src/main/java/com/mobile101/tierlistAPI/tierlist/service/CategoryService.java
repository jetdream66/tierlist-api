package com.mobile101.tierlistAPI.tierlist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile101.tierlistAPI.tierlist.model.Category;
import com.mobile101.tierlistAPI.tierlist.repository.CategoryRepository;
import com.mobile101.tierlistAPI.tierlist.service.intf.ICategory;

@Service
public class CategoryService implements ICategory{
    
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategories() {
       return categoryRepository.findAll();
    }

    @Override
    public Category findById(long id) {
       return categoryRepository.findById(id);
    }

    @Override
    public Category findByName(String name) {
       return categoryRepository.findByName(name);
    }

    @Override
    public Category save(Category category) {
       return categoryRepository.save(category);
    }

    @Override
    public void deleteById(long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> findOptionalById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOptionalById'");
    }
}
