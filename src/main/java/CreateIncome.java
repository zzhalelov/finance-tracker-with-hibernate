import model.Account;
import model.Income;
import model.IncomeCategory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Scanner;

public class CreateIncome {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();

        LocalDate date = getDate("Введите дату в формате yyyy-mm-dd:");
        double amount = getDouble("Введите сумму дохода:");

        printAllCategories();
        int categoryId = getInt("Выберите ID категории доходов:");
        manager.find(IncomeCategory.class, categoryId);

        printAllAccounts();
        int accountId = getInt("Выберите ID счета:");
        manager.find(Account.class, accountId);

        String comment = getComment("Введите описание транзакции:");

        Income income = Income.builder()
                .date(date)
                .amount(amount)
                .incomeCategory(categoryId)
                .account(accountId)
                .comment(comment)
                .build();

        try {
            manager.getTransaction().begin();
            manager.persist(income);
            manager.getTransaction().commit();
            System.out.println("Транзакция записана");
        } catch (Exception e) {
            manager.getTransaction().rollback();
            System.out.println("Ошибка" + e.getMessage());
        }
    }

    static LocalDate getDate(String message) {
        System.out.println(message);
        return LocalDate.parse(scanner.nextLine());
    }

    static double getDouble(String message) {
        System.out.println(message);
        return Double.parseDouble(scanner.nextLine());
    }

    static int getInt(String message) {
        System.out.println(message);
        return Integer.parseInt(scanner.nextLine());
    }

    static String getComment(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    static void printAllCategories() {
        System.out.println("----------------------");
        System.out.println("КАТЕГОРИИ:");
        System.out.println("1. Зарплата");
        System.out.println("2. Премия");
        System.out.println("3. Дивиденды");
        System.out.println("4. Прочие доходы");
    }

    static void printAllAccounts() {
        System.out.println("----------------------");
        System.out.println("1. Наличные");
        System.out.println("2. Банковская карта");
    }
}