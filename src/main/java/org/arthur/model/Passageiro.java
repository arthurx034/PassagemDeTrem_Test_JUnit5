package org.arthur.model;

public class Passageiro {
    private String nome;
    private int idade;
    private String documento;

    public Passageiro (String nome, int idade, String documento) {
        this.nome = nome;
        this.idade = idade;
        this.documento = documento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDocumento() {
        return documento;
    }

    public boolean temDesconto() {
        if (idade > 0) {
            if (idade < 12 || idade > 60) {
                return true;
            }
        }
        else {
            throw new IllegalArgumentException("Idade nao pode ser negativa");
        }
        return false;
    }
}
