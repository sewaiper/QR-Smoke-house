package ru.sewaiper.smokehouse.model.order;

import ru.sewaiper.smokehouse.model.customer.Customer;
import ru.sewaiper.smokehouse.model.customer.CustomerGenerator;
import ru.sewaiper.smokehouse.model.employee.Employee;
import ru.sewaiper.smokehouse.model.employee.EmployeeGenerator;
import ru.sewaiper.smokehouse.model.table.TableGenerator;
import ru.sewaiper.smokehouse.model.table.WorkTable;
import ru.sewaiper.smokehouse.util.SmokehouseTestUtils;

public class OrderGenerator {

    public static Order getOrder() {
        Employee employee = EmployeeGenerator.getEmployee();
        Customer customer = CustomerGenerator.getCustomer();
        WorkTable table = TableGenerator.getTable();

        return getOrder(employee, customer, table);
    }

    public static Order getOrder(Employee employee, Customer customer, WorkTable table) {
        Order order = new Order();

        order.setRating((int) SmokehouseTestUtils.getRandomNumber(0, 5));

        order.setComment(SmokehouseTestUtils.getRandomString(
                (int) SmokehouseTestUtils.getRandomNumber(50, 1000), true));

        order.setValue((int) SmokehouseTestUtils.getRandomNumber(700, 10000));

        order.setEmployee(employee);
        order.setCustomer(customer);
        order.setTable(table);

        return order;
    }
}
