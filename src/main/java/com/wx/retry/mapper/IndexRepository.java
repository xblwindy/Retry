package com.wx.retry.mapper;

import com.wx.retry.model.RetryConfig;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IndexRepository extends JpaRepository<RetryConfig,Integer> {




}
