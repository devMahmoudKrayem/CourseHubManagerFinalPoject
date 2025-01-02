package com.example.coursehubmanagerfinalpoject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.coursehubmanagerfinalpoject.databinding.ActivityAddCourseBinding;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class AddCourseActivity extends AppCompatActivity {
    ActivityAddCourseBinding binding;
    AppDataBase appDataBase;
    Uri uri;
    int cat_id =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityAddCourseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        appDataBase=AppDataBase.getDatabase(this);


        binding.btAddCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameCourse=binding.edNameCourse.getText().toString();
                String topicCourse=binding.edTopicCourse.getText().toString();
                String priceCourse=binding.edPriceCourse.getText().toString();
                String hoursCourse=binding.edNumOfHours.getText().toString();
                String instructorNameCourse=binding.edInstructorName.getText().toString();
                String StudentCourse=binding.edNumOfStudents.getText().toString();
                int rbId=binding.RadioG.getCheckedRadioButtonId();
                if (binding.rb1.isChecked()){
                    cat_id=1;
                } else if (binding.rb2.isChecked()) {
                    cat_id=2;;

                } else if (binding.rb3.isChecked()) {
                    cat_id=3;

                }
                appDataBase.coursesDao().insertCourse(new Courses(uri,hoursCourse,StudentCourse,priceCourse,instructorNameCourse,topicCourse,nameCourse,cat_id));
                finish();
            }
        });
        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();

                            binding.image.setImageURI(uri);
                        } else {
                            Toast.makeText(AddCourseActivity.this, "No Image Selected", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        binding.btAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPicker = new Intent(Intent.ACTION_PICK);
                photoPicker.setType("image/*");
                activityResultLauncher.launch(photoPicker);

            }
        });
    }
}