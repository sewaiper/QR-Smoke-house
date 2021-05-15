package ru.sewaiper.smokehouse.model.employee;

import org.junit.Test;
import ru.sewaiper.smokehouse.model.BaseModelTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class SimpleEmployeeEntityTest extends BaseModelTest {
    private final static int TABLE_SIZE = 100;

    @Override
    public void setPersistenceUnitName() {
        persistenceUnitName = "SmokehousePU";
    }

    @Test
    public void populateStorage() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Employee> employees = EmployeeGenerator.getEmployees(TABLE_SIZE);
        entityManager.getTransaction().begin();
        try {
            for (Employee employee : employees) {
                entityManager.persist(employee);
            }
            entityManager.getTransaction().commit();
        }
        catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
        }

        entityManager.close();
    }

    @Test
    public void simpleSaveTest() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(EmployeeGenerator.getEmployee());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void findByIdTest() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee employee = entityManager.find(Employee.class, 2L);
        System.out.println(employee);
        entityManager.close();
    }

    @Test
    public void findLimitQuery() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Employee> employees = entityManager.createQuery("select e from Employee e", Employee.class)
                .setMaxResults(6).getResultList();
        entityManager.close();
    }
}