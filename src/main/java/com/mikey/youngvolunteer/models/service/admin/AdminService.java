package com.mikey.youngvolunteer.models.service.admin;

import com.mikey.youngvolunteer.common.PageBean;
import com.mikey.youngvolunteer.models.model.SysAdminEntity;

/**
 * @Program: YoungVolunteer
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-04 00:10
 * @Describe：
 **/
public interface AdminService {

    /**
     * 添加
     * @param sysAdminEntity
     */
    public void addAdmin(SysAdminEntity sysAdminEntity);

    /**
     * 删除
     * @param sysAdminEntity
     */
    public void deleteAdmin(SysAdminEntity sysAdminEntity);

    /**
     * 修改
     * @param sysAdminEntity
     */
    public void updateAdmin(SysAdminEntity sysAdminEntity);

    /**
     * 查询
     * @param sysAdminEntity
     * @return
     */
    public SysAdminEntity findOneAdminy(SysAdminEntity sysAdminEntity);

    /**
     * 查询
     * @return
     */
    public PageBean findAllAdmin(String key, PageBean<SysAdminEntity> pageBean);

    /**
     * 批量删除
     * @param Ids
     */
    public void deleteAllAdmin(String[] Ids);
}
