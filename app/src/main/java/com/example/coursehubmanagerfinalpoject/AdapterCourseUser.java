package com.example.coursehubmanagerfinalpoject;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursehubmanagerfinalpoject.databinding.CourseDeaignItemUserBinding;

import java.util.List;

public class AdapterCourseUser extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   private Context context;
   private ClickHandle clickHandle;
    CourseDeaignItemUserBinding binding;
    private List<Courses>coursesList;

    public AdapterCourseUser(Context context, List<Courses> coursesList, ClickHandle clickHandle) {
        this.context = context;
        this.coursesList = coursesList;
        this.clickHandle = clickHandle;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=CourseDeaignItemUserBinding.inflate(LayoutInflater.from(context),parent,false);
        return new MyviewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyviewHolder myviewHolder=new MyviewHolder(binding);
        myviewHolder.binding.nameCourse.setText(coursesList.get(position).getName_course());
        myviewHolder.binding.lecturerOfCourse.setText(coursesList.get(position).getInstructor_name());
        myviewHolder.binding.courseImage.setImageURI(Uri.parse(coursesList.get(position).getImage_course()));
        myviewHolder.binding.topic.setText(coursesList.get(position).getTopic());

        myviewHolder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickHandle.onItemClick(position);
            }
        });

    }
    public class MyviewHolder extends RecyclerView.ViewHolder{

        CourseDeaignItemUserBinding binding;
        public MyviewHolder(CourseDeaignItemUserBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

    @Override
    public int getItemCount() {
        return coursesList.size();
    }
    public interface ClickHandle{
        void onItemClick(int position);
        void onrbClick(int position,String id);


    }
}
