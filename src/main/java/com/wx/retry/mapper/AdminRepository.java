package com.wx.retry.mapper;

import com.wx.retry.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminRepository extends JpaRepository<Admin,Integer> {

    Admin findAdminByNum(Long num);

    Admin findAdminByName(String name);

}
