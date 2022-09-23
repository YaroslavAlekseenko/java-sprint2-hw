import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ManagerYearlyReport {

    YearlyReport yearlyReport;
                                                                                            // Запись годового отчета
    void readYearlyReport(String fileName) {
        String content = readFileContentsOrNull(fileName);
        String[] lines = content.split("\r?\n");

        ArrayList<RecordYear> records = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            RecordYear record = makeRecordFromLine(lines[i]);
            records.add(record);
        }

        yearlyReport = new YearlyReport(records);
        System.out.println("Годовой отчёт успешно загружен!");
    }

    RecordYear makeRecordFromLine(String line) {
        String[] tokens = line.split(",");
        return new RecordYear(
            Integer.parseInt(tokens[0]),
            Integer.parseInt(tokens[1]),
            tokens[2]
        );
    }
                                                                                    // Вывод информации о годовом отчёте
    void printYearlyReport() {
        if (yearlyReport == null) {
            System.out.println("Годовой отчёт не считан");
        }

        System.out.println("\nГодовой отчёт: " + 2021);
        int expense = 0, expense1 = 0, expense2 = 0, expense3 = 0;
        int income =0, income1 =0, income2 =0, income3 =0;
        int profit1 = 0;
        int profit2 = 0;
        int profit3 = 0;

            for (RecordYear record : yearlyReport.records) {
                if (record.isExpense.equals("true")&&record.month == 01) {
                    expense1 = expense + record.amount;
                } else if (record.isExpense.equals("false")&&record.month == 01) {
                    income1 = income + record.amount;
                }
                profit1 = income1 - expense1;
            }

        for (RecordYear record : yearlyReport.records) {
            if (record.isExpense.equals("true")&&record.month == 02) {
                expense2 = expense + record.amount;
            } else if (record.isExpense.equals("false")&&record.month == 02) {
                income2 = income + record.amount;
            }
            profit2 = income2 - expense2;
        }

        for (RecordYear record : yearlyReport.records) {
            if (record.isExpense.equals("true")&&record.month == 03) {
                expense3 = expense + record.amount;
            } else if (record.isExpense.equals("false")&&record.month == 03) {
                income3 = income + record.amount;
            }
            profit3 = income3 - expense3;
        }

        for (RecordYear record : yearlyReport.records) {
            if (record.isExpense.equals("true")) {
                expense = expense + record.amount;
            } else {
                income = income + record.amount;
            }

        }
        System.out.println("\nПрибыль за январь: " + profit1 + "\nПрибыль за февраль: " + profit2 + "\nПрибыль за март: "+ profit3);
        System.out.println("\nСредний расход за все месяцы в году: " + expense/3 + "\nСредний доход за все месяцы в году: " + income/3);
    }
                                                                                        // Методы для сравнения отчётов
    int compareJanuaryT() {
        if (yearlyReport == null) {
            System.out.println("Годовой отчёт не считан");
        }

        int januaryT = 0;
        for (RecordYear record : yearlyReport.records) {
            if (record.isExpense.equals("true") && record.month == 01) {
                januaryT = record.amount;
            }
        }
        return januaryT;
    }

    int compareJanuaryF() {
        if (yearlyReport == null) {
            System.out.println("Годовой отчёт не считан");
        }

        int januaryF = 0;
        for (RecordYear record : yearlyReport.records) {
            if (record.isExpense.equals("false") && record.month == 01) {
                januaryF = record.amount;
            }
        }
        return januaryF;
    }

    int compareFebruaryT() {
        if (yearlyReport == null) {
            System.out.println("Годовой отчёт не считан");
        }

        int februaryT = 0;
        for (RecordYear record : yearlyReport.records) {
            if (record.isExpense.equals("true") && record.month == 02) {
                februaryT = record.amount;
            }
        }
        return februaryT;
    }

    int compareFebruaryF() {
        if (yearlyReport == null) {
            System.out.println("Годовой отчёт не считан");
        }

        int februaryF = 0;
        for (RecordYear record : yearlyReport.records) {
            if (record.isExpense.equals("false") && record.month == 02) {
                februaryF = record.amount;
            }
        }
        return februaryF;
    }

    int compareMarchT() {
        if (yearlyReport == null) {
            System.out.println("Годовой отчёт не считан");
        }

        int marchT = 0;
        for (RecordYear record : yearlyReport.records) {
            if (record.isExpense.equals("true") && record.month == 03) {
                marchT = record.amount;
            }
        }
        return marchT;
    }

    int compareMarchF() {
        if (yearlyReport == null) {
            System.out.println("Годовой отчёт не считан");
        }

        int marchF = 0;
        for (RecordYear record : yearlyReport.records) {
            if (record.isExpense.equals("false") && record.month == 03) {
                marchF = record.amount;
            }
        }
        return marchF;
    }
                                                                                        // Считывание годового отчета
    String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с годовым отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

}
