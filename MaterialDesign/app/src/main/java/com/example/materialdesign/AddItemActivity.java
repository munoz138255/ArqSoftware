package com.example.materialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }
    public void add(View view) {
        Bundle bundle = new Bundle();
        EditText editText = (EditText) findViewById(R.id.new_text);
        String text = editText.getText().toString();
        bundle.putString("text", text);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }

}