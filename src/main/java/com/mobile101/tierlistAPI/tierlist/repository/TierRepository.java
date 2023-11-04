package com.mobile101.tierlistAPI.tierlist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile101.tierlistAPI.tierlist.model.Category;
import com.mobile101.tierlistAPI.tierlist.model.Item;
import com.mobile101.tierlistAPI.tierlist.model.Tier;

@Repository
public interface TierRepository extends JpaRepository<Tier, Long>{
    Tier findById(long id);
    Tier findByName(String name);
    List<Tier> findByCategory(Category category);
    Optional<Tier> findOptionalById(long id);
}
