package com.ssh.models.service.admin.impl;

import com.ssh.common.PageBean;
import com.ssh.models.dao.admin.AdminDao;
import com.ssh.models.model.SysAdminEntity;
import com.ssh.models.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Program: SSH
 * @Author: soldier
 * @Email： 583403411@qq.com
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
