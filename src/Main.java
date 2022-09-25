import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerMonthlyReport managerMonthlyReport = new ManagerMonthlyReport();
        ManagerYearlyReport managerYearlyReport = new ManagerYearlyReport();

        while (true) {
            printMenu();                                                                                   // Вызов меню
            int command = scanner.nextInt();


            if (command == 1) {                                                 // Считывание месячных отчётов из файлов

                for (int i = 1; i <= 3; i++)
                managerMonthlyReport.readMonthlyReport("resources/m.20210" + i + ".csv");

            } else if (command == 2) {                                            // Считывание годового отчёта из файла

                managerYearlyReport.readYearlyReport("resources/y.2021.csv");

            } else if (command == 3) {                          // Сравнение доходов и расходов в месячных и годовом отчётах
                                                                // Проверка загрузки отчётов
                managerMonthlyReport.checkMonthlyReport();
                managerYearlyReport.checkYearlyReport();
                if (managerMonthlyReport.monthlyReports.isEmpty()) {
                    return;
                }
                if (managerYearlyReport.yearlyReport == null) {
                    return;
                }
                                                                // Сравнение доходов за январь
                if (managerMonthlyReport.compareJanuaryFalse() == managerYearlyReport.compareJanuaryF()) {
                    System.out.println("\nДоходы в январе равны");
                } else {
                    System.out.println("\nДоходы в январе не равны");
                }
                                                                // Сравнение расходов за январь
                if (managerMonthlyReport.compareJanuaryTrue() == managerYearlyReport.compareJanuaryT()) {
                    System.out.println("Расходы в январе равны");
                } else {
                    System.out.println("Расходы в январе не равны");
                }
                                                                // Сравнение доходов за февраль
                if (managerMonthlyReport.compareFebruaryFalse() == managerYearlyReport.compareFebruaryF()) {
                    System.out.println("\nДоходы в феврале равны");
                } else {
                    System.out.println("\nДоходы в феврале не равны");
                }
                                                                // Сравнение расходов за февраль
                if (managerMonthlyReport.compareFebruaryTrue() == managerYearlyReport.compareFebruaryT()) {
                    System.out.println("Расходы в феврале равны");
                } else {
                    System.out.println("Расходы в феврале не равны");
                }
                                                                // Сравнение доходов за март
                if (managerMonthlyReport.compareMarchFalse() == managerYearlyReport.compareMarchF()) {
                    System.out.println("\nДоходы в марте равны");
                } else {
                    System.out.println("\nДоходы в марте не равны");
                }
                                                                // Сравнение расходов за март
                if (managerMonthlyReport.compareMarchTrue() == managerYearlyReport.compareMarchT()) {
                    System.out.println("Расходы в марте равны");
                } else {
                    System.out.println("Расходы в марте не равны");
                }

            } else if (command == 4) {                          // Вывод информации о всех месячных отчётах

                managerMonthlyReport.printMonthlyReport();

            } else if (command == 5) {                          // Вывод информации о годовом отчёте

                managerYearlyReport.printYearlyReport();

            } else if (command == 0) {                          // Выход из программы

                System.out.println("Выход...");
                return;

            } else {
                System.out.println("Такой команды нет!");
            }
        }
    }

                                                                // Меню для управления программой
    public static void printMenu() {
        System.out.println("\n1. Считать все месячные отчёты");
        System.out.println("2. Считать годовой отчёт");
        System.out.println("3. Сверить отчёты");
        System.out.println("4. Вывести информацию о всех месячных отчётах");
        System.out.println("5. Вывести информацию о годовом отчёте");
        System.out.println("0. Выход");
    }

}

