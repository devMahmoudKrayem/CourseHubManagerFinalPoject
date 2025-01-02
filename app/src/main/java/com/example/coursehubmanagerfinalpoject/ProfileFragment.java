package com.example.coursehubmanagerfinalpoject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String name="";
    String email="";
    String password="";
    AppDataBase appDataBase;
    User user;
    SharedPreferences sharedPreferences;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        sharedPreferences = getContext().getSharedPreferences("login", Context.MODE_PRIVATE);
        name=sharedPreferences.getString("name","");
        email=sharedPreferences.getString("email","");
        password=sharedPreferences.getString("password","");
        appDataBase=AppDataBase.getDatabase(requireContext());
        user=appDataBase.userDao().getusere(email,password);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_profile, container, false);
        EditText ed_name=view.findViewById(R.id.ed_name) ;
        EditText ed_email=view.findViewById(R.id.ed_email) ;
        EditText ed_password=view.findViewById(R.id.ed_password);
        Button bt_edit=view.findViewById(R.id.bt_edit);
        ImageView im_logOut=view.findViewById(R.id.logout);
        im_logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),MainActivity.class));
            }
        });
        ed_name.setText(user.getName());
        ed_email.setText(user.getEmail());
        ed_password.setText(user.getPassword());
        bt_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updateEmail =ed_email.getText().toString();
                String updateName =ed_name.getText().toString();
                String updatePassword =ed_password.getText().toString();
                if (!updateEmail.isEmpty()&&!updateName.isEmpty()&&!updatePassword.isEmpty()){
                    user.setName(updateName);
                    user.setEmail(updateEmail);
                    user.setPassword(updatePassword);
                    appDataBase.userDao().updateUser(user);
                    Toast.makeText(requireContext(), "is update", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(requireContext(), "is not update", Toast.LENGTH_SHORT).show();
                }


//                User user1=new User(ed_email.getText().toString(),ed_password.getText().toString(),ed_name.getText().toString());
//                appDataBase.userDao().updateUser(user1);

            }
        });
        return view;
    }
}