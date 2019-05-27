package com.trabalho.faculdade.services;

import java.util.List;
import java.util.Set;
public interface CrudInterface <T, ID> {
        List<T> getAll();

        T findById(ID id);

        T saveOrUpdate(T object);

        T update(ID id, T object);

        void delete(T object);

        void deleteById(ID id);
}
