import java.util.Scanner;

public class ProgramaComplexo {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("digite o numero 1: ");
        int num1 = sc.nextInt();

        System.out.print("digite o numero 2: ");
        int num2 = sc.nextInt();

        System.out.print("digite o numero 3: ");
        int num3 = sc.nextInt();

        int media = (num1 + num2 + num3) / 3;

        System.out.println("a media é " + media + " entre os numeros");
        System.out.println(Math.PI);
        System.out.format("o valor de Pi é %.2f para as contas %i", Math.PI, media);
        
        
        int outroNumero = num1 + num2 + 6 / 3;
        int resto1 = num3 % num2;
        int resto2 = 7 % 2;
        double varPI = Math.PI;
    }
}
