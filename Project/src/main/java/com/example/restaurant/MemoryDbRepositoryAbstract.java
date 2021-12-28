package com.example.restaurant;

import com.example.restaurant.db.MemoryDbEntity;
import com.example.restaurant.db.MemoryDbRepositoryIfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract public class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T> {
    private final List<T> db = new ArrayList<>();
    private int index = 0;

    @Override
    public Optional<T> findById(int index) {
        db.stream().filter(it -> it.getIndex() == index).findFirst();
        return Optional.empty();
    }

    @Override
    public T save(T entity) {
        // db
        return null;
    }

    @Override
    public void deleteById(int index) {

    }

    @Override
    public List<T> listAll() {
        return null;
    }
}
