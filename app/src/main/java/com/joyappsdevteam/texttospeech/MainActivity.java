package com.joyappsdevteam.texttospeech;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private String text;
    private EditText editText;
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button speak = findViewById(R.id.buttonSpeech);
        Button clear = findViewById(R.id.buttonClear);
        editText = findViewById(R.id.editText);


        textToSpeech = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS){
                    //Select Language
                    int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });

        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text = editText.getText().toString().trim();

                if(text.equals("")){
                    Toast.makeText(MainActivity.this,"Please type a Valid text!",Toast.LENGTH_SHORT).show();
                }
                else {
                    //Text Convert to Speech
                    int speech = textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                text = "";
            }
        });
    }
}
