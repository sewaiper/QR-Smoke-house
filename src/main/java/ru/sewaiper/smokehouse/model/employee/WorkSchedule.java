package ru.sewaiper.smokehouse.model.employee;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "work_schedules")
public class WorkSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected long id;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "start_workday")
    protected LocalTime startWorkday;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "end_workday")
    protected LocalTime endWorkday;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "lunch_break")
    protected LocalTime lunchBreak;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "workdays")
    protected int workdays;

    @Basic
    @Access(AccessType.PROPERTY)
    @Column(name = "weekends")
    protected int weekends;

    public WorkSchedule() {}

    public WorkSchedule(LocalTime startWorkday, LocalTime endWorkday, LocalTime lunchBreak, int workdays, int weekends) {
        this.startWorkday = startWorkday;
        this.endWorkday = endWorkday;
        this.lunchBreak = lunchBreak;
        this.workdays = workdays;
        this.weekends = weekends;
    }

    public long getId() {
        return id;
    }

    public LocalTime getStartWorkday() {
        return startWorkday;
    }

    public void setStartWorkday(LocalTime startWorkday) {
        this.startWorkday = startWorkday;
    }

    public LocalTime getEndWorkday() {
        return endWorkday;
    }

    public void setEndWorkday(LocalTime endWorkday) {
        this.endWorkday = endWorkday;
    }

    public LocalTime getLunchBreak() {
        return lunchBreak;
    }

    public void setLunchBreak(LocalTime lunchBreak) {
        this.lunchBreak = lunchBreak;
    }

    public int getWorkdays() {
        return workdays;
    }

    public void setWorkdays(int workdays) {
        this.workdays = workdays;
    }

    public int getWeekends() {
        return weekends;
    }

    public void setWeekends(int weekends) {
        this.weekends = weekends;
    }

    @Override
    public String toString() {
        return "WorkSchedule{" +
                "startWorkday=" + startWorkday +
                ", endWorkday=" + endWorkday +
                ", lunchBreak=" + lunchBreak +
                ", workdays=" + workdays +
                ", weekends=" + weekends +
                '}';
    }
}
