INSERT INTO area_conhecimento (id, descricao)
VALUES (1, 'História');
INSERT INTO area_conhecimento (id, descricao)
VALUES (2, 'Geografia');
INSERT INTO area_conhecimento (id, descricao)
VALUES (3, 'Linguagens');
INSERT INTO area_conhecimento (id, descricao)
VALUES (4, 'Sociologia');
INSERT INTO alternativas (id, a, b, c, d, e)
VALUES (
        1,
        'Europeia',
        'Norte-americana',
        'Asiática',
        'Australiana',
        'Indígena'
    );
INSERT INTO alternativas (id, a, b, c, d, e)
VALUES (
        2,
        'Norte',
        'Nordeste',
        'Centro-oeste',
        'Sul',
        'Sudeste'
    );
INSERT INTO alternativas (id, a, b, c, d, e)
VALUES (
        3,
        'Nordeste',
        'Norte',
        'Centro-Oeste',
        'Sul',
        'Sudeste'
    );
INSERT INTO alternativas (id, a, b, c, d, e)
VALUES (
        4,
        'Nordeste, Fortaleza',
        'Sudeste, Rio de Janeiro',
        'Sudeste, São Paulo',
        'Centro-oeste, Brasília',
        'Sul, Porto Alegre'
    );
INSERT INTO alternativas (id, a, b, c, d, e)
VALUES (
        5,
        'Sudeste',
        'Nordeste',
        'Sul',
        'Norte',
        'Centro-oeste'
    );
INSERT INTO alternativas (id, a, b, c, d, e)
VALUES (
        6,
        'Centro-oeste',
        'Norte',
        'Nordeste',
        'Sudeste',
        'Sul'
    );
INSERT INTO alternativas (id, a, b, c, d, e)
VALUES (
        7,
        'Europeia, percebida atualmente pelas festividades Dança de Fitas e Oktoberfest',
        'Indígena, devido á gastronomia com predomínio de ingredientes como peixes e milho',
        'Asiática, observada pela forte imigração de japoneses e coreanos',
        'Europeia, em razão da inspiração artística e teatral, responsável pela criação do Festival de Gramado',
        'Norte-americana, visto que há gírias regionais de origem estadunidense'
    );
INSERT INTO alternativas (id, a, b, c, d, e)
VALUES (
        8,
        'Sul',
        'Sudeste',
        'Norte',
        'Centro-oeste',
        'Nordeste'
    );
INSERT INTO alternativas (id, a, b, c, d, e)
VALUES (
        9,
        'O cultivo do café',
        'Produção e colheita da cana-de-açúcar',
        'Mineração',
        'Produção de soja e derivados',
        'Extrativismo vegetal de madeira e látex'
    );
INSERT INTO alternativas (id, a, b, c, d, e)
VALUES (
        10,
        'Brasília',
        'Rio de Janeiro',
        'Salvador',
        'Curitiba',
        'São Paulo'
    );
INSERT INTO alternativas (id, a, b, c, d, e)
VALUES (
        11,
        'Em 1960, com a fundação da cidade sob governo do presidente Juscelino Kubitschek',
        'Em 1970, em decorrência da alteração de nome da cidade',
        'Em 1978, no governo de Getúlio Vargas',
        'Em 2000, com a fundação da cidade sob governo de Fernando Henrique Cardoso',
        'Em 2016, com o impeachment da então presidente Dilma Rousseff'
    );
INSERT INTO alternativas (id, a, b, c, d, e)
VALUES (
        12,
        'Café e açúcar',
        'Feijão e arroz',
        'Cana-de-açúcar e amendoim',
        'Soja e café',
        'Feijão e açúcar'
    );
INSERT INTO alternativas (id, a, b, c, d, e)
VALUES (
        13,
        'Na região Norte, no estado do Acre',
        'Sul, no estado do Rio Grande do Sul',
        'Norte, no estado do Pará',
        'Nordeste, no estado de Alagoas',
        'Nordeste, no estado do Maranhão'
    );
INSERT INTO alternativas (id, a, b, c, d, e)
VALUES (
        14,
        'Clarice Lispector, Graciliano Ramos e Aluísio Azevedo',
        'Machado de Assis, Fernando Drummond de Andrade e Cecília Meireles',
        'Graciliano Ramos, Machado de Assis e Mário de Andrade',
        'Ariano Suassuna, Jorge Amado e Lygia Fagundes',
        'Rachel de Queiroz, Graciliano Ramos e Jorge Amado'
    );
INSERT INTO alternativas (id, a, b, c, d, e)
VALUES (
        15,
        'Mata Atlântica',
        'Floresta de Araucárias',
        'Cerrado',
        'Caatinga',
        'Floresta Amazônica'
    );
INSERT INTO questao (
        id,
        comando,
        curiosidade,
        dica,
        resposta,
        tempo,
        pontuacao,
        fk_alternativas
    )
VALUES (
        1,
        'Qual a maior influência cultural na culinária nortista brasileira?',
        'O primeiro Presidente da República do Brasil foi um militar.',
        'A cozinha tradicional do norte do Brasil é rica em mandioca e peixe, herança dos costumes indígenas.',
        'Indígena',
        120,
        5,
        1
    );
INSERT INTO questao (
        id,
        comando,
        curiosidade,
        dica,
        resposta,
        tempo,
        pontuacao,
        fk_alternativas
    )
VALUES (
        2,
        'Alimentos como churrasco, polenta e chimarrão são típicos de qual região?',
        'O nome oficial do Brasil é República Federativa do Brasil',
        'O churrasco, como conhecemos no Brasil, é oriundo do Pampa, região da América do Sul, que reuni Rio Grande do Sul, Uruguai e Argentina.',
        'Sul',
        120,
        5,
        2
    );
INSERT INTO questao (
        id,
        comando,
        curiosidade,
        dica,
        resposta,
        tempo,
        pontuacao,
        fk_alternativas
    )
VALUES (
        3,
        'O cordel é um gênero literário popular brasileiro, na maioria das vezes composto por rimas, que se originou através de falas e relatos. Em qual região o cordel se formou?',
        'O Brasil é 206 vezes maior que a Suíça.',
        'No Brasil, veio com os colonizadores, instalando-se na capital brasileira da época.',
        'Nordeste',
        120,
        5,
        3
    );
INSERT INTO questao (
        id,
        comando,
        curiosidade,
        dica,
        resposta,
        tempo,
        pontuacao,
        fk_alternativas
    )
VALUES (
        4,
        'Em qual estado se encontra a maior metrópole do Brasil e qual é o nome dela?',
        'O Brasil é o maior produtor de café do mundo.',
        'Essa cidade é a capital do estado homônimo, localizado na região Sudeste do Brasil. Trata-se da maior metrópole do país, cuja região de influência é formada por uma população de 49.295.747 habitantes, ao passo que a sua região metropolitana compreende de forma direta 21,5 milhões de pessoas.',
        'Sudeste, São Paulo',
        120,
        5,
        4
    );
INSERT INTO questao (
        id,
        comando,
        curiosidade,
        dica,
        resposta,
        tempo,
        pontuacao,
        fk_alternativas
    )
VALUES (
        5,
        'O Pantanal é um importante bioma encontrado no Brasil, no Paraguai e na Bolívia. Em que região brasileira ele está localizado?
',
        'Das 30 cidades mais violentas do mundo, 12 estão localizadas do Brasil.',
        'O Pantanal é uma das maiores extensões úmidas contínuas do planeta e está localizado no centro da América do Sul.',
        'Centro-oeste',
        120,
        5,
        5
    );
INSERT INTO questao (
        id,
        comando,
        curiosidade,
        dica,
        resposta,
        tempo,
        pontuacao,
        fk_alternativas
    )
VALUES (
        6,
        'Qual é a maior região brasileira em termos de extensão?',
        'No Brasil, em 2022, foram contados 896,9 mil indígenas, de 305 etnias ou povos e falantes de 274 línguas indígenas.',
        'Essa região abrange sete estados, correspondendo a um pouco mais de 45% do território brasileiro.',
        'Norte',
        90,
        7,
        6
    );
INSERT INTO questao (
        id,
        comando,
        curiosidade,
        dica,
        resposta,
        tempo,
        pontuacao,
        fk_alternativas
    )
VALUES (
        7,
        'Qual foi a principal influência cultural disseminada na região sul?',
        'Nas prisões federais, é possível reduzir a sua pena lendo livros.',
        'A região sul tem, tradicionalmente, muitas festas e eventos culturais, que traduzem a cultura da região, qual é muito marcada pela influencia dos colonizadores.',
        'Europeia, percebida atualmente pelas festividades Dança de Fitas e Oktoberfest',
        90,
        7,
        7
    );
INSERT INTO questao (
        id,
        comando,
        curiosidade,
        dica,
        resposta,
        tempo,
        pontuacao,
        fk_alternativas
    )
VALUES (
        8,
        'Em que região brasileira estão localizados o Parque Nacional da Chapada dos Veadeiros, Chapada dos Guimarães e a Gruta do Rio Azul?',
        'O Brasil é o único país do mundo em que o etanol é oferecido em todos os postos de gasolina.',
        'O Parque Nacional está localizado entre os municípios de Cuiabá e Chapada dos Guimarães, no estado de Mato Grosso.',
        'Centro-oeste',
        90,
        7,
        8
    );
INSERT INTO questao (
        id,
        comando,
        curiosidade,
        dica,
        resposta,
        tempo,
        pontuacao,
        fk_alternativas
    )
VALUES (
        9,
        'Qual foi a principal atividade econômica desenvolvida na região sudeste, principalmente no estado de São Paulo, no século XIX?',
        'Sendo consideradas nocivas para a pele, o Brasil foi o primeiro país a banir as câmaras de bronzeamento.',
        'O solo e o clima da região favoreceram essa atividade, que se destinava a atender ao mercado consumidor da Europa e dos EUA. Os africanos escravizados formaram a força de trabalho para laborarem no cultivo, colheita e beneficiamento desse produto.',
        'O cultivo do café',
        90,
        7,
        9
    );
INSERT INTO questao (
        id,
        comando,
        curiosidade,
        dica,
        resposta,
        tempo,
        pontuacao,
        fk_alternativas
    )
VALUES (
        10,
        'O Brasil já teve quatro capitais diferentes desde a sua existência. Sabendo disso, qual foi a primeira capital brasileira?',
        'Estudos históricos revelaram que Dom Pedro I não declarou a independência às margens do riacho do Ipiranga por ser um lugar bonito para um marco histórico, e sim por estar com diarreia e por lá ser um ótimo lugar para que ele pudesse fazer suas necessidades rapidamente.',
        'Está situada na Zona da Mata da Região Nordeste do Brasil e é notável em todo o país pela sua gastronomia, música e arquitetura',
        'Salvador',
        90,
        7,
        10
    );
INSERT INTO questao (
        id,
        comando,
        curiosidade,
        dica,
        resposta,
        tempo,
        pontuacao,
        fk_alternativas
    )
VALUES (
        11,
        'Em que ano e sobre qual circunstância a região centro-oeste recebeu Brasília como capital do país?
',
        'Dom Pedro II morreu deitado em cima de um travesseiro, que ele havia enchido de terra do solo brasileiro.',
        'Uma frase muito do conhecida do presidente da época é: "50 anos em 5".',
        'Em 1960, com a fundação da cidade sob governo do presidente Juscelino Kubitschek',
        60,
        9,
        11
    );
INSERT INTO questao (
        id,
        comando,
        curiosidade,
        dica,
        resposta,
        tempo,
        pontuacao,
        fk_alternativas
    )
VALUES (
        12,
        'Quais são os principais produtos cultivados na região sudeste atualmente?',
        'Dom Pedro I, teve que pagar à Portugal mais de 2.000.000 de libras, pela nossa independência.',
        'Um desses produtos teve um papel importante no período colonial brasileiro.',
        'Cana-de-açúcar e amendoim',
        60,
        9,
        12
    );
INSERT INTO questao (
        id,
        comando,
        curiosidade,
        dica,
        resposta,
        tempo,
        pontuacao,
        fk_alternativas
    )
VALUES (
        13,
        'Em qual região e estado tradicionalmente ocorrem as festas populares Círio de Nazaré e Festival de Parintins, a mais conhecida festa do Boi-Bumbá?',
        'Alguns donos de escravos os converteram ao cristianismo. Mas como algumas passagens da Bíblia combatiam a escravidão, eles não permitiam que os seus escravos a lessem.',
        'A capital do estado é Belém.',
        'Norte, no estado do Pará',
        60,
        9,
        13
    );
INSERT INTO questao (
        id,
        comando,
        curiosidade,
        dica,
        resposta,
        tempo,
        pontuacao,
        fk_alternativas
    )
VALUES (
        14 'A região Nordeste é famosa pelo surgimento de importantes nomes da literatura brasileira. Quais são alguns desses autores?',
        'Brasil significa “vermelho como brasa” e a sua origem vem da árvore pau-brasil, que possui a cor avermelhada.',
        'Os autores escreveram, respectivamente, os seguintes livros: "O Quinze", "Vidas Secas" e "Capitães de Areia".',
        'Rachel de Queiroz, Graciliano Ramos e Jorge Amado.',
        60,
        9,
        14
    );
INSERT INTO questao (
        id,
        comando,
        curiosidade,
        dica,
        resposta,
        tempo,
        pontuacao,
        fk_alternativas
    )
VALUES (
        15 'A região sul é composta por três estados, que são Rio Grande do Sul, Santa Catarina e Paraná. Nela se encontram vegetações como Campos e Florestas Tropicais, além da maior das paisagens, que é o(a):',
        'Os bandeirantes se comunicavam em tupi. É por isso que tantos estados, municípios e rios têm nomes de origem indígena. Neste sentido, Paraná é “mar”; Pará é “rio”; Piauí é “rio de piaus” (um tipo de peixe); Sergipe é “no rio do siri”; Curitiba é “muito pinhão”; Pernambuco é “mar com fendas”, entre outros.',
        'Também chamada de Floresta Ombrófila Mista, possui clima subtropical, ou seja, com as estações do ano bem definidas. Os invernos são frios e os verões quentes, com temperaturas médias anuais oscilando entre 18 ºC e 22 ºC.',
        'Floresta de Araucárias',
        60,
        9,
        15
    );
INSERT INTO associacao_questao_area_conhecimento (fk_questao, fk_area_conhecimento)
VALUES (1, 1);
INSERT INTO associacao_questao_area_conhecimento (fk_questao, fk_area_conhecimento)
VALUES (2, 2);
INSERT INTO associacao_questao_area_conhecimento (fk_questao, fk_area_conhecimento)
VALUES (3, 3);
INSERT INTO associacao_questao_area_conhecimento (fk_questao, fk_area_conhecimento)
VALUES (4, 4);
INSERT INTO associacao_questao_area_conhecimento (fk_questao, fk_area_conhecimento)
VALUES (5, 2);
INSERT INTO associacao_questao_area_conhecimento (fk_questao, fk_area_conhecimento)
VALUES (6, 2);
INSERT INTO associacao_questao_area_conhecimento (fk_questao, fk_area_conhecimento)
VALUES (7, 1);
INSERT INTO associacao_questao_area_conhecimento (fk_questao, fk_area_conhecimento)
VALUES (8, 2);
INSERT INTO associacao_questao_area_conhecimento (fk_questao, fk_area_conhecimento)
VALUES (9, 1);
INSERT INTO associacao_questao_area_conhecimento (fk_questao, fk_area_conhecimento)
VALUES (10, 1);
INSERT INTO associacao_questao_area_conhecimento (fk_questao, fk_area_conhecimento)
VALUES (11, 1);
INSERT INTO associacao_questao_area_conhecimento (fk_questao, fk_area_conhecimento)
VALUES (12, 2);
INSERT INTO associacao_questao_area_conhecimento (fk_questao, fk_area_conhecimento)
VALUES (13, 3);
INSERT INTO associacao_questao_area_conhecimento (fk_questao, fk_area_conhecimento)
VALUES (14, 3);
INSERT INTO associacao_questao_area_conhecimento (fk_questao, fk_area_conhecimento)
VALUES (15, 2);