package com.example.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.NewsDetails;
@Repository
public interface NewsDetailsRepository extends CrudRepository<NewsDetails, Integer> {
	@Query("SELECT d FROM NewsDetails d WHERE d.idnews.id= :idnews")
	NewsDetails findNewsDetailsByIdNews(@Param("idnews") int idnews);
	
}
