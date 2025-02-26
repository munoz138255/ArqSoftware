package upna.arqsoft.fizzbuzz2025;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FizzBuzzActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fizz_buzz);
    }

    public void calculate(View view) {
        EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        EditText editTextResponse = (EditText) findViewById(R.id.editTextResponse);
        String strNumber = String.valueOf(editTextNumber.getText());
        int number = Integer.parseInt(strNumber);
        editTextResponse.setEnabled(false);
        if(number%15 == 0) {
            editTextResponse.setText("fizzbuzz", TextView.BufferType.NORMAL);
            return;
        }
        if(number%5 == 0) {
            editTextResponse.setText("buzz", TextView.BufferType.NORMAL);
            return;
        }
        if(number%3 == 0) {
            editTextResponse.setText("fizz", TextView.BufferType.NORMAL);
            return;
        }
        editTextResponse.setText(strNumber, TextView.BufferType.NORMAL);
    }
}