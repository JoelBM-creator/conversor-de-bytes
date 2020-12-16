package com.example.conversordebytes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /* Definimos todos los elementos según hemos introducido en
    * la vista del usuario. */
    private Spinner spUnidad1, spUnidad2;
    private EditText txtNum1;
    private TextView txtNum2;
    private Button btnConvertir;

    /* Definimos las dos unidades,
     * que serán los elementos spinner seleccionados. */
    private int unidad1;
    private int unidad2;

    /* Metodo para parsear lo introducido en txtNum1,
    * en caso de no introducir nada, el valor será 0. */
    double ParseDouble(String strNumber) {
        if (strNumber != null && strNumber.length() > 0) {
            try {
                return Double.parseDouble(strNumber);
            } catch (Exception e) {
                return -1;
            }
        }
        else return 0;
    }

    /* Metodo onCreate, cuando creamos el view de la activity main,
    * llamaremos a los distintemos metodos para incializar los elementos
    * de la vista. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initElements();
        listarUnidades();
        asignar();

        /* Cuando le demos al botón, este parseará el valor introduciro en txtNum1 a Double
         * y llamamos al metodo que hemos creado conversion, para crear la conversión. */
        btnConvertir.setOnClickListener((v) -> {
            conversion(ParseDouble(String.valueOf(txtNum1.getText())));
        });
    }

    // Incializamos todos los elementos de la vista.
    public void initElements() {
        spUnidad1 = findViewById(R.id.spUnidad1);
        spUnidad2 = findViewById(R.id.spUnidad2);

        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);

        btnConvertir = findViewById(R.id.btnConvertir);
    }

    // Listamos las unidades y le añadimos un a los spinners un adapter.
    public void listarUnidades() {
        String _byte = "Byte";
        String kiloByte = "Kilobyte";
        String megaByte = "Megabyte";
        String teraByte = "Terabyte";
        String petaByte = "Petabyte";
        String exaByte = "Exabyte";
        String zetaByte = "Zetabyte";
        String yottaByte = "Yottabyte";
        String brontoByte = "Brontobyte";
        String geoByte = "GeoByte";

        String[] arrayUnidades = new String[]{_byte, kiloByte, megaByte, teraByte, petaByte, exaByte, zetaByte, yottaByte, brontoByte, geoByte};
        ArrayAdapter<String>adapter = new ArrayAdapter<>
                (MainActivity.this, android.R.layout.simple_list_item_1, arrayUnidades);
        spUnidad1.setAdapter(adapter);
        spUnidad2.setAdapter(adapter);
    }

    // Asignamos las unidades según el valor seleccionado en el spinner.
    public void asignar() {
        spUnidad1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    unidad1 = 1; // 8 Bytes
                } if(i==1) {
                    unidad1 = 2; // 1024 bytes
                } if(i==2){
                    unidad1 = 3; // 1024 Kb
                } if(i==3){
                    unidad1 = 4; // 1024 Mb
                } if(i==4) {
                    unidad1 = 5; // 1024 Gb
                } if (i==5) {
                    unidad1 = 6; // 1024 Tb
                } if (i==6) {
                    unidad1 = 7; // 1024 Pb
                } if (i==7) {
                    unidad1 = 8; // 1024 Eb
                } if (i==8) {
                    unidad1 = 9; // 1024 Zb
                } if (i==9) {
                    unidad1 = 10; // 1024 Yb
                } if (i==10) {
                    unidad1 = 11; // 1024Bb
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spUnidad2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    unidad2 = 1; // 8 Bytes
                } if(i==1) {
                    unidad2 = 2; // 1024 bytes
                } if(i==2){
                    unidad2 = 3; // 1024 Kb
                } if(i==3){
                    unidad2 = 4; // 1024 Mb
                } if(i==4) {
                    unidad2 = 5; // 1024 Gb
                } if (i==5) {
                    unidad2 = 6; // 1024 Tb
                } if (i==6) {
                    unidad2 = 7; // 1024 Pb
                } if (i==7) {
                    unidad2 = 8; // 1024 Eb
                } if (i==8) {
                    unidad2 = 9; // 1024 Zb
                } if (i==9) {
                    unidad2 = 10; // 1024 Yb
                } if (i==10) {
                    unidad2 = 11; // 1024 Bb
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    // Metodo para la conversión que le añadimos al txtNum2 el resultado.
    public void conversion(Double valor){
        Double resultado = 0.0;
        long n = 1024;

        Double kb = valor / n;
        Double mb = kb / n;
        Double gb = mb / n;
        Double tb = gb / n;
        Double pb = tb / n;
        Double eb = pb / n;
        Double zb = eb / n;
        Double yb = zb / n;
        Double bb = yb / n;
        Double geob = bb / n;

        Double kbUp = valor * n;
        Double mbUp = kbUp * n;
        Double gbUp = mbUp * n;
        Double tbUp = gbUp * n;
        Double pbUp = tbUp * n;
        Double ebUp = pbUp * n;
        Double zbUp = ebUp * n;
        Double ybUp = zbUp * n;
        Double bbUp = ybUp * n;
        Double geoBUp = bbUp * n;

        if (unidad1 == 1 && unidad2 == 2 || unidad1 == 2 && unidad2 == 3 || unidad1 == 3 && unidad2 == 4 || unidad1 == 4 && unidad2 == 5 ||
                unidad1 == 5 && unidad2 == 6 || unidad1 == 6 && unidad2 == 7 || unidad1 == 7 && unidad2 == 8 ||
                unidad1 == 8 && unidad2 == 9 || unidad1 == 9 && unidad2 == 10 || unidad1 == 10 && unidad2 == 11) {
            resultado = kb;
        } if (unidad1 == 1 && unidad2 == 3 || unidad1 == 2 && unidad2 == 4 || unidad1 == 3 && unidad2 == 5 || unidad1 == 4 && unidad2 == 6 ||
                unidad1 == 5 && unidad2 == 7 || unidad1 == 6 && unidad2 == 8 || unidad1 == 7 && unidad2 == 9 || unidad1 == 8 && unidad2 == 10 ||
                unidad1 == 9 && unidad2 == 11) {
            resultado = mb;
        } if (unidad1 == 1 && unidad2 == 4 || unidad1 == 2 && unidad2 == 5 || unidad1 == 3 && unidad2 == 6 || unidad1 == 4 && unidad2 == 7 ||
                unidad1 == 5 && unidad2 == 8 || unidad1 == 6 && unidad2 == 9 || unidad1 == 7 && unidad2 == 10 || unidad1 == 8 && unidad2 == 11) {
            resultado = gb;
        } if (unidad1 == 1 && unidad2 == 5 || unidad1 == 2 && unidad2 == 6 || unidad1 == 3 && unidad2 == 7 || unidad1 == 4 && unidad2 == 8 ||
                unidad1 == 5 && unidad2 == 9 || unidad1 == 6 && unidad2 == 10 || unidad1 == 7 && unidad2 == 11) {
            resultado = tb;
        } if (unidad1 == 1 && unidad2 == 6 || unidad1 == 2 && unidad2 == 7 || unidad1 == 3 && unidad2 == 8 ||
                unidad1 == 4 && unidad2 == 9 || unidad1 == 5 && unidad2 == 10 || unidad1 == 6 && unidad2 == 11) {
            resultado = pb;
        } if (unidad1 == 1 && unidad2 == 7 || unidad1 == 2 && unidad2 == 8 || unidad1 == 3 && unidad2 == 9 || unidad1 == 4 && unidad2 == 10 || unidad1 == 5 && unidad2 == 11) {
            resultado = eb;
        } if (unidad1 == 1 && unidad2 == 8 || unidad1 == 2 && unidad2 == 9 || unidad1 == 3 && unidad2 == 10 || unidad1 == 4 && unidad2 == 11) {
            resultado = zb;
        } if (unidad1 == 1 && unidad2 == 9 || unidad1 == 2 && unidad2 == 10 || unidad1 == 3 && unidad2 == 11) {
            resultado = yb;
        } if (unidad1 == 1 && unidad2 == 10 || unidad1 == 1 && unidad2 == 10) {
            resultado = bb;
        } if (unidad1 == 1 && unidad2 == 11) {
            resultado = geob;
        } if(unidad1 == 2 && unidad2 == 1 || unidad1 == 3 && unidad2 == 2 || unidad1 == 4 && unidad2 == 3 || unidad1 == 5 && unidad2 == 4 || unidad1 == 6 && unidad2 == 5 ||
                unidad1 == 7 && unidad2 == 6 || unidad1 == 8 && unidad2 == 7 || unidad1 == 9 && unidad2 == 8 || unidad1 == 10 && unidad2 == 9 || unidad1 == 11 && unidad2 == 10){
            resultado = kbUp;
        } if(unidad1 == 3 && unidad2 == 1 || unidad1 == 4 && unidad2 == 2 || unidad1 == 5 && unidad2 == 3 || unidad1 == 6 && unidad2 == 4 || unidad1 == 7 && unidad2 == 5 ||
                unidad1 == 8 && unidad2 == 6 || unidad1 == 9 && unidad2 == 7 || unidad1 == 10 && unidad2 == 8 || unidad1 == 11 && unidad2 == 9){
            resultado = mbUp;
        } if(unidad1 == 4 && unidad2 == 1 || unidad1 == 5 && unidad2 == 2 || unidad1 == 6 && unidad2 == 3 || unidad1 == 7 && unidad2 == 4 || unidad1 == 8 && unidad2 == 5 ||
                unidad1 == 9 && unidad2 == 6 || unidad1 == 10 && unidad2 == 7 || unidad1 == 11 && unidad2 == 8){
            resultado = gbUp;
        } if(unidad1 == 5 && unidad2 == 1 || unidad1 == 6 && unidad2 == 2 || unidad1 == 7 && unidad2 == 3 || unidad1 == 8 && unidad2 == 4 || unidad1 == 9 && unidad2 == 5 ||
                unidad1 == 10 && unidad2 == 6 || unidad1 == 11 && unidad2 == 7){
            resultado = tbUp;
        } if(unidad1 == 6 && unidad2 == 1 || unidad1 == 7 && unidad2 == 2 || unidad1 == 8 && unidad2 == 3 ||
                unidad1 == 9 && unidad2 == 4 || unidad1 == 10 && unidad2 == 5 || unidad1 == 11 && unidad2 == 6){
            resultado = pbUp;
        } if(unidad1 == 7 && unidad2 == 1 || unidad1 == 8 && unidad2 == 2 || unidad1 == 9 && unidad2 == 3 || unidad1 == 10 && unidad2 == 4 || unidad1 == 11 && unidad2 == 5){
            resultado = ebUp;
        } if(unidad1 == 8 && unidad2 == 1 || unidad1 == 9 && unidad2 == 2 || unidad1 == 10 && unidad2 == 3 || unidad1 == 11 && unidad2 == 4){
            resultado = zbUp;
        }  if(unidad1 == 9 && unidad2 == 1 || unidad1 == 10 && unidad2 == 2 || unidad1 == 11 && unidad2 == 3){
            resultado = ybUp;
        }  if(unidad1 == 10 && unidad2 == 1 || unidad1 == 11 && unidad2 == 2){
            resultado = bbUp;
        } if(unidad1 == 11 && unidad2 == 1){
            resultado = geoBUp;
        } if (unidad1 == 1 && unidad2 == 1 || unidad1 == 2 && unidad2 == 2 || unidad1 == 3 && unidad2 == 3 || unidad1 == 4 && unidad2 == 4 || unidad1 == 5 && unidad2 == 5 ||
                unidad1 == 6 && unidad2 == 6 || unidad1 == 7 && unidad2 == 7 || unidad1 == 8 && unidad2 == 8 || unidad1 == 9 && unidad2 == 9 || unidad1 == 10 && unidad2 == 10 ||
                unidad1 == 11 && unidad2 == 11) {
            resultado = valor;
        }

        txtNum2.setText(resultado.toString());
    }
}