package com.oho.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.oho.dao.OperationDAO;
import com.oho.dao.model.BaseModel;
import com.oho.dao.utils.Utils;

public class BaseDAOImpl<T extends BaseModel> implements OperationDAO<T>{
    
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    private Class<T> clazz;
    
    public BaseDAOImpl() {
        clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    @Override
    public T save(T entity) {
        getSessionFactory().getCurrentSession().save(entity);
        return entity;
    }

    @Override
    public void delete(T entity) {
        getSessionFactory().getCurrentSession().delete(entity);
    }

    @Override
    public T update(T entity) {
        getSessionFactory().getCurrentSession().update(entity);
        return entity;
    }

    @Override
    public T getById(Serializable id) {
        String sql = "FROM " + clazz.getSimpleName() + " c WHERE c.id = ?";
        List<T> list = getByQuery(sql, new Object[]{id});
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<T> getByQuery(String queryStr, Object[] values) {
        if (Utils.isEmpty(queryStr)) return new ArrayList<T>();
        Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i + 1, values[i]);
            }
        }
        return (List<T>) query.list();
    }

    @Override
    public T getObjectByQuery(String queryString) {
        return getObjectByQuery(queryString, null);
    }

    @Override
    public T getObjectByQuery(String queryString, Object[] values) {
        List<T> list = getByQuery(queryString, values);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<T> getByQueryPagination(String queryString, Object[] values,
            int firstResult, int maxResults) {
        if (Utils.isEmpty(queryString)) return new ArrayList<T>();
        
        Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i + 1, values[i]);
            }
        }
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResults);
        return query.list();
    }

    @Override
    public List<T> getByQuery(String queryString) {
        return getByQuery(queryString, null);
    }

    @Override
    public void clear() {
        getSessionFactory().getCurrentSession().clear();
    }

    @Override
    public void flush() {
        getSessionFactory().getCurrentSession().flush();
    }

    @Override
    public long count() {
        Query query = getSessionFactory().getCurrentSession().createQuery("SELECT COUNT(c.id) FROM " +clazz.getSimpleName()+ " c");
        return (Long)query.uniqueResult();
    }

    @Override
    public List<T> getByNativeQuery(String queryStr, Object[] values,
            Class<T> type) {
        if (Utils.isEmpty(queryStr)) return new ArrayList<T>();
        SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(queryStr);
        query.addEntity(type);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i + 1, values[i]);
            }
        }
        return query.list();
    }

    @Override
    public List<T> getByNativeQueryNoParam(String queryStr, Class<T> type) {
        if (Utils.isEmpty(queryStr)) return new ArrayList<T>();
        SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(queryStr);
        query.addEntity(type);
        return query.list();
    }

    @Override
    public List<Object> getGeneralDataByQuery(String queryStr, Object[] values) {
        if (Utils.isEmpty(queryStr)) return null;
        Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i + 1, values[i]);
            }
        }
        return query.list();
    }

    @Override
    public void executeUpdate(String queryStr, Object[] params) {
        Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i + 1, params[i]);
            }
        }
       query.executeUpdate();
    }

}
