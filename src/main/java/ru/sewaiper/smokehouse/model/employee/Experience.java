package ru.sewaiper.smokehouse.model.employee;

import javax.persistence.*;
import java.time.LocalDate;

@Embeddable
@Access(AccessType.PROPERTY)
public class Experience {
    @Basic
    protected String position;

    @Basic(fetch = FetchType.LAZY)
    protected LocalDate firstWorkday;

    @Basic(fetch = FetchType.LAZY)
    protected LocalDate lastWorkday;

    public Experience() {}

    public Experience(String position, LocalDate firstWorkday, LocalDate lastWorkday) {
        this.position = position;
        this.firstWorkday = firstWorkday;
        this.lastWorkday = lastWorkday;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getFirstWorkday() {
        return firstWorkday;
    }

    public void setFirstWorkday(LocalDate firstWorkday) {
        this.firstWorkday = firstWorkday;
    }

    public LocalDate getLastWorkday() {
        return lastWorkday;
    }

    public void setLastWorkday(LocalDate lastWorkday) {
        this.lastWorkday = lastWorkday;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "position='" + position + '\'' +
                ", firstWorkday=" + firstWorkday +
                ", lastWorkday=" + lastWorkday +
                '}';
    }
}
