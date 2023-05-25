package com.example.pruebaexamen;

import java.io.Serializable;

public class Persona implements Serializable {
    private int edad;
    private String name;

    public Persona(int edad, String name) {
        this.edad = edad;
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " " + edad;
    }
}
