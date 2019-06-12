package com.ssh.models.dao.volunteersignup.impl;

import com.ssh.common.PageBean;
import com.ssh.models.dao.volunteersignup.VolunteerSignUpDao;
import com.ssh.models.model.VolunteerSignUpEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: SSH
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-06-04 00:31
 * @Describe：
 **/
@Repository
public class VolunteerSignUpDaoImpl implements VolunteerSignUpDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addVolunteerSignUp(VolunteerSignUpEntity volunteerSignUpEntity) {
        hibernateTemplate.save(volunteerSignUpEntity);
    }

    @Override
    public void deleteVolunteerSignUp(VolunteerSignUpEntity volunteerSignUpEntity) {
        hibernateTemplate.delete(volunteerSignUpEntity);
    }

    @Override
    public void updateVolunteerSignUp(VolunteerSignUpEntity volunteerSignUpEntity) {
        hibernateTemplate.update(volunteerSignUpEntity);
    }

    @Override
    public VolunteerSignUpEntity findOneVolunteerSignUpy(VolunteerSignUpEntity volunteerSignUpEntity) {
        return (VolunteerSignUpEntity) hibernateTemplate.find("from com.mikey.SSH.models.model.VolunteerSignUpEntity where signUpId = ?0", volunteerSignUpEntity.getSignUpId()).get(0);
    }

    @Override
    public PageBean findAllVolunteerSignUp(String key, PageBean<VolunteerSignUpEntity> pageBean) {

        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(VolunteerSignUpEntity.class);

        if (key != null && !key.equals("")) {
            //搜索
            List list = criteria.add(
                    Restrictions.or(Restrictions.like("volunteerScore", key, MatchMode.ANYWHERE),
                            Restrictions.or(Restrictions.like("volunteerId", key, MatchMode.ANYWHERE)),
                            Restrictions.or(Restrictions.like("activityId", key, MatchMode.ANYWHERE))))
                    .setFirstResult((pageBean.getCurrPage() - 1) * pageBean.getPageSize() )
                    .setMaxResults((pageBean.getCurrPage() - 1) * pageBean.getPageSize() + pageBean.getPageSize()).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

//            System.out.println("条件查询保安人员："+pageBean+"\n"+list);

            pageBean.setRows(list);

        } else {
            List list = criteria.setFirstResult((pageBean.getCurrPage() - 1) * pageBean.getPageSize())
                    .setMaxResults((pageBean.getCurrPage() - 1) * pageBean.getPageSize() + pageBean.getPageSize()).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            System.out.println(pageBean+"\n"+list);
            pageBean.setRows(list);
        }

        session.close();

        return pageBean;
    }

    @Override
    public void deleteAllVolunteerSignUp(String[] Ids) {

        List<VolunteerSignUpEntity> list = new ArrayList<>();

        for (String id : Ids) {
            VolunteerSignUpEntity volunteerSignUpEntity = new VolunteerSignUpEntity();
            volunteerSignUpEntity.setSignUpId(Integer.parseInt(id));
            list.add(volunteerSignUpEntity);
        }
        hibernateTemplate.deleteAll(list);
    }
}
