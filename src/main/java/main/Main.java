package main;

import dao.PersonalInformationDao;
import entity.PersonalInformationEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyDB");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        PersonalInformationDao personalInformationDao = new PersonalInformationDao(entityManager);

        String url = "jdbc:postgresql://slon.felk.cvut.cz:5432/leductha";
        String username = "leductha";
        String password = "0000";

        /**
         * Get persons email based on his ID
         */
        Optional<PersonalInformationEntity> personalInformationEntity = personalInformationDao.get(4312);
        if (personalInformationEntity.isPresent()) {
            System.out.println("First Name: " + personalInformationEntity.get().getFirstname() +
                    ", Last Name: " + personalInformationEntity.get().getLastname() +
                    ", Birthday: " + personalInformationEntity.get().getBirthday() +
                    ", Email: " + personalInformationEntity.get().getEmail());
        }

        /**
         * Insert a new person
         *
         * // EMAIL UNIQUE
         */
//        PersonalInformationEntity person = new PersonalInformationEntity();
//        person.setEmail("johnwick@gmail.com");
//        person.setBirthday(Date.valueOf("2000-01-07"));
//        person.setFirstname("John");
//        person.setLastname("Wick");
//        personalInformationDao.save(person);
//
//        System.out.println("Inserted person: ID: " + person.getPersonId() + ", First Name: " + person.getFirstname() + ", Last Name: " + person.getLastname() + ", Birthday: " + person.getBirthday() + ", Email: " + person.getEmail());


        /**
         * Update a person's information
         */
        Optional<PersonalInformationEntity> personToUpdate = personalInformationDao.get(5000);

        if (personToUpdate.isPresent()) {
            PersonalInformationEntity updatedPerson = personToUpdate.get();
            updatedPerson.setLastname("Updated Lastname");
            updatedPerson.setFirstname("Updated Firstname");
            updatedPerson.setEmail("updatedemail@gmail.com");
            personalInformationDao.update(updatedPerson, new String[]{"email", "firstname"});
        }

        System.out.println("Updated person: First Name: " + personToUpdate.get().getFirstname() +
                ", Last Name: " + personToUpdate.get().getLastname() +
                ", Email: " + personToUpdate.get().getEmail());

        /**
         * Delete a person
         */
        Optional<PersonalInformationEntity> personToDelete = personalInformationDao.get(3);
        if (personToDelete.isPresent()) {
            personalInformationDao.delete(personToDelete.get());
            System.out.println("Person deleted successfully");
        } else {
            System.out.println("Person not in database");
        }


        /**
         * Transaction from CP-4
         *
         * // Functions with same name error
         */
//        try (Connection connection = DriverManager.getConnection(url, username, password);
//             Statement statement = connection.createStatement()) {
//             String sql = "CREATE FUNCTION add_to_cart_3 (prod_id INT, car_id INT, num INT)\n" +
//                    "RETURNS BOOLEAN\n" +
//                    "AS $$\n" +
//                    "DECLARE\n" +
//                    "count1 INT; count2 INT;\n" +
//                    "BEGIN\n" +
//                    "count1 := (SELECT product_count FROM product WHERE product_id = prod_id);\n" +
//                    "count2 := (SELECT cart_quantity FROM cart WHERE cart_number = car_id);\n" +
//                    "IF (count1 <= 0) OR (num > count1) THEN RETURN false; END IF;\n" +
//                    "UPDATE product SET product_count = product_count - num WHERE product_id = prod_id;\n" +
//                    "UPDATE cart SET cart_quantity = cart_quantity + num WHERE cart_number = car_id;\n" +
//                    "RETURN true;\n" +
//                    "END;\n" +
//                    "$$ LANGUAGE plpgsql;";
//
//            statement.executeUpdate(sql);
//
//            System.out.println("Transaction created successfully.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        /**
         * SELECTS
         */
//        try (Connection connection = DriverManager.getConnection(url, username, password);
//             Statement statement = connection.createStatement()) {
//
//            // SELECTS ALL PEOPLE NAMED JAN
//            String select = "SELECT * FROM personal_information WHERE firstname = 'Jan';";
//            ResultSet resultSet = statement.executeQuery(select);
//            while (resultSet.next()) {
//                int personId = resultSet.getInt("person_id");
//                String firstName = resultSet.getString("firstname");
//                String lastName = resultSet.getString("lastname");
//                Date birthday = resultSet.getDate("birthday");
//                String email = resultSet.getString("email");
//                System.out.println("Person ID: " + personId +
//                        ", First Name: " + firstName +
//                        ", Last Name: " + lastName +
//                        ", Birthday: " + birthday +
//                        ", Email: " + email);
//            }
//
//            // SELECTS ALL PEOPLE BORN IN DATE 1970 - 1975
//            String selectQuery = "SELECT * FROM personal_information WHERE birthday >= '1970-01-01' AND birthday <= '1975-01-01';";
//            ResultSet resultSet2 = statement.executeQuery(selectQuery);
//            while (resultSet2.next()) {
//                int personId = resultSet2.getInt("person_id");
//                String firstName = resultSet2.getString("firstname");
//                String lastName = resultSet2.getString("lastname");
//                Date birthday = resultSet2.getDate("birthday");
//                String email = resultSet2.getString("email");
//                System.out.println("Person ID: " + personId +
//                        ", First Name: " + firstName +
//                        ", Last Name: " + lastName +
//                        ", Birthday: " + birthday +
//                        ", Email: " + email);
//            }
//
//            // SELECTS ALL PEOPLE BORN IN DATE 1970 - 1975
//            String select2 = "SELECT * FROM personal_information WHERE email LIKE '%@gmail.com';";
//            ResultSet resultSet3 = statement.executeQuery(select2);
//            while (resultSet3.next()) {
//                int personId = resultSet3.getInt("person_id");
//                String firstName = resultSet3.getString("firstname");
//                String lastName = resultSet3.getString("lastname");
//                Date birthday = resultSet3.getDate("birthday");
//                String email = resultSet3.getString("email");
//                System.out.println("Person ID: " + personId +
//                        ", First Name: " + firstName +
//                        ", Last Name: " + lastName +
//                        ", Birthday: " + birthday +
//                        ", Email: " + email);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        /**
         * CREATE INDEX
         */
//        try (Connection connection = DriverManager.getConnection(url, username, password);
//             Statement statement = connection.createStatement()) {
//             String sql = "CREATE INDEX personal_info_index ON personal_information (person_id, email, firstname, lastname, birthday);";
//
//            statement.executeUpdate(sql);
//
//            System.out.println("Index created");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }
}


