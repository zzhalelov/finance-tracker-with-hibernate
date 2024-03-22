package dao;

import model.Expense;
import model.Income;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class TransactionDao {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    EntityManager manager = factory.createEntityManager();

    //1. Вывести список всех доходов и расходов
    public List<Expense> printAllExpenses() {
        return manager.createQuery("SELECT e FROM Expense e", Expense.class).getResultList();
    }

    public List<Income> printAllIncomes() {
        return manager.createQuery("SELECT i FROM Income i", Income.class).getResultList();
    }

    //2. Вывести расшифровку по всем доходам и расходам
    public Double sumAllIncomes() {
        return manager.createQuery("SELECT SUM (amount) FROM Income i", Double.class).getSingleResult();
    }

    public Double sumAllExpenses() {
        return manager.createQuery("SELECT SUM (amount) FROM Expense e", Double.class).getSingleResult();
    }

    public List<Object[]> sumAllExpensesByCategory() {
        return manager.createQuery(
                "SELECT ec.name, SUM(e.amount) " +
                        "FROM Expense e " +
                        "JOIN ExpenseCategory ec ON e.expenseCategory = ec.id " +
                        "GROUP BY ec.name", Object[].class).getResultList();
    }

    //3. Вывести сумму доходов и расходов за промежуток времени, указанный пользователем
    public Double sumExpensesBetweenDate(LocalDate startDate, LocalDate endDate) {
        TypedQuery<Double> query = manager.createQuery("SELECT SUM(e.amount) FROM Expense e WHERE e.date BETWEEN :startDate AND :endDate", Double.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getSingleResult();
    }
}