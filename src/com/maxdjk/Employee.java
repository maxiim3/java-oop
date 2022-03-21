package com.maxdjk;

public class Employee {
    private int baseSalary;
    private int hourlyRate;

    public int calculateWage(int extraHours ) {
        if (extraHours < 0)
            throw new IllegalArgumentException("You cannot enter negative hours");
        return baseSalary + (hourlyRate * extraHours);
    }

    public void setBaseSalary(int baseSalary){
        if (baseSalary <= 0)
            throw new IllegalArgumentException("Salary must be greater than 0");
        this.baseSalary = baseSalary;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setHourlyRate(int hourlyRate){
        if (hourlyRate <= 0)
            throw new IllegalArgumentException("Hourly rate must be greater to 0");
        this.hourlyRate = hourlyRate;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }
}
