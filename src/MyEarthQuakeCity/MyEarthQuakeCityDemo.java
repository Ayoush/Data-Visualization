package MyEarthQuakeCity;

import java.util.ArrayList;
import java.util.List;

//Processing library
import processing.core.*;

//Unfolding libraries
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.core.Coordinate;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.providers.OpenStreetMap;
import de.fhpotsdam.unfolding.utils.MapUtils;

//Parsing library
import parsing.ParseFeed;

public class MyEarthQuakeCityDemo extends PApplet {
	private UnfoldingMap map;//unfolding jar
	public void setup()
	{
		size(900,600,OPENGL);
		map= new UnfoldingMap(this,0,0,900,600,new Google.GoogleMapProvider());
        map.zoomToLevel(2);
        MapUtils.createDefaultEventDispatcher(this, map);
        int yellow = color(255,255,0);
        int gray = color(150,150,150);
        PointFeature valdiviaEq = new PointFeature(new Location(-38.14f,-73.03f));
	    valdiviaEq.addProperty("title", "Valdivia, Chile");
	    valdiviaEq.addProperty("magnitude", "9.5");
	    valdiviaEq.addProperty("date", "March 22, 1960");
	    valdiviaEq.addProperty("year", 1960);
	    
	    PointFeature alaskaEq = new PointFeature(new Location(61.02f,-147.65f));
	    alaskaEq.addProperty("title", "1964 Great Alaska Earthquake");
	    alaskaEq.addProperty("magnitude", "9.2");
	    alaskaEq.addProperty("date", "March 28, 1964"); 
	    alaskaEq.addProperty("year", 1964);

	    PointFeature sumatraEq = new PointFeature(new Location(3.30f,95.78f));
	    sumatraEq.addProperty("title", "Off the West Coast of Northern Sumatra");
	    sumatraEq.addProperty("magnitude", "9.1");
	    sumatraEq.addProperty("date", "February 26, 2004");
	    sumatraEq.addProperty("year", 2004);

	    
	    PointFeature japanEq = new PointFeature(new Location(38.322f,142.369f));
	    japanEq.addProperty("title", "Near the East Coast of Honshu, Japan");
	    japanEq.addProperty("magnitude", "9.0");
	    japanEq.addProperty("date", "March 11, 2011");
	    japanEq.addProperty("year", 2011);

	    
	    PointFeature kamchatkaEq = new PointFeature(new Location(52.76f,160.06f));
	    kamchatkaEq.addProperty("title", "Kamchatka");
	    kamchatkaEq.addProperty("magnitude", "9.0");
	    kamchatkaEq.addProperty("date", "November 4, 1952");
	    kamchatkaEq.addProperty("year", 1952);
	    List<PointFeature> bigEq = new ArrayList<PointFeature>();
	    bigEq.add(valdiviaEq);
	    bigEq.add(kamchatkaEq);
	    bigEq.add(japanEq);
	    bigEq.add(sumatraEq);
	    bigEq.add(alaskaEq);
	    List<Marker> markers = new ArrayList<Marker>();
	    for(PointFeature eq:bigEq)
	    {
	    	markers.add(new SimplePointMarker(eq.getLocation(),eq.getProperties()));
	    }
	    for(Marker mk:markers)
	    {
	    	if((int)mk.getIntegerProperty("year")>2000)
	    	{
	    		mk.setColor(yellow);
	    	}else
	    	{
	    		mk.setColor(gray);
	    	}
	    }
	    map.addMarkers(markers);
	}
	public void draw()
	{
		background(10);
		map.draw();
		//addkey();
	}
	public static void main(String[] args) {
		

	}

}
