package webprak.webprak.DAO;

import webprak.webprak.tables.TableEntity;

import java.util.Collection;

public interface TableDAO<T extends TableEntity<ID>, ID> {
    T getById(ID id);

    Collection<T> getAll();

    void save(T entity);

    void saveCollection(Collection<T> entities);

    void delete(T entity);

    void deleteById(ID id);

    void update(T entity);
}