import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
    /*15 - Faça um algoritmo que leia o ano em que uma pessoa nasceu, imprima na tela quantos anos, 
    meses e dias essa pessoa ja viveu. Leve em consideração o ano com 365 dias e o mês com 30 dias. 
    (Ex: 5 anos, 2 meses e 15 dias de vida) */

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Scanner sc = new Scanner(System.in);

    System.out.println("Insira sua data de nascimento: (dd/MM/yyyy)");
    String data = sc.next();
    LocalDate dataParse = LocalDate.parse(data, formatter);
    
    LocalDate start = dataParse;
    LocalDate end = LocalDate.now();
    
    Period period = start.until(end);
    System.out.println("Você já viveu por: ");
    System.out.print("Anos: " + period.getYears());
    System.out.print(" | Meses: " + period.getMonths());
    System.out.print(" | Dias: " + period.getDays());

    sc.close();
    }
}
