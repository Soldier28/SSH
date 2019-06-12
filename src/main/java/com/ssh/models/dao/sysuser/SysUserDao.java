package com.ssh.models.dao.sysuser;

import com.ssh.common.PageBean;
import com.ssh.models.model.SysUserEntity;

/**
 * @Program: SSH
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-06-03 23:46
 * @Describe：
 **/
public interface SysUserDao {

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
