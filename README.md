# CapiRaffle

## Introdução
Bem vindo ao CapiRaffle! 

Aqui você vai encontrar a documentação do projeto respectiva ao front end do projeto: sua main, modelos, fragmentos e adapters .java, camadas .xml e dicionário de dados.

## Sobre o projeto
Trata-se de um aplicativo de rifas, onde é possível cadastrar uma rifa e marcar seus números já escolhidos.

O CapiRaffle foi um projeto criado com o propósito de validação de nota para as disciplinas de Desenvolvimento de Aplicativos Móveis e de Linguagem de Programação 3 do curso de Engenharia de Computação do Centro Universitário SENAI CIMATEC.

## Stack
- Java
- Android Studio

## Funcionalidades
É um aplicativo cliente-consumidor, ou seja, é possível ser utilizado tanto para o lado do cliente quanto para o consumidor.

1. Cadastrar uma rifa tendo opção de escolha: nome, data final, valor mínimo da dezena, prêmio da rifa.
2. Vizualizar rifas disponíveis com data final, prêmio e nome do rifeiro.
3. Escolher uma rifa disponível e comprar sua dezena.
4. Sorteio de dezena da rifa

## Detalhes do Projeto
O projeto foi desenvolvido usando a arquitetura single-activity, a qual se concentra em ter uma única atividade principal em seu aplicativo, na qual a maior parte do fluxo do aplicativo é controlada. Ao invés de ter várias atividades representando diferentes telas, você tem apenas uma atividade principal que atua como um container para exibir fragmentos ou componentes visuais dentro dela. 
Em conjunto a isso, foi utilizada a biblioteca Navigation Component para gerenciar a navegação entre as telas, por meio de uma estrutura declarativa e poderosa para o roteamento entre destinos. Por meio de um gráfico de navegação, localizado no arquivo main_nav.xml, um modelo visual da estrutura de navegação do aplicativo, podemos definir as ações de navegação entre eles, como a transição de uma tela para outra e passagem de argumentos entre destinos. 

![Gráfico de Navegação](C:\Users\soran\Pictures\navComp.png)
