package com.etroya.service;

import com.etroya.database.DatabaseClass;
import com.etroya.model.Program;
import com.etroya.model.Station;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Adam on 2015-06-14.
 */
public class StationService {
    private Map<Long, Station> stations = DatabaseClass.getStations();

    public List<Station> getAllStations(){
        return new ArrayList<Station>(stations.values());
    }

    public List<Station> getAllStationsPaginated(int start, int size){
        List<Station> list = new ArrayList<>(stations.values());
        return list.subList(start, start+size);
    }

    public Station getStation(long id) {
        return stations.get(id);
    }

    public Station addStation(Station station){
        station.setId(stations.size()+1);
        stations.put(station.getId(), station);
        return station;
    }

    public Station updateStation(Station station){
        if(station.getId() <= 0){
            return null;
        }else{
            stations.put(station.getId(), station);
            return station;
        }
    }

    public Station removeStation(long id){
        return stations.remove(id);
    }
}
