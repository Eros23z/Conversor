package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    EditText dolares;
    EditText euro;
    EditText cambio;
    RadioButton rbdolareuro;
    RadioButton rbeurodolar;
    Button convertir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla);



        // INICIALIZACIÓN DE CAMPOS //////////////////////////////////////////////
        dolares = (EditText)this.findViewById(R.id.edtDolares);
        euro = (EditText)this.findViewById(R.id.edtEuros);
        cambio = (EditText)this.findViewById(R.id.etCambio);

        rbdolareuro = (RadioButton)this.findViewById(R.id.rbDolarAeuro);
        rbdolareuro.setChecked(true);
        rbeurodolar = (RadioButton)this.findViewById(R.id.rbEuroAdolar);

        convertir = (Button)this.findViewById(R.id.btnConvertir);
        // FIN INICIALIZACIÓN DE CAMPOS ////////////////////////////////////////////////


        // EVENTOS ///////////////////////////////////////////
        //convertir.setOnClickListener(this);
        //rbdolareuro.setOnClickListener(this);
        //rbeurodolar.setOnClickListener(this);
        convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == convertir) {
                    if (rbdolareuro.isChecked()) {
                        convertiraDolar();
                    }
                    if (rbeurodolar.isChecked()) {
                        convertiraEuro();
                    }
                }
            }
        });
        // FIN EVENTOS ///////////////////////////////////////

    }

    public void convertiraDolar() {
        double val;
        double temp;
        double dolar = 0.9;

        if ("".equals(dolares.getText().toString())) {
            val = 0;
        } else {
            val = Double.parseDouble(dolares.getText().toString());
        }
        if ("".equals(cambio.getText().toString())) {
            temp = 0;
        } else {
            temp = Double.parseDouble(cambio.getText().toString());
        }
        euro.setText(Double.toString(val * dolar));
    }

    public void convertiraEuro() {
        double val;
        double temp;
        double euros = 1.11;

        if ("".equals(euro.getText().toString())) {
            val = 0;
        } else {
            val = Double.parseDouble(euro.getText().toString());
        }
        if ("".equals(cambio.getText().toString())) {
            temp = 0;
        } else {
            temp = Double.parseDouble(cambio.getText().toString());
        }
        dolares.setText(Double.toString(val * euros));
    }


}
