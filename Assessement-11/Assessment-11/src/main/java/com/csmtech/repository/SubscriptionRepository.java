package com.csmtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.csmtech.model.SubscriptionMaster;
@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionMaster, Integer> {

	@Query("From SubscriptionMaster where libraryId=:libraryId")
	List<SubscriptionMaster> getAllSubscription(Integer libraryId);

}
