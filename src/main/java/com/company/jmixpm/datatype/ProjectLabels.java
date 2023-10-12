package com.company.jmixpm.datatype;

import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class ProjectLabels implements Serializable {
    List<String> labels;

    public ProjectLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<String> getLabels() {
        return Collections.unmodifiableList(labels);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectLabels)) return false;
        ProjectLabels that = (ProjectLabels) o;
        return Objects.equal(getLabels(), that.getLabels());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getLabels());
    }
}
