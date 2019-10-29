package com.jcohy.scis.repository;

import com.jcohy.scis.model.RetryConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jiac on 2018/4/2.
 * Description  :
 */
public interface IndexRepository extends JpaRepository<RetryConfig,Integer> {




}
