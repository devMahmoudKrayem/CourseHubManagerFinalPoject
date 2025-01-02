package com.example.coursehubmanagerfinalpoject;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.coursehubmanagerfinalpoject.databinding.ActivityUpdateDeleteBinding;

import java.util.List;

public class UpdateDeleteActivity extends AppCompatActivity {
    ActivityUpdateDeleteBinding binding;
    AppDataBase appDataBase;
    List<Courses>coursesList;
    AdapterCourseAdmin adapterCourseAdmin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityUpdateDeleteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        appDataBase=AppDataBase.getDatabase(this);
        coursesList=appDataBase.coursesDao().getAllCourses();
        adapterCourseAdmin=new AdapterCourseAdmin(this, coursesList, new AdapterCourseUser.ClickHandle() {
            @Override
            public void onItemClick(int position) {

            }

            @Override
            public void onrbClick(int position, String id) {


            }
        });
        binding.recDeleteAndUpdate.setAdapter(adapterCourseAdmin);
        binding.recDeleteAndUpdate.setLayoutManager(new LinearLayoutManager(this));



    }
}