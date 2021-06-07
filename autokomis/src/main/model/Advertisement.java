package main.model;

import main.model.client.Client;

import java.util.List;
import java.util.Random;

public class Advertisement {

    private final int priceNewspaper;
    private final int priceInternet;


    public Advertisement() {
        this.priceNewspaper = 1000;
        this.priceInternet = 300;
    }

    public List<Client> buyNewspaper (Wallet wallet){
        if (wallet.payForAdvertisement(priceNewspaper)){
            Generator generator = new Generator();
            Random random = new Random();
            int rNumber = random.nextInt(6-3+1)+3; // generuje losowo od 3 - 6 do nowych klientów
            System.out.println("Kupiono reklamę w gazecie za " + priceNewspaper + " PLN " + "zyskałeś "
                                + rNumber + " nowych klientów.");

            return generator.newClients(rNumber);
        }
        System.out.println("Nie masz wystarczającej ilości środków na koncie");
        return null;
    }

    public Client buyInternet (Wallet wallet){
        if (wallet.payForAdvertisement(priceInternet)) {
            System.out.println("Kupiono reklamę w internecie za " + priceNewspaper + " PLN " +
                                "zyskałeś nowego klienta.");

            return new Generator().newClient();
        }
        System.out.println("Nie masz wystarczającej ilości środków na koncie");
        return null;
    }

}
