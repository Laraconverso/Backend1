package com.company.dao;

import com.company.model.Odontologo;

import java.util.List;

public interface IDao <T> {
    public T guardar(T t);
    public List<T> listarTodos();
}
