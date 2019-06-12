package com.ssh.models.dao.login;

import com.ssh.common.R;
import com.ssh.models.model.SysUserEntity;

/**
 * @Program: SSH
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-05-01 20:55
 * @Describe：
 **/
public interface LoginDao {

    /**
     * 用户登入
     * @param sysUserEntity
     * @return
     */
    R userLogin(SysUserEntity sysUserEntity);

    /**
     * 修改密码
     * @param sysUserEntity
     * @return
     */
    R updatePassword(SysUserEntity sysUserEntity, String newPassword);

}
