package com.example.loginsugar.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginsugar.R;
import com.example.loginsugar.fragment.Dialog;
import com.example.loginsugar.model.usuarios;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText usu, pass;
    Button button;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch aSwitch;
    TextView singUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usu = findViewById(R.id.txtUsuario);
        pass = findViewById(R.id.txtPassword);

        button = findViewById(R.id.button);
        aSwitch = findViewById(R.id.switch1);

        singUp = findViewById(R.id.singUp);

        singUp.setOnClickListener(v -> openDialog());

        button.setOnClickListener(v -> {

            if(!usu.getText().toString().equals("") && !pass.getText().toString().equals("")) {

                List<usuarios> verify = usuarios.find(usuarios.class, "Usuario = ?",usu.getText().toString());

                if (!verify.isEmpty()) {

                    usuarios usuarios = verify.get(0);
                    if (pass.getText().toString().equals(usuarios.getPassword()) && usu.getText().toString().equals(usuarios.getUsuario())) {

                        Intent intent = new Intent(this, MainActivity2.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(this, "contraseña incorrecta", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_LONG).show();
                }
            }else {
                Toast.makeText(this, "rellene los campos", Toast.LENGTH_LONG).show();
            }

        });

    }

    public void openDialog() {

        Dialog dialog = new Dialog(MainActivity.this);
        dialog.show(getSupportFragmentManager(), "dialog");

    }
}