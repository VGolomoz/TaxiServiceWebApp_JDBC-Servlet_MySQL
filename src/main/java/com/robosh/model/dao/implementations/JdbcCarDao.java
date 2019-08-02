package com.robosh.model.dao.implementations;

import com.robosh.model.dao.interfaces.CarDao;
import com.robosh.model.dao.implementations.queries.CarSQL;
import com.robosh.model.dao.mappers.CarMapper;
import com.robosh.model.dao.mappers.Mapper;
import com.robosh.model.entity.Car;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * This class named JdbcCarDao implements CarDao
 * execute different queries to database with prepared statements
 *
 * @author Orest Shemelyuk
 */

public class JdbcCarDao implements CarDao {

    private static final Logger LOG = Logger.getLogger(JdbcCarDao.class);
    private Connection connection;

    /**
     * public Constructor that assigns connection
     *
     * @param connection
     */
    public JdbcCarDao(Connection connection) {
        this.connection = connection;
    }


    /**
     * This method takes one int parameter and return Car object
     * if iit exists else Car with idCar equals -1
     *
     * @param id
     * @return Car
     */
    @Override
    public Car getById(int id) {
        Mapper<Car> carMapper = new CarMapper();
        Car result = new Car();
        result.setIdCar(-1);

        try (PreparedStatement ps = connection.prepareStatement(CarSQL.READ_BY_ID.getQUERY())) {
            ps.setInt(1, id);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + CarSQL.READ_BY_ID);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                result = carMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.error("SQLException occurred in JdbcCarDao ", e);
        }
        return result;
    }

    /**
     * This method should return all Car from database
     * else return null
     *
     * @return List<Car>
     */

    @Override
    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        final String query = CarSQL.READ_ALL.getQUERY();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            Mapper<Car> carMapper = new CarMapper();
            LOG.debug("Executed query" + CarSQL.READ_ALL);
            while (rs.next()) {
                LOG.debug("check is rs has next");
                Car car = carMapper.getEntity(rs);
                cars.add(car);
            }
            return cars;
        } catch (SQLException e) {
            LOG.error("SQLException occurred in JdbcCarDao" , e);
            return null;
        }
    }

    /**
     * This method take two parameters
     * int parameter id_car and String carType
     * and checks if Car exists in database according to such parameters
     *
     * @param id_car
     * @param carType
     * @return boolean
     */
    @Override
    public boolean isSameCarType(int id_car, String carType) {
        try (PreparedStatement ps = connection.prepareStatement(CarSQL.READ_BY_ID_AND_CAR_TYPE.getQUERY())) {
            ps.setInt(1, id_car);
            ps.setString(2, carType);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + CarSQL.READ_BY_ID_AND_CAR_TYPE);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                return true;
            }
        } catch (SQLException e) {
            LOG.error("SQLException occurred in JdbcCarDao", e);
        }
        return false;
    }

    @Override
    /**
     *This method not using here
     */
    public void create(Car entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    /**
     *This method not using here
     */
    public boolean update(Car car) {
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
            LOG.error("SQLException occurred", e);
            throw new RuntimeException(e);
        }
    }
}
