package org.dstu.dao;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class BaseDaoImpl<T, Id extends Serializable> extends AbstractDao implements IBaseDao<T, Id> {

    public BaseDaoImpl(Class clz) {
        super(clz);
        openSession();
    }

    @Override
    public Id save(T entity) {
        Transaction t = getSession().beginTransaction();
        Id result = (Id) getSession().save(entity);
        t.commit();
        return result;
    }

    @Override
    public void update(T entity) {
        Transaction t = getSession().beginTransaction();
        getSession().update(entity);
        t.commit();
    }

    @Override
    public T findOne(Id id) {
        return (T) getSession().get(getClz(), id);
    }

    @Override
    public List<T> findAll() {
        Query q = getSession().createQuery("FROM " + getClz().getName());
        return q.list();
    }

    @Override
    public void delete(T entity) {
        Transaction t = getSession().beginTransaction();
        getSession().delete(entity);
        t.commit();
    }
}
