package main.java;

import java.time.LocalDate;

public class DailyCupcakeSold {
    private Double totalRevenue;
    private LocalDate dateOfCalculatedRevenue;

    public DailyCupcakeSold(double totalRevenue, LocalDate dateOfCalculatedRevenue) {
        this.totalRevenue = totalRevenue;
        this.dateOfCalculatedRevenue = dateOfCalculatedRevenue;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public LocalDate getDateOfCalculatedRevenue() {
        return dateOfCalculatedRevenue;
    }
}
