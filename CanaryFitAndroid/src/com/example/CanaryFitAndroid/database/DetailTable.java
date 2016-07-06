package com.example.CanaryFitAndroid.database;


import com.example.CanaryFitAndroid.detail.data.DetailData;
import org.droidpersistence.dao.TableDefinition;


public class DetailTable extends TableDefinition<DetailData> {

	public DetailTable() {
		super(DetailData.class);
	}

}
