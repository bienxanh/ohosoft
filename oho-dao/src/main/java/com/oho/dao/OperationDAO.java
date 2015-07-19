package com.oho.dao;

import java.io.Serializable;
import java.util.List;

public interface OperationDAO<T> {

    T save(T entity);

    void delete(T entity);

    T update(T entity);

    T getById(Serializable id);

    List<T> getByQuery(String query, Object[] values);

    T getObjectByQuery(String queryString);

    T getObjectByQuery(final String queryString, final Object[] values);

    List<T> getByQueryPagination(final String queryString,
            final Object[] values, final int firstResult, final int maxResults);

    List<T> getByQuery(String queryString);

    void clear();

    void flush();

    long count();

    public List<T> getByNativeQuery(String queryStr, Object[] values,
            Class<T> type);

    public List<T> getByNativeQueryNoParam(String queryStr, Class<T> type);

    List<Object> getGeneralDataByQuery(String queryStr, Object[] values);

    void executeUpdate(String queryStr, Object[] params);
}
