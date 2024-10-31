package org.dstu.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T, Id extends Serializable> {
    Id save(T entity);

    void update(T entity);

    T findOne(Id id);

    List<T> findAll();

    void delete(T entity);
}
