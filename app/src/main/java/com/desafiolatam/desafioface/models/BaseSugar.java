package com.desafiolatam.desafioface.models;

import com.orm.SugarRecord;

/**
 * Created by Aldo Gallardo on 27-03-2017.
 */

public class BaseSugar extends SugarRecord {

    private long serverId;

    //colocar la id que trae el json a sugar ya que sugar poner una propia y no queremos eso
    @Override
    public long save() {
        return super.save();
    }

    public void create(){
        setServerId(getId());
        setId(null);
        super.save();
    }

    public long getServerId() {return serverId;}

    public void setServerId(long serverId) {this.serverId = serverId;}
}
