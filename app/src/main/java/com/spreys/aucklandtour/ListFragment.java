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
import android.widget.ListView;

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

        return view;
    }

    private List<Landmark> getLandmarksForType() {
        ListType type = (ListType)getArguments().getSerializable(KEY_VIEW_TYPE);

        List<Landmark> results = new ArrayList<>();

        switch (type) {
            case Landmarks:
                results.add(new Landmark());
                break;
            case Shops:
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

        public LandmarksAdapter(Context context, int resource, List<Landmark> landmarks) {
            super(context, 0, landmarks);
            this.landmarks = landmarks;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return super.getView(position, convertView, parent);
        }

        @Override
        public int getCount() {
            return landmarks.size();
        }
    }
}
