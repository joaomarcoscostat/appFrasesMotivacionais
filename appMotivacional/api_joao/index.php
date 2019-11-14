<?php
header('Content-Type: application/json');
$dadosDB = [
    ["conteudo"=>"A persistência é o caminho do êxito.", "autor"=>"Charles Chaplin"],
    ["conteudo"=>"O sucesso nasce do querer, da determinação e persistência em se chegar a um objetivo. Mesmo não atingindo o alvo, quem busca e vence obstáculos, no mínimo fará coisas admiráveis.", "autor"=>"José de Alencar"],
    ["conteudo"=>"Determinação, coragem e autoconfiança são fatores decisivos para o sucesso. Se estamos possuídos por uma inabalável determinação, conseguiremos superá-los. Independentemente das circunstâncias, devemos ser sempre humildes, recatados e despidos de orgulho.", "autor"=>"Dalai Lama"],
    ["conteudo"=>"Agir, eis a inteligência verdadeira. Serei o que quiser. Mas tenho que querer o que for. O êxito está em ter êxito, e não em ter condições de êxito. Condições de palácio tem qualquer terra larga, mas onde estará o palácio se não o fizerem ali?", "autor"=>"Fernando Pessoa"],
    ["conteudo"=>"Lute. Acredite. Conquiste. Perca. Deseje. Espere. Alcance. Invada. Caia. Seja tudo o quiser ser, mas acima de tudo, seja você sempre.", "autor"=>"Tumblr"],
    ["conteudo"=>"Só existe um êxito: a capacidade de levar a vida que se quer.", "autor"=>"Cristopher Morley"],
    ["conteudo"=>"A vitalidade é demonstrada não apenas pela persistência, mas pela capacidade de começar de novo.", "autor"=>"F. Scott Fitzgerald"],
    ["conteudo"=>"A coragem não é ausência do medo; é a persistência apesar do medo.", "autor"=>"Desconhecido"],
    ["conteudo"=>"O homem não teria alcançado o possível se, repetidas vezes, não tivesse tentado o impossível.", "autor"=>"Max Weber"],
    ["conteudo"=>"Só se pode alcançar um grande êxito quando nos mantemos fiéis a nós mesmos.", "autor"=>"Friedrich Nietzsche"],
    ["conteudo"=>"Todo mundo é capaz de sentir os sofrimentos de um amigo. Ver com agrado os seus êxitos exige uma natureza muito delicada.", "autor"=>"Oscar Wilde"],
    ["conteudo"=>"Lute com determinação, abrace a vida com paixão, perca com classe e vença com ousadia, porque o mundo pertence a quem se atreve e a vida é muito para ser insignificante.", "autor"=>"Augusto Branco"],
    ["conteudo"=>"Força de ânimo e coragem na adversidade servem para conquistar o êxito, mais do que um exército.", "autor"=>"John Dryden"],
    ["conteudo"=>"Creia em si, mas não duvide sempre dos outros.", "autor"=>"Machado de Assis"],
    ["conteudo"=>"Dois homens não podem passar meia hora juntos sem que um conquiste uma evidente superioridade em relação ao outro.", "autor"=>"Samuel Johnson"],
    ["conteudo"=>"Não deixe que as pessoas te façam desistir daquilo que você mais quer na vida. Acredite. Lute. Conquiste. E acima de tudo, seja feliz!", "autor"=>"Desconhecido"],
    ["conteudo"=>"As únicas grandes companhias que conseguirão ter êxito são aquelas que consideram os seus produtos obsoletos antes que os outros o façam.", "autor"=>"Bill Gates"],
    ["conteudo"=>"Talento é dom, é graça. E sucesso nada tem haver com sorte, mas com determinação e trabalho.", "autor"=>"Augusto Branco"],
    ["conteudo"=>"Para ter um negócio de sucesso, alguém, algum dia, teve que tomar uma atitude de coragem.", "autor"=>"Peter Drucker"],
    ["conteudo"=>"Nenhum mentiroso tem uma memória suficientemente boa para ser um mentiroso de êxito.", "autor"=>"Abraham Lincoln"],
    ["conteudo"=>"Estar decidido, acima de qualquer coisa, é o segredo do êxito.", "autor"=>"Henry Ford"],
];
$max = count($dadosDB);
$random = rand(0, $max);
echo json_encode($dadosDB[$random]);
?>