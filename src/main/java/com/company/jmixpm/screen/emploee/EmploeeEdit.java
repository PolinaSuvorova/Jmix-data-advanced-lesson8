package com.company.jmixpm.screen.emploee;

import com.company.jmixpm.entity.EmploeeDetails;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import com.company.jmixpm.entity.Emploee;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Emploee.edit")
@UiDescriptor("emploee-edit.xml")
@EditedEntityContainer("emploeeDc")
public class EmploeeEdit extends StandardEditor<Emploee> {
    @Autowired
    private DataContext dataContext;

    @Subscribe
    public void onInitEntity(final InitEntityEvent<Emploee> event) {
        EmploeeDetails ed = dataContext.create(EmploeeDetails.class);
        event.getEntity().setEmploeeDetails(ed);
    }
}