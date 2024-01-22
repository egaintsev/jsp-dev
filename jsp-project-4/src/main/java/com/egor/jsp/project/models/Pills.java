/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.egor.jsp.project.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Pills")
@NamedQueries({
        @NamedQuery(name = "Pills.findAll", query = "SELECT b FROM Pills b"),
        @NamedQuery(name = "Pills.findById", query = "SELECT b FROM Pills b WHERE b.id = :id"),
        @NamedQuery(name = "Pills.findByName", query = "SELECT b FROM Pills b WHERE b.name = :name")
})
public class Pills implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "firm")
    private String firm;
    @Column(name = "releaseForm")
    private String releaseForm;
    @Column(name = "dose")
    private String dose;
    @Column(name = "description")
    private String description;
    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "pills", orphanRemoval = true)
    private Collection<TotalAmount> totalAmounts;

    public Collection<TotalAmount> getTotalAmounts() {
        return totalAmounts;
    }

    public void setTotalAmounts(Collection<TotalAmount> totalAmounts) {
        this.totalAmounts = totalAmounts;
    }

    public Pills() {
    }

    @Override
    public String toString() {
        return "Pills{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firm='" + firm + '\'' +
                ", releaseForm='" + releaseForm + '\'' +
                ", dose='" + dose + '\'' +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pills pills = (Pills) o;
        return Objects.equals(id, pills.id) && Objects.equals(name, pills.name) && Objects.equals(firm, pills.firm) && Objects.equals(releaseForm, pills.releaseForm) && Objects.equals(dose, pills.dose) && Objects.equals(description, pills.description) && Objects.equals(country, pills.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, firm, releaseForm, dose, description, country);
    }

    public Pills(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getReleaseForm() {
        return releaseForm;
    }

    public void setReleaseForm(String releaseForm) {
        this.releaseForm = releaseForm;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
