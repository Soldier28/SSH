package com.mikey.youngvolunteer.models.dao.volunteersignup;

import com.mikey.youngvolunteer.common.PageBean;
import com.mikey.youngvolunteer.models.model.VolunteerSignUpEntity;

/**
 * @Program: YoungVolunteer
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
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
