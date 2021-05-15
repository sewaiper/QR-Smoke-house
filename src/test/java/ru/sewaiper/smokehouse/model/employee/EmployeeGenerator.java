package ru.sewaiper.smokehouse.model.employee;

import ru.sewaiper.smokehouse.util.SmokehouseTestUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EmployeeGenerator {
    protected static Passport getPassport() {
        Passport passport = new Passport();

        passport.setBirthdate(SmokehouseTestUtils.getRandomDate(
                LocalDate.of(1985, 1, 1),
                LocalDate.of(1998, 1, 1)
        ));
        passport.setSeries(SmokehouseTestUtils.getRandomNumberString(4));
        passport.setNumber(SmokehouseTestUtils.getRandomNumberString(6));

        return passport;
    }

    protected static Experience getExperience(boolean hasLastWorkday) {
        Experience experience = new Experience();
        experience.setFirstWorkday(SmokehouseTestUtils.getRandomDate(
                LocalDate.of(2012, 1, 1),
                LocalDate.of(2019, 1, 1)
        ));
        LocalDate lastWorkday = null;
        if(hasLastWorkday) lastWorkday = experience.getFirstWorkday()
                .plusYears(SmokehouseTestUtils.getRandomNumber(0, 3))
                .plusMonths(SmokehouseTestUtils.getRandomNumber(1, 12))
                .plusDays(SmokehouseTestUtils.getRandomNumber(0, 15));
        experience.setLastWorkday(lastWorkday);

        experience.setPosition(SmokehouseTestUtils.getRandomString(20));

        return experience;
    }

    protected static WorkSchedule getWorkSchedule() {
        WorkSchedule workSchedule = new WorkSchedule();

        workSchedule.setStartWorkday(SmokehouseTestUtils.getRandomTime(
                LocalTime.of(8, 0),
                LocalTime.of(12, 0)
        ));

        workSchedule.setEndWorkday(workSchedule.getStartWorkday()
                .plusHours(SmokehouseTestUtils.getRandomNumber(6, 10)));

        workSchedule.setLunchBreak(LocalTime.of( (int)(workSchedule.getStartWorkday().getHour() +
                SmokehouseTestUtils.getRandomNumber(2, 4)), workSchedule.getStartWorkday().getMinute()));

        workSchedule.setWorkdays((int) SmokehouseTestUtils.getRandomNumber(1, 15));
        workSchedule.setWeekends((int) SmokehouseTestUtils.getRandomNumber(0, workSchedule.getWorkdays()/2));

        return workSchedule;
    }

    public static Employee getEmployee() {
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

    public static List<Employee> getEmployees(int size) {
        List<Employee> employees = new ArrayList<>(size);
        for(int i=0; i<size; i++) employees.add(getEmployee());
        return employees;
    }
}
