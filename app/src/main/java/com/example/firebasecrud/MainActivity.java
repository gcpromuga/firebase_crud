package com.example.firebasecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editName;
    private EditText editAddress;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString();
                String address = editAddress.getText().toString();
                Database dao = new Database();

                Person person = new Person(name,address);
                dao.add(person).addOnSuccessListener(success -> {
                    Toast.makeText(MainActivity.this, "Successfully saved", Toast.LENGTH_SHORT).show();
                });

            }
        });
    }

    private void initComponents() {
        editName = (EditText) findViewById(R.id.editName);
        editAddress = (EditText) findViewById(R.id.editAddress);
        btnSave = (Button) findViewById(R.id.buttonSave);
    }

}