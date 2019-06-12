package com.ssh.models.dao.admin.impl;

import com.ssh.common.PageBean;
import com.ssh.models.dao.admin.AdminDao;
import com.ssh.models.model.SysAdminEntity;
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
 * @Create: 2019-06-04 00:10
 * @Describe：
 **/
@Repository
public class AdminDaoImpl implements AdminDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addAdmin(SysAdminEntity sysAdminEntity) {
        hibernateTemplate.save(sysAdminEntity);
    }

    @Override
    public void deleteAdmin(SysAdminEntity sysAdminEntity) {
        hibernateTemplate.delete(sysAdminEntity);
    }

    @Override
    public void updateAdmin(SysAdminEntity sysAdminEntity) {
        hibernateTemplate.update(sysAdminEntity);
    }

    @Override
    public SysAdminEntity findOneAdminy(SysAdminEntity sysAdminEntity) {
        return (SysAdminEntity) hibernateTemplate.find("from com.mikey.SSH.models.model.SysAdminEntity where adminId = ?0", sysAdminEntity.getAdminId()).get(0);
    }

    @Override
    public PageBean findAllAdmin(String key, PageBean<SysAdminEntity> pageBean) {

        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(SysAdminEntity.class);

        if (key != null && !key.equals("")) {
            //搜索
            List list = criteria.add(
                    Restrictions.or(Restrictions.like("adminCode", key, MatchMode.ANYWHERE),
                            Restrictions.or(Restrictions.like("adminEmail", key, MatchMode.ANYWHERE)),
                            Restrictions.or(Restrictions.like("adminName", key, MatchMode.ANYWHERE))))
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
    public void deleteAllAdmin(String[] Ids) {

        List<SysAdminEntity> list = new ArrayList<>();

        for (String id : Ids) {
            SysAdminEntity sysAdminEntity = new SysAdminEntity();
            sysAdminEntity.setAdminId(Integer.parseInt(id));
            list.add(sysAdminEntity);
        }
        hibernateTemplate.deleteAll(list);

    }
}
