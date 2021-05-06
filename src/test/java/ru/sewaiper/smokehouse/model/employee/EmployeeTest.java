package ru.sewaiper.smokehouse.model.employee;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.sewaiper.smokehouse.util.SmokehouseTestUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {

    protected Passport getPassport() {
        return new Passport(SmokehouseTestUtils.getRandomDate(
                LocalDate.of(1985, 1, 1),
                LocalDate.of(1998, 1, 1)
        ),
                SmokehouseTestUtils.getRandomNumberString(4),
                SmokehouseTestUtils.getRandomNumberString(6));
    }

    protected Experience getExperience(boolean hasLastWorkday) {
        LocalDate firstWorkday = SmokehouseTestUtils.getRandomDate(
                LocalDate.of(2012, 1, 1),
                LocalDate.of(2019, 1, 1)
        );
        LocalDate lastWorkday = null;
        if(hasLastWorkday) lastWorkday = firstWorkday.plusYears(SmokehouseTestUtils.getRandomNumber(0, 3))
                .plusMonths(SmokehouseTestUtils.getRandomNumber(1, 12))
                .plusDays(SmokehouseTestUtils.getRandomNumber(0, 15));

        return new Experience(SmokehouseTestUtils.getRandomString(20),
                firstWorkday, lastWorkday);
    }

    protected WorkSchedule getWorkSchedule() {
        LocalTime startWorkday = SmokehouseTestUtils.getRandomTime(
                LocalTime.of(8, 0),
                LocalTime.of(12, 0)
        );
        LocalTime endWorkday = startWorkday.plusHours(SmokehouseTestUtils.getRandomNumber(6, 10));
        LocalTime lunchBreak = LocalTime.of( (int)(startWorkday.getHour() +
                SmokehouseTestUtils.getRandomNumber(2, 4)), startWorkday.getMinute());
        int workdays = (int) SmokehouseTestUtils.getRandomNumber(1, 15);
        int weekends = (int) SmokehouseTestUtils.getRandomNumber(0, workdays/2);

        return new WorkSchedule(startWorkday, endWorkday, lunchBreak, workdays, weekends);
    }

    protected Employee getEmployee() {
        Employee employee = new Employee();

        employee.setFirstName(SmokehouseTestUtils.getRandomString(
                (int) SmokehouseTestUtils.getRandomNumber(5, 15), true));

        employee.setPatronymic(SmokehouseTestUtils.getRandomString(
                (int) SmokehouseTestUtils.getRandomNumber(5, 15), true));

        employee.setLastName(SmokehouseTestUtils.getRandomString(
                (int) SmokehouseTestUtils.getRandomNumber(5, 15), true));

        employee.setPhone(SmokehouseTestUtils.getRandomNumberString(10));

        employee.setPassport(getPassport());
        employee.setExperience(getExperience(SmokehouseTestUtils.getRandomBoolean()));
        employee.setWorkSchedule(getWorkSchedule());

        return employee;
    }

    protected List<Employee> getEmployees(int size) {
        List<Employee> employees = new ArrayList<>(size);
        for(int i=0; i<size; i++) employees.add(getEmployee());
        return employees;
    }

    protected static EntityManagerFactory entityManagerFactory;
    protected static SessionFactory sessionFactory;

    @BeforeClass
    public static void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("SmokehousePU");
        sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
    }

    @Test
    public void probe() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.close();
    }
}