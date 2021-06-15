package main.java;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        createItem();
    }

    public static void createItem() throws Exception {
        String path = "/home/helder/Desktop/JAVA-PROJECTS/cupcake-revenue-calculator/src/main/resources/Total.txt";
        File dailyRevenueFile = new File(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(dailyRevenueFile));

        List<DailyCupcakeSellItem> dailyCupcakeSellItemList = new ArrayList<>();
        long pastDays = Files.lines(Paths.get(path)).count() - 1;
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("Total:")) continue;

            dailyCupcakeSellItemList.add(new DailyCupcakeSellItem(Double.parseDouble(line), LocalDate.now().minusDays(pastDays)));
            pastDays--;
        }

        dailyCupcakeSellItemList.forEach(c -> {
            System.out.println(c.getTotalRevenue() + "   " + c.getDateOfCalculatedRevenue());
        });
    }
}
