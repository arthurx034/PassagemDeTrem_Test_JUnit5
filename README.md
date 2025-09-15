# PassagemDeTrem_Test_JUnit5

Repositório com testes automatizados em **JUnit 5** para validação de funcionalidades de um sistema de passagens de trem — voltado para aprendizado e demonstração de boas práticas de teste em Java.

---

## 🚀 Visão Geral

Este projeto tem como objetivo aplicar testes automatizados para funcionalidades de um sistema de emissão/compra de passagens de trem. Através de JUnit 5, são criados casos de teste para garantir que:

- o sistema calcula preços corretamente;  
- as regras de negócio (como descontos, cancelamento, remarcação ou restrições de assentos) sejam respeitadas;  
- entradas inválidas sejam tratadas apropriadamente (validação de dados);  
- operações básicas funcionem como esperado (reservar, pagar, confirmar, cancelar, etc.).

---

## 🛠 Tecnologias e Ferramentas

- **Linguagem**: Java  
- **Framework de Teste**: JUnit 5  
- **Build Tool / Gerenciamento de Dependências**: Maven  
- IDEs sugeridas: IntelliJ IDEA, Eclipse ou VS Code com suporte a Java/JUnit  

---

## 📁 Estrutura do Projeto

| Caminho                  | Descrição |
|---------------------------|-----------|
| `src/main/java/`          | Contém as classes principais do sistema (modelo, serviços, regras de negócio). |
| `src/test/java/`          | Contém os casos de teste escritos com **JUnit 5**. |
| `pom.xml`                 | Arquivo de configuração do **Maven** (dependências e build). |
| `.gitignore`              | Define arquivos e pastas a serem ignorados pelo Git. |


---

## ✅ Exemplos de Casos de Teste

| Funcionalidade         | O que testar |
|------------------------|--------------|
| Cálculo de Preço       | Preço base, tarifas adicionais, descontos especiais, taxas etc. |
| Validação de Dados     | Campos obrigatórios, formato incorreto, valores inválidos |
| Fluxos de Compra       | Reservar → pagar → confirmar; cancelamentos e reembolsos |
| Regras de Negócio      | Limite de assentos, horários, políticas de remarcação |

---

## 📦 Como Rodar os Testes

1. Clone o repositório:

   ```bash
   git clone https://github.com/arthurx034/PassagemDeTrem_Test_JUnit5.git

2. Acesse o diretório do projeto:

   ```bash
   cd PassagemDeTrem_Test_JUnit5

3. Execute os testes via Maven:

   ```bash
   mvn test

Ou rode diretamente pela sua IDE com suporte a JUnit.

---

## 🎯 Propósito de Aprendizado

**Esse projeto é ótimo para:**

- Praticar desenvolvimento orientado a testes (TDD)
- Aprender a usar JUnit 5 no Java de forma estruturada
- Desenvolver disciplina de manter casos de teste bem claros e abrangentes
- Melhorar qualidade de código, confiabilidade e manutenção

---

## 🔮 Melhorias Futuras

- Integração contínua com GitHub Actions para rodar os testes automaticamente.
- Cobertura de teste mais ampla, incluindo cenários de exceção e casos de borda.
- Uso de mocks/stubs para simular dependências externas.
- Dados de teste parametrizados.

---

## 📄 Licença

**Este projeto é para fins de aprendizado.**  
**Sinta-se livre para clonar, modificar e estudar.**
