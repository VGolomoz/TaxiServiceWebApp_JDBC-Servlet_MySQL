package com.robosh.model.dao.implementations;

import com.robosh.model.dao.interfaces.AddressDao;
import com.robosh.model.dao.implementations.queries.AddressSQL;
import com.robosh.model.dao.mappers.AddressMapper;
import com.robosh.model.dao.mappers.Mapper;
import com.robosh.model.entity.Address;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class named JdbcAddressDao implements AddressDao
 * execute different queries to database with prepared statements
 *
 * @author Orest Shemelyuk
 */

public class JdbcAddressDao implements AddressDao {

    private static final Logger LOG = Logger.getLogger(JdbcAddressDao.class);
    private Connection connection;

    /**
     * public Constructor that assigns connection
     *
     * @param connection
     */
    public JdbcAddressDao(Connection connection) {
        this.connection = connection;
    }

    /**
     * This method takes two String parameters and checks
     * if object exists in database with such fields
     *
     * @param street
     * @param numberHouse
     * @return boolean
     */
    @Override
    public boolean checkAddressExist(String street, String numberHouse) {
        try (PreparedStatement ps = connection.prepareStatement(AddressSQL.READ_BY_ADRESS.getQUERY())) {
            ps.setString(1, street);
            ps.setString(2, numberHouse);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + AddressSQL.READ_BY_ADRESS);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                return true;
            }
        } catch (SQLException e) {
            LOG.error("SQLException occurred", e);
        }
        return false;
    }


    /**
     * This method takes two String parameters
     * and get idAddress if such object exists in database
     * else return -1
     *
     * @param street
     * @param numberHouse
     * @return int
     */
    @Override
    public int getAddressId(String street, String numberHouse) {
        try (PreparedStatement ps = connection.prepareStatement(AddressSQL.READ_ADDRESS_ID.getQUERY())) {
            ps.setString(1, street);
            ps.setString(2, numberHouse);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + AddressSQL.READ_ADDRESS_ID);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                return rs.getInt("id_adress");
            }
        } catch (SQLException e) {
            LOG.error("SQLException occurred", e);
        }
        return -1;
    }


    /**
     * This method takes two String parameters
     * ans return Address if such object exists in database
     * according to parameters else return Address with idAddress
     * equals -1
     *
     * @param street
     * @param numberHouse
     * @return Address
     */
    @Override
    public Address getAddressByStreetNumberHouse(String street, String numberHouse) {
        Mapper<Address> addressMapper = new AddressMapper();
        Address result = new Address();
        result.setIdAddress(-1);
        try (PreparedStatement ps = connection.prepareStatement(AddressSQL.READ_BY_ADRESS.getQUERY())) {
            ps.setString(1, street);
            ps.setString(2, numberHouse);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + AddressSQL.READ_BY_ADRESS);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                result = addressMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.error("SQLException occurred", e);
        }
        return result;
    }


    /**
     * This method takes one int parameter
     * ans return Address if such object exists in database
     * according to parameter else return Address with idAddress
     * equals -1
     *
     * @param id
     * @return Address
     */
    @Override
    public Address getById(int id) {
        Mapper<Address> addressMapper = new AddressMapper();
        Address result = new Address();
        result.setIdAddress(-1);
        try (PreparedStatement ps = connection.prepareStatement(AddressSQL.READ_BY_ID.getQUERY())) {
            ps.setInt(1, id);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + AddressSQL.READ_BY_ADRESS);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                result = addressMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.error("SQLException occurred", e);
        }
        return result;
    }


    /**
     * This method return all addresses from database
     * else null
     *
     * @return List<Address>
     */
    @Override
    public List<Address> findAll() {
        List<Address> addresses = new ArrayList<>();
        final String query = AddressSQL.READ_ALL.getQUERY();

        try (Statement st = connection.createStatement()) {
            LOG.debug("connection createStatement");
            ResultSet rs = st.executeQuery(query);
            LOG.debug("Executed query" + AddressSQL.READ_ALL);
            Mapper<Address> addressMapper = new AddressMapper();

            while (rs.next()) {
                LOG.debug("Read objects");
                Address address = addressMapper.getEntity(rs);
                addresses.add(address);
            }
            return addresses;
        } catch (SQLException e) {
            LOG.error("SQLException occurred", e);
            return null;
        }
    }

    @Override
    /**
     *This method not using here
     */
    public void create(Address entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    /**
     *This method not using here
     */
    public boolean update(Address address) {
        throw new UnsupportedOperationException();
    }

    @Override
    /**
     *This method not using here
     */
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
            LOG.error(" SQLException occurred", e);
            throw new RuntimeException(e);
        }
    }
}
