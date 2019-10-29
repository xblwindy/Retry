package com.jcohy.scis.controller;

import com.jcohy.scis.common.PageJson;
import com.jcohy.scis.model.*;
import com.jcohy.scis.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/student")
public class IndexController extends BaseController{

    @Autowired
    private IndexService indexService;


    @GetMapping("/list")
    @ResponseBody
    public PageJson<RetryConfig> all(ModelMap map){
        PageRequest pageRequest = getPageRequest();
        Page<RetryConfig> retryConfigs = indexService.findAll(pageRequest);
        PageJson<RetryConfig> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(retryConfigs.getContent().size());
        page.setData(retryConfigs.getContent());
        return page;
    }

    @GetMapping("/form")
    public String form(@RequestParam(required = false) Integer id, ModelMap map){
        if(id != null){
            RetryConfig retryConfig = indexService.findById(id);
            map.put("retryConfig",retryConfig);
        }
        return "admin/student/form";
    }



}
