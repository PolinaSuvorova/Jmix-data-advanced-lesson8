package com.company.jmixpm.entity;

import io.jmix.core.entity.annotation.EmbeddedParameters;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JmixEntity
@Table(name = "ROAD_MAP", indexes = {
        @Index(name = "IDX_ROAD_MAP_PROJECT", columnList = "PROJECT_ID")
})
@Entity
public class RoadMap {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @NotNull
    @InstanceName
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "GOAL")
    private String goal;

    @JoinColumn(name = "PROJECT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    @EmbeddedParameters(nullAllowed = false)
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "startDate", column = @Column(name = "ESTIMATION_START_DATE", nullable = false)),
            @AttributeOverride(name = "endDate", column = @Column(name = "ESTIMATION_END_DATE")),
            @AttributeOverride(name = "description", column = @Column(name = "ESTIMATION_DESCRIPTION"))
    })
    private Estimation estimation;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Estimation getEstimation() {
        return estimation;
    }

    public void setEstimation(Estimation estimation) {
        this.estimation = estimation;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}