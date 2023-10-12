package com.company.jmixpm.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Table(name = "EMPLOEE_DETAILS")
@Entity
public class EmploeeDetails {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "PASPORT_NUMBER")
    private String pasportNumber;

    @Column(name = "EXPIRY_DATE")
    private LocalDate expiryDate;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "emploeeDetails")
    private Emploee emploee;

    public Emploee getEmploee() {
        return emploee;
    }

    public void setEmploee(Emploee emploee) {
        this.emploee = emploee;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getPasportNumber() {
        return pasportNumber;
    }

    public void setPasportNumber(String pasportNumber) {
        this.pasportNumber = pasportNumber;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}