package com.hand.infra.util;

import com.hand.domain.entity.SpecialFeature;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class SpecialFeatureTypeHandler implements TypeHandler<Set<SpecialFeature>> {

    private static ThreadLocal<StringBuilder> setValueBuilder = ThreadLocal.withInitial(StringBuilder::new);

    @Override
    public void setParameter(PreparedStatement ps, int i, Set<SpecialFeature> parameter, JdbcType jdbcType) throws SQLException {
        StringBuilder valueBuilder = setValueBuilder.get();
        parameter.stream().forEach(sf -> valueBuilder.append(sf.getStringValue()).append(','));
        valueBuilder.setLength(valueBuilder.length() - 1);

        ps.setString(i, valueBuilder.toString());
    }

    private Set<SpecialFeature> handleSetValue(String value) {
        String[] values = value.split(",");
        Set<SpecialFeature> valueSet = new HashSet<>();
        for (int i = 0; i < values.length; i++) {
            valueSet.add(SpecialFeature.ofString(values[i]));
        }

        return valueSet;
    }

    @Override
    public Set<SpecialFeature> getResult(ResultSet rs, String columnName) throws SQLException {
        return handleSetValue(rs.getString(columnName));
    }

    @Override
    public Set<SpecialFeature> getResult(ResultSet rs, int columnIndex) throws SQLException {
        return handleSetValue(rs.getString(columnIndex));
    }

    @Override
    public Set<SpecialFeature> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return handleSetValue(cs.getString(columnIndex));
    }
}
