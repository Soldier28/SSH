package com.ssh.models.dao.volunteer;

import com.ssh.common.PageBean;
import com.ssh.models.model.SysVolunteerEntity;

/**
 * @Program: SSH
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-06-03 23:36
 * @Describe：
 **/
public interface VolunteerDao {

    /**
     * 添加
     * @param sysVolunteerEntity
     */
    public void addSysVolunteer(SysVolunteerEntity sysVolunteerEntity);

    /**
     * 删除
     * @param sysVolunteerEntity
     */
    public void deleteSysVolunteer(SysVolunteerEntity sysVolunteerEntity);

    /**
     * 修改
     * @param sysVolunteerEntity
     */
    public void updateSysVolunteer(SysVolunteerEntity sysVolunteerEntity);

    /**
     * 查询
     * @param sysVolunteerEntity
     * @return
     */
    public SysVolunteerEntity findOneSysVolunteery(SysVolunteerEntity sysVolunteerEntity);

    /**
     * 查询
     * @return
     */
    public PageBean findAllSysVolunteer(String key, PageBean<SysVolunteerEntity> pageBean);

    /**
     * 批量删除
     * @param Ids
     */
    public void deleteAllSysVolunteer(String[] Ids);

}
