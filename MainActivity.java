package com.example.aplikasitodo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox someTextView = (CheckBox) findViewById(R.id.checkBox9);
        someTextView.setText("Pekerjaan 1");
        someTextView.setPaintFlags(someTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        CheckBox someTextView2 = (CheckBox) findViewById(R.id.checkBox11);
        someTextView2.setText("Pekerjaan 2");
        someTextView2.setPaintFlags(someTextView2.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu,menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_add_task:
                    Log.d("MainActivity","Add a new task");
                    return true;

                default:
                    return false;
            }
        }

        public void addtask () {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Add a task");
            builder.setMessage("What do you want to do?");
            final EditText inputField = new EditText(this);
            builder.setView(inputField);
            builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Log.d("MainActivity",inputField.getText().toString());
                }
            });

            builder.setNegativeButton("Cancel", null);

            builder.create().show();
        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                addtask();

            }
        });
    }
}

