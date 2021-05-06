package ru.sewaiper.smokehouse.model.employee;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "employee")
@Access(AccessType.PROPERTY)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Basic
    @Column(name = "first_name", nullable = false)
    protected String firstName;

    @Basic
    @Column(name = "patronymic", nullable = false)
    protected String patronymic;

    @Basic
    @Column(name = "last_name", nullable = false)
    protected String lastName;

    @Embedded
    protected Passport passport;

    @Basic
    @Column(name = "phone", length = 10)
    protected String phone;

    @Embedded
    protected Experience experience;

    @OneToOne(targetEntity = WorkSchedule.class, fetch = FetchType.LAZY)
    protected WorkSchedule workSchedule;

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public WorkSchedule getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(WorkSchedule workSchedule) {
        this.workSchedule = workSchedule;
    }

    public boolean isWorkDay(LocalDate date) {
        LocalDate firstWorkday = this.getExperience().getFirstWorkday();
        WorkSchedule activeSchedule = this.getWorkSchedule();

        int workdays = activeSchedule.getWorkdays();
        int weekends = activeSchedule.getWeekends();

        if(workdays <= 0) return false;
        if(weekends == 0) return true;

        long diff = ChronoUnit.DAYS.between(firstWorkday, date);

        return (diff % (workdays + weekends)) < workdays;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passport=" + passport +
                ", phone='" + phone + '\'' +
                ", experience=" + experience +
                ", workSchedule=" + workSchedule +
                '}';
    }
}
