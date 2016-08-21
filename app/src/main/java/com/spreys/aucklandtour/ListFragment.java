package com.spreys.aucklandtour;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created with Android Studio
 *
 * @author vspreys
 *         Date: 14/08/16
 *         Project: AucklandTour
 *         Contact by: vlad@spreys.com
 */
public class ListFragment extends Fragment {
    public static final String KEY_VIEW_TYPE = "key_view_type";

    public enum ListType {
        Landmarks,
        Shops,
        Cinemas,
        Parks
    }

    @BindView(R.id.fragment_list_listview)
    ListView landmarksListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        ButterKnife.bind(this, view);

        List<Landmark> landmarks = getLandmarksForType();
        landmarksListView.setAdapter(new LandmarksAdapter(getActivity(), landmarks));

        return view;
    }

    private List<Landmark> getLandmarksForType() {
        ListType type = (ListType)getArguments().getSerializable(KEY_VIEW_TYPE);

        List<Landmark> results = new ArrayList<>();

        switch (type) {
            case Landmarks:
                results.add(new Landmark("Auckland Museum", "The Auckland Domain, Parnell", R.drawable.auckland_museum));
                results.add(new Landmark("One Tree Hill Obelisk", "670 Manukau Rd, Epsom", R.drawable.one_tree_hill_obelisk));
                results.add(new Landmark("Sky City", "Victoria Street & Federal Street, Auckland ", R.drawable.sky_city));
                break;
            case Shops:
                results.add(new Landmark("Sylvia Park Shopping Mall", "286 Mount Wellington Hwy, Mount Wellington", null));
                results.add(new Landmark("Dressmart Shopping Mall", "151 Arthur St, Onehunga", null));
                results.add(new Landmark("St Lukes Shopping Mall", "80 St Lukes Rd, St Lukes", null));
                break;
            case Parks:
                break;
            case Cinemas:
                break;
        }

        return results;
    }

    private class LandmarksAdapter extends ArrayAdapter<Landmark> {
        List<Landmark> landmarks;

        public LandmarksAdapter(Context context, List<Landmark> landmarks) {
            super(context, 0, landmarks);
            this.landmarks = landmarks;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.landmark_item, parent,
                        false);
            }

            Landmark landmark = this.landmarks.get(position);

            ((TextView)view.findViewById(R.id.ladmark_item_name)).setText(landmark.getName());
            ((TextView)view.findViewById(R.id.lanmark_item_location)).setText(landmark.getLocation());

            ImageView imageView = (ImageView) view.findViewById(R.id.lanmark_item_image);
            imageView.setVisibility(landmark.getDrawableResourceId() != null ? View.VISIBLE : View.GONE);

            if (landmark.getDrawableResourceId() != null) {
                imageView.setImageResource(landmark.getDrawableResourceId());
            }

            return view;
        }

        @Override
        public int getCount() {
            return landmarks.size();
        }
    }
}
