import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ManagerMonthlyReport {

    ArrayList<MonthlyReport> monthlyReports;

    MonthlyReport monthlyReport;

    ManagerMonthlyReport() {
        monthlyReports = new ArrayList<>();
    }
                                                                                            // Запись месячных отчетов
    void readMonthlyReport(String fileName) {
        String content = readFileContentsOrNull(fileName);
        String[] lines = content.split("\r?\n");

        ArrayList<RecordMonth> records = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            RecordMonth record = makeRecordFromLine(lines[i]);
            records.add(record);
        }

        MonthlyReport monthlyReport = new MonthlyReport(records);
        monthlyReports.add(monthlyReport);
        System.out.println("Месячный отчёт успешно загружен!");
    }

    RecordMonth makeRecordFromLine(String line) {
        String[] tokens = line.split(",");
        return new RecordMonth(
                tokens[0],
                tokens[1],
                Integer.parseInt(tokens[2]),
                Double.parseDouble(tokens[3])
        );
    }
                                                                            // Вывод информации о всех месячных отчётах
    void printMonthlyReport() {
        if (monthlyReports == null) {
            System.out.println("Месячный отчёт не считан");
        }

        double sum, sum0;
        double maxSum00 = 0, maxSum01 = 0, maxSum10 = 0, maxSum11 = 0, maxSum20 = 0, maxSum21 = 0;
        String name00 = null, name01 = null, name10 = null, name11 = null, name20 = null, name21 = null;

        System.out.println("\nЯнварь");
        for (MonthlyReport report: monthlyReports) {
            if (report == monthlyReports.get(0)) {
                for (RecordMonth record : report.records) {
                    if (record.isExpense.equals("FALSE")) {
                        sum = record.quantity * record.sumOfOne;
                        if (maxSum00 < sum) {
                            maxSum00 = sum;
                            name00 = record.itemName;
                        }

                    } else if (record.isExpense.equals("TRUE")) {
                        sum0 = record.quantity * record.sumOfOne;
                        if (maxSum01 < sum0) {
                            maxSum01 = sum0;
                            name01 = record.itemName;
                        }
                    }
                }
            }
        }

        System.out.println("Самый прибыльный товар: " + name00 + " " + maxSum00);
        System.out.println("Самая большая трата: " + name01 + " " + maxSum01);

        System.out.println("\nФевраль");
        for (MonthlyReport report: monthlyReports) {
            if (report == monthlyReports.get(1)) {
                for (RecordMonth record : report.records) {
                    if (record.isExpense.equals("FALSE")) {
                        sum = record.quantity * record.sumOfOne;
                        if (maxSum10 < sum) {
                            maxSum10 = sum;
                            name10 = record.itemName;
                        }

                    } else if (record.isExpense.equals("TRUE")) {
                        sum0 = record.quantity * record.sumOfOne;
                        if (maxSum11 < sum0) {
                            maxSum11 = sum0;
                            name11 = record.itemName;
                        }
                    }
                }
            }
        }

        System.out.println("Самый прибыльный товар: " + name10 + " " + maxSum10);
        System.out.println("Самая большая трата: " + name11 + " " + maxSum11);

        System.out.println("\nМарт");
        for (MonthlyReport report: monthlyReports) {
            if (report == monthlyReports.get(2)) {
                for (RecordMonth record : report.records) {
                    if (record.isExpense.equals("FALSE")) {
                        sum = record.quantity * record.sumOfOne;
                        if (maxSum20 < sum) {
                            maxSum20 = sum;
                            name20 = record.itemName;
                        }

                    } else if (record.isExpense.equals("TRUE")) {
                        sum0 = record.quantity * record.sumOfOne;
                        if (maxSum21 < sum0) {
                            maxSum21 = sum0;
                            name21 = record.itemName;
                        }
                    }
                }
            }
        }

        System.out.println("Самый прибыльный товар: " + name20 + " " + maxSum20);
        System.out.println("Самая большая трата: " + name21 + " " + maxSum21);
    }
                                                                                        // Методы для сравнения отчётов
    double compareJanuaryTrue() {
        if (monthlyReports == null) {
            System.out.println("Месячный отчёт не считан");
        }

        double januaryTrue = 0;
        for (MonthlyReport report : monthlyReports) {
            if (report == monthlyReports.get(0)) {
                for (RecordMonth record : report.records) {
                    if (record.isExpense.equals("TRUE")) {
                        januaryTrue += record.quantity * record.sumOfOne;
                    }
                }
            }
        }
        return januaryTrue;
    }

    double compareJanuaryFalse() {
        if (monthlyReports == null) {
            System.out.println("Месячный отчёт не считан");
        }

        double januaryFalse = 0;
        for (MonthlyReport report : monthlyReports) {
            if (report == monthlyReports.get(0)) {
                for (RecordMonth record : report.records) {
                    if (record.isExpense.equals("FALSE")) {
                        januaryFalse += record.quantity * record.sumOfOne;
                    }
                }
            }
        }
        return januaryFalse;
    }

    double compareFebruaryTrue() {
        if (monthlyReports == null) {
            System.out.println("Месячный отчёт не считан");
        }

        double februaryTrue = 0;
        for (MonthlyReport report : monthlyReports) {
            if (report == monthlyReports.get(1)) {
                for (RecordMonth record : report.records) {
                    if (record.isExpense.equals("TRUE")) {
                        februaryTrue += record.quantity * record.sumOfOne;
                    }
                }
            }
        }
        return februaryTrue;
    }

    double compareFebruaryFalse() {
        if (monthlyReports == null) {
            System.out.println("Месячный отчёт не считан");
        }

        double februaryFalse = 0;
        for (MonthlyReport report : monthlyReports) {
            if (report == monthlyReports.get(1)) {
                for (RecordMonth record : report.records) {
                    if (record.isExpense.equals("FALSE")) {
                        februaryFalse += record.quantity * record.sumOfOne;
                    }
                }
            }
        }
        return februaryFalse;
    }

    double compareMarchTrue() {
        if (monthlyReports == null) {
            System.out.println("Месячный отчёт не считан");
        }

        double marchTrue = 0;
        for (MonthlyReport report : monthlyReports) {
            if (report == monthlyReports.get(2)) {
                for (RecordMonth record : report.records) {
                    if (record.isExpense.equals("TRUE")) {
                        marchTrue += record.quantity * record.sumOfOne;
                    }
                }
            }
        }
        return marchTrue;
    }

    double compareMarchFalse() {
        if (monthlyReports == null) {
            System.out.println("Месячный отчёт не считан");
        }

        double marchFalse = 0;
        for (MonthlyReport report : monthlyReports) {
            if (report == monthlyReports.get(2)) {
                for (RecordMonth record : report.records) {
                    if (record.isExpense.equals("FALSE")) {
                        marchFalse += record.quantity * record.sumOfOne;
                    }
                }
            }
        }
        return marchFalse;
    }

                                                                                        // Считывание месячных отчетов
    String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }
}

