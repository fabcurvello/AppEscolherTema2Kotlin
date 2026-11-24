# App Escolher Tema 2 (Kotlin)

> Repositório didático: exercício prático de Android nativo com **Kotlin**, desenvolvido e aplicado em sala de aula pelo Prof. Fabricio Curvello.

## Sobre o projeto

Segunda versão do app de escolha de tema: em vez de `SharedPreferences`, a preferência do usuário é salva em um **arquivo no armazenamento interno**.

## Contexto acadêmico

Exercício aplicado em sala de aula, usado como prática guiada com os alunos.

## Versão em Java

Esta mesma aplicação também foi desenvolvida em **Java**: [AppEscolherTema2Java](https://github.com/fabcurvello/AppEscolherTema2Java). Comparar as duas versões lado a lado ajuda a entender as diferenças de sintaxe entre Java e Kotlin no Android.

## O que o app faz

- Botões **Tema Claro** e **Tema Escuro** para trocar o tema.
- A escolha é gravada no arquivo `theme_preference.txt`, no armazenamento interno.
- Ao abrir o app, o tema salvo é aplicado antes de a tela ser criada; sem preferência salva, segue o tema do sistema.
- Um texto mostra qual tema está ativo.

## Conceitos trabalhados em aula

- Tema claro/escuro com `AppCompatDelegate` (incluindo `MODE_NIGHT_FOLLOW_SYSTEM`)
- Persistência em arquivo no **armazenamento interno**
- Momento certo de aplicar o tema no ciclo de vida (antes do `setContentView`)

## Tecnologias

- **Kotlin**
- **Android SDK** (Android Studio)
- **Gradle**
- `minSdk 27` / `compileSdk 34`

## Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/fabcurvello/AppEscolherTema2Kotlin.git
   ```
2. Abra a pasta no **Android Studio** e aguarde a sincronização do Gradle.
3. Execute em um emulador ou dispositivo físico com Android compatível com a API 27 ou superior.

## Veja também

Outros repositórios de aula com o mesmo tema:

- [AppEscolherTemaJava](https://github.com/fabcurvello/AppEscolherTemaJava)
- [AppEscolherTemaKotlin](https://github.com/fabcurvello/AppEscolherTemaKotlin)
- [AppEscolherTema2Java](https://github.com/fabcurvello/AppEscolherTema2Java)

## Autor

**Fabricio Curvello**: professor de desenvolvimento de software no SENAI-RJ (desde 1997) e em faculdades do grupo Ânima Educação (IBMR e UNA).

- GitHub: [github.com/fabcurvello](https://github.com/fabcurvello)
- LinkedIn: [linkedin.com/in/fabriciocurvello](https://www.linkedin.com/in/fabriciocurvello)
- YouTube: [@fabriciocurvello](https://www.youtube.com/@fabriciocurvello)
