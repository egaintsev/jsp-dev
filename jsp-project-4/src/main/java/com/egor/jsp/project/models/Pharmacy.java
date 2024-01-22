/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.egor.jsp.project.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author vboxuser
 */
@Entity
@Table(name = "Pharmacy")
@NamedQueries({
    @NamedQuery(name = "Pharmacy.findAll", query = "SELECT a FROM Pharmacy a"),
    @NamedQuery(name = "Pharmacy.findByID", query = "SELECT a FROM Pharmacy a WHERE a.pharmacyId = :pharmacyID"),
    @NamedQuery(name = "Pharmacy.findByName", query = "SELECT a FROM Pharmacy a WHERE a.pharmacyName = :pharmacyName")})
public class Pharmacy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pharmacyId")
    private Integer pharmacyId;
    @Basic(optional = false)
    @Column(name = "pharmacyName")
    private String pharmacyName;

    @OneToMany(mappedBy = "pharmacy", orphanRemoval = true)
    private List<TotalAmount> totalAmounts;

    public List<TotalAmount> getTotalAmounts() {
        return totalAmounts;
    }

    public void setTotalAmounts(List<TotalAmount> totalAmounts) {
        this.totalAmounts = totalAmounts;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "pharmacyId=" + pharmacyId +
                ", pharmacyName='" + pharmacyName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pharmacy pharmacy = (Pharmacy) o;
        return Objects.equals(pharmacyId, pharmacy.pharmacyId) && Objects.equals(pharmacyName, pharmacy.pharmacyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pharmacyId, pharmacyName);
    }

    public Pharmacy(Integer pharmacyId, String pharmacyName) {
        this.pharmacyId = pharmacyId;
        this.pharmacyName = pharmacyName;
    }

    public Pharmacy() {
    }

    public Integer getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Integer pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }
}
