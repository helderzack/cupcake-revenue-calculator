package main.java;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws Exception {
        RevenueRecord revenueRecord = new RevenueRecord("/home/helder/Desktop/JAVA-PROJECTS/cupcake-revenue-calculator/src/main/resources/Total.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu();
            System.out.print("Enter the desired option: ");
            int option = scanner.nextInt();
            System.out.println();

            switch (option) {
                case 1:
                    getAnnualRevenue(scanner, revenueRecord);
                    break;
                case 2:
                    getMonthlyRevenue(scanner, revenueRecord);
                    break;
                case 3:
                    getWeeklyRevenue(scanner, revenueRecord);
                    break;
                case 99:
                    scanner.close();
                    exit(0);
                    break;
                default:
                    System.out.println("Unknown option");
                    break;
            }

            System.out.print("Press any key to continue ...");
            System.in.read();
            System.out.println();
        }

    }

    public static void menu() {
        System.out.println("====================================================");
        System.out.println();
        System.out.println("                Revenue Calculator");
        System.out.println();
        System.out.println("====================================================");
        System.out.println("1 - Get Annual Revenue");
        System.out.println("2 - Get Monthly Revenue");
        System.out.println("3 - Get Weekly Revenue");
        System.out.println("99 - EXIT");
        System.out.println();
    }

    public static void getAnnualRevenue(Scanner scanner, RevenueRecord revenueRecord) {
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();
        System.out.println(year + " yearly revenue: R$" + revenueRecord.getAnnualRevenue(year));
        System.out.println();
    }

    public static void getMonthlyRevenue(Scanner scanner, RevenueRecord revenueRecord) {
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();

        System.out.print("Enter the month (numeric): ");
        int month = scanner.nextInt();
        System.out.println();
        System.out.println("Monthly revenue of month " + month + " of " + year + ": R$" + revenueRecord.getMonthlyRevenue(year, month));
    }

    public static void getWeeklyRevenue(Scanner scanner, RevenueRecord revenueRecord) {
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();

        System.out.print("Enter the week of the year: ");
        int week = scanner.nextInt();
        System.out.println();
        System.out.println("Revenue of week " + week + " of " + year + ": R$" + revenueRecord.getWeeklyRevenue(year, week));
    }
}
