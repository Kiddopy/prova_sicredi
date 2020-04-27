## Prova Sicredi

 Este projeto foi desenvolvido em Java utilizando Selenium WebDriver e TestNG, tendo com objetivo realizar o cadastro e exclusão de um cliente no sistema com as informações solicitadas.

# Pré-requisitos

Este projeto conta com a versão JavaSE 1.8 e TestNG.

Caso você não possua o TestNG instalado no Eclipse, basta adicioná-lo por meio do botão "Help" presente no menu superior da IDE, e, em seguida, clique em "Install new software". Procure pelo plugin, selecione-o e clique em "Finish".

# Execução

- Abra o projeto dentro do Eclipse por meio de File > Import > Existing Maven Project. Em seguida, selecione o diretório do projeto e clique em "Finish".
- Uma vez com o projeto aberto dentro do Eclipse, clique com o botão direito do mouse em cima do arquivo "regression.xml" e selecione "Run As" > "TestNG Suite".

# CMD
Você também pode executá-lo via CMD, abrindo a pasta do projeto via linha de comando e inserindo o seguinte código:

 mvn clean test -DsuiteXmlFile=regression.xml

# Reports

Os resultados obtidos podem ser conferidos por meio dos reports HTML gerados via ExtentReport dentro da pasta TestReport. Dentro dele estão os resultados de ambos os TestCases.

