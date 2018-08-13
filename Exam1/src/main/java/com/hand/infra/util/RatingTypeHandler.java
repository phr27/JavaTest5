package com.hand.infra.util;

import com.hand.domain.entity.RatingEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RatingTypeHandler implements TypeHandler<RatingEnum> {
    @Override
    public void setParameter(PreparedStatement ps, int i, RatingEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getStringValue());
    }

    @Override
    public RatingEnum getResult(ResultSet rs, String columnName) throws SQLException {
        return RatingEnum.ofString(rs.getString(columnName));
    }

    @Override
    public RatingEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        return RatingEnum.ofString(rs.getString(columnIndex));
    }

    @Override
    public RatingEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return RatingEnum.ofString(cs.getString(columnIndex));
    }
}
