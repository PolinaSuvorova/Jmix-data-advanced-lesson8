package com.company.jmixpm.screen.emploeedetails;

import io.jmix.ui.screen.*;
import com.company.jmixpm.entity.EmploeeDetails;

@UiController("EmploeeDetails.browse")
@UiDescriptor("emploee-details-browse.xml")
@LookupComponent("emploeeDetailsesTable")
public class EmploeeDetailsBrowse extends StandardLookup<EmploeeDetails> {
}