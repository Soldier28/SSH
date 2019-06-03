package com.mikey.youngvolunteer.dao.volunteer.impl;

import com.mikey.youngvolunteer.common.PageBean;
import com.mikey.youngvolunteer.dao.volunteer.VolunteerDao;
import com.mikey.youngvolunteer.model.SysVolunteerEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Program: YoungVolunteer
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-03 23:37
 * @Describe：
 **/
@Component
public class VolunteerDaoImpl implements VolunteerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addSysVolunteer(SysVolunteerEntity sysVolunteerEntity) {

    }

    @Override
    public void deleteSysVolunteer(SysVolunteerEntity sysVolunteerEntity) {

    }

    @Override
    public void updateSysVolunteer(SysVolunteerEntity sysVolunteerEntity) {

    }

    @Override
    public SysVolunteerEntity findOneSysVolunteery(SysVolunteerEntity sysVolunteerEntity) {
        return null;
    }

    @Override
    public PageBean findAllSysVolunteer(String key, PageBean<SysVolunteerEntity> pageBean) {
        return null;
    }

    @Override
    public void deleteAllSysVolunteer(String[] Ids) {

    }
}
