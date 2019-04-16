package com.example.name.mapper;

import java.util.List;

import com.example.name.model.Chennel;

public interface ChennelMapper {
    public void insert(Chennel chennel);

    public Chennel getById(Integer chennelId);

    public List<Chennel> getAll();

    public void update(Chennel chennel);

    public void delete(Integer chennelId);
}
