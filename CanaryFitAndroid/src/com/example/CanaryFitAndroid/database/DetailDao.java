package com.example.CanaryFitAndroid.database;

import android.database.sqlite.SQLiteDatabase;
import com.example.CanaryFitAndroid.detail.data.DetailData;
import org.droidpersistence.dao.DroidDao;
import org.droidpersistence.dao.TableDefinition;


public class DetailDao extends DroidDao<DetailData, Long> {

	public DetailDao(TableDefinition<DetailData> td, SQLiteDatabase db) {

		super(DetailData.class, td, db);
	}

}
