package com.robosh.model.dao.implementations;

import com.robosh.model.dao.interfaces.CouponDao;
import com.robosh.model.dao.implementations.queries.CouponSQL;
import com.robosh.model.dao.mappers.CouponMapper;
import com.robosh.model.dao.mappers.Mapper;
import com.robosh.model.entity.Coupon;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class named JdbcCouponDao implements CouponDao
 * execute different queries to database with prepared statements
 *
 * @author Orest Shemelyuk
 */
public class JdbcCouponDao implements CouponDao {
    private Connection connection;
    private static final Logger LOG = Logger.getLogger(JdbcCouponDao.class);

    public JdbcCouponDao(Connection connection) {
        this.connection = connection;
    }

    /**
     * takes int parameter and search
     * Coupon by id else return Coupon with idCoupon -1
     *
     * @param id
     * @return
     */
    @Override
    public Coupon getById(int id) {
        Mapper<Coupon> couponMapper = new CouponMapper();
        Coupon result = new Coupon();
        result.setIdCoupon(-1);

        try (PreparedStatement ps = connection.prepareStatement(CouponSQL.READ_BY_ID.getQUERY())) {
            ps.setInt(1, id);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + CouponSQL.READ_BY_ID);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                result = couponMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.error("SQLException occurred in JdbcCouponDao", e);
        }
        return result;
    }

    /**
     * return All Coupon from database
     *
     * @return List<Coupon>
     */
    @Override
    public List<Coupon> findAll() {
        List<Coupon> coupons = new ArrayList<>();
        final String query = CouponSQL.READ_ALL.getQUERY();
        LOG.debug("Executed query" + CouponSQL.READ_ALL);
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            Mapper<Coupon> couponMapper = new CouponMapper();

            while (rs.next()) {
                LOG.debug("Read objects");
                Coupon coupon = couponMapper.getEntity(rs);
                coupons.add(coupon);
            }
            return coupons;
        } catch (SQLException e) {
            LOG.error("SQLException occurred in JdbcCouponDao", e);
            return null;
        }
    }

    /**
     * return from database Coupon by couponName
     *
     * @param couponName
     * @return Coupon
     */
    @Override
    public Coupon readByCouponName(String couponName) {
        Mapper<Coupon> couponMapper = new CouponMapper();
        Coupon result = new Coupon();
        result.setIdCoupon(-1);
        try (PreparedStatement ps = connection.prepareStatement(CouponSQL.READ_BY_COUPON.getQUERY())) {
            ps.setString(1, couponName);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + CouponSQL.READ_BY_COUPON);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                result = couponMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.error("SQLException occurred in JdbcCouponDao", e);
        }
        return result;
    }

    /**
     * This method not using here
     */
    @Override
    public void create(Coupon entity) {
        throw new UnsupportedOperationException();
    }


    /**
     * This method not using here
     */
    @Override
    public boolean update(Coupon coupon) {
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
