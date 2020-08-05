package pratiksha.example.texttospeechapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
   EditText editText;
   Button btConvert,btClear;
   TextToSpeech textToSpeech;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.ed_input);
        btConvert = findViewById(R.id.bt_convert);
        btClear = findViewById(R.id.bt_clear);

        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
               if(i==TextToSpeech.SUCCESS){
                int lang =textToSpeech.setLanguage(Locale.ENGLISH);

               }
            }
        });
        btConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=editText.getText().toString();
                int speech=textToSpeech.speak(s,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              editText.setText("");
            }
        });
    }
}