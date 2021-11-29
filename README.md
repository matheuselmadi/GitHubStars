# GitHubAPI
Aplicativo que consome a API do GitHub e mostra os repositórios com mais estrelas referentes a linguagem Kotlin em ordem descendente (do repositório com mais estrelas para o com menos estrelas)

Tecnologias utilizadas:

- Dagger Hilt (Injeção de Dependêcia)
- Glide (Para o carregamento das imagens de perfil de cada repositorio)
- JUnit4 (Testes Unitários)
- Espresso (Testes de UI)
- MVVM + Clean Architecture (Arquitetura utilizada para a construção da aplicação)
- Truth (Para deixar os testes mais idiomaticos, mais simples)
- Coroutines (Programação Assíncrona)
- ViewModel (Para a persistência de estado mesmo quando o aplicativo muda de orientação)
- Paging 3 (Para o scroll infinito)
- GitHub API (Fonte dos dados exibidos na aplicação)
- Retrofit (Para o consumo da API)

O caching em tempo de execução da aplicação é feito pela Paging 3.
 
