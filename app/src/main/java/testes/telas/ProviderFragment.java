package testes.telas;

import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ProviderFragment extends  SupportMapFragment implements OnMapReadyCallback,
        GoogleMap.OnMapClickListener{

    // Variavel do Mapa
    private GoogleMap mMap;
    // Variavel que controla a localização atual
    private LocationManager locationManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this);
    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        try{
            locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            Criteria criteria = new Criteria();
            String provider = locationManager.getBestProvider(criteria, true);

            mMap = googleMap;
            mMap.getUiSettings().setZoomGesturesEnabled(true);
            mMap.setOnMapClickListener(this);
            mMap.setMyLocationEnabled(true);
        }catch(SecurityException ex){

        }

        // Teste de Marcação AVENIDA PAULISTA
        LatLng paulista = new LatLng(-23.5629, -46.6544 );
        MarkerOptions marker = new MarkerOptions();
        marker.position(paulista);
        marker.title("Avenida Paulista");
        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(paulista));
    }

    @Override
    public void onMapClick(LatLng latLng) {

    }
}
