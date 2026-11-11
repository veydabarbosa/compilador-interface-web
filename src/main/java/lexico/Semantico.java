package lexico;

import java.util.Stack;
import java.util.LinkedHashMap;
import java.util.Map;

public class Semantico implements Constants {

    //registros semanticos
    private StringBuilder codigoObjeto = new StringBuilder();
    private Stack<String> pilhaTipos = new Stack<>();
    private String operadorRelacional = "";
    private String identificador = "";
    private Map<String, Simbolo> tabelaSimbolos = new LinkedHashMap<>();
    private boolean destinoVetor = false;
    private Stack<String> pilhaRotulos = new Stack<>();
    private int contadorRotulos = 0;

    private static class Simbolo {
        String tipo;
        int tamanho;
        boolean utilizado;

        Simbolo(String tipo, int tamanho) {
            this.tipo = tipo;
            this.tamanho = tamanho;
            this.utilizado = false;
        }
    }

    public void executeAction(int action, Token token) throws SemanticError {
        System.out.println("Acao #" + action + ", Token: " + token);

        switch (action) {
            case 101:
                acao101();
                break;
            case 102:
                acao102(token);
                break;
            case 103:
                acao103(token);
                break;
            case 104:
                acao104();
                break;
            case 105:
                acao105(token);
                break;
            case 106:
                acao106();
                break;
            case 107:
                acao107();
                break;
            case 108:
                acao108();
                break;
            case 109:
                acao109();
                break;
            case 110:
                acao110(token);
                break;
            case 111:
                acao111();
                break;
            case 112:
                acao112();
                break;
            case 113:
                acao113();
                break;
            case 114:
                acao114(token);
                break;
            case 115:
                acao115();
                break;
            case 116:
                acao116();
                break;
            case 117:
                acao117();
                break;
            case 118:
                acao118();
                break;
            case 119:
                acao119();
                break;
            case 120:
                acao120();
                break;
            case 121:
                acao121(token);
                break;
            case 122:
                acao122();
                break;
            case 123:
                acao123();
                break;
            case 124:
                acao124();
                break;
            case 125:
                acao125(token);
                break;
            case 126:
                acao126();
                break;
            case 127:
                acao127(token);
                break;
            case 128:
                acao128(token);
                break;
            case 129:
                acao129(token);
                break;
            case 130:
                acao130(token);
                break;
            case 131:
                acao131();
                break;
            case 132:
                acao132();
                break;
            case 133:
                acao133();
                break;
            case 134:
                acao134();
                break;
            default:
                throw new SemanticError("Acao semantica nao implementada: " + action);
        }
    }

    private void acao101() {
        codigoObjeto.append(".assembly extern mscorlib {}\n");
        codigoObjeto.append(".assembly _codigo_objeto{}\n");
        codigoObjeto.append(".module _codigo_objeto.exe\n");
        codigoObjeto.append("\n");
        codigoObjeto.append(".class public _codigo_objeto{\n");
        codigoObjeto.append(".method static public void _principal(){\n");
        codigoObjeto.append(".entrypoint\n");
    }

    private void acao102(Token token) throws SemanticError {
        for (Map.Entry<String, Simbolo> entrada
                : tabelaSimbolos.entrySet()) {

            if (!entrada.getValue().utilizado) {
                throw new SemanticError(
                        entrada.getKey()
                                + " identificador declarado, não utilizado",
                        token.getPosition()
                );
            }
        }

        codigoObjeto.append("ret\n");
        codigoObjeto.append("}\n");
        codigoObjeto.append("}");
    }

    private void acao103(Token token) {
        identificador = token.getLexeme();
        destinoVetor = false;
    }

    private String obterTipo(String nome) {
        switch (nome.charAt(0)) {
            case 'i':
                return "int64";
            case 'f':
                return "float64";
            case 's':
                return "string";
            default:
                return "bool";
        }
    }

    private void acao104() {
        String tipo = obterTipo(identificador);

        tabelaSimbolos.put(identificador, new Simbolo(tipo, 0));

        codigoObjeto.append(
                ".locals (" + tipo + " " + identificador + ")\n"
        );
    }

    private void acao105(Token token) {
        String tipo = obterTipo(identificador);
        int tamanho = Integer.parseInt(token.getLexeme());

        tabelaSimbolos.put(
                identificador, new Simbolo(tipo, tamanho)
        );

        codigoObjeto.append(
                ".locals (" + tipo + "[] " + identificador + ")\n"
        );
        codigoObjeto.append("ldc.i8 " + tamanho + "\n");

        String tipoElemento;
        switch (tipo) {
            case "int64":
                tipoElemento = "System.Int64";
                break;
            case "float64":
                tipoElemento = "System.Double";
                break;
            case "string":
                tipoElemento = "System.String";
                break;
            default:
                tipoElemento = "System.Boolean";
                break;
        }

        codigoObjeto.append(
                "newarr [mscorlib]" + tipoElemento + "\n"
        );
        codigoObjeto.append("stloc " + identificador + "\n");
    }

    private void acao106() {
        Simbolo simbolo = tabelaSimbolos.get(identificador);

        pilhaTipos.pop();

        if ("int64".equals(simbolo.tipo)) {
            codigoObjeto.append("conv.i8\n");
        }

        if (destinoVetor) {
            switch (simbolo.tipo) {
                case "int64":
                    codigoObjeto.append("stelem.i8\n");
                    break;
                case "float64":
                    codigoObjeto.append("stelem.r8\n");
                    break;
                case "string":
                    codigoObjeto.append("stelem.ref\n");
                    break;
                case "bool":
                    codigoObjeto.append("stelem.i1\n");
                    break;
            }
        } else {
            codigoObjeto.append("stloc " + identificador + "\n");
        }

        simbolo.utilizado = true;
        destinoVetor = false;
    }

    private void acao107() {
        destinoVetor = true;
        codigoObjeto.append("ldloc " + identificador + "\n");
    }

    private void acao108() {
        Simbolo simbolo = tabelaSimbolos.get(identificador);

        codigoObjeto.append(
                "call string [mscorlib]System.Console::ReadLine()\n"
        );

        switch (simbolo.tipo) {
            case "int64":
                codigoObjeto.append(
                        "call int64 [mscorlib]System.Int64::Parse(string)\n"
                );
                break;
            case "float64":
                codigoObjeto.append(
                        "call float64 [mscorlib]System.Double::Parse(string)\n"
                );
                break;
            case "bool":
                codigoObjeto.append(
                        "call bool [mscorlib]System.Boolean::Parse(string)\n"
                );
                break;
        }

        pilhaTipos.push(simbolo.tipo);
        acao106();
    }

    private void acao109() {
        String tipo = pilhaTipos.pop();
        if ("int64".equals(tipo)) {
            codigoObjeto.append("conv.i8\n");
        }
        codigoObjeto.append("call void [mscorlib]System.Console::Write(" + tipo + ")\n");
    }

    private String novoRotulo() {
        contadorRotulos++;
        return "r" + contadorRotulos;
    }

    private void acao110(Token token) {
        pilhaTipos.pop();

        String rotulo = novoRotulo();
        pilhaRotulos.push(rotulo);

        if (token.getId() == t_istruedo) {
            codigoObjeto.append("brfalse " + rotulo + "\n");
        } else {
            codigoObjeto.append("brtrue " + rotulo + "\n");
        }
    }

    private void acao111() {
        String rotulo = pilhaRotulos.pop();
        codigoObjeto.append(rotulo + ":\n");
    }

    private void acao112() {
        String rotuloAlternativo = pilhaRotulos.pop();
        String rotuloFim = novoRotulo();

        codigoObjeto.append("br " + rotuloFim + "\n");
        codigoObjeto.append(rotuloAlternativo + ":\n");

        pilhaRotulos.push(rotuloFim);
    }

    private void acao113() {
        String rotuloInicio = novoRotulo();
        pilhaRotulos.push(rotuloInicio);

        codigoObjeto.append(rotuloInicio + ":\n");
    }

    private void acao114(Token token) {
        pilhaTipos.pop();

        String rotuloFim = novoRotulo();
        pilhaRotulos.push(rotuloFim);

        if (token.getId() == t_istruedo) {
            codigoObjeto.append("brfalse " + rotuloFim + "\n");
        } else {
            codigoObjeto.append("brtrue " + rotuloFim + "\n");
        }
    }

    private void acao115() {
        String rotuloFim = pilhaRotulos.pop();
        String rotuloInicio = pilhaRotulos.pop();

        codigoObjeto.append("br " + rotuloInicio + "\n");
        codigoObjeto.append(rotuloFim + ":\n");
    }

    private void acao116() {
        pilhaTipos.pop();
        pilhaTipos.pop();
        pilhaTipos.push("bool");
        codigoObjeto.append("and\n");
    }

    private void acao117() {
        pilhaTipos.pop();
        pilhaTipos.pop();
        pilhaTipos.push("bool");
        codigoObjeto.append("or\n");
    }

    private void acao118() {
        pilhaTipos.push("bool");
        codigoObjeto.append("ldc.i4.1\n");
    }

    private void acao119() {
        pilhaTipos.push("bool");
        codigoObjeto.append("ldc.i4.0\n");
    }

    private void acao120() {
        String tipo = pilhaTipos.pop();
        pilhaTipos.push("bool");
        codigoObjeto.append("ldc.i4.1\n");
        codigoObjeto.append("xor\n");
    }

    private void acao121(Token token) {
        operadorRelacional = token.getLexeme();
    }

    private void acao122() {
        String tipoDireita = pilhaTipos.pop();
        String tipoEsquerda = pilhaTipos.pop();

        if ("string".equals(tipoEsquerda)
                && "string".equals(tipoDireita)) {
            codigoObjeto.append(
                    "call int32 [mscorlib]System.String::Compare(string, string)\n"
            );
            codigoObjeto.append("ldc.i4.0\n");
        }

        switch (operadorRelacional) {
            case "=":
                codigoObjeto.append("ceq\n");
                break;
            case "<>":
                codigoObjeto.append("ceq\n");
                codigoObjeto.append("ldc.i4.0\n");
                codigoObjeto.append("ceq\n");
                break;
            case "<":
                codigoObjeto.append("clt\n");
                break;
            case ">":
                codigoObjeto.append("cgt\n");
                break;
        }

        pilhaTipos.push("bool");
    }

    private void acao123() {
        String tipo1 = pilhaTipos.pop();
        String tipo2 = pilhaTipos.pop();
        if ("int64".equals(tipo1) && "int64".equals(tipo2)) {
            pilhaTipos.push("int64");
        } else {
            pilhaTipos.push("float64");
        }
        codigoObjeto.append("add\n");
    }

    private void acao124() {
        String tipo1 = pilhaTipos.pop();
        String tipo2 = pilhaTipos.pop();
        if ("int64".equals(tipo1) && "int64".equals(tipo2)) {
            pilhaTipos.push("int64");
        } else {
            pilhaTipos.push("float64");
        }
        codigoObjeto.append("sub\n");
    }

    private void acao125(Token token) throws SemanticError {
        String tipoDireita = pilhaTipos.pop();
        String tipoEsquerda = pilhaTipos.pop();

        boolean direitaNumerica =
                "int64".equals(tipoDireita)
                        || "float64".equals(tipoDireita);

        boolean esquerdaNumerica =
                "int64".equals(tipoEsquerda)
                        || "float64".equals(tipoEsquerda);

        if (!direitaNumerica || !esquerdaNumerica) {
            throw new SemanticError(
                    "tipos incompatíveis em operador aritmético *",
                    token.getPosition()
            );
        }

        if ("int64".equals(tipoEsquerda)
                && "int64".equals(tipoDireita)) {
            pilhaTipos.push("int64");
        } else {
            pilhaTipos.push("float64");
        }

        codigoObjeto.append("mul\n");
    }

    private void acao126() {
        String tipo1 = pilhaTipos.pop();
        String tipo2 = pilhaTipos.pop();
        pilhaTipos.push("float64");
        codigoObjeto.append("div\n");
    }

    private void acao127(Token token) {
        String nome = token.getLexeme();
        Simbolo simbolo = tabelaSimbolos.get(nome);

        pilhaTipos.push(simbolo.tipo);
        codigoObjeto.append("ldloc " + nome + "\n");

        if (simbolo.tamanho == 0 && "int64".equals(simbolo.tipo)) {
            codigoObjeto.append("conv.r8\n");
        }
    }

    private void acao128(Token token) {
        pilhaTipos.push("int64");
        codigoObjeto.append("ldc.i8 " + token.getLexeme() + "\n");
        codigoObjeto.append("conv.r8\n");
    }

    private void acao129(Token token) {
        pilhaTipos.push("float64");
        codigoObjeto.append(
                "ldc.r8 " + token.getLexeme().replace(',', '.') + "\n"
        );
    }

    private void acao130(Token token) {
        pilhaTipos.push("string");
        codigoObjeto.append("ldstr " + token.getLexeme() + "\n");
    }

    private void acao131() {
        String tipo = pilhaTipos.pop();
        if ("int64".equals(tipo)) {
            pilhaTipos.push("int64");
        } else {
            pilhaTipos.push("float64");
        }
    }

    private void acao132() {
        String tipo = pilhaTipos.pop();
        if ("int64".equals(tipo)) {
            pilhaTipos.push("int64");
        } else {
            pilhaTipos.push("float64");
        }
        codigoObjeto.append("ldc.i8 -1\n");
        codigoObjeto.append("conv.r8\n");
        codigoObjeto.append("mul\n");
    }

    private void acao133() {
        pilhaTipos.pop();
        codigoObjeto.append("conv.i8\n");

        String tipo = pilhaTipos.peek();

        switch (tipo) {
            case "int64":
                codigoObjeto.append("ldelem.i8\n");
                codigoObjeto.append("conv.r8\n");
                break;
            case "float64":
                codigoObjeto.append("ldelem.r8\n");
                break;
            case "string":
                codigoObjeto.append("ldelem.ref\n");
                break;
            case "bool":
                codigoObjeto.append("ldelem.u1\n");
                break;
        }
    }

    private void acao134() {
        pilhaTipos.pop();
        codigoObjeto.append("conv.i8\n");
    }

    public String getCodigoObjeto() {
        return codigoObjeto.toString();
    }
}