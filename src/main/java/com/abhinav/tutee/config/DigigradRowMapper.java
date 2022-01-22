package com.abhinav.tutee.config;

import com.abhinav.tutee.dto.ReportDto;
import com.abhinav.tutee.model.consts.Skill;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DigigradRowMapper implements RowMapper<ReportDto> {

    @Override
    @SneakyThrows
    public ReportDto mapRow(ResultSet resultSet, int i) throws SQLException {
        ReportDto dto = new ReportDto();
        dto.setSkill(Skill.values()[resultSet.getInt("skill")].toString());
        dto.setValue(resultSet.getInt("value"));
        return dto;
    }
}
