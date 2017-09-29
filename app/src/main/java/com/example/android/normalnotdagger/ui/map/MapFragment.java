package com.example.android.normalnotdagger.ui.map;



import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;


import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.normalnotdagger.R;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.Layer;
import com.google.maps.android.data.geojson.GeoJsonFeature;
import com.google.maps.android.data.geojson.GeoJsonLayer;
import com.google.maps.android.data.geojson.GeoJsonPoint;

import com.google.maps.android.data.geojson.GeoJsonPolygonStyle;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;


public class MapFragment extends Fragment implements OnMapReadyCallback, MapMVP, Layer.OnFeatureClickListener, GoogleMap.OnPolygonClickListener {
    private GoogleMap mMap;

    MapPresentr presentr;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map_fragment, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().
                findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        presentr = new MapPresentr(this);
        presentr.loadMap();


        return view;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng sydney = new LatLng(51, 107);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 5.0f));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(final LatLng latLng) {

//                for(int i = 0; i < pol.size(); i++){
//                    pol.get(i).setOnFeatureClickListener(new Layer.OnFeatureClickListener() {
//                        @Override
//                        public void onFeatureClick(Feature feature) {
//                            String text = feature.getProperty("text");
//                            Log.e("text1", feature.getProperty("text"));
//
//                        }
//                    });
//                }

            }
        });

    }



    List<GeoJsonLayer> pol = new ArrayList<>();
  //  List<String> texts = new ArrayList<>();






    @Override
    public void showMap(JSONArray maps) {
        for(int i = 0; i < maps.length(); i++) {
            JSONObject json = null;
            try {
                json = new JSONObject(maps.get(i).toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            GeoJsonLayer layer = new GeoJsonLayer(mMap, json);
            GeoJsonPolygonStyle style = layer.getDefaultPolygonStyle();
            style.toPolygonOptions().clickable(true);
            layer.setOnFeatureClickListener(this);

//            JSONObject dataJsonObj = null;
//            String secondName = "";
//            try {
//                dataJsonObj = new JSONObject(maps.getString(i));
//                secondName = dataJsonObj.getString("");
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }



//            JSONObject geometry = null;
//            try {
//                geometry = new JSONObject(json.get("geometry").toString());
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            JSONArray coordinates = null;
//
//            try {
//                String cm = geometry.getString("coordinates");
//                coordinates = new JSONArray(cm);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }

//            JSONArray coordinates1 = null;
//            try {
//                coordinates1 = new JSONArray(coordinates.getString(0));
//            } catch (JSONException e) {
//                Log.e("Coordinates", "2 geometry: "+ e);
//                e.printStackTrace();
//            }
//
//            double x = 0;
//            double y = 0;
           // try {
              //  Log.e("error",coordinates1.getString(0).substring(1,coordinates1.getString(0).length()-1).split(",")[0]);
              //  Log.e("double", "" + Double.valueOf(coordinates1.getString(0).substring(1,coordinates1.getString(0).length()-1).split(",")[0].substring(1,coordinates1.getString(0).substring(1,coordinates1.getString(0).length()-1).split(",")[0].length()-1)));
//                x = Double.valueOf(coordinates1.getString(0).substring(1,coordinates1.getString(0).length()-1).split(",")[0].substring(1,coordinates1.getString(0).substring(1,coordinates1.getString(0).length()-1).split(",")[0].length()-1));
//                y = Double.valueOf(coordinates1.getString(0).substring(1,coordinates1.getString(0).length()-1).split(",")[1].substring(1,coordinates1.getString(0).substring(1,coordinates1.getString(0).length()-1).split(",")[1].length()-1));
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }

//
//            JSONArray cor = null;
//            try {
//                cor = new JSONArray(coordinates1);
//                Log.e("cor", cor.getString(0));
//            } catch (JSONException e) {
//                Log.e("error", e +"");
//                e.printStackTrace();
//            }

          //  mMap.addMarker(new MarkerOptions().position(new LatLng(x,y)).title("point"));



//            JSONObject properties = null;
//            try {
//                properties = new JSONObject(json.get("properties").toString());
//            } catch (JSONException e) {
//             //   Log.e("ErrorProperties", "not Properties: "+ e);
//                e.printStackTrace();
//            }
//            try {
//                if(properties.get("fillColor").toString().isEmpty()){
//                    Log.e("Color", properties.get("color").toString());
//                }
//              //  Log.e("Color", properties.get("fillColor").toString());
//            } catch (JSONException e) {
//            //    Log.e("ErrorColor", "not Color: "+ e);
//                e.printStackTrace();
//            }
//            String text = null;
//            try {
//                text = properties.get("text").toString();
//
//                texts.add(text);
//                //  Log.e("Color", properties.get("fillColor").toString());
//            } catch (JSONException e) {
//                //    Log.e("ErrorColor", "not Color: "+ e);
//                e.printStackTrace();
//            }

         //   if(text != null) {
//                GeoJsonPoint point = new GeoJsonPoint(new LatLng(y, x));
//                HashMap<String, String> info = new HashMap<String, String>();
//                info.put(String.valueOf(i), text);
//                GeoJsonFeature pointFeature = new GeoJsonFeature(point,"points", info, null);
//                layer.addFeature(pointFeature);
       //     }


            int coll = Integer.parseInt("e74c3c", 16);
            double a = 0.4 * 255;
           // Log.e("color", Color.parseColor("#e74c3c") + "  " + coll);
            int b = (int) a;
            int myColor = Color.argb(b, 151, 583, 32);
            style.setFillColor(myColor);
            layer.addLayerToMap();

            pol.add(layer);
        }
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void startProgresBar() {

    }

    @Override
    public void stopProgresBar() {

    }

    @Override
    public void onFeatureClick(Feature feature) {
        Log.e("text1", feature.getProperty("text1")+ " tessst " + feature.getProperties());

    }

    @Override
    public void onPolygonClick(Polygon polygon) {
        Log.e("text1", polygon.getFillColor() + " teeest poligon");
    }
}


