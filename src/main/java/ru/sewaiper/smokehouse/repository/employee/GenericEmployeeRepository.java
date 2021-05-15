package ru.sewaiper.smokehouse.repository.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.sewaiper.smokehouse.model.employee.Employee;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Repository
public class GenericEmployeeRepository implements EmployeeRepository {
    protected EntityManagerFactory entityManagerFactory;

    public GenericEmployeeRepository(@Autowired EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Optional<Employee> findById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.close();
        return Optional.of(employee);
    }

    @Override
    public List<Employee> findByName(String firstName, String patronymic, String lastName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where " +
                "e.firstName = :firstName and " +
                "e.patronymic = :patronymic and " +
                "e.lastName = :lastName", Employee.class)
                .setParameter("firstName", firstName)
                .setParameter("patronymic", patronymic)
                .setParameter("lastName", lastName);

        return query.getResultList();
    }

    @Override
    public List<Employee> findByFirstName(String firstName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where " +
                "e.firstName = :firstName", Employee.class)
                .setParameter("firstName", firstName);
        return query.getResultList();
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where " +
                "e.lastName = :lastName", Employee.class)
                .setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    public List<Employee> findByPosition(String position) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where " +
                "e.experience.position = :position", Employee.class)
                .setParameter("position", position);
        return query.getResultList();
    }

    @Override
    public List<Employee> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
    }

    @Override
    public void save(Employee employee) {

    }
}
