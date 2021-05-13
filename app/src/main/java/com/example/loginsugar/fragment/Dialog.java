package com.example.loginsugar.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.loginsugar.R;
import com.example.loginsugar.model.usuarios;

import java.util.List;

public class Dialog extends AppCompatDialogFragment {

    EditText usu,pass,direc,tel,cod;

    Button button2;

    Activity context;

    public Dialog(Activity context) {
        this.context = context;
    }

    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = context.getLayoutInflater();

        View view = inflater.inflate(R.layout.layout_dialog, null);

        usu = view.findViewById(R.id.txtUsuario);
        pass = view.findViewById(R.id.txtPassword);
        direc = view.findViewById(R.id.txtDireccion);
        tel = view.findViewById(R.id.txtTel);
        cod = view.findViewById(R.id.txtCodigo);

        button2 = view.findViewById(R.id.btnCreate);

        button2.setOnClickListener(v -> {

            if (!usu.getText().toString().equals("") && !pass.getText().toString().equals("") && !direc.getText().toString().equals("") && !tel.getText().toString().equals("") && !cod.getText().toString().equals("")){


                List<usuarios> verify = usuarios.find(usuarios.class, "Usuario = ?",usu.getText().toString());

                if(verify.isEmpty() && pass.getText().length() >= 2 && pass.getText().length() <= 5){

                    usuarios usuarios = new usuarios(cod.getText().toString(),usu.getText().toString(),
                            pass.getText().toString(),direc.getText().toString(),tel.getText().toString(),
                            false);

                    usuarios.save();

                    usu.setText("");
                    pass.setText("");
                    direc.setText("");
                    tel.setText("");
                    cod.setText("");

                    Toast.makeText(getActivity(), "Creacion de usuario exitosa", Toast.LENGTH_LONG).show();

                    dismiss();
                }else{
                    Toast.makeText(getActivity(), "nombre de usuario en uso y o contraseña no valida" +
                            "la contraseña no puede exceder los 5 caracteres y no menos de 2", Toast.LENGTH_LONG).show();

                }

            }else {
                Toast.makeText(getActivity(), "Todos los datos deben estar completos", Toast.LENGTH_SHORT).show();
            }

        });

        builder.setView(view);

        return builder.create();

    }
}
