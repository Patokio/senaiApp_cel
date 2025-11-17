package com.example.teste;

public class FuncionarioDominio {
    private String nome;
    private double salarioBruto;
    private double imposto;
    private double porcentagem;


    // 🔹 Construtor com parâmetros
    public FuncionarioDominio(String nome, double salarioBruto, double imposto, double porcentagem) {
        this.nome = nome;
        this.salarioBruto = salarioBruto;
        this.imposto = imposto;
        this.porcentagem = porcentagem;
    }

    // 🔹 Getter e Setter para nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // 🔹 Getter e Setter para salarioBruto
    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    // 🔹 Getter e Setter para imposto
    public double getImposto() {
        return imposto;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    // 🔹 Método para calcular salário líquido
    public double salarioLiquido() {
        double salarioLiquido = salarioBruto - imposto;
        return salarioLiquido;
    }

    public double aumento(double porcentagem) {
        double aumento = salarioBruto * (porcentagem / 100);
        double salarioNovo = salarioLiquido() + aumento;
        return salarioNovo;
    }
}
