package com.example.provagabrielspliciodecastro;

public class Task {
    private String titulo;
    private String descricao;

    public Task(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }
}
