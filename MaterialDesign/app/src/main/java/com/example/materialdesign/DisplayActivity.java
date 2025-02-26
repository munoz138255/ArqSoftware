package com.example.materialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        assert bundle != null;
        String text= bundle.getString("text");
        this.position= bundle.getInt("position");
        TextView textView =((TextView) findViewById(R.id.textViewDisplay));
        textView.setText(text);
    }
    public void save(View view) {
        Bundle bundle = new Bundle();
        EditText editText = (EditText) findViewById(R.id.editTextDisplay);
        String name = editText.getText().toString();
        bundle.putString("text", name);
        bundle.putInt("position", this.position);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }
    public void cancel(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}