# Sharingan (NeoForge 1.21.1)

Mod que adiciona somente o Sharingan do Naruto: 1, 2 e 3 tomoe, Mangekyou (Itachi, Sasuke, Obito, Shisui) e Mangekyou Eterno.

## Compilar no GitHub
1. Crie um repositório e envie o conteúdo desta pasta (incluindo `.github`).
2. Aba **Actions** > workflow **Build mod** (roda sozinho a cada push).
3. Baixe o `.jar` em **Artifacts > sharingan-mod** e coloque em `mods/` com NeoForge 21.1.x.

## Teclas (reconfiguráveis em Controles > Sharingan; o HUD e as mensagens mostram a tecla real)
| Padrão | Ação |
|---|---|
| J | Aba Sharingan (equipar/remover, extrair olho, partilhar Obito) |
| V | Ativar/desativar Sharingan (som de vidro quebrando) |
| B | Ativar/desativar Mangekyou |
| \ , Z, X, C | Habilidades 1 a 4 (a 4 é o Susanoo) |

## Chakra
Sharingan só funciona com chakra (precisa de pelo menos 10% para ligar). Gasta 1 de chakra a cada 1,2 s ligado; recupera a barra inteira em 90 s desligado.

| Estágio | Chakra máx. | Duração contínua |
|---|---|---|
| 1 tomoe | 100 | 2 min |
| 2 tomoe | 200 | 4 min |
| 3 tomoe | 300 | 6 min |
| Mangekyou | 400 | 8 min |
| Eterno | 500 | 10 min |

Cada habilidade do Mangekyou gasta chakra (valor mostrado no HUD) e também desgasta o olho. O Susanoo custa 100 para ligar e gasta mais enquanto dura.

## Clã Uchiha
Todo jogador recebe o **Emblema do Clã Uchiha** ao entrar pela primeira vez no mundo. Clique direito para pertencer ao clã. **Só quem é do Clã Uchiha pode despertar o Sharingan** (30% de chance ao sobreviver a um golpe quase fatal). Quem tiver o Sharingan sem ser do clã (por comando de admin) paga +50% de recarga e de custo de chakra e +25% de desgaste ocular.

## Progressão
- **Despertar**: sobreviver a um golpe que deixe você com 2 corações ou menos.
- **1 > 2 tomoe**: 150 XP. **2 > 3 tomoe**: 250 XP. Com o Sharingan ativo: +10 por monstro morto, XP de orbes coletados e +1 por segundo.
- **Mangekyou**: com 3 tomoe, mate qualquer mob domesticado (lobo, gato, papagaio, cavalo...): o Mangekyou que vem é aleatório (Itachi, Sasuke, Obito ou Shisui).
- **Eterno**: com o Mangekyou de Itachi ou Sasuke, implante o olho do outro. Não cura cegueira, só remove o desgaste daí em diante.
- **Obito**: "Partilhar" na aba J parte o olho (meio olho: recargas +50%, desgaste -50%). Usar o Meio Olho de Obito em quem já tem a outra metade restaura os dois olhos.
- **Retirar o Sharingan**: o botão da aba J entrega o item na sua mão em qualquer estágio. 1/2/3 tomoe viram o item Sharingan do estágio (guarda o XP). O Mangekyou é o 3 tomoe evoluído: retirar o Mangekyou (ou o Eterno) tira o 3 tomoe junto, num item só (olho do tipo, ou Olhos do Mangekyou Eterno), e você fica sem Sharingan. O desgaste/cegueira continuam com você.
- **Implantar**: clique direito no item. Implantar o Mangekyou ou o Eterno já implanta o 3 tomoe. O item **substitui** o Sharingan que você tiver (o antigo volta como item). Quem recebe o item fica com o mesmo XP que o dono tinha; quem não é do Clã Uchiha tem as penalidades (recargas e custo de chakra +50%, desgaste +25%).

## Diminuir os ticks (tick rate do jogo)
Com o Sharingan ativo o jogo inteiro roda a (20 - N) ticks por segundo, igual ao `/tick rate`: 18 (1 tomoe), 17, 16, 15 (Mangekyou) e 14 (Eterno). Isso desacelera tudo, inclusive você, e vale para o servidor todo (com vários jogadores vale o maior N). Ao desligar volta a 20. O chakra é compensado, então a duração em tempo real não muda.

## Rosto
Os dois olhos aparecem no rosto do jogador (visível para todos em terceira pessoa) enquanto o Sharingan está ativo, com o desenho do estágio atual.

## Habilidades
- **Itachi**: Tsukuyomi, Amaterasu, Karasu Bunshin.
- **Sasuke**: Chidori Corrente, Enton: Kagutsuchi, Kirin.
- **Obito**: "Partilhar" na aba J parte o olho (meio olho: recargas +50%, desgaste -50%). Usar o Meio Olho de Obito em quem já tem a outra metade restaura os dois olhos.
- **Shisui**: Kotoamatsukami, Shunshin, Olhar Revelador.
- **Eterno**: com o Mangekyou de Itachi ou Sasuke, implante o olho do outro. Não cura cegueira, só remove o desgaste daí em diante.

## Cegueira (permanente)
O desgaste ocular nunca diminui. Em média cada habilidade soma cerca de 1% (uns 100 usos até cegar). Ao chegar a 100% a tela fica preta para sempre; com o Sharingan ativo você só vê silhuetas escuras. Não há como desfazer. O Eterno não acumula desgaste.

## Comandos de teste (OP)
`/sharingan stage <0-3>`, `/sharingan mangekyou <itachi|sasuke|obito|shisui|eterno>`, `/sharingan xp <n>`, `/sharingan chakra`, `/sharingan uchiha <true|false>`, `/sharingan blind`, `/sharingan cure` (só para testes de admin).

## Texturas
Os olhos vêm das imagens de referência em `tools/source` (convertidas por `tools/process_images.py`).
