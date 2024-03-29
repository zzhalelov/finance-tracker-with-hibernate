import model.Account;
import model.Expense;
import model.ExpenseCategory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Scanner;

public class CreateExpense {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();

        LocalDate date = getDate("Введите дату в формате yyyy-mm-dd:");
        double amount = getDouble("Введите сумму расхода:");

        printAllCategories();
        int categoryId = getInt("Выберите ID категории расходов:");
        manager.find(ExpenseCategory.class, categoryId);

        printAllAccounts();
        int accountId = getInt("Выберите ID счета:");
        manager.find(Account.class, accountId);

        String comment = getComment("Введите описание транзакции:");

        Expense expense = Expense.builder()
                .date(date)
                .amount(amount)
                .expenseCategory(categoryId)
                .account(accountId)
                .comment(comment)
                .build();
        try {
            manager.getTransaction().begin();
            manager.persist(expense);
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
        System.out.println("1. Питание");
        System.out.println("2. Жилье");
        System.out.println("3. Коммунальные услуги");
        System.out.println("4. Обучение и саморазвитие");
        System.out.println("5. Здоровье и красота");
        System.out.println("6. Подарки и развлечения");
        System.out.println("7. Транспортные расходы");
        System.out.println("8. Связь и интернет");
        System.out.println("9. Техника");
        System.out.println("10. Одежда");
        System.out.println("11. Фин.обязательства");
        System.out.println("12. Прочие расходы");
    }

    static void printAllAccounts() {
        System.out.println("----------------------");
        System.out.println("1. Наличные");
        System.out.println("2. Банковская карта");
    }
}