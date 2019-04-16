
package com.example.name.model;

public class Subscriber {

    private long id;
    private String name;

    public Subscriber() {

    }

    public Subscriber(long id, String name) {
        this.id = id;
        this.name = name;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Subscriber [id=" + id + ", name=" + name + "]";
    }
}
