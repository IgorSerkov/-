package org.dstu.domain;

import javax.persistence.*;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;
import javax.persistence.FetchType;

import javax.persistence.*;
import java.util.Set;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Arithmetic {

    private int id;
    private String name;
    private String type;
    private int quantity;
    private Set<Progression> progressions; // По конвенции, имена переменных начинаются с маленькой буквы
    private Set<Geometric> geometrics;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Добавлено для явного указания стратегии генерации
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @OneToMany(mappedBy = "arithmetic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Geometric> getGeometrics() {
        return geometrics; // Используем правильное имя переменной
    }

    public void setGeometrics(Set<Geometric> geometrics) {
        this.geometrics = geometrics; // Используем правильное имя переменной
    }

    @OneToMany(mappedBy = "arithmetic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Progression> getProgressions() {
        return progressions; // Используем правильное имя переменной
    }

    public void setProgressions(Set<Progression> progressions) {
        this.progressions = progressions; // Используем правильное имя переменной
    }
}
