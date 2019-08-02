package com.robosh.model.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * interface Mapper
 * @author Orest Shemelyuk
 * @param <T>
 */
public interface Mapper<T> {
    T getEntity(ResultSet resultSet) throws SQLException;
}
