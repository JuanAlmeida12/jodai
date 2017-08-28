package com.example.admin.myapplication.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.adapter.SpinnerAdapter;
import com.example.admin.myapplication.database.DatabaseManager;
import com.example.admin.myapplication.models.Mission;
import com.example.admin.myapplication.models.Task;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link TasksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TasksFragment extends Fragment {

    private static final String ARG_MISSION_ID = "mission_id";

    private int mission_id;

    private Task current_task;
    private List<Task> tasks;


    private TextView task_name;
    private TextView task_description;
    private Button bt_check;
    private Button anwser;
    private EditText anwserEt;
    private View task_info;


    public TasksFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TasksFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TasksFragment newInstance(int mission_id) {
        TasksFragment fragment = new TasksFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_MISSION_ID, mission_id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        mission_id = args.getInt(ARG_MISSION_ID, 0);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View my_view = inflater.inflate(R.layout.fragment_tasks, null);
        tasks = DatabaseManager.getTasks(mission_id, getActivity());

        Spinner spinner = (Spinner) my_view.findViewById(R.id.spinner_task);
        SpinnerAdapter adapter = new SpinnerAdapter(null, tasks, getContext());
        spinner.setAdapter(adapter);

        task_description = (TextView) my_view.findViewById(R.id.task_desp);
        task_name = (TextView) my_view.findViewById(R.id.task_name);
        bt_check = (Button) my_view.findViewById(R.id.bt_check_place);
        anwser = (Button) my_view.findViewById(R.id.bt_awnser);
        anwserEt = (EditText) my_view.findViewById(R.id.resposta);
        task_info = (View) my_view.findViewById(R.id.view_task_info);

        current_task = tasks.get(spinner.getSelectedItemPosition());
        task_info.setVisibility(View.GONE);
        task_name.setText(current_task.getTask_name());
        task_description.setText(current_task.getTask_question());

        taskDone();

        anwser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String awnser_user = anwserEt.getText().toString();
                if (awnser_user.equals(current_task.getTask_answer())) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(current_task.getNext_tip());
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User clicked OK button
                            dialog.dismiss();
                        }
                    });

                    AlertDialog dialog = builder.create();
                    current_task.setDone(true);

                    taskDone();
                    DatabaseManager.updateTask(current_task, getActivity());
                    dialog.show();

                } else {
                    Toast.makeText(getContext(), "Não parece certo...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task_info.setVisibility(View.VISIBLE);
                bt_check.setVisibility(View.GONE);
            }
        });

        return my_view;
    }

    private void taskDone() {
        if (current_task.isDone()) {
            task_info.setVisibility(View.VISIBLE);
            bt_check.setVisibility(View.GONE);
            anwser.setVisibility(View.GONE);
            anwserEt.setVisibility(View.GONE);
            task_description.setText(current_task.getFacts_task() + "\n --------------------------------- \n" + current_task.getNext_tip());
        }
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
