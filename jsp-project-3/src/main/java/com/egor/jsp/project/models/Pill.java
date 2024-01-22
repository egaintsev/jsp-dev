package com.egor.jsp.project.models;

import java.util.UUID;

public class Pill {
    private UUID id;
    private String name;
    private String country;
    private String releaseForm;
    private String dose;
    private String firm;
    private String description;

    public Pill() {
    }

    public Pill(UUID id, String name, String country, String releaseForm, String dose, String firm, String description) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.releaseForm = releaseForm;
        this.dose = dose;
        this.firm = firm;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
