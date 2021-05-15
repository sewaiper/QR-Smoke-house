package ru.sewaiper.smokehouse.model.order;

import org.junit.Test;
import ru.sewaiper.smokehouse.model.BaseModelTest;
import ru.sewaiper.smokehouse.model.employee.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class OrderEntityTest extends BaseModelTest {

    @Override
    public void setPersistenceUnitName() {
        persistenceUnitName = "SmokehousePU";
    }

    protected List<Employee> getEmployees() {
        return null;
    }

    @Test
    public void probe() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(OrderGenerator.getOrder());
            transaction.commit();
        }
        catch (Exception e) {
            transaction.rollback();
        }

        entityManager.close();
    }
}
