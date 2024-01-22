package com.egor.jsp.project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "TotalAmount")
@NamedQueries({
        @NamedQuery(name = "TotalAmount.findAll", query = "SELECT b FROM TotalAmount b"),
        @NamedQuery(name = "TotalAmount.findByPill", query = "SELECT b FROM TotalAmount b WHERE b.pills = :pills"),
        @NamedQuery(name = "TotalAmount.findByPharmacy", query = "SELECT b FROM TotalAmount b WHERE b.pharmacy = :pharmacy")
})
public class TotalAmount {
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pharmacy_pharmacy_id")
    private Pharmacy pharmacy;

    @ManyToOne
    @JoinColumn(name = "pills_id")
    private Pills pills;

    public TotalAmount() {
    }

    public TotalAmount(Integer id, Pharmacy pharmacy, Pills pills) {
        this.id = id;
        this.pharmacy = pharmacy;
        this.pills = pills;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pills getPills() {
        return pills;
    }

    public void setPills(Pills pills) {
        this.pills = pills;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
