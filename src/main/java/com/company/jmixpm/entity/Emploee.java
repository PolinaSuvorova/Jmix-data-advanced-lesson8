package com.company.jmixpm.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JmixEntity
@Table(name = "EMPLOEE", indexes = {
        @Index(name = "IDX_EMPLOEE_EMPLOEE_DETAILS", columnList = "EMPLOEE_DETAILS_ID")
})
@Entity
public class Emploee {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME")
    private String name;

    @Column(name = "PHONE")
    private String phone;

    @NotNull
    @JoinColumn(name = "EMPLOEE_DETAILS_ID", nullable = false)
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private EmploeeDetails emploeeDetails;

    @Column(name = "SALARY")
    private Long salary;

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public EmploeeDetails getEmploeeDetails() {
        return emploeeDetails;
    }

    public void setEmploeeDetails(EmploeeDetails emploeeDetails) {
        this.emploeeDetails = emploeeDetails;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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