package com.example.root.waslni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class feedbacklayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbacklayout);
        Button btnSend=findViewById(R.id.button_send);
        final EditText editText_feedback=findViewById(R.id.edittext_feedback);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String feedback=editText_feedback.getText().toString();
                Toast.makeText(feedbacklayout.this, "تم", Toast.LENGTH_SHORT).show();
                editText_feedback.setText("");
            }
        });
    }
}
