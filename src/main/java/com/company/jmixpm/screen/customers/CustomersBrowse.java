package com.company.jmixpm.screen.customers;

import io.jmix.ui.screen.*;
import com.company.jmixpm.entity.Customers;

@UiController("Customers.browse")
@UiDescriptor("customers-browse.xml")
@LookupComponent("customersesTable")
public class CustomersBrowse extends StandardLookup<Customers> {
}