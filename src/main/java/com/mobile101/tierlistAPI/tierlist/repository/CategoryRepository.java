package com.mobile101.tierlistAPI.tierlist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile101.tierlistAPI.tierlist.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    Category findById(long id);
    Category findByName(String name);
    Optional<Category> findOptionalById(long id);
}
