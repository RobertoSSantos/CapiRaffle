# CapiRaffle

## Introdução
Bem vindo ao CapiRaffle! 

O CapiRaffle é um aplicativo de rifas em construção, que busca apresentar todas as suas funcionalidades em breve, mas para nossa versão incial, já contamos com uma quantidade de funcionalidades para auxiliar o gerenciamento de suas rifas e sorteios diversos. Permitindo o cadastramento, visualização e seleção de dezenas para as rifas, junto a um sorteador para a geração dos resultados!!

Aqui você vai encontrar a documentação do projeto.

## Sobre o projeto
O CapiRaffle foi um projeto criado com o propósito de validação de nota para a disciplina de Desenvolvimento de Aplicativos Móveis do curso de Engenharia de Computação do Centro Universitário SENAI CIMATEC.

## Stack
- Java
- SQLite

## Funcionalidades
É um aplicativo cliente-consumidor, ou seja, é possível ser utilizado tanto para o lado do cliente quanto para o consumidor.

1. Cadastrar uma rifa tendo opção de escolha: nome, data final, valor mínimo da dezena, prêmio da rifa.
2. Vizualizar rifas disponíveis com data final, prêmio e nome do rifeiro.
3. Escolher uma rifa disponível e comprar sua dezena.
4. Sorteio de dezena da rifa

## Detalhes do Projeto
O projeto foi desenvolvido usando a arquitetura single-activity, a qual se concentra em ter uma única atividade principal em seu aplicativo, na qual a maior parte do fluxo do aplicativo é controlada. Ao invés de ter várias atividades representando diferentes telas, você tem apenas uma atividade principal que atua como um container para exibir fragmentos ou componentes visuais dentro dela. 

Em conjunto a isso, foi utilizada a biblioteca Navigation Component para gerenciar a navegação entre as telas, por meio de uma estrutura declarativa e poderosa para o roteamento entre destinos. Por meio de um gráfico de navegação, localizado no arquivo main_nav.xml, um modelo visual da estrutura de navegação do aplicativo, podemos definir as ações de navegação entre eles, como a transição de uma tela para outra e passagem de argumentos entre destinos. O gráfico de navegação utilizado na aplicação está representado na imagem abaixo. 

![navComp](https://github.com/RobertoSSantos/CapiRaffle/assets/118369354/6d32fc7b-6345-4fe1-8b01-b4fe4a7bba2a)

## API Rolz
A aplicação consome a API rolz, uma API de rolamento de dados e geração de números aleatório, com auxílio da biblioteca retrofit para realizar as requisições. A API foi utilizada para a geração do resultado do sorteio, uma das futuras funcionalidades a serem completamente implementadas na aplicação.

Para referência da API, acesse o seu site oficial: <https://rolz.org/help/api>

## Para o Futuro...

Como o aplicativo é um projeto em expansão, desejamos aumentar nosso conjunto de funcionalidades e facilitar ainda mais a vida dos gestores e consumidores. Planejamos a criação de um sistema usuário-administrador, em conjunto com a integração de formas de pagamento e notificação de resultados das rifas para os consumidores.

## Outras referências
Documentação oficial do Navigation Component: <https://developer.android.com/guide/navigation?hl=pt-br>

Documentação oficial da biblioteca Retrofit2: <https://square.github.io/retrofit/>
