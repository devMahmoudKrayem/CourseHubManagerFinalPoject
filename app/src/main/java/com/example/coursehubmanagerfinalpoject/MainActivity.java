package com.example.coursehubmanagerfinalpoject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.coursehubmanagerfinalpoject.databinding.ActivityMainBinding;
import com.example.coursehubmanagerfinalpoject.databinding.RegisterUserBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    AlertDialog dialog;
    AppDataBase appDataBase;
    List<User>userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        SharedPreferences sharedPreferences1=getSharedPreferences("login",MODE_PRIVATE);
        boolean remember =sharedPreferences1.getBoolean("Remember Me",false);
        if (remember){
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
            finish();
        }
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        appDataBase= AppDataBase.getDatabase(this);
        userList =new ArrayList<>();
        userList.addAll(appDataBase.userDao().getAlluseres());
        SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        String save_email=sharedPreferences.getString("email","");
        String save_password=sharedPreferences.getString("password","");
//        if (!save_email.isEmpty()&&!save_password.isEmpty()){
//            binding.edEmail.setText(save_email);
//            binding.edPssword.setText(save_password);
//            binding.rememberMe.setChecked(true);
//        }

        binding.btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateNewAccountDialog();
            }
        });
        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=binding.edEmail.getText().toString();
                String password =binding.edPssword.getText().toString();
                String name ="";
                if (email.equals("admin")&&password.equals("admin")){

                    Intent intent = new Intent(MainActivity.this,DashboardActivity.class);
                    startActivity(intent);

                    Toast.makeText(MainActivity.this, "Admin", Toast.LENGTH_SHORT).show();
                }
                if (email.isEmpty()||password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Some Of this edit Text is Empty", Toast.LENGTH_SHORT).show();

                }
                boolean loginSuccess = false;
                for (User user: userList){
                    if (user.getEmail().equals(email)&&user.getPassword().equals(password)){
                        name=user.getName();
                        loginSuccess =true;
                        break;

                    }
                }
                if (loginSuccess){
                    rememberMe(email,password,name);
                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);

                    Toast.makeText(MainActivity.this, "loginSuccess", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Invalid Login Credentials", Toast.LENGTH_SHORT).show();


                }
            }
        });
        binding.rememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                SharedPreferences sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putBoolean("Remember Me",b);
                editor.apply();

            }
        });
    }
    private void CreateNewAccountDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        RegisterUserBinding binding = RegisterUserBinding.inflate(getLayoutInflater());
        builder.setView(binding.getRoot());

        binding.btCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name =binding.edName.getText().toString();
                String email = binding.edEmail.getText().toString();
                String password = binding.edPssword.getText().toString();
                String confirmPassword = binding.edSamedPssword.getText().toString();

                if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()||name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Some Of this edit Text is Empty", Toast.LENGTH_SHORT).show();
                    return; // Exit the function if fields are empty
                }

                if (password.equals(confirmPassword)) {
                    User user = new User(email, password,name);
                    long id = appDataBase.userDao().insertUser(user);
                    user.setId(id);
                    userList.add(user);

                    // Clear input fields after successful registration
                    binding.edName.setText("");
                    binding.edEmail.setText("");
                    binding.edPssword.setText("");
                    binding.edSamedPssword.setText("");

                    // Dismiss the dialog
                    dialog.dismiss();
                } else {
                    Toast.makeText(MainActivity.this, "Passwords Don't Match", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog = builder.create();
        dialog.show();
    }
    private void rememberMe (String email,String password,String name){
        if (binding.rememberMe.isChecked()){
            SharedPreferences sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putString("email",email);
            editor.putString("password",password);
            editor.putString("name",name);
            editor.apply();
        }
    }
}