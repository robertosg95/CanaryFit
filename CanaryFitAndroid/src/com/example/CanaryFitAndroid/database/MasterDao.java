package com.example.CanaryFitAndroid.database;

import android.database.sqlite.SQLiteDatabase;
import com.example.CanaryFitAndroid.master.data.MasterData;
import org.droidpersistence.dao.DroidDao;
import org.droidpersistence.dao.TableDefinition;

/**
 * Un Data Access Object (DAO, Objeto de Acceso a Datos) es un componente de software
 * que suministra una interfaz común entre la aplicación y uno o más dispositivos de almacenamiento de datos,
 * tales como una Base de datos o un archivo. El término se aplica frecuentemente al Patrón de diseño Object.
 * Referencia: https://es.wikipedia.org/wiki/Data_Access_Object
 */

public class MasterDao extends DroidDao<MasterData, Long> {

	public MasterDao(TableDefinition<MasterData> td, SQLiteDatabase db) {

		super(MasterData.class, td, db);
	}

}
