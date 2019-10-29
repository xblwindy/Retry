package com.jcohy.scis.service.impl;

import com.jcohy.scis.model.RetryConfig;
import com.jcohy.scis.repository.IndexRepository;
import com.jcohy.scis.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by jiac on 2018/4/2.
 * Description  :
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexRepository indexRepository;


    @Override
    public Page<RetryConfig> findAll(Pageable pageable) {
        return indexRepository.findAll(pageable);
    }

    @Override
    public RetryConfig findById(Integer id) {
        return indexRepository.findById(id).get();
    }
}
