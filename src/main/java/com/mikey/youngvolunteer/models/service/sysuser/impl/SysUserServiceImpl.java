package com.mikey.youngvolunteer.models.service.sysuser.impl;

import com.mikey.youngvolunteer.common.PageBean;
import com.mikey.youngvolunteer.models.dao.sysuser.SysUserDao;
import com.mikey.youngvolunteer.models.model.SysUserEntity;
import com.mikey.youngvolunteer.models.service.sysuser.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Program: YoungVolunteer
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-04 00:31
 * @Describe：
 **/
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public void addSysUser(SysUserEntity sysUserEntity) {
        sysUserDao.addSysUser(sysUserEntity);
    }

    @Override
    public void deleteSysUser(SysUserEntity sysUserEntity) {
        sysUserDao.deleteSysUser(sysUserEntity);
    }

    @Override
    public void updateSysUser(SysUserEntity sysUserEntity) {
        sysUserDao.updateSysUser(sysUserEntity);
    }

    @Override
    public SysUserEntity findOneSysUsery(SysUserEntity sysUserEntity) {
        return sysUserDao.findOneSysUsery(sysUserEntity);
    }

    @Override
    public PageBean findAllSysUser(String key, PageBean<SysUserEntity> pageBean) {

        return sysUserDao.findAllSysUser(key, pageBean);
    }

    @Override
    public void deleteAllSysUser(String[] Ids) {

        sysUserDao.deleteAllSysUser(Ids);

    }
}
