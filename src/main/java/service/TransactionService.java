package service;

import dao.TransactionDao;
import model.Expense;
import model.Income;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TransactionService {
    Scanner scanner = new Scanner(System.in);

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

    //2. Вывести сумму по всем доходам и расходам
    public void sumAll() {
        TransactionDao dao = new TransactionDao();
        System.out.println("Доходов всего: " + dao.sumAllIncomes());
        System.out.println("Расходов всего: " + dao.sumAllExpenses());
    }

    //3. Вывести сумму доходов и расходов за промежуток времени, указанный пользователем
    public void sumAllBetweenDate() {
        TransactionDao dao = new TransactionDao();
        System.out.println("Введите начальную и конечную дату для отбора: ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());
        LocalDate endDate = LocalDate.parse(scanner.nextLine());
        System.out.println(dao.sumExpensesBetweenDate(startDate, endDate));
    }
}