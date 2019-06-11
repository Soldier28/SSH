package com.mikey.youngvolunteer.models.dao.sysuser.impl;

import com.mikey.youngvolunteer.common.PageBean;
import com.mikey.youngvolunteer.models.dao.sysuser.SysUserDao;
import com.mikey.youngvolunteer.models.model.SysUserEntity;
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
 * @Program: YoungVolunteer
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-06-04 00:31
 * @Describe：
 **/
@Repository
public class SysUserDaoImpl implements SysUserDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addSysUser(SysUserEntity sysUserEntity) {
        hibernateTemplate.save(sysUserEntity);
    }

    @Override
    public void deleteSysUser(SysUserEntity sysUserEntity) {
        hibernateTemplate.delete(sysUserEntity);
    }

    @Override
    public void updateSysUser(SysUserEntity sysUserEntity) {
        hibernateTemplate.update(sysUserEntity);
    }

    @Override
    public SysUserEntity findOneSysUsery(SysUserEntity sysUserEntity) {
        return (SysUserEntity) hibernateTemplate.find("from com.mikey.youngvolunteer.models.model.SysUserEntity where userId = ?0", sysUserEntity.getUserId()).get(0);
    }

    @Override
    public PageBean findAllSysUser(String key, PageBean<SysUserEntity> pageBean) {

        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(SysUserEntity.class);

        if (key != null && !key.equals("")) {
            //搜索
            List list = criteria.add(
                    Restrictions.or(Restrictions.like("volunteerCode", key, MatchMode.ANYWHERE),
                            Restrictions.or(Restrictions.like("volunteerName", key, MatchMode.ANYWHERE)),
                            Restrictions.or(Restrictions.like("volunteerPhone", key, MatchMode.ANYWHERE))))
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
    public void deleteAllSysUser(String[] Ids) {

        List<SysUserEntity> list = new ArrayList<>();

        for (String id : Ids) {
            SysUserEntity sysUserEntity = new SysUserEntity();
            sysUserEntity.setUserId(Integer.parseInt(id));
            list.add(sysUserEntity);
        }
        hibernateTemplate.deleteAll(list);

    }
}
