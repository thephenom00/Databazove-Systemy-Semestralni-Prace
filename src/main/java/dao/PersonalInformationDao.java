package dao;

import entity.PersonalInformationEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class PersonalInformationDao implements DaoInterface<PersonalInformationEntity> {
    private final EntityManager entityManager;

    public PersonalInformationDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createTable() {
        executeInsideTransaction(entityManager -> {
            // Create the table using PostgreSQL syntax
            String createTableQuery = "CREATE TABLE IF NOT EXISTS personal_information (" +
                    "id SERIAL PRIMARY KEY," +
                    "email VARCHAR(255) NOT NULL," +
                    "birthday DATE," +
                    "firstname VARCHAR(255)," +
                    "lastname VARCHAR(255)" +
                    ")";
            entityManager.createNativeQuery(createTableQuery).executeUpdate();
        });
    }

    @Override
    public Optional<PersonalInformationEntity> get(long id) {
        return Optional.ofNullable(entityManager.find(PersonalInformationEntity.class, id));
    }

    @Override
    public List<PersonalInformationEntity> getAll() {
        Query query = entityManager.createQuery("SELECT a FROM PersonalInformationEntity a");
        return query.getResultList();
    }

    @Override
    public void save(PersonalInformationEntity personalInformationEntity) {
        executeInsideTransaction(entityManager -> entityManager.persist(personalInformationEntity));
    }

    @Override
    public void update(PersonalInformationEntity personalInformationEntity, String[] params) {
        executeInsideTransaction(entityManager -> entityManager.merge(personalInformationEntity));
    }

    @Override
    public void delete(PersonalInformationEntity personalInformationEntity) {
        executeInsideTransaction(entityManager -> entityManager.remove(personalInformationEntity));
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
