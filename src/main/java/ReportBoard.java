import service.TransactionService;

import java.util.Scanner;

public class ReportBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransactionService transactionService = new TransactionService();

        while (true) {
            menu();
            int command = Integer.parseInt(scanner.nextLine());
            switch (command) {
                case 0 -> {
                    return;
                }
                case 1 -> transactionService.printAll();
                case 2 -> transactionService.sumAll();
                case 3 -> transactionService.sumAllBetweenDate();
            }
        }
    }

    public static void menu() {
        System.out.println("-----------------------------------------------");
        System.out.println("1. Вывести список доходов и расходов за весь период");
        System.out.println("2. Вывести сумму по всем доходам и расходам");
        System.out.println("3. Вывести сумму доходов и расходов за промежуток времени, указанный пользователем");
        System.out.println("-----------------------------------------------");
    }
}