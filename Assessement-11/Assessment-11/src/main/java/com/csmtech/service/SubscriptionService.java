package com.csmtech.service;

import java.util.List;

import com.csmtech.model.SubscriptionMaster;

public interface SubscriptionService {
	List<SubscriptionMaster> getAllSubscription(Integer libraryId);

	SubscriptionMaster getById(Integer subscriptionId);
}
