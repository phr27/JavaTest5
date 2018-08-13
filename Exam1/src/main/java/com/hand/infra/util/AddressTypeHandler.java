package com.hand.infra.util;

import com.hand.domain.entity.Address;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressTypeHandler implements TypeHandler<Address> {
    @Override
    public void setParameter(PreparedStatement ps, int i, Address parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getAddressId());
    }

    @Override
    public Address getResult(ResultSet rs, String columnName) throws SQLException {
        return null;
    }

    @Override
    public Address getResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public Address getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
