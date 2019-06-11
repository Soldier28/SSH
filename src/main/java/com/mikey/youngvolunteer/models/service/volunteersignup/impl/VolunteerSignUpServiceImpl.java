package com.mikey.youngvolunteer.models.service.volunteersignup.impl;

import com.mikey.youngvolunteer.common.PageBean;
import com.mikey.youngvolunteer.models.dao.volunteersignup.VolunteerSignUpDao;
import com.mikey.youngvolunteer.models.model.VolunteerSignUpEntity;
import com.mikey.youngvolunteer.models.service.volunteersignup.VolunteerSignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Program: YoungVolunteer
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-04 00:31
 * @Describe：
 **/
@Service
public class VolunteerSignUpServiceImpl implements VolunteerSignUpService {

    @Autowired
    private VolunteerSignUpDao volunteerSignUpDao;

    @Override
    public void addVolunteerSignUp(VolunteerSignUpEntity volunteerSignUpEntity) {
        volunteerSignUpDao.addVolunteerSignUp(volunteerSignUpEntity);
    }

    @Override
    public void deleteVolunteerSignUp(VolunteerSignUpEntity volunteerSignUpEntity) {
        volunteerSignUpDao.deleteVolunteerSignUp(volunteerSignUpEntity);
    }

    @Override
    public void updateVolunteerSignUp(VolunteerSignUpEntity volunteerSignUpEntity) {
        volunteerSignUpDao.updateVolunteerSignUp(volunteerSignUpEntity);
    }

    @Override
    public VolunteerSignUpEntity findOneVolunteerSignUpy(VolunteerSignUpEntity volunteerSignUpEntity) {
        return volunteerSignUpDao.findOneVolunteerSignUpy(volunteerSignUpEntity);
    }

    @Override
    public PageBean findAllVolunteerSignUp(String key, PageBean<VolunteerSignUpEntity> pageBean) {
        return volunteerSignUpDao.findAllVolunteerSignUp(key, pageBean);
    }

    @Override
    public void deleteAllVolunteerSignUp(String[] Ids) {
        volunteerSignUpDao.deleteAllVolunteerSignUp(Ids);
    }
}
