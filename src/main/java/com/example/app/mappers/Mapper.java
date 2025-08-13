package com.example.app.mappers;

public interface Mapper<E, D> {
    public E fromDto(D dto);

    public D toDto(E entity);
}
