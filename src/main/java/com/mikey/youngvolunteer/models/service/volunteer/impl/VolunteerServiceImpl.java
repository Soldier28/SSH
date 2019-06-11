package com.mikey.youngvolunteer.models.service.volunteer.impl;

import com.mikey.youngvolunteer.common.PageBean;
import com.mikey.youngvolunteer.models.dao.volunteer.VolunteerDao;
import com.mikey.youngvolunteer.models.model.SysVolunteerEntity;
import com.mikey.youngvolunteer.models.service.volunteer.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Program: YoungVolunteer
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-03 23:37
 * @Describe：
 **/
@Service
public class VolunteerServiceImpl implements VolunteerService {

    @Autowired
    private VolunteerDao volunteerDao;
    @Override
    public void addSysVolunteer(SysVolunteerEntity sysVolunteerEntity) {
        volunteerDao.addSysVolunteer(sysVolunteerEntity);
    }

    @Override
    public void deleteSysVolunteer(SysVolunteerEntity sysVolunteerEntity) {
        volunteerDao.deleteSysVolunteer(sysVolunteerEntity);
    }

    @Override
    public void updateSysVolunteer(SysVolunteerEntity sysVolunteerEntity) {
        volunteerDao.updateSysVolunteer(sysVolunteerEntity);
    }

    @Override
    public SysVolunteerEntity findOneSysVolunteery(SysVolunteerEntity sysVolunteerEntity) {
        return volunteerDao.findOneSysVolunteery(sysVolunteerEntity);
    }

    @Override
    public PageBean findAllSysVolunteer(String key, PageBean<SysVolunteerEntity> pageBean) {

        return volunteerDao.findAllSysVolunteer(key, pageBean);
    }

    @Override
    public void deleteAllSysVolunteer(String[] Ids) {

        volunteerDao.deleteAllSysVolunteer(Ids);

    }
}
