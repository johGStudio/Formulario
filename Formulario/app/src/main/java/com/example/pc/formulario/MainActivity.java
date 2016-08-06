package com.example.pc.formulario;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private CheckBox aviso;
    EditText nombretxt, apellidotxt, emailtxt, passtxt, repasstxt;
    CheckBox aceptar_condi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aviso = (CheckBox) findViewById(R.id.aceptar_condi);
        nombretxt = (EditText) findViewById(R.id.nombretxt);
        apellidotxt = (EditText) findViewById(R.id.apellidotxt);
        emailtxt = (EditText) findViewById(R.id.emailtxt);
        passtxt = (EditText)findViewById(R.id.passtxt);
        repasstxt = (EditText)findViewById(R.id.repasstxt);
        aceptar_condi = (CheckBox) findViewById(R.id.aceptar_condi);
    }

    public void mostrarAviso(View v){
        String s = (aviso.isChecked()? "¡Aceptó la condición!" : "¡Acepte las condiciones!");
        Toast.makeText(this, s , Toast.LENGTH_SHORT).show();
    }

    public void registrar(View v){

        String nomb = nombretxt.getText().toString();
        String apell = apellidotxt.getText().toString();
        String email = emailtxt.getText().toString();
        String pass = passtxt.getText().toString();
        String repass = repasstxt.getText().toString();


            Conexion admin = new Conexion(this, "formulario", null, 1);
            SQLiteDatabase dato = admin.getWritableDatabase();

            ContentValues registro = new ContentValues();
            registro.put("nombre",nomb);
            registro.put("apellido",apell);
            registro.put("email",email);
            registro.put("password",pass);
            //insertar los datos en db
            if(dato.insert("usuario",null,registro)>0)
                Toast.makeText(this, "REGISTRADO!", Toast.LENGTH_SHORT).show();
            dato.close();

            nombretxt.setText("");
            apellidotxt.setText("");
            emailtxt.setText("");
            passtxt.setText("");
            repasstxt.setText("");

    }

    public boolean validarPass(String p1, String p2){
        boolean b=true;
        if(p1.equalsIgnoreCase(p2)){
            b=false;
        }
        return b;
    }


}
