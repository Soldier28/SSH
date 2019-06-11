package com.mikey.youngvolunteer.models.service.admin.impl;

import com.mikey.youngvolunteer.common.PageBean;
import com.mikey.youngvolunteer.models.dao.admin.AdminDao;
import com.mikey.youngvolunteer.models.model.SysAdminEntity;
import com.mikey.youngvolunteer.models.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Program: YoungVolunteer
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-04 00:10
 * @Describe：
 **/
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public void addAdmin(SysAdminEntity sysAdminEntity) {
        adminDao.addAdmin(sysAdminEntity);
    }

    @Override
    public void deleteAdmin(SysAdminEntity sysAdminEntity) {
        adminDao.deleteAdmin(sysAdminEntity);
    }

    @Override
    public void updateAdmin(SysAdminEntity sysAdminEntity) {
        adminDao.updateAdmin(sysAdminEntity);
    }

    @Override
    public SysAdminEntity findOneAdminy(SysAdminEntity sysAdminEntity) {
        return adminDao.findOneAdminy(sysAdminEntity);
    }

    @Override
    public PageBean findAllAdmin(String key, PageBean<SysAdminEntity> pageBean) {

        return adminDao.findAllAdmin(key,pageBean);
    }

    @Override
    public void deleteAllAdmin(String[] Ids) {

        adminDao.deleteAllAdmin(Ids);

    }
}
