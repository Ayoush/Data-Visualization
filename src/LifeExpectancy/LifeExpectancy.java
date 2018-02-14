package LifeExpectancy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;

public class LifeExpectancy extends PApplet {
	private UnfoldingMap map;
	Map <String,Float> lifeExpbyCountry;
	List<Feature> countries;
	List<Marker> countryMarker;
	
	public void setup()
	{
		size(900,900,OPENGL);
		map = new UnfoldingMap(this,0,0,900,900,new Google.GoogleMapProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
		lifeExpbyCountry = loadLifeExpectancyFromCSV("LifeExpectancyWorldBankModule3.csv");
		countries = GeoJSONReader.loadData(this, "countries.geo.json");
		countryMarker = MapUtils.createSimpleMarkers(countries);
		map.addMarkers(countryMarker);
		shadeCountries();
	}
	public void draw()
	{
		map.draw();
	}
	private void shadeCountries()
	{
		for(Marker marker:countryMarker)
		{
			String countryId = marker.getId();
			if(lifeExpbyCountry.containsKey(countryId))
			{
				float lifeExp = lifeExpbyCountry.get(countryId);
				int colorLevel = (int) map(lifeExp,40,90,10,255);
				marker.setColor(color(255-colorLevel,100,colorLevel));
			}
			else {
				marker.setColor(color(150,150,150));
			}
		}
	}
	private Map<String,Float> loadLifeExpectancyFromCSV(String fileName)
	{
		Map<String,Float> lifeExpMap = new HashMap<String,Float>();
		String[] rows = loadStrings(fileName);
		for(String row:rows)
		{
			String[] columns = row.split(",");
			if(columns.length == 6 && !columns[5].equals(".."))
			{
				float value = Float.parseFloat(columns[5]);
				lifeExpMap.put(columns[4], value);
			}
		}
		return lifeExpMap;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
