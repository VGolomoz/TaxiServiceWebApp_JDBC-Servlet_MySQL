package com.robosh.model.dao.implementations;

import com.robosh.model.dao.interfaces.ClientDao;
import com.robosh.model.dao.implementations.queries.ClientSQL;
import com.robosh.model.dao.mappers.ClientMapper;
import com.robosh.model.dao.mappers.Mapper;
import com.robosh.model.entity.Client;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * This class named JdbcClientDao implements ClientDao
 * execute different queries to database with prepared statements
 *
 * @author Orest Shemelyuk
 */

public class JdbcClientDao implements ClientDao {

    private static final Logger LOG = Logger.getLogger(JdbcClientDao.class);
    private Connection connection;

    public JdbcClientDao(Connection connection) {
        this.connection = connection;
    }

    /**
     * Takes two parameters and checks if
     * client exists in database
     *
     * @param phoneNumber
     * @param password
     * @return
     */
    @Override
    public boolean isClientExists(String phoneNumber, String password) {
        try (PreparedStatement ps = connection.prepareStatement(ClientSQL.READ_BY_PHONE_PASSWORD.getQUERY())) {
            ps.setString(1, phoneNumber);
            ps.setString(2, password);
            final ResultSet rs = ps.executeQuery();

            LOG.debug("Executed query" + ClientSQL.READ_BY_PHONE_PASSWORD);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                return true;
            }
        } catch (SQLException e) {
            LOG.error("SQLException occurred in JdbcClientDao", e);
        }
        return false;
    }

    /**
     * Takes phone Number
     * and checks if phone number is free
     *
     * @param phoneNumber
     * @return boolean
     */
    @Override
    public boolean isPhoneNumberExists(String phoneNumber) {
        try (PreparedStatement ps = connection.prepareStatement(ClientSQL.READ_BY_PHONE_NUMBER.getQUERY())) {
            ps.setString(1, phoneNumber);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + ClientSQL.READ_BY_PHONE_NUMBER);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                return true;
            }
        } catch (SQLException e) {
            LOG.error("SQLException occurred in JdbcClientDao", e);
        }
        return false;
    }

    /**
     * Takes email and checks if email is free
     *
     * @param email
     * @return boolean
     */
    @Override
    public boolean isEmailExists(String email) {
        try (PreparedStatement ps = connection.prepareStatement(ClientSQL.READ_BY_EMAIL.getQUERY())) {
            ps.setString(1, email);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + ClientSQL.READ_BY_EMAIL);
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            LOG.error("SQLException occurred in JdbcClientDao", e);
        }
        return false;
    }

    /**
     * Takes two parameters and get Client
     * from database
     *
     * @param phoneNumber
     * @param password
     * @return Client
     */
    @Override
    public Client getClientByPassPhone(String phoneNumber, String password) {
        Mapper<Client> clientMapper = new ClientMapper();
        Client result = new Client();
        result.setPersonId(-1);
        try (PreparedStatement ps = connection.prepareStatement(ClientSQL.READ_BY_PHONE_PASSWORD.getQUERY())) {
            ps.setString(1, phoneNumber);
            ps.setString(2, password);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + ClientSQL.READ_BY_PHONE_PASSWORD);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                result = clientMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.error("SQLException occurred in JdbcClientDao ",e);
        }
        return result;
    }

    /**
     * takes Client object and create such object in database
     *
     * @param client
     */
    @Override
    public void create(Client client) {
        try (PreparedStatement ps = connection.prepareStatement(ClientSQL.INSERT.getQUERY())) {
            LOG.debug("Executed query" + ClientSQL.INSERT);
            ps.setString(1, client.getSurname());
            ps.setString(2, client.getName());
            ps.setString(3, client.getPhoneNumber());
            ps.setString(4, client.getEmail());
            ps.setString(5, client.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error("SQLException occurred in JdbcClientDao", e);
        }
    }

    /**
     * takes one int parameter and return Client by id
     *
     * @param id
     * @return Client
     */
    @Override
    public Client getById(int id) {
        Mapper<Client> clientMapper = new ClientMapper();
        Client result = new Client();
        result.setPersonId(-1);

        try (PreparedStatement ps = connection.prepareStatement(ClientSQL.READ_BY_ID.getQUERY())) {
            ps.setInt(1, id);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + ClientSQL.READ_BY_ID);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                result = clientMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.error("SQLException occurred in JdbcClientDao", e);
        }
        return result;
    }

    /**
     * returns all Clients from Database
     *
     * @return
     */
    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        final String query = ClientSQL.READ_ALL.getQUERY();

        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            LOG.debug("Executed query" + ClientSQL.READ_ALL);
            Mapper<Client> clientMapper = new ClientMapper();

            while (rs.next()) {
                LOG.debug("Read objects");
                Client student = clientMapper.getEntity(rs);
                clients.add(student);
            }
            return clients;
        } catch (SQLException e) {
            LOG.error("SQLException occurred in JdbcClientDao", e);
            return null;
        }
    }


    /**
     * This method not using here
     */
    @Override
    public boolean update(Client client) {
        throw new UnsupportedOperationException();
    }

    /**
     * This method not using here
     */
    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException();
    }

    /**
     * this method
     * close connection
     */
    @Override
    public void close() {
        try {
            connection.close();
            LOG.debug("Connection closed");
        } catch (SQLException e) {
            LOG.error("SQLException occurred", e);
            throw new RuntimeException(e);
        }
    }

}
