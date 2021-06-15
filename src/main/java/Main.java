package main.java;

public class Main {
    public static void main(String[] args) throws Exception {
        RevenueRecord revenueRecord = new RevenueRecord("/home/helder/Desktop/JAVA-PROJECTS/cupcake-revenue-calculator/src/main/resources/Total.txt");
        int year = 2020;
        Double yearlyRevenue = revenueRecord.getYearlyRevenue(year);
        System.out.println(year + " yearly revenue: " + "R$" + yearlyRevenue);
    }
}
