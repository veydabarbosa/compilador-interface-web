# Compilador WEB - Interface

Projeto de desenvolvimento de um **compilador em Java**, desenvolvido para a disciplina de **Compiladores** do curso de **Bacharelado em Ciência da Computação da FURB — Fundação Universidade Regional de Blumenau**.

O projeto tem como objetivo construir, de forma incremental, um compilador completo, iniciando pela implementação de sua interface gráfica e posteriormente incorporando as etapas responsáveis pelo processamento e análise dos programas.

## Sobre o projeto

A aplicação fornece uma interface gráfica semelhante à de um ambiente de desenvolvimento, permitindo escrever, abrir e salvar programas, além de apresentar mensagens relacionadas ao processamento realizado pelo compilador.

A primeira etapa do projeto concentra-se na construção da interface e na criação da estrutura necessária para suportar as funcionalidades que serão implementadas posteriormente.

A interface é composta por quatro áreas principais:

* **Barra de ferramentas:** reúne as principais ações disponíveis na aplicação;
* **Editor:** área destinada à escrita e edição dos programas;
* **Área de mensagens:** exibe informações e resultados das operações realizadas;
* **Barra de status:** apresenta informações sobre o arquivo atualmente aberto.

O editor e a área de mensagens são separados por uma divisão móvel, permitindo que o espaço destinado a cada componente seja ajustado verticalmente.

## Funcionalidades

### Editor

O editor foi desenvolvido para proporcionar uma experiência básica de edição de código, contando com:

* Numeração das linhas iniciando em `1`;
* Numeração independente do conteúdo editado;
* Rolagem vertical;
* Rolagem horizontal;
* Suporte à edição de texto;
* Área dimensionável em relação à área de mensagens.

### Gerenciamento de arquivos

A aplicação permite trabalhar com arquivos de texto:

* Criar um novo arquivo;
* Abrir arquivos `.txt`;
* Salvar arquivos novos;
* Salvar alterações em arquivos existentes;
* Manter as informações do arquivo atualmente aberto;
* Atualizar a barra de status conforme o arquivo manipulado.

### Área de mensagens

A área de mensagens é utilizada para apresentar informações referentes às ações executadas na aplicação.

Ela possui:

* Conteúdo somente para visualização;
* Rolagem vertical;
* Rolagem horizontal;
* Limpeza das mensagens conforme a operação executada.

### Barra de ferramentas

A barra de ferramentas disponibiliza as principais operações da aplicação:

| Ação     | Atalho     |
| -------- | ---------- |
| Novo     | `Ctrl + N` |
| Abrir    | `Ctrl + O` |
| Salvar   | `Ctrl + S` |
| Copiar   | `Ctrl + C` |
| Colar    | `Ctrl + V` |
| Recortar | `Ctrl + X` |
| Compilar | `F7`       |
| Equipe   | `F1`       |

Os botões possuem ícones, identificação da ação e respectivo atalho de teclado.

### Compilação

A arquitetura do projeto foi preparada para receber as etapas de compilação.

Na versão atual, a ação **Compilar (`F7`)** funciona como ponto de entrada para essa funcionalidade e informa que a implementação da compilação ainda está em desenvolvimento.

A intenção é que, nas próximas etapas, essa operação seja responsável pelo processamento efetivo dos programas escritos no editor.

## Interface

A janela principal possui uma dimensão fixa e é organizada da seguinte forma:

```text
┌───────────────────────────────────────────────────────────────┐
│                       BARRA DE FERRAMENTAS                    │
├───────────────────────────────────────────────────────────────┤
│                                                               │
│                            EDITOR                             │
│                                                               │
│  1                                                            │
│  2                                                            │
│  3                                                            │
│  4                                                            │
│                                                               │
├───────────────────────────────────────────────────────────────┤
│                                                               │
│                       ÁREA DE MENSAGENS                       │
│                                                               │
│                                                               │
├───────────────────────────────────────────────────────────────┤
│                         BARRA DE STATUS                       │
└───────────────────────────────────────────────────────────────┘
```

A divisão entre o editor e a área de mensagens pode ser movimentada para ajustar o espaço disponível para cada componente.

## Tecnologias

O projeto utiliza as seguintes tecnologias:

* **Java** — linguagem principal utilizada no desenvolvimento;
* **Java Swing** — construção da interface gráfica;
* **IntelliJ IDEA** — ambiente de desenvolvimento;
* **Git** — controle de versão;
* **GitHub** — hospedagem do código e colaboração entre os integrantes.

## Arquitetura

O projeto busca manter uma organização modular, separando os componentes da interface e as responsabilidades relacionadas às diferentes funcionalidades.

Estrutura inicial:

```text
src/
└── main/
    ├── java/
    │   └── br/
    │       └── furb/
    │           └── compilador/
    │               ├── Main.java
    │               ├── JanelaPrincipal.java
    │               │
    │               ├── editor/
    │               ├── mensagens/
    │               ├── status/
    │               ├── ferramentas/
    │               └── arquivos/
    │
    └── resources/
        └── icons/
```

A estrutura poderá evoluir conforme novas etapas do compilador forem implementadas.

## Desenvolvimento

O projeto utiliza Git para controle de versão e GitHub para hospedagem do código.

O desenvolvimento é realizado de forma colaborativa, utilizando branches para separar funcionalidades e facilitar a integração das alterações.

Exemplo:

```text
main
│
├── feature/editor
├── feature/arquivos
└── feature/ferramentas
```

Após o desenvolvimento e validação das funcionalidades, as alterações são integradas à branch principal.

## Equipe

Desenvolvido por:

* **Nicole Bruch**
* **Veyda Cristina Barbosa**
* **Vitor W.**

**Bacharelado em Ciência da Computação — FURB**

## Status

**Em desenvolvimento.**

O projeto encontra-se em evolução e novas funcionalidades relacionadas às etapas de análise e processamento de programas serão incorporadas posteriormente.
