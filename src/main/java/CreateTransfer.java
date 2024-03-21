import model.Account;
import model.Expense;
import model.Transfer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Scanner;

public class CreateTransfer {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();

        LocalDate date = getDate("Введите дату в формате yyyy-mm-dd:");
        double amount = getDouble("Введите сумму дохода:");
        double fee = getDouble("Введите сумму комиссии за перевод:");

        printAllAccounts();
        int sourceAccountId = getInt("С какого счета переводите деньги:");
        manager.find(Account.class, sourceAccountId);
        int destinationAccountId = getInt("На какой счет переводите деньги:");
        manager.find(Account.class, destinationAccountId);

        String comment = getComment("Введите описание транзакции:");

        Transfer transfer = Transfer.builder()
                .date(date)
                .amount(amount)
                .fee(fee)
                .sourceAccountId(sourceAccountId)
                .destinationAccountId(destinationAccountId)
                .comment(comment)
                .build();

    }

    static LocalDate getDate(String message) {
        System.out.println(message);
        return LocalDate.parse(scanner.nextLine());
    }

    static double getDouble(String message) {
        System.out.println(message);
        return Double.parseDouble(scanner.nextLine());
    }

    static void printAllAccounts() {
        System.out.println("----------------------");
        System.out.println("1. Наличные");
        System.out.println("2. Банковская карта");
    }

    static int getInt(String message) {
        System.out.println(message);
        return Integer.parseInt(scanner.nextLine());
    }

    static String getComment(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}