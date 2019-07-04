# Pong Framework

## Sumário
1. [Descrição](#Desc)
2. [Instalação](#Inst)
3. [Padrões de Projeto](#Pad)
4. [Recursos Oferecidos](#Recursos)

<a name="Desc"></a>
## 1. Descrição
O objetivo do projeto é desenvolver um framework capaz de permitir a criação de famílias de Pong, como, por exemplo, o Pong Tênis, Pong Paredão e Pong Futebol. Além disso, o projeto deve implementar os padrões estudados em sala de aula a fim de que a manutenção do sistema seja simples e escalável. 

<a name="Inst"></a>
## 2. Instalação
### Pré-requisitos
Para que o usuário consiga utilizar o framework e criar sua própria família de Pongs será necessário instalar:
* Java >= 8

Além disso, após realizar o download do framework, é necessário importá-lo como dependência ou incluí-lo no build path do novo Pong a ser implementado. 

Por fim, recomenda-se a utilização de uma IDE para facilitar a implementação. 

<a name="Pad"></a>
## 3. Padrões de Projeto
Para o desenvolvimento do framework, foram utilizados dois padrões de projeto: Template Method e Builder. O papel de cada um deles para o projeto serão explicados na sequência.

O Template Method foi utilizado para que o usuário conseguisse personalizar o seu próprio pong a partir de um escopo parcialmente definido. Dessa forma, é possível que o usuário instancie um pong com as funções básicas que já foram definidas ou que ele crie novas funcionalidades. Além disso, existe um template especialmente para o frame do Pong, o qual permite que o usuário personalize a instância dos utilitários.

(INCLUIR AQUI DIAGRAMA QUE MOSTRA O TEMPLATE METHOD DO PONG)

Já o Builder foi implementado para suprimir o uso de vários construtores para uma mesma entidade. Desse modo, utiliza-se o Builder de cada entidade para que sejam definidos os atributos das mesmas. 

<a name="Recursos"></a>
## 4. Recursos Oferecidos
O framework oferece três pacotes principais: utilitários, builders e template. 

O pacote utilitários inclue a classe abstrata Ponto que pode ser extendida para criar outras classes que possam ter características de ser um ponto em um frame. Além disso, o framework implementa pontos comumente utilizados em Pongs tais como Bola, Jogador, Obstáculo e Borda. 

Já o builders inclui os builders das entidades básicas do framework, além de possuir uma classe abstrata que permite a criação do builder de um Pong do usuário.

Por último, o pacote template inclui o template para o Pong, permitindo que o usuário o extenda e crie seu próprio jogo. 

