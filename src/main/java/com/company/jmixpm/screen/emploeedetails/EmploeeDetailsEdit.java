package com.company.jmixpm.screen.emploeedetails;

import io.jmix.ui.screen.*;
import com.company.jmixpm.entity.EmploeeDetails;

@UiController("EmploeeDetails.edit")
@UiDescriptor("emploee-details-edit.xml")
@EditedEntityContainer("emploeeDetailsDc")
public class EmploeeDetailsEdit extends StandardEditor<EmploeeDetails> {
}