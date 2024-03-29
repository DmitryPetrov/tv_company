package com.example.name.mapper;

import java.util.List;

import com.example.name.model.Subscriber;

public interface SubscriberMapper {
    public void insert(Subscriber subscriber);

    public Subscriber getById(Long subscriberId);

    public List<Subscriber> getAll();
    
    public List<Subscriber> getByFavoriteChennel(Long ChennelId);

    public void update(Subscriber subscriber);

    public void delete(Long subscriberId);
}
