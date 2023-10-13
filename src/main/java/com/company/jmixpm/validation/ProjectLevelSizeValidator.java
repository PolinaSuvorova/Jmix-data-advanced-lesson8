package com.company.jmixpm.validation;

import com.company.jmixpm.datatype.ProjectLabels;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ProjectLevelSizeValidator implements ConstraintValidator<ProjectLabelSize, ProjectLabels> {

    private int min;
    private int max;
    @Override
    public void initialize(ProjectLabelSize constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(ProjectLabels value, ConstraintValidatorContext context) {
        if (value == null){
            return false;
        }
        List<String> lables = value.getLabels();
        return  lables.size() >= min && lables.size() <= max;
    }
}
