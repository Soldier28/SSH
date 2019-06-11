package com.mikey.youngvolunteer.models.service.sysuser;

import com.mikey.youngvolunteer.common.PageBean;
import com.mikey.youngvolunteer.models.model.SysUserEntity;

/**
 * @Program: YoungVolunteer
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-03 23:46
 * @Describe：
 **/
public interface SysUserService {

    /**
     * 添加
     * @param sysUserEntity
     */
    public void addSysUser(SysUserEntity sysUserEntity);

    /**
     * 删除
     * @param sysUserEntity
     */
    public void deleteSysUser(SysUserEntity sysUserEntity);

    /**
     * 修改
     * @param sysUserEntity
     */
    public void updateSysUser(SysUserEntity sysUserEntity);

    /**
     * 查询
     * @param sysUserEntity
     * @return
     */
    public SysUserEntity findOneSysUsery(SysUserEntity sysUserEntity);

    /**
     * 查询
     * @return
     */
    public PageBean findAllSysUser(String key, PageBean<SysUserEntity> pageBean);

    /**
     * 批量删除
     * @param Ids
     */
    public void deleteAllSysUser(String[] Ids);
}
