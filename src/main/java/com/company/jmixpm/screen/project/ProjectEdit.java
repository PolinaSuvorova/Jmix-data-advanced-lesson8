package com.company.jmixpm.screen.project;

import com.company.jmixpm.app.ProjectService;
import com.company.jmixpm.datatype.ProjectLabels;
import com.company.jmixpm.entity.Project;
import io.jmix.core.validation.group.UiComponentChecks;
import io.jmix.core.validation.group.UiCrossFieldChecks;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.TextArea;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.Collection;
import java.util.Set;

@UiController("Project.edit")
@UiDescriptor("project-edit.xml")
@EditedEntityContainer("projectDc")
public class ProjectEdit extends StandardEditor<Project> {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private InstanceContainer<Project> projectDc;
    @Autowired
    private Notifications notifications;

    @Autowired
    private Validator validator;
    @Autowired
    private TextArea<ProjectLabels> lablesField;

    @Subscribe
    public void onInit(final InitEvent event) {
      //  Collection<io.jmix.ui.component.validation.Validator<ProjectLabels>> validators = lablesField.getValidators();
        //      setCrossFieldValidate(false);
    }

    @Subscribe("commitWithBeanValidator")
    public void onCommitWithBeanValidatorClick(final Button.ClickEvent event) {
        try {
            projectService.saveProject(getEditedEntity());
            closeWithDiscard();
        } catch (ConstraintViolationException e) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
                sb.append(constraintViolation.getMessage()).append("\n");
            }

            notifications.create(Notifications.NotificationType.TRAY)
                    .withCaption(sb.toString())
                    .show();
        }

    }

    private void showBeanValidationExceptions( Set<ConstraintViolation<Project>> e){
        StringBuilder sb = new StringBuilder();
        for (ConstraintViolation<?> constraintViolation : e) {
            sb.append(constraintViolation.getMessage()).append("\n");
        }

        notifications.create(Notifications.NotificationType.TRAY)
                .withCaption(sb.toString())
                .show();
    }

    @Subscribe("performBeanValidator")
    public void onPerformBeanValidatorClick(final Button.ClickEvent event) {
        Set<ConstraintViolation<Project>> validate = validator.validate(getEditedEntity(), Default.class, UiCrossFieldChecks.class, UiComponentChecks.class);
        showBeanValidationExceptions(validate);
    }


}