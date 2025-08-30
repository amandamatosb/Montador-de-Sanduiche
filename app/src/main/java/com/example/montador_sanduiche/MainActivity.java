package com.example.montador_sanduiche;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private CheckBox check_queijo;
    private CheckBox check_alface;
    private CheckBox check_tomate;
    private CheckBox check_cream;
    private CheckBox check_cebola;
    private CheckBox check_manteiga;
    private CheckBox check_carne;
    private CheckBox check_bacon;
    private Button button_pedido;
    private TextView text_valor;
    private RadioGroup radioG_paes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        radioG_paes = findViewById(R.id.radioG_paes);
        check_queijo = findViewById(R.id.check_queijo);
        check_alface = findViewById(R.id.check_alface);
        check_tomate = findViewById(R.id.check_tomate);
        check_cream = findViewById(R.id.check_cream);
        check_cebola = findViewById(R.id.check_cebola);
        check_manteiga = findViewById(R.id.check_manteiga);
        check_carne = findViewById(R.id.check_carne);
        check_bacon = findViewById(R.id.check_bacon);
        button_pedido = findViewById(R.id.button_pedido);
        text_valor = findViewById(R.id.text_valor);

        button_pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double valor_total = 2;

                int checkedId = radioG_paes.getCheckedRadioButtonId();
                RadioButton radioB_pao = findViewById(checkedId);

                if(check_queijo.isChecked())
                    valor_total += 4;

                if(check_alface.isChecked())
                    valor_total += 0.50;

                if(check_tomate.isChecked())
                    valor_total += 1;

                if(check_cream.isChecked())
                    valor_total += 4.50;

                if(check_manteiga.isChecked())
                    valor_total += 1.50;

                if(check_cebola.isChecked())
                    valor_total += 1;

                if(check_carne.isChecked())
                    valor_total += 8;

                if(check_bacon.isChecked())
                    valor_total += 5;

                String text_total = String.format("Total: R$%.2f", valor_total);
                text_valor.setText(text_total);
                Toast.makeText(MainActivity.this, radioB_pao.getText() + " escolhido! ", Toast.LENGTH_SHORT).show();
            }
        });



    }
}