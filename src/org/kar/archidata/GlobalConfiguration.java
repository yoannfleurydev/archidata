package org.kar.archidata;

import org.kar.archidata.db.DBConfig;
import org.kar.archidata.tools.ConfigBaseVariable;

public class GlobalConfiguration {
	public static DBConfig dbConfig = null;

	static {
		dbConfig = new DBConfig(ConfigBaseVariable.getDBType(), ConfigBaseVariable.getDBHost(),
				Integer.parseInt(ConfigBaseVariable.getDBPort()), ConfigBaseVariable.getDBLogin(),
				ConfigBaseVariable.getDBPassword(), ConfigBaseVariable.getDBName(),
				ConfigBaseVariable.getDBKeepConnected());
	}
}
