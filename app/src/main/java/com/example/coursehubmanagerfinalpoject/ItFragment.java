package com.example.coursehubmanagerfinalpoject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ItFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    AppDataBase appDataBase ;
    List<Courses>coursesList;
    AdapterCourseUser adapterCourseUser;

    public ItFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ItFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ItFragment newInstance(String param1, String param2) {
        ItFragment fragment = new ItFragment();
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
        appDataBase=AppDataBase.getDatabase(requireContext());
       coursesList= appDataBase.coursesDao().getAllCoursesbycat(1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_it, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.rec_it);
        adapterCourseUser=  new AdapterCourseUser(requireContext(), coursesList, new AdapterCourseUser.ClickHandle() {
            @Override
            public void onItemClick(int position) {

            }

            @Override
            public void onrbClick(int position, String id) {

            }
        });
        recyclerView.setAdapter(adapterCourseUser);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        return view;
    }
}