package org.dstu.dao;

import org.dstu.domain.Geometric;

public class GeometricDao extends BaseDaoImpl <Geometric, Integer> {
    public GeometricDao() {
        super(Geometric.class);
    }
}
