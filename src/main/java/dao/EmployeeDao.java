package dao;

import entity.EmployeeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class EmployeeDao implements DaoInterface<EmployeeEntity> {
    private final EntityManager entityManager;

    public EmployeeDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<EmployeeEntity> get(long id) {
        return Optional.ofNullable(entityManager.find(EmployeeEntity.class, id));
    }

    @Override
    public List<EmployeeEntity> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM EmployeeEntity e");
        return query.getResultList();
    }

    @Override
    public void save(EmployeeEntity employeeEntity) {
        executeInsideTransaction(entityManager -> entityManager.persist(employeeEntity));
    }

    @Override
    public void update(EmployeeEntity employeeEntity, String[] params) {
        executeInsideTransaction(entityManager -> entityManager.merge(employeeEntity));
    }

    @Override
    public void delete(EmployeeEntity employeeEntity) {
        executeInsideTransaction(entityManager -> entityManager.remove(employeeEntity));
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
