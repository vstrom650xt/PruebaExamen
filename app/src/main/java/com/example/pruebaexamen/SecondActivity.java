package com.example.pruebaexamen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private Button btnenviar2;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        btnenviar2 =  findViewById(R.id.button2);

        textView2 = findViewById(R.id.textView2);
        Bundle bundle = getIntent().getExtras();

        textView2.setText(bundle.getSerializable("texto").toString());


        btnenviar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SecondActivity.this,MainActivity.class);
                i.putExtra("va",textView2.getText().toString());
               System.out.println(textView2.getText().toString());
                setResult(RESULT_OK,i); //MUY IMPORTANTEEEEEEEEEEEEEEEEEE
                finish();;

            }
        });






    }
}
