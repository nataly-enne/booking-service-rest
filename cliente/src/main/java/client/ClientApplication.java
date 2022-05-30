package client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.Scanner;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {

        boolean isDirect = false;
        RestTemplate restTemplate = new RestTemplate();

        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("T&N`S Booking Service\nEscolha algumas das opções abaixo para continuar");
        System.out.println("1 - Ver voos disponiveis\n2 - Buscar voo\n3 - Reservar voo");
        System.out.println("-----------------------------------------------------------------------");
        int operation = sc.nextInt();

        switch (operation) {
            case 1:
                ResponseEntity<String> flightsResponse = restTemplate.getForEntity("http://localhost:8080/company/flights", String.class);
                System.out.println(flightsResponse);
                break;
            case 2:
                sc.nextLine();
                System.out.println("Digite o local de saida do voo: ");
                String saida = sc.nextLine();
                System.out.println("Digite o local de destino do voo: ");
                String destino = sc.nextLine();
                ResponseEntity<String> flightResponse = restTemplate.getForEntity("http://localhost:8080/company/flight/"+saida+"/"+destino, String.class);
                System.out.println(flightResponse);
                break;
            case 3:
                sc.nextLine();
                System.out.println("Digite o codigo do voo: ");
                String flyCode = sc.nextLine();
                System.out.println("Digite a data do voo (DD-MM-YYYY): ");
                String date = sc.nextLine();
                System.out.println("Deseja voo direto? S/N ");
                char isDirectChar = sc.nextLine().charAt(0);
                if(isDirectChar == 'S' || isDirectChar == 's'){
                    isDirect = true;
                }

                ResponseEntity<String> reserveResponse = restTemplate.postForEntity("http://localhost:8080/company/reserve/"+flyCode+"/"+date+"/"+isDirect, null,String.class);
                System.out.println(reserveResponse);
                break;
            default:
                System.out.println("Wrong inputs!");
        }
    }

}
