package co.edu.uac.apmoviles.example1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView texto;
    EditText p1, p2;
    Button mayor, vocal, invertr, longitud, mayus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button vocales= findViewById(R.id.btnvocales);
        final Button invertir= findViewById(R.id.btninvertir);
        final CheckBox mayuscula=findViewById(R.id.edtmaymin);
        final Button botonA = (Button) findViewById(R.id.toggleButton);
        final Button botonB = (Button) findViewById(R.id.tButton);

        Intent i = getIntent();
        String user = i.getStringExtra("Usuario");
        texto = findViewById(R.id.texto);
        texto.setText(texto.getText().toString() + " " + user);
        p1 = findViewById(R.id.edtp1);
        p2 = findViewById(R.id.edtp2);
        mayor = findViewById(R.id.btnmayor);
        vocal = findViewById(R.id.btnvocales);
        invertr = findViewById(R.id.btninvertir);
        longitud = findViewById(R.id.btnlongitud);
        mayus = findViewById(R.id.edtmaymin);


        invertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                invertirp();
            }
        });
        vocales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dltvocales();
            }
        });
        mayuscula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mayuscula.isChecked()){
                    pmayusculas();
                }else{
                    pminusculas();

                }
            }
        });

        botonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mayor.setEnabled(false);
                longitud.setEnabled(false);
                vocal.setEnabled(false);
                invertir.setEnabled(false);
                mayus.setEnabled(false);}
        });

        botonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mayor.setEnabled(true);
                longitud.setEnabled(true);
                vocal.setEnabled(true);
                invertir.setEnabled(true);
                mayus.setEnabled(true);}
        });


        longitud.setOnClickListener(this);
        mayor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(p1.getText().toString()) || TextUtils.isEmpty(p2.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Datos invalidos",Toast.LENGTH_LONG).show();
               }
                else{
                    if (p1.getText().toString().compareToIgnoreCase(p2.getText().toString())>0){
                        Toast.makeText(getApplicationContext(),"P1 es mayor que P2", Toast.LENGTH_LONG).show();
                    }
                    else{
                        if (p1.getText().toString().compareToIgnoreCase(p2.getText().toString())<00){
                            Toast.makeText(getApplicationContext(),"P1 es menor que P2", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Son iguales", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });

    }

    private void  invertirp(){
        String pal1=p1.getText().toString();
        String pal2=p2.getText().toString();
        String palabra1=invertirpal(pal1);
        String palabra2=invertirpal(pal2);
        p1.setText(palabra1);
        p2.setText(palabra2);
        Toast.makeText(getBaseContext(),"Se han eliminado invertido las palabras",Toast.LENGTH_SHORT).show();


    }
    private String invertirpal(String pal){
        String res = "";
        int j = pal.length()-1;
        for (int i=0;i<pal.length();i++){
            res+=pal.charAt(j);
            j--;
        }
        return res;
    }

    private  void dltvocales(){
        String pal1=p1.getText().toString();
        String pal2=p2.getText().toString();
        String palabra1=elmvocales(pal1);
        String palabra2=elmvocales(pal2);
        p1.setText(palabra1);
        p2.setText(palabra2);
        Toast.makeText(getBaseContext(),"Se han eliminado las vocales",Toast.LENGTH_SHORT).show();
    }

    private String elmvocales(String vcl){
        String res = "";
        for (int i = 0; i<vcl.length();i++){
            char letras =vcl.charAt(i);
            if(!es_vocal(letras)){
                res+=letras;

            }


        }
        return res ;
    }
    private  boolean es_vocal(char letra){
        switch (letra){

            case 'a':
                return true;

            case 'e':
                return true;

            case 'i':
                return true;

            case 'o':
                return true;

            case 'u':
                return true;

            case 'A':
                return true;

            case 'E':
                return true;

            case 'I':
                return true;

            case 'O':
                return true;

            case 'U':
                return true;

            default:
                return false;
        }

    }

    private void pmayusculas(){
        String pal1=p1.getText().toString();
        String pal2=p2.getText().toString();
        String palabra1=convmayuscula(pal1);
        String palabra2=convmayuscula(pal2);
        p1.setText(palabra1);
        p2.setText(palabra2);
        Toast.makeText(getBaseContext(),"Palabras en mayuscula",Toast.LENGTH_SHORT).show();
    }

    private String convmayuscula(String pal){
        return pal.toUpperCase();

    }

    private void pminusculas(){
        String pal1=p1.getText().toString();
        String pal2=p2.getText().toString();
        String palabra1=convminusculas(pal1);
        String palabra2=convminusculas(pal2);
        p1.setText(palabra1);
        p2.setText(palabra2);
        Toast.makeText(getBaseContext(),"Palabras en minuscula",Toast.LENGTH_SHORT).show();
    }

    private String convminusculas(String pal){
        return pal.toLowerCase();

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnlongitud: int l1 = p1.getText().toString().length();
                                  int l2 = p2.getText().toString().length();
                Toast.makeText(getApplicationContext(),"Longitud1=" + l1 + " Longitud2=" + l2, Toast.LENGTH_LONG).show();
                 break;
        }
    }


}
