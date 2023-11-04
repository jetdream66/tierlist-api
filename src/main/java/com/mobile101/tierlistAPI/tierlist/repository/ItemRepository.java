package com.mobile101.tierlistAPI.tierlist.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mobile101.tierlistAPI.tierlist.model.Category;
import com.mobile101.tierlistAPI.tierlist.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
    Item findById(long id);
    List<Item> findByCategory(Category category);
    Item findByName(String name);
    Optional<Item> findOptionalById(long id);
    
}
