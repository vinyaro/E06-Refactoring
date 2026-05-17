# Exercício: Refactoring

Professor: Márcio Júnior Nunes

## Refatorações

Você está recebendo nesta atividade um sistema bancário bastante simples.
Nesse sistema, é possível criar uma `Conta` com as informações do correntista, da agência, além das movimentações (representadas pela classe `Operacao`) e saldo da conta.
Contudo, você irá observar que várias más decisões de implementação foram feitas no desenvolvimento desse sistema.

**Nessa atividade, você deverá aplicar uma série de refatorações para deixar o seu código mais organizado e estruturado.**

Um ponto importante, você deverá garantir que o programa continue funcionando da mesma forma que antes após suas modificações.


### Modificações - vinyaro

1. Classe Cliente - Eu apliquei a refatoração Extract Class para mover as responsabilidades de dados pessoais do cliente para uma classe coesa e própria, adicionando também a reescrita do toString() para delegar a formatação.
2. Classe Agência - Eu apliquei Extract Class para agrupar as informações bancárias da conta e da agência em um local adequado, isolando essa responsabilidade e tratando sua respectiva exibição.
3. Classe Operação - Para resolver a alta responsabilidade e eliminar o comando condicional baseado em códigos de tipo (switch), eu apliquei a refatoração Replace Conditional with Polymorphism, transformando `Operacao` em uma classe abstrata.
4. Classe Conta - Eu realizei as seguintes modificações aqui: apliquei Rename Field mudando a variável genérica valor para saldo; utilizei Extract Method criando atualizarSaldo para dividir as tarefas de realizarOperacao; criei o método gerarExtrato para retirar a lógica de loops de dentro do toString; e por fim, deleguei as exibições de texto para os novos objetos instanciados.
5. Classe Main - Mantive a classe idêntica para comprovar que nossa interface pública não quebrou e preservou com sucesso o comportamento original do sistema.

> O código agora segue estritamente os princípios de design limpo, alta coesão e baixo acoplamento recomendados pela engenharia de software moderna.