/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author danilomonteiro
 */
public class Pessoa {
    
    
    private String nome;
    private String senha;
    private int id;
    private int nivel;

    public Pessoa(String nome, String senha, int id, int nivel) {
        this.nome = nome;
        this.senha = senha;
        this.id = id;
        this.nivel = nivel;
    }

    public Pessoa(){
        
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = Integer.valueOf(nivel);
    }
    
    
    
}
