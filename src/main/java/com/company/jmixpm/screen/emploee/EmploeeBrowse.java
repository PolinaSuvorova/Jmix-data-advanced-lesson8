package com.company.jmixpm.screen.emploee;

import io.jmix.ui.screen.*;
import com.company.jmixpm.entity.Emploee;

@UiController("Emploee.browse")
@UiDescriptor("emploee-browse.xml")
@LookupComponent("emploeesTable")
public class EmploeeBrowse extends StandardLookup<Emploee> {
}