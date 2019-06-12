package com.ssh.models.service.login.impl;

import com.ssh.common.R;
import com.ssh.models.dao.login.LoginDao;
import com.ssh.models.model.SysUserEntity;
import com.ssh.models.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Program: SSH
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-05-01 20:54
 * @Describe：
 **/
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    /**
     * 用户登入
     * @param sysUserEntity
     * @return
     */
    @Override
    public R userLogin(SysUserEntity sysUserEntity) {

        return loginDao.userLogin(sysUserEntity);
    }

    /**
     * 修改密码
     * @param sysUserEntity
     * @param newPassword
     * @return
     */
    @Override
    public R updatePassword(SysUserEntity sysUserEntity,String newPassword) {

        return loginDao.updatePassword(sysUserEntity,newPassword);
    }
}
