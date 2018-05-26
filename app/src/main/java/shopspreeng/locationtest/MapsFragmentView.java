package shopspreeng.locationtest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsFragmentView extends Fragment implements OnMapReadyCallback, MainActivity.LocationInteractionListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    GoogleMap gmap;
    boolean mapReady;
    MainActivity.LocationInteractionListener mLocationInteraction;
    MarkerOptions locationMarker;

    public MapsFragmentView() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MapsFragmentView.
     */
    // TODO: Rename and change types and number of parameters
    public static MapsFragmentView newInstance(String param1, String param2) {
        MapsFragmentView fragment = new MapsFragmentView();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_maps, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(this);
        mLocationInteraction = this;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        gmap = googleMap;
        moveAndSetMarker(new LatLng(40.784,-73.9857));
    }

    void moveAndSetMarker (LatLng lastLocation) {
        Toast.makeText(getActivity(), "second entry : " + String.valueOf(lastLocation), Toast.LENGTH_SHORT).show();
        if (locationMarker != null) {
            gmap.clear();
        }
        locationMarker = new MarkerOptions().position(lastLocation).title("Home");
        gmap.addMarker(locationMarker);
        CameraPosition target = CameraPosition.builder().target(lastLocation).zoom(17).build();
        gmap.animateCamera(CameraUpdateFactory.newCameraPosition(target));
    }

    @Override
    public void onLocationInteractionChanged(LatLng latLng) {
        Toast.makeText(getActivity(), "first entry : " + String.valueOf(latLng), Toast.LENGTH_SHORT).show();
        moveAndSetMarker(latLng);
    }

}
