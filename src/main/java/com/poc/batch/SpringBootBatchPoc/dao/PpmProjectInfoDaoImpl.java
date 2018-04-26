package com.poc.batch.SpringBootBatchPoc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.mysql.jdbc.Statement;
import com.poc.batch.SpringBootBatchPoc.model.PpmProjectInfo;

public class PpmProjectInfoDaoImpl extends JdbcDaoSupport implements PpmProjectInfoDao {

	@Override
	public PpmProjectInfo insert(PpmProjectInfo ppmProjectInfo) {
		String sql = "Insert  into ppm_project_info (batch_id, status, project_type, project_number, project_title, project_decription, product_category,"
				+ " platform, project_gate, project_start_date, project_end_date) "
				+ " values (?,?,?,?,?,?,?,?,?,?,?)";
		KeyHolder holder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, ppmProjectInfo.getBatchId());
				ps.setString(2, ppmProjectInfo.getStatus());
				ps.setString(3, ppmProjectInfo.getProjectType());
				ps.setString(4, ppmProjectInfo.getProjectNumber());
				ps.setString(5, ppmProjectInfo.getProjectTitle());
				ps.setString(6, ppmProjectInfo.getProjectDescription());
				ps.setString(7, ppmProjectInfo.getProjectCategory());
				ps.setString(8, ppmProjectInfo.getPlatform());
				ps.setString(9, ppmProjectInfo.getProjectGate());
				ps.setString(10, ppmProjectInfo.getProjectStartDate());
				ps.setString(11, ppmProjectInfo.getProjectEndDate());
				return ps;
			}
		}, holder);

		int id = holder.getKey().intValue();
		ppmProjectInfo.setBatchId(id);
		return ppmProjectInfo;
	}

	@Override
	public void update(PpmProjectInfo ppmProjectInfo) {
		String sql = "Update ppm_project_info set error_message=? where  batch_id=?";
		Object[] params = { new Date(), ppmProjectInfo.getErrorMessage(), ppmProjectInfo.getBatchId() };
		getJdbcTemplate().update(sql, params);
	}

}
