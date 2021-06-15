package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RevenueRecord {
    private final String path;
    private final File dailyRevenueFile;
    private final BufferedReader bufferedReader;
    private List<DailyCupcakeSold> dailyCupcakeSoldList = new ArrayList<>();

    public RevenueRecord(String path) throws Exception {
        this.path = path;
        this.dailyRevenueFile = new File(path);
        this.bufferedReader = new BufferedReader(new FileReader(dailyRevenueFile));
        createRevenueRecord();
    }

    private void createRevenueRecord() throws Exception {
        long pastDays = Files.lines(Paths.get(path)).count() - 1;
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("Total:")) continue;

            dailyCupcakeSoldList.add(new DailyCupcakeSold(Double.parseDouble(line), LocalDate.now().minusDays(pastDays)));
            pastDays--;
        }
    }

    public Double getAnnualRevenue(int year) {
        return dailyCupcakeSoldList.stream().
                filter(dailySale -> dailySale.getDateOfCalculatedRevenue().getYear() == year).
                map(dailySale -> dailySale.getTotalRevenue()).collect(Collectors.summingDouble(Double::doubleValue));
    }

    public Double getMonthlyRevenue(int year, int month) {
        return dailyCupcakeSoldList.stream().
                filter(dailySale -> dailySale.getDateOfCalculatedRevenue().getYear() == year && dailySale.getDateOfCalculatedRevenue().getMonthValue() == month).
                map(dailySale -> dailySale.getTotalRevenue()).collect(Collectors.summingDouble(Double::doubleValue));
    }
}
