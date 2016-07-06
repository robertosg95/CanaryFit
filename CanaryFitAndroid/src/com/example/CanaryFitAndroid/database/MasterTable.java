package com.example.CanaryFitAndroid.database;


import com.example.CanaryFitAndroid.master.data.MasterData;
import org.droidpersistence.dao.TableDefinition;


public class MasterTable extends TableDefinition<MasterData> {

	public MasterTable() {
		super(MasterData.class);
	}

}
