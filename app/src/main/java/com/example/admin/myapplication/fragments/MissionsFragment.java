package com.example.admin.myapplication.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.activities.MainActivity;
import com.example.admin.myapplication.adapter.SpinnerAdapter;
import com.example.admin.myapplication.database.DatabaseManager;
import com.example.admin.myapplication.models.Mission;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link MissionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MissionsFragment extends Fragment {

    private Mission current_mission;
    private List<Mission> missions;

    private MainActivity mainActivity;

    private TextView mission_name;
    private TextView mission_description;
    private TextView bt_start;

    public MissionsFragment() {
        // Required empty public constructor
    }

    public MissionsFragment(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MissionsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MissionsFragment newInstance(MainActivity mainActivity) {
        MissionsFragment fragment = new MissionsFragment(mainActivity);
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View my_view = inflater.inflate(R.layout.fragment_missions, null);
        missions = DatabaseManager.getMissions(getActivity());

        Spinner spinner = (Spinner) my_view.findViewById(R.id.spinner);
        SpinnerAdapter adapter = new SpinnerAdapter(missions,null, getContext());
        spinner.setAdapter(adapter);

        mission_description = (TextView) my_view.findViewById(R.id.mission_desp);
        mission_name = (TextView) my_view.findViewById(R.id.mission_name);
        bt_start = (Button) my_view.findViewById(R.id.bt_start_mission);


        current_mission = missions.get(spinner.getSelectedItemPosition());

        mission_description.setText(current_mission.getMission_description());
        mission_name.setText(current_mission.getMission_name());


        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TasksFragment fragment = TasksFragment.newInstance(current_mission.getMission_id());
                mainActivity.setFrag(fragment);
            }
        });
        return my_view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
