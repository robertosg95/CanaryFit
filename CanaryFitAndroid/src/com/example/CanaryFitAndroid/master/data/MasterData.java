package com.example.CanaryFitAndroid.master.data;


import com.example.CanaryFitAndroid.database.I_Data;
import org.droidpersistence.annotation.Column;
import org.droidpersistence.annotation.PrimaryKey;
import org.droidpersistence.annotation.Table;

@Table(name="category_table")
public class MasterData implements I_Data {

    @PrimaryKey(autoIncrement = true)
    @Column(name = "id")
    private Long id;

    @Column(name = "modalidad")
    private String label;


    public MasterData() {
        setLabel("");
    }

    public MasterData(String txt) {
        setLabel(txt);
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long num) {
        id = num;
    }

    @Override
    public String getLabel() {
        return label;
    }

    public void setLabel(String txt) {
        label = txt;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MasterData){
            MasterData data = (MasterData) obj;

            if(data.getId() == getId()){   //todo
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return getLabel();
    }
}
