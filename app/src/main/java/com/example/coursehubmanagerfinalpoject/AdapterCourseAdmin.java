package com.example.coursehubmanagerfinalpoject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursehubmanagerfinalpoject.databinding.CourseDeaignItemUserBinding;
import com.example.coursehubmanagerfinalpoject.databinding.CourseDesignAdminItemBinding;

import java.util.List;

public class AdapterCourseAdmin extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    CourseDesignAdminItemBinding binding;
    private Context context;
    private AdapterCourseUser.ClickHandle clickHandle;
    private List<Courses> coursesList;
    Courses courses;
    AppDataBase appDataBase;

    public AdapterCourseAdmin(Context context,  List<Courses> coursesList,AdapterCourseUser.ClickHandle clickHandle) {
        this.context = context;
        this.clickHandle = clickHandle;
        this.coursesList = coursesList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=CourseDesignAdminItemBinding.inflate(LayoutInflater.from(context),parent,false);
        return new MyviewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyviewHolder myviewHolder=new MyviewHolder(binding);
        myviewHolder.binding.lecturerOfCourse.setText(coursesList.get(position).getInstructor_name());
        myviewHolder.binding.nameCourse.setText(coursesList.get(position).getName_course());
        myviewHolder.binding.numOfHoursCourse.setText(coursesList.get(position).getNum_of_hours());
        myviewHolder.binding.numOfStuCourse.setText(coursesList.get(position).getNum_of_students());
        myviewHolder.binding.topicOfCourse.setText(coursesList.get(position).getTopic());
        myviewHolder.binding.courseImage.setImageURI(coursesList.get(position).getImage_course());
        myviewHolder.binding.deleteCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickHandle.onItemClick(position);
            }
        });
        myviewHolder.binding.updateCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updateNameCourse=binding.nameCourse.getText().toString();
                String updatePriceCourse=binding.priceCourse.getText().toString();
                String updateStudentCourse=binding.numOfStuCourse.getText().toString();
                String updateHoursCourse=binding.numOfHoursCourse.getText().toString();
                String updateTopicCourse=binding.topicOfCourse.getText().toString();
                String updateLecturerCourse=binding.lecturerOfCourse.getText().toString();
                if (!updateNameCourse.isEmpty()&&!updatePriceCourse.isEmpty()&&!updateStudentCourse.isEmpty()
                &&!updateHoursCourse.isEmpty()&&!updateTopicCourse.isEmpty()&&!updateLecturerCourse.isEmpty()){
                    courses.setName_course(updateNameCourse);
                    courses.setPrice_course(updatePriceCourse);
                    courses.setNum_of_students(updateStudentCourse);
                    courses.setNum_of_hours(updateHoursCourse);
                    courses.setTopic(updateTopicCourse);
                    courses.setInstructor_name(updateLecturerCourse);
                    appDataBase.coursesDao().updateCourse(courses);
                    Toast.makeText(context, "is update", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "is not update", Toast.LENGTH_SHORT).show();

                }

                Toast.makeText(context, coursesList.get(position).getTopic(), Toast.LENGTH_SHORT).show();
            }
        });
        myviewHolder.binding.courseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickHandle.onItemClick(position);

            }
        });

    }

    @Override
    public int getItemCount() {
        return coursesList.size();
    }
    public class MyviewHolder extends RecyclerView.ViewHolder{

        CourseDesignAdminItemBinding binding;
        public MyviewHolder(CourseDesignAdminItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
    public interface ClickHandle{
        void onItemClick(int position);
        void onrbClick(int position,String id);


    }
}
