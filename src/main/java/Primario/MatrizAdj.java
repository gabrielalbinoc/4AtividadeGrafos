package Primario;

import java.util.ArrayList;

public class MatrizAdj {
    LeitorTXT lerTXT = new LeitorTXT("src/main/java/pequenoG.txt");
    ArrayList<String> linhas = lerTXT.read();
    int [] ante = new int[Integer.parseInt(linhas.get(0))];
    int s = 12; //VÉRTICE INICIAL
    int[][] matAdj = new int[Integer.parseInt(linhas.get(0))][Integer.parseInt(linhas.get(1))];
    String[] cor = new String[matAdj.length];
    int [] i = new int[matAdj.length];
    int [] f = new int[matAdj.length];
    int tempo;

    public static void main(String[] args) {
        MatrizAdj run = new MatrizAdj();
        LeitorTXT lerTXT = new LeitorTXT("src/main/java/pequenoG.txt");
        ArrayList<String> linhas = lerTXT.read();
        for (int i = 0; i < run.matAdj.length; i++) {
            String[] valores = linhas.get(i + 2).split(" ");
            run.matAdj[Integer.parseInt(valores[0])][Integer.parseInt(valores[1])] = 1;
            run.matAdj[Integer.parseInt(valores[1])][Integer.parseInt(valores[0])] = 1;
        }
        System.out.println("Matriz Adjacência");
        for (int i = 0; i < run.matAdj.length; i++) {
            for (int j = 0; j < run.matAdj[0].length; j++) {

                System.out.print(run.matAdj[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("========== Imprimindo DFS ==========");
        run.dfsInicio(run.matAdj, run.s);
    }

    void dfsInicio (int [][]matAdj, int s) {
        int v;
        for (v = 0; v < matAdj.length; v++) {
            cor[v] = "BRANCO";
            i[v] = f[v] = -1;
            ante[v] = -1;
        }
        tempo = 1;
        dfsVisitar(matAdj, s);
        imprimeCaminho(10); //VÉRTICE FINAL
    }

    void dfsVisitar (int [][]matAdj, int u) {
        cor[u] = "CINZA";
        i[u] = tempo++;
            for (int v = 0; v < matAdj.length; v++) {
                if (matAdj[u][v] == 1 && matAdj[v][u] == 1) {
                    if (cor[v] == "BRANCO") {
                        ante[v] = u;
                        dfsVisitar(matAdj, v);
                    }
                }
            }
            cor[u] = "PRETO";
            f[u] = tempo++;
    }

    void imprimeCaminho(int vertice) {
        if (vertice == s) {
            System.out.println(s);
        } else if (ante[vertice] == -1) {
            System.out.println("Não há caminho");
        } else {
            imprimeCaminho(ante[vertice]);
            System.out.println(vertice);
        }
    }
}
