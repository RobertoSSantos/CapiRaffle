package br.com.senaicimatec.capiraffle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}

/*
Situacao atual:

Tela Splash:
    Completo

Tela Home:
    envio -> (id) para tela Rifa [nao feito]
    uso geral -> instanciar os objetos de rifa a partir dos dados do banco [nao feito]

Tela Cadastro:
    envio -> objeto de rifa criado para o banco por meio da API [nao feito]
    uso geral -> verificacoes de nulos [feito]

Tela de Rifas:
    envio -> Array dos numeros selecionados para Tela de Compra [feito]
    envio -> ChavePix do criador e titulo da rifa para a tela de compra [parcialmente feito]
    uso geral -> Definir os numeros ja marcados [nao feito]
    uso geral -> receber dados do banco para instanciar o objeto de rifa [nao feito]

Tela de Compra:
    envio -> Nome comprador, cpf comprador, array de numeros selecionados para a tela de recibo [parcialmente feito]
    envio -> Titulo da Rifa para a tela de recibo [parcialmente feito]
    envio -> dados do objeto comprador para o banco [nao feito]
    uso geral -> verificacoes de nulo [feito]
    uso geral -> mensagem de compra realizada [feito]

Tela de Recibo:
    uso geral -> definir os valores a serem apresentados nas Tvs a partir dos dados recebidos do fragmento de compra [feito]

 */