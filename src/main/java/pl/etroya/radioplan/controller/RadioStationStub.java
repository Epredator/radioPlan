package pl.etroya.radioplan.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pl.etroya.radioplan.model.RadioStation;

public class RadioStationStub {
	private static Map<Long, RadioStation> radioStations = new HashMap<Long, RadioStation>();
	private static Long idIndex = 3L;

	//populate initial wrecks
	static {
		RadioStation a = new RadioStation(1L, "Radio Warszawa", "opis stacji", 1990);
		radioStations.put(1L, a);
		RadioStation b = new RadioStation(2L, "Radio Zet", "kolejny opis stacji",  1994);
		radioStations.put(2L, b);
		RadioStation c = new RadioStation(3L, "Radio Maryja", "inny opis stacji", 1991);
		radioStations.put(3L, c);
	}

	public static List<RadioStation> list() {
		return new ArrayList<RadioStation>(radioStations.values());
	}

	public static RadioStation create(RadioStation wreck) {
		idIndex += idIndex;
		wreck.setId(idIndex);
		radioStations.put(idIndex, wreck);
		return wreck;
	}

	public static RadioStation get(Long id) {
		return radioStations.get(id);
	}

	public static RadioStation update(Long id, RadioStation radioStation) {
		radioStations.put(id, radioStation);
		return radioStation;
	}

	public static RadioStation delete(Long id) {
		return radioStations.remove(id);
	}
}
