package com.mobile101.tierlistAPI.tierlist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile101.tierlistAPI.tierlist.model.Category;
import com.mobile101.tierlistAPI.tierlist.model.TierList;
import com.mobile101.tierlistAPI.tierlist.model.TierListItem;

@Repository
public interface TierListRepository extends JpaRepository<TierList, Long>{
    TierList findById(long id);
	TierList findByUserId(long id);
	TierList findByName(String name);
	List<TierList> findByCategory(Category category);
	Optional<TierList> findOptionalById(long id);
}
