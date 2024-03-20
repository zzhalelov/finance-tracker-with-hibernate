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