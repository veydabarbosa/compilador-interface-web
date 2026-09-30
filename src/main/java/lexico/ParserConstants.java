package lexico;

public interface ParserConstants
{
    int START_SYMBOL = 38;

    int FIRST_NON_TERMINAL    = 38;
    int FIRST_SEMANTIC_ACTION = 78;

    int[][] PARSER_TABLE =
    {
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1,  1,  1,  1,  1, -1, -1, -1, -1, -1,  1,  1, -1, -1, -1, -1, -1,  1, -1,  1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1,  4,  4,  4,  4, -1, -1, -1, -1, -1,  7,  5, -1, -1, -1, -1, -1,  6, -1,  8, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1,  9,  9,  9,  9, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  9, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 11, 11, 11, 11, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 12, 12, 12, 12, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 15, 15, 15, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 16, 17, 18, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, 21, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 22, 22, 22, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, 27, -1, -1, 26, -1, -1, -1, -1, -1, -1, 26, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 28, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 29, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 30, 30, 30, 30, 30, 30, 30, -1, 30, -1, -1, -1, -1, -1, 30, -1, -1, 30, -1, -1, -1, -1, 30, -1, -1, -1, 30, 30, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 37, 37, 37, 37, -1, -1, -1, -1, -1, 37, 37, 38, -1, -1, -1, -1, 37, -1, 37, -1, -1, -1, -1, -1, -1, 37, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 39, 39, 39, 39, -1, -1, -1, -1, -1, 39, 39, -1, 40, -1, -1, -1, 39, -1, 39, -1, -1, -1, -1, -1, -1, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 45, 45, 45, 45, 45, 45, 45, -1, 45, -1, -1, -1, -1, -1, 45, -1, -1, 45, -1, -1, -1, -1, 45, -1, -1, -1, 45, 45, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 23, 23, 23, 23, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 49, 49, 49, 49, 49, 49, 49, -1, 51, -1, -1, -1, -1, -1, 52, -1, -1, 50, -1, -1, -1, -1, 49, -1, -1, -1, 49, 49, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 46, 46, 46, 46, -1, -1, -1, 47, -1, 46, 46, -1, -1, -1, -1, 48, 46, -1, 46, 46, -1, 46, -1, 46, -1, 46, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 53, 53, 53, 53, 53, 53, 53, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 53, -1, -1, -1, 53, 53, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 54, 54, 54, 54, -1, -1, -1, 54, -1, 54, 54, -1, -1, -1, -1, 54, 54, -1, 54, 54, -1, 54, -1, 54, -1, 54, -1, -1, -1, -1, -1, 55, 55, 55, 55 },
        { -1, -1, 60, 60, 60, 60, 60, 60, 60, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 60, -1, -1, -1, 60, 60, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 61, 61, 61, 61, -1, -1, -1, 61, -1, 61, 61, -1, -1, -1, -1, 61, 61, -1, 61, 61, -1, 61, -1, 61, -1, 61, 62, 63, -1, -1, -1, 61, 61, 61, 61 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 56, 57, 58, 59 },
        { -1, -1, 64, 64, 64, 64, 64, 64, 64, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 64, -1, -1, -1, 64, 64, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 65, 65, 65, 65, -1, -1, -1, 65, -1, 65, 65, -1, -1, -1, -1, 65, 65, -1, 65, 65, -1, 65, -1, 65, -1, 65, 65, 65, 66, 67, -1, 65, 65, 65, 65 },
        { -1, -1, 68, 68, 68, 68, 69, 70, 71, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 72, -1, -1, -1, 73, 74, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 75, 76, 77, 78, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 79, 79, 79, 79, -1, -1, -1, 79, -1, 79, 79, -1, -1, -1, -1, 79, 79, -1, 79, 79, 80, 79, -1, 79, -1, 79, 79, 79, 79, 79, -1, 79, 79, 79, 79 },
        { -1, -1,  3,  3,  3,  3, -1, -1, -1, -1, -1,  3,  3, -1, -1, -1, -1, -1,  3, -1,  3, -1, -1, -1, -1, -1, -1,  2, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 14, -1, -1, -1, -1, 13, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 25, -1, -1, -1, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 32, -1, -1, -1, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, 42, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 44, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
    };

    int[][] PRODUCTIONS = 
    {
        { 16, 41, 27, 39, 28 },
        { 40, 70 },
        {  0 },
        { 39 },
        { 47 },
        { 49 },
        { 50 },
        { 52 },
        { 55 },
        { 42 },
        {  0 },
        { 43 },
        { 44, 71 },
        {  0 },
        { 22, 43 },
        { 45, 46 },
        {  3 },
        {  4 },
        {  5 },
        {  6 },
        {  0 },
        { 23,  7, 24 },
        { 45, 48, 33, 56 },
        { 45, 48, 72 },
        {  0 },
        { 22, 57 },
        {  0 },
        { 23, 56, 24 },
        { 13, 25, 57, 26 },
        { 19, 25, 51, 26 },
        { 56, 73 },
        {  0 },
        { 22, 51 },
        { 12, 25, 56, 26, 74 },
        { 15, 75, 53 },
        { 14, 75, 54 },
        { 27, 39, 28 },
        {  0 },
        { 14, 27, 39, 28 },
        {  0 },
        { 15, 27, 39, 28 },
        { 21, 25, 56, 26, 76 },
        { 15, 77 },
        { 14, 77 },
        { 27, 39, 28 },
        { 58, 59 },
        {  0 },
        { 10, 58, 59 },
        { 18, 58, 59 },
        { 60 },
        { 20 },
        { 11 },
        { 17, 58 },
        { 62, 61 },
        {  0 },
        { 64, 62 },
        { 34 },
        { 35 },
        { 36 },
        { 37 },
        { 65, 63 },
        {  0 },
        { 29, 65, 63 },
        { 30, 65, 63 },
        { 67, 66 },
        {  0 },
        { 31, 67, 66 },
        { 32, 67, 66 },
        { 68, 69 },
        {  7 },
        {  8 },
        {  9 },
        { 25, 56, 26 },
        { 29, 67 },
        { 30, 67 },
        {  3 },
        {  4 },
        {  5 },
        {  6 },
        {  0 },
        { 23, 56, 24 }
    };

    String[] PARSER_ERROR =
    {
        "", // 
        "esperado EOF", // Era esperado fim de programa
        "esperado palavra_reservada", // Era esperado palavra_reservada
        "esperado identificador", // Era esperado identificador_int
        "esperado identificador", // Era esperado identificador_float
        "esperado identificador", // Era esperado identificador_string
        "esperado identificador", // Era esperado identificador_bool
        "esperado constante_int", // Era esperado const_int
        "esperado constante_float", // Era esperado const_float
        "esperado constante_string", // Era esperado const_string
        "esperado and", // Era esperado and
        "esperado false", // Era esperado false
        "esperado if", // Era esperado if
        "esperado in", // Era esperado in
        "esperado isFalseDo", // Era esperado isfalsedo
        "esperado isTrueDo", // Era esperado istruedo
        "esperado module", // Era esperado module
        "esperado not", // Era esperado not
        "esperado or", // Era esperado or
        "esperado out", // Era esperado out
        "esperado true", // Era esperado true
        "esperado while", // Era esperado while
        "esperado ,", // Era esperado ","
        "esperado [", // Era esperado "["
        "esperado ]", // Era esperado "]"
        "esperado (", // Era esperado "("
        "esperado )", // Era esperado ")"
        "esperado {", // Era esperado "{"
        "esperado }", // Era esperado "}"
        "esperado +", // Era esperado "+"
        "esperado -", // Era esperado "-"
        "esperado *", // Era esperado "*"
        "esperado /", // Era esperado "/"
        "esperado <-", // Era esperado "<-"
        "esperado =", // Era esperado "="
        "esperado <>", // Era esperado "<>"
        "esperado <", // Era esperado "<"
        "esperado >", // Era esperado ">"
        "esperado module", // <forma_geral> inválido
        "esperado identificador if in out while", // <lista_comandos> inválido
        "esperado identificador if in out while", // <comando> inválido
        "esperado identificador {", // <declaracao_variaveis> inválido
        "esperado identificador {", // <lista_variaveis> inválido
        "esperado identificador", // <lista_identificadores> inválido
        "esperado identificador", // <identificador> inválido
        "esperado identificador", // <tipo_identificadores> inválido
        "esperado , [ {", // <int_colchetes> inválido
        "esperado identificador", // <comando_atribuicao> inválido
        "esperado expressao", // <expressao_colchetes> inválido
        "esperado in", // <comando_entrada> inválido
        "esperado out", // <comando_saida> inválido
        "esperado expressao", // <lista_expressoes> inválido
        "esperado if", // <comando_selecao> inválido
        "esperado identificador if in isFalseDo out while }", // <isfalsedo_opcional> inválido
        "esperado identificador if in isTrueDo out while }", // <istruedo_opcional> inválido
        "esperado while", // <comando_repeticao> inválido
        "esperado expressao", // <expressao> inválido
        "esperado identificador", // <lista_id_entrada> inválido
        "esperado expressao", // <termo_logico> inválido
        "esperado expressao", // <expressao_> inválido
        "esperado expressao", // <relacional> inválido
        "esperado expressao", // <relacional_> inválido
        "esperado expressao", // <aritmetica> inválido
        "esperado expressao", // <aritmetica_> inválido
        "esperado = <> < >", // <operador_relacional> inválido
        "esperado expressao", // <termo_aritmetico> inválido
        "esperado expressao", // <termo_aritmetico_> inválido
        "esperado expressao", // <fator> inválido
        "esperado identificador", // <identificador_expressao> inválido
        "esperado expressao", // <vetor> inválido
        "esperado identificador if in out while }", // <lista_comandos1> inválido
        "esperado , {", // <lista_identificadores1> inválido
        "esperado , )", // <lista_id_entrada1> inválido
        "esperado , )", // <lista_expressoes1> inválido
        "esperado isFalseDo isTrueDo", // <comando_selecao1> inválido
        "esperado {", // <comando_selecao2> inválido
        "esperado isFalseDo isTrueDo", // <comando_repeticao1> inválido
        "esperado {" // <comando_repeticao2> inválido
    };
}
