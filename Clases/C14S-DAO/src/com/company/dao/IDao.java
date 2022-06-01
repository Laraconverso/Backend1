package com.company.dao;



public interface IDao <T>{

    public T guardar (T t);

    public T buscar (Long id);

}
