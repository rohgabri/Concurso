import java.util.Scanner;

public class Concurso {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Qual a quantidade de pessoas? ");
        int qntdPessoas = sc.nextInt();
        sc.nextLine();

        String[] nome = new String[qntdPessoas];
        double[] nota1 = new double[qntdPessoas];
        double[] nota2 = new double[qntdPessoas];
        double[] media = new double[qntdPessoas];
        boolean[] aprovados  = new boolean[qntdPessoas];
        int porcentagem = 0;
        String maiorMedia = "!!!Não teve notas!!! ";
        double maiorNota = 0;
        double mediaAprovados = 0;



        for (int i = 0; i < qntdPessoas; i++) {
            System.out.print("\nDigite os dados da " + (i + 1) + "a Pessoa: \n");
            System.out.print("Nome: ");
            nome[i] = sc.nextLine();
            System.out.print("Nota etapa 1: ");
            nota1[i] = sc.nextDouble();
            System.out.print("Nota etapa 2: ");
            nota2[i] = sc.nextDouble();
            sc.nextLine();
            media[i] = (nota1[i] + nota2[i]) / 2;
            aprovados[i] = media[i] >= 70;
        }

        System.out.println("\n###TABELA###");
        for (int i = 0; i < qntdPessoas; i++) {
            System.out.println(nome[i] + ", " + nota1[i] + ", " + nota2[i] + ", MÉDIA = " + media[i]);
        }
        System.out.println("\n###PESSOAS APROVADAS###");
        for (int i = 0; i < qntdPessoas; i++) {
            if (aprovados[i]) {
                System.out.println(nome[i]);
                porcentagem++;
                mediaAprovados = mediaAprovados + media[i];
            }
            if (media[i] > maiorNota){
                maiorNota = media[i];
                maiorMedia = nome[i];
            }
        }
        System.out.println("\nPorcentagem de aprovação: " + ((double) porcentagem / qntdPessoas * 100)+ "%");
        System.out.println("Maior média: " + maiorMedia);
        if (porcentagem > 0) {
            System.out.println("Nota média dos Aprovados: " + (mediaAprovados / porcentagem));
        }
        else {
            System.out.println("Não há candidatos aprovados");
        }
        sc.close();
}
}