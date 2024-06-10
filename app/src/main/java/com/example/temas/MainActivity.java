package com.example.temas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerStyles;
    private TextView textView;
    private RelativeLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerStyles = findViewById(R.id.spinner_styles);
        textView = findViewById(R.id.textView);
        mainLayout = findViewById(R.id.main_layout);


        String[] stylesArray = getResources().getStringArray(R.array.styles_array);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, stylesArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStyles.setAdapter(adapter);

        spinnerStyles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                applyStyle(selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void applyStyle(String styleName) {
        int backgroundColorId;
        int textColorId;

        switch (styleName) {
            case "Rojo":
                backgroundColorId = R.color.colorRojo;
                textColorId = R.color.colorAzul;
                break;
            case "Azul":
                backgroundColorId = R.color.colorAzul;
                textColorId = R.color.colorRojo;
                break;
            case "Morado":
                backgroundColorId = R.color.colorMorado;
                textColorId = R.color.colorBlancoFuerte;
                break;
            case "Verde":
                backgroundColorId = R.color.colorVerde;
                textColorId = R.color.colorAmarillo;
                break;
            default:
                return; //
        }

        mainLayout.setBackgroundColor(getResources().getColor(backgroundColorId));
        textView.setTextColor(getResources().getColor(textColorId));
    }
}
