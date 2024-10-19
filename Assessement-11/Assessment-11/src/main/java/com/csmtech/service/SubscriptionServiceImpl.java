package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.model.SubscriptionMaster;
import com.csmtech.repository.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	private SubscriptionRepository subscriptionRepository;
	@Override
	public List<SubscriptionMaster> getAllSubscription(Integer libraryId) {
		
		return subscriptionRepository.getAllSubscription(libraryId);
	}
	@Override
	public SubscriptionMaster getById(Integer subscriptionId) {
		return subscriptionRepository.getById(subscriptionId);
	}

}
