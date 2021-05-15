package ru.sewaiper.smokehouse.model.employee;

import ru.sewaiper.smokehouse.model.order.Order;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected long id;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "first_name", nullable = false)
    protected String firstName;

    @Basic
    @Column(name = "patronymic", nullable = false)
    protected String patronymic;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "last_name", nullable = false)
    protected String lastName;

    @Embedded
    @Access(AccessType.PROPERTY)
    @AttributeOverrides({
            @AttributeOverride(name = "birthdate", column = @Column(name = "birthdate")),
            @AttributeOverride(name = "series", column = @Column(name = "passport_series", nullable = false, length = 4)),
            @AttributeOverride(name = "number", column = @Column(name = "passport_number", nullable = false, length = 6))
    })
    protected Passport passport;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "phone", length = 10)
    protected String phone;

    @Embedded
    @Access(AccessType.PROPERTY)
    @AttributeOverrides({
            @AttributeOverride(name = "position", column = @Column(name = "position")),
            @AttributeOverride(name = "firstWorkday", column = @Column(name = "first_workday", nullable = false)),
            @AttributeOverride(name = "lastWorkday", column = @Column(name = "last_workday"))
    })
    protected Experience experience;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "work_schedule_id")
    protected WorkSchedule workSchedule;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @Access(AccessType.PROPERTY)
    protected Collection<Order> orders;

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

    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
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
                ", experience=" + experience + '}';
    }
}
