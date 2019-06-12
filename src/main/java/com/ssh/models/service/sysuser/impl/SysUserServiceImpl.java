package com.ssh.models.service.sysuser.impl;

import com.ssh.common.PageBean;
import com.ssh.models.dao.sysuser.SysUserDao;
import com.ssh.models.model.SysUserEntity;
import com.ssh.models.service.sysuser.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Program: SSH
 * @Author: soldier
 * @Email： 583403411@qq.com
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
