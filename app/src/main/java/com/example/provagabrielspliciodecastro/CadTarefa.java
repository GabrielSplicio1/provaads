package com.example.provagabrielspliciodecastro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadTarefa extends AppCompatActivity {

    private EditText editTextTitulo, editTextDescricao;
    private Button buttonSalvarTarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_terefa);

        editTextTitulo = findViewById(R.id.editTextTitulo);
        editTextDescricao = findViewById(R.id.editTextDescricao);
        buttonSalvarTarefa = findViewById(R.id.buttonSalvarTarefa);

        buttonSalvarTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = editTextTitulo.getText().toString();
                String descricao = editTextDescricao.getText().toString();

                if (!titulo.isEmpty() && !descricao.isEmpty()) {
                    Task novaTarefa = new Task(titulo, descricao);
                    TaskStorage.taskList.add(novaTarefa); // Adiciona na memória (RAM)

                    Toast.makeText(CadTarefa.this, "Tarefa cadastrada com sucesso!", Toast.LENGTH_SHORT).show();

                    // Fecha a tela e volta para a principal
                    finish();
                } else {
                    Toast.makeText(CadTarefa.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
