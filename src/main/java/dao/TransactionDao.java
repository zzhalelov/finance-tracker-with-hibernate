package dao;

import model.Expense;
import model.Income;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
}