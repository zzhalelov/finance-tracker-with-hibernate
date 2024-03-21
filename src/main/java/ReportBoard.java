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
            }
        }
    }

    public static void menu() {
        System.out.println("-----------------------------------------------");
        System.out.println("1. Вывести список доходов и расходов за весь период");
        System.out.println("-----------------------------------------------");
    }
}