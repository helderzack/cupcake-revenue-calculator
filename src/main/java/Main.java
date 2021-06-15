package main.java;

public class Main {
    public static void main(String[] args) throws Exception {
        RevenueRecord revenueRecord = new RevenueRecord("/home/helder/Desktop/JAVA-PROJECTS/cupcake-revenue-calculator/src/main/resources/Total.txt");
        int year = 2020;
        int month = 6;
        Double annualRevenue = revenueRecord.getAnnualRevenue(year);
        Double monthlyRevenue = revenueRecord.getMonthlyRevenue(year, 6);
        System.out.println(year + " yearly revenue: " + "R$" + annualRevenue);
        System.out.println();
        System.out.println("Monthly revenue of month " + month + " of " + year + ": R$" + monthlyRevenue);
    }
}
