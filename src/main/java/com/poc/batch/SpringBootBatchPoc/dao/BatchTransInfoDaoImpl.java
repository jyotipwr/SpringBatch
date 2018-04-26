package com.poc.batch.SpringBootBatchPoc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Statement;
import com.poc.batch.SpringBootBatchPoc.model.BatchTransInfo;

@Repository
public class BatchTransInfoDaoImpl extends JdbcDaoSupport implements BatchTransInfoDao {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public BatchTransInfo insert(BatchTransInfo batchInfo) {
		String sql = "Insert  into batch_trans_info (file_name, status, start_time) values (?,?,?)";
		KeyHolder holder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, batchInfo.getFileName());
				ps.setString(2, batchInfo.getStatus());
				ps.setString(3, new Date().toString());
				return ps;
			}
		}, holder);

		int id = holder.getKey().intValue();
		batchInfo.setBatchId(id);
		return batchInfo;
	}

	@Override
	public void update(BatchTransInfo batchInfo) {
		String sql = "Update batch_trans_info set end_time=?, status=?, error_message=? where  batch_id=?";
		Object[] params = { new Date(), batchInfo.getStatus(), batchInfo.getErrorMessage(), batchInfo.getBatchId() };
		getJdbcTemplate().update(sql, params);
	}

}
