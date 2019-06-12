package com.ssh.models.dao.volunteer.impl;

import com.ssh.common.PageBean;
import com.ssh.models.dao.volunteer.VolunteerDao;
import com.ssh.models.model.SysVolunteerEntity;
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
 * @Create: 2019-06-03 23:37
 * @Describe：
 **/
@Repository
public class VolunteerDaoImpl implements VolunteerDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addSysVolunteer(SysVolunteerEntity sysVolunteerEntity) {
        hibernateTemplate.save(sysVolunteerEntity);
    }

    @Override
    public void deleteSysVolunteer(SysVolunteerEntity sysVolunteerEntity) {
        hibernateTemplate.delete(sysVolunteerEntity);
    }

    @Override
    public void updateSysVolunteer(SysVolunteerEntity sysVolunteerEntity) {
        hibernateTemplate.update(sysVolunteerEntity);
    }

    @Override
    public SysVolunteerEntity findOneSysVolunteery(SysVolunteerEntity sysVolunteerEntity) {
        return (SysVolunteerEntity) hibernateTemplate.find("from com.mikey.SSH.models.model.SysVolunteerEntity where volunteerId = ?0", sysVolunteerEntity.getVolunteerId()).get(0);
    }

    @Override
    public PageBean findAllSysVolunteer(String key, PageBean<SysVolunteerEntity> pageBean) {

        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(SysVolunteerEntity.class);

        if (key != null && !key.equals("")) {
            //搜索
            List list = criteria.add(
                    Restrictions.or(Restrictions.like("userName", key, MatchMode.ANYWHERE),
                            Restrictions.or(Restrictions.like("loginPassword", key, MatchMode.ANYWHERE)),
                            Restrictions.or(Restrictions.like("loginAccount", key, MatchMode.ANYWHERE))))
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
    public void deleteAllSysVolunteer(String[] Ids) {

        List<SysVolunteerEntity> list = new ArrayList<>();

        for (String id : Ids) {
            SysVolunteerEntity sysVolunteerEntity = new SysVolunteerEntity();
            sysVolunteerEntity.setVolunteerId(Integer.parseInt(id));
            list.add(sysVolunteerEntity);
        }
        hibernateTemplate.deleteAll(list);

    }
}
