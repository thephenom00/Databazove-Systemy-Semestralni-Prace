package dao;

import java.util.List;
import java.util.Optional;

public interface DaoInterface<T> {

        Optional<T> get(long id);

        List<T> getAll();

        void save(T t);

        void update(T t, String[] params);

        void delete(T t);


    }
