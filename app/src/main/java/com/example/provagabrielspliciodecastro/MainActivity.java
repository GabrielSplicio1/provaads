package com.example.provagabrielspliciodecastro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private Button buttonNovaTarefa;
    private RecyclerView recyclerViewTarefas;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNovaTarefa = findViewById(R.id.buttonNovaTarefa);
        recyclerViewTarefas = findViewById(R.id.recyclerViewTarefas);

        recyclerViewTarefas.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new TaskAdapter(TaskStorage.taskList);
        recyclerViewTarefas.setAdapter(taskAdapter);

        buttonNovaTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadTarefa.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        taskAdapter.notifyDataSetChanged(); // Atualiza a lista quando volta para essa tela
    }
}
