package com.example.repository;
import com.example.model.*;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryNewsRepository extends CrudRepository<CategoryNews, Integer> {
	
}
