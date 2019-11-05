package com.wx.retry.service;

import com.wx.retry.model.RetryConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by jiac on 2017/12/18 09:22.
 * ClassName  : UserService
 * Description  :
 */

public interface IndexService {


    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<RetryConfig> findAll(Pageable pageable);


    RetryConfig findById(Integer id);
}
