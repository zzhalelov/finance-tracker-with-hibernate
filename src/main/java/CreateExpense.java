import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Scanner;

public class CreateExpense {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();

        LocalDate date = getDate("Введите дату:");
        double amount = getDouble("Введите сумму расхода:");

    }

    static LocalDate getDate(String message) {
        System.out.println(message);
        return LocalDate.parse(scanner.nextLine());
    }

    static double getDouble(String message) {
        System.out.println(message);
        return Double.parseDouble(scanner.nextLine());
    }
}