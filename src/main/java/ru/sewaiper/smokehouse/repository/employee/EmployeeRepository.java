package ru.sewaiper.smokehouse.repository.employee;

import ru.sewaiper.smokehouse.model.employee.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Optional<Employee> findById(long id);
    List<Employee> findByName(String firstName, String patronymic, String lastName);
    List<Employee> findByFirstName(String firstName);
    List<Employee> findByLastName(String lastName);
    List<Employee> findByPosition(String position);
    List<Employee> findAll();
    void save(Employee employee);
}
