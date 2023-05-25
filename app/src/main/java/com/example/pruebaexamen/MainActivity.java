package com.example.pruebaexamen;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnenviar;
    private TextView textView;
    private EditText textoeditado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Persona p = new Persona(25,"pepe");

        btnenviar=findViewById(R.id.btnenviar);


         textView=findViewById(R.id.txtvwtexto);
        textoeditado=findViewById(R.id.editTextTextPersonName);



        ActivityResultLauncher<Intent> someActivityResultLauncher =
                registerForActivityResult(
                        new ActivityResultContracts.StartActivityForResult(),
                        result -> {
                            if (result.getResultCode() == Activity.RESULT_OK) {
                                Intent data = result.getData();
                                if (data != null) {
                                    Bundle bundle = data.getExtras();
                                    if (bundle != null && bundle.containsKey("va")) {
                                        String texto = bundle.getString("va");
                                        textView.setText(texto);
                                    }
                                }
                            }
                        }
                );

        btnenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,SecondActivity.class);
        //        i.putExtra("texto", textoeditado.getText().toString());
                i.putExtra("texto", p);

                someActivityResultLauncher.launch(i);


            }
        });

    }
}