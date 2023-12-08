package org.kar.archidata.migration.model;

import org.kar.archidata.annotation.DataComment;
import org.kar.archidata.annotation.DataDefault;
import org.kar.archidata.annotation.DataIfNotExists;
import org.kar.archidata.model.GenericDataSoftDelete;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Table;

// For logs only
//public static final String TABLE_NAME = "KAR_migration";

@Table(name = "KAR_migration")
@DataIfNotExists
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Migration1 extends GenericDataSoftDelete {
	final static int VERSION_MIGRATION = 1;
	@DataComment("Name of the migration")
	@Column(length = 256)
	public String name;
	@Column(nullable = false)
	@DataDefault("'0'")
	@DataComment("if the migration is well terminated or not")
	public Boolean terminated = false;
	@DataComment("index in the migration progression")
	public Integer stepId = 0;
	@DataComment("number of element in the migration")
	public Integer count;
	@DataComment("Log generate by the migration")
	@Column(length = 0)
	public String log = "";
}
