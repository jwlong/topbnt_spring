package com.dxfjyygy.dao;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by longjinwen on 2017/3/22.
 */
public class BaseDaoImpl  implements BaseDao{

    @Autowired
    private SessionFactory sessionFactory;

    Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /*
     * (non-Javadoc)
     *
     *
     */

    public <T> T findObject(String hql) {
        List<T> list = findList(hql);
        return (null == list || list.size() == 0) ? null : list.get(0);
    }

    /*
     * (non-Javadoc)
     *

     */

    public <T> T findObject(String hql, Object... objects) {
        List<T> list = findList(hql, objects);
        return (null == list || list.size() == 0) ? null : list.get(0);
    }

    /*
     * (non-Javadoc)
     *
     * java.io.Serializable)
     */

    public <T> T findObject(Class<T> cls, Serializable id) {
        return (T) getSession().get(cls, id);
    }

    /*
     * (non-Javadoc)
     *
     */

    public <T> T findObjectBySql(String sql) {
        List<T> list = findListBySql(sql);
        return (null == list || list.size() == 0) ? null : list.get(0);
    }

    /*
     * (non-Javadoc)
     *
     * java.lang.Object[])
     */

    public <T> T findObjectBySql(String sql, Object... objects) {
        List<T> list = findListBySql(sql, objects);
        return (null == list || list.size() == 0) ? null : list.get(0);
    }

    /*
     * (non-Javadoc)
     *
     */

    public <T> List<T> findList(String hql) {
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    /*
     * (non-Javadoc)
     *
     * java.lang.Object[])
     */

    public <T> List<T> findList(String hql, Object... objects) {
        Query query = getSession().createQuery(hql);
        setParameter(query, objects);
        return query.list();
    }

    /*
     * (non-Javadoc)
     *
     * 
     */

    public <T> List<T> findList(Class<T> cls) {
        String hql = "FROM " + cls.getName();
        return findList(hql);
    }

    /*
     * (non-Javadoc)
     *
     * 
     */

    public <T> List<T> findListBySql(String sql) {
        Query query = getSession().createSQLQuery(sql);
        return query.list();
    }

    /*
     * (non-Javadoc)
     *
     * 
     * java.lang.Object[])
     */

    public <T> List<T> findListBySql(String sql, Object... objects) {
        Query query = getSession().createSQLQuery(sql);
        setParameter(query, objects);
        return query.list();
    }

    /*
     * (non-Javadoc)
     *
     * 
     */
    public <T> Long saveObject(T obj) {
        return  (Long) getSession().save(obj);
    }

    public <T> Integer save(T obj) {
      return (Integer) getSession().save(obj);
    }

    /*
     * (non-Javadoc)
     *
     * 
     */

    public <T> void updateObject(T obj) {
        getSession().update(obj);
    }

    /*
     * (non-Javadoc)
     *
     * 
     */

    public <T> void saveOrUpdateObject(T obj) {
        getSession().saveOrUpdate(obj);
    }

    /*
     * (non-Javadoc)
     *
     * 
     */

    public int executeSql(String sql) {
        Query query = getSession().createSQLQuery(sql);
        return query.executeUpdate();
    }

    /*
     * (non-Javadoc)
     *
     * 
     * java.lang.Object[])
     */

    public int executeSql(String sql, Object... objects) {
        Query query = getSession().createSQLQuery(sql);
        setParameter(query, objects);
        return query.executeUpdate();
    }

    /*
     * (non-Javadoc)
     *
     * 
     */

    public int coutObjects(String hql) {
        Query query = getSession().createQuery(hql);
        ScrollableResults sr = query.scroll();
        sr.last();
        return sr.getRowNumber() == -1 ? 0 : sr.getRowNumber() + 1;
    }

    /*
     * (non-Javadoc)
     *
     * 
     * java.lang.Object[])
     */

    public int countObjects(String hql, Object... objects) {
        Query query = getSession().createQuery(hql);
        setParameter(query, objects);
        ScrollableResults sr = query.scroll();
        sr.last();
        return sr.getRowNumber() == -1 ? 0 : sr.getRowNumber() + 1;
    }

    /*
     * (non-Javadoc)
     *
     *  int, int)
     */

    public <T> PageList<T> findPageList(String hql, int page, int rows) {
        Query query = getSession().createQuery(hql);
        return findPageList(query, page, rows);
    }

    /*
     * (non-Javadoc)
     *
     *  int, int,
     * java.lang.Object[])
     */

    public <T> PageList<T> findPageList(String hql, int page, int rows,
                                        Object... objects) {
        Query query = getSession().createQuery(hql);
        setParameter(query, objects);
        return findPageList(query, page, rows);
    }

    <T> PageList<T> findPageList(Query query, int page, int rows) {
        ScrollableResults sr = query.scroll();
        sr.last();
        int count = sr.getRowNumber() == -1 ? 0 : sr.getRowNumber() + 1;
        query.setFirstResult((page - 1) * rows);
        query.setMaxResults(page * rows);
        return new PageList<T>(page, rows, count, query.list());
    }

    void setParameter(Query query, Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            query.setParameter(i, objects[i]);
        }
    }

}
