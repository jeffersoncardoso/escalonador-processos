# Descrição
- Trabalho realizado para a disciplina de Sistemas Operacionais, na Universidade Feevale (Novo Hamburgo - Brasil) para o curso de Ciencia da Computação.

# Objetivos do Trabalho

- Criação de uma interface que simule um Escalonador de Processos do tipo Round Robin

# Tecnologias Utilizadas
- Java 
- Swing (para GUI)

# Arquitetura do Sistema
- Utilizei alguns conceitos de DDD (Domain Driven Design) para criação da estrutura de pastas, portanto dividi o código da seguinte forma:

> - Dominio - Toda lógica de negocio se encontra aqui (entidades como Processo, Escalonador, Situacao, etc.)
> - GUI - Interface do usuário (foi utilizado o Swing para criação das telas)
> - Controle - Integração entre classes de Dominio e GUI, como no MVC

