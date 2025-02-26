package upna.arqsoft.fizzbuzz2025;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openFizzBuzz(View view) {
        Intent intent = new Intent(this, FizzBuzzActivity.class);
        startActivity(intent);
    }

    public void openFizzBuzzMvc(View view) {
        Intent intent = new Intent(this, FizzBuzzMvcActivity.class);
        startActivity(intent);
    }
}