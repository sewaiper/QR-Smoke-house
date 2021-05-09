package ru.sewaiper.smokehouse.model.employee;

import javax.persistence.*;
import java.time.LocalDate;

@Embeddable
@Table(name = "employee")
@Access(AccessType.PROPERTY)
public class Passport {
    @Basic
    protected LocalDate birthdate;

    @Basic
    protected String series;

    @Basic
    protected String number;

    public Passport() {}

    public Passport(LocalDate birthdate, String series, String number) {
        this.birthdate = birthdate;
        this.series = series;
        this.number = number;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "birthdate=" + birthdate +
                ", series='" + series + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
