package org.dstu.dao;
import org.dstu.domain.Arithmetic;
import org.hibernate.query.Query;

import java.util.List;

public class ArithmeticDao extends BaseDaoImpl<Arithmetic, Integer> {
    public ArithmeticDao() {
        super(Arithmetic.class);
    }

    public List<Arithmetic> getAllByName(String name) {
        Query q = getSession().createQuery("FROM Arithmetic WHERE Arithmetic.name = \"" + name + "\"");
        return q.list();
    }
}