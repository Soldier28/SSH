package com.mikey.youngvolunteer.models.service.login.impl;

import com.mikey.youngvolunteer.common.R;
import com.mikey.youngvolunteer.models.dao.login.LoginDao;
import com.mikey.youngvolunteer.models.model.SysUserEntity;
import com.mikey.youngvolunteer.models.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Program: Ped_Moni
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
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
