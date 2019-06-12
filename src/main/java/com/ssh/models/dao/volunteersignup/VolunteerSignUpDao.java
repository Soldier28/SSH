package com.ssh.models.dao.volunteersignup;

import com.ssh.common.PageBean;
import com.ssh.models.model.VolunteerSignUpEntity;

/**
 * @Program: SSH
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-06-03 23:46
 * @Describe：
 **/
public interface VolunteerSignUpDao {

    /**
     * 添加
     * @param volunteerSignUpEntity
     */
    public void addVolunteerSignUp(VolunteerSignUpEntity volunteerSignUpEntity);

    /**
     * 删除
     * @param volunteerSignUpEntity
     */
    public void deleteVolunteerSignUp(VolunteerSignUpEntity volunteerSignUpEntity);

    /**
     * 修改
     * @param volunteerSignUpEntity
     */
    public void updateVolunteerSignUp(VolunteerSignUpEntity volunteerSignUpEntity);

    /**
     * 查询
     * @param volunteerSignUpEntity
     * @return
     */
    public VolunteerSignUpEntity findOneVolunteerSignUpy(VolunteerSignUpEntity volunteerSignUpEntity);

    /**
     * 查询
     * @return
     */
    public PageBean findAllVolunteerSignUp(String key, PageBean<VolunteerSignUpEntity> pageBean);

    /**
     * 批量删除
     * @param Ids
     */
    public void deleteAllVolunteerSignUp(String[] Ids);
}
