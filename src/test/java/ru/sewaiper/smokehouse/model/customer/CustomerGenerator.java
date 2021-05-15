package ru.sewaiper.smokehouse.model.customer;

import ru.sewaiper.smokehouse.util.SmokehouseTestUtils;

import java.util.ArrayList;
import java.util.List;

public class CustomerGenerator {
    public static Customer getCustomer() {
        Customer customer = new Customer();

        customer.setFirstName(SmokehouseTestUtils.getRandomString(
                (int) SmokehouseTestUtils.getRandomNumber(10, 15)));

        customer.setLastName(SmokehouseTestUtils.getRandomString(
                (int) SmokehouseTestUtils.getRandomNumber(10, 15)
        ));

        customer.setPhone(SmokehouseTestUtils.getRandomNumberString(10));

        return customer;
    }

    public static List<Customer> getCustomers(int size) {
        List<Customer> customers = new ArrayList<>(size);

        for(int i=0; i<size; i++) {
            customers.add(getCustomer());
        }

        return customers;
    }
}
