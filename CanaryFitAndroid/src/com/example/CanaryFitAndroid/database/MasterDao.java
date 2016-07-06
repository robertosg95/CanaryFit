package com.example.CanaryFitAndroid.database;

import android.database.sqlite.SQLiteDatabase;
import com.example.CanaryFitAndroid.master.data.MasterData;
import org.droidpersistence.dao.DroidDao;
import org.droidpersistence.dao.TableDefinition;


public class MasterDao extends DroidDao<MasterData, Long> {

	public MasterDao(TableDefinition<MasterData> td, SQLiteDatabase db) {

		super(MasterData.class, td, db);
	}

}
