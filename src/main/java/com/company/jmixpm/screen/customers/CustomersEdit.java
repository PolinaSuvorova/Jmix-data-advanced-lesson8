package com.company.jmixpm.screen.customers;

import io.jmix.ui.screen.*;
import com.company.jmixpm.entity.Customers;

@UiController("Customers.edit")
@UiDescriptor("customers-edit.xml")
@EditedEntityContainer("customersDc")
public class CustomersEdit extends StandardEditor<Customers> {
}