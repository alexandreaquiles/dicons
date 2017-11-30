# dicons
Exemplo que lista diretórios e permite fazer o download para alunos do FJ-21


Se você quiser, pode baixar um ZIP com o código pelo link:
https://github.com/alexandreaquiles/dicons/archive/master.zip

---


A classe `PesquisadorDicons`, para um dado número de atendimento, vasculha o diretório configurado e monta uma lista de `Dicon`.

Um `Dicon` tem o número de atendimento, o nome do diretório, o nome do cliente (o nome do diretório sem os digítos).

Já a classe `CompactadorDicons` recebe o nome de um diretório e cria um _zip_ contendo cada arquivo desse diretório.
O _zip_ tem o nome do diretório e é salvo numa pasta configurada.

As configurações do diretório de origem (o que deve ser vasculhado) e também o diretório onde são salvos os _zips_ estão na classe `Dirs`. 

O `DiconsController` faz a ponte entre as chamadas das URLs, essas classes que fazem o trabaho pesado e as JSPs.

---

Para rodar, crie um projeto Web no Eclipse e jogue esses arquivos.

Mande pra um Tomcat e acesse por:

http://localhost:8080/nome-do-projeto/dicons

Os valores padrão para os diretórios ficam em: src/dir.properties
Deixei o diretório de origem como `dicons` e o dos zips como `dicons-zips`, ambos na pasta do usuário.

Esses valores pode ser sobreescritos com um system properties.

Exemplo:
-DdiconsDir=/meu/outro/dicon/dir
-DdiconsZipDir=/outro/dicon/zip/dir

Ao executar o Tomcat por dentro do Eclipse:
- dê duplo clique no Tomcat na aba Servers
- clique em "Open Launch Configuration"
- vá até a aba "Arguments"
- insira as configurações acima no final de "VM Arguments"
