package service;

import dao.TransactionDao;
import model.Expense;
import model.Income;

import java.util.List;

public class TransactionService {
    //1. Вывести список всех доходов и расходов
    public void printAll() {
        TransactionDao dao = new TransactionDao();

        List<Income> incomes = dao.printAllIncomes();
        List<Expense> expenses = dao.printAllExpenses();

        if (expenses.isEmpty() && incomes.isEmpty()) {
            System.out.println("В таблице доходов и расходов записей нет");
        } else {
            System.out.println("Записи в таблице доходы за весь период:");
            for (Income income : incomes) {
                System.out.println(income);
            }
            System.out.println("----------------------------------------");
            System.out.println("Записи в таблице расходы за весь период:");
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }
}