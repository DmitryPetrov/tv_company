
package com.example.name.model;

public class FavoriteChennel {

    private long idChennel;
    private long idSubscriber;

    
    public FavoriteChennel() {
    }

    public FavoriteChennel(long idSubscriber, long idChennel) {
        this.idChennel = idChennel;
        this.idSubscriber = idSubscriber;
    }


    public long getIdChennel() {
        return idChennel;
    }


    public void setIdChennel(long idChennel) {
        this.idChennel = idChennel;
    }


    public long getIdSubscriber() {
        return idSubscriber;
    }


    public void setIdSubscriber(long idSubscriber) {
        this.idSubscriber = idSubscriber;
    }

    @Override
    public String toString() {
        return "FavoriteChennel [idChennel=" + idChennel + ", idSubscriber="
                + idSubscriber + "]";
    }

}
