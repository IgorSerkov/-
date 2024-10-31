import org.dstu.dao.ArithmeticDao;
import org.dstu.dao.GeometricDao;
import org.dstu.dao.ProgressionDao;
import org.dstu.domain.Arithmetic;
import org.dstu.domain.Geometric;
import org.dstu.domain.Progression;
import org.dstu.util.HibernateUtil;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;

public class Main {

    public static void main(final String[] args) throws Exception {
        final Session session = HibernateUtil.getSession();
        GeometricDao geometricDao = new geometricDao();

        Geometric geometric = new  Geometric();

        geometric.setName(" arifmetic 5463");
        geometric.setQuantity("5463");
        geometric.setType(356);
        geometricDao.save(geometric);

        ArithmeticDao arithmeticDao = new ArithmeticDao();

        Arithmetic arithmetic = new arithmetic();

        arithmetic.setName("arifmetic");
        arithmetic.setType("geometric");
        arithmetic.setQuantity(5678);
        arithmeticDao.save(arithmetic);

        GeometricDao GeometricDao = new GeometricDao();

        Geometric geometric = new Geometric();
        Geometric.setName("geo");
        geometric.setQuantity(3456789);
        geometric.setType("geomet");
        geometricDao.save(geometric);



        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }
}