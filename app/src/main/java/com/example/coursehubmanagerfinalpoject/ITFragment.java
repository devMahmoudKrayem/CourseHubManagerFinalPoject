package com.example.coursehubmanagerfinalpoject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ITFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ITFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    AdapterCourseUser adapterCourseUser;
    AppDataBase appDataBase;
    List<Courses>coursesList;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ITFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ITFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ITFragment newInstance(String param1, String param2) {
        ITFragment fragment = new ITFragment();
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
 View view= inflater.inflate(R.layout.fragment_i_t, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rec_it);
        appDataBase = AppDataBase.getDatabase(requireContext());
        coursesList = appDataBase.coursesDao().getAllCoursesbycat(1);

        adapterCourseUser = new AdapterCourseUser(requireContext(), coursesList, new AdapterCourseUser.ClickHandle() {
            @Override
            public void onItemClick(int position) {
                // Handle item click
            }

            @Override
            public void onrbClick(int position, String id) {
                // Handle radio button click
            }
        });

        recyclerView.setAdapter(adapterCourseUser);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        return view;
    }
}