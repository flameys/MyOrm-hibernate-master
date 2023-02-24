package scanner;

import entity.Docent;
import entity.courses.Onderdeel;
import proxy.GetMethodsProxy;
import service.DocentService;
import service.OnderdeelService;

import java.util.List;
import java.util.Scanner;

public class DocentScanner {
    private static Scanner scanner;
    private static DocentService docentService;
    private static OnderdeelService onderdeelService;
    private static StartApp start = new StartApp();

    public void DocentPage(){
        mainMenu();

        int option;
        scanner = new Scanner(System.in);
        do {
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1: //zie alle studenten
                    displayAlleDocenten();
                    mainMenu();
                    break;

                case 2: //zoek student op
                    zoekDocent();
                    System.out.println("");
                    mainMenu();
                    break;

                case 3: //voeg student toe
                    newDocent();
                    break;

                case 4: //terug
                    start.runApp();
                    break;

                case 0: //exit
                    System.exit(0);

                default: {

                }
            }
        } while (option != 0);

    }

    private void mainMenu(){
        scanner = new Scanner(System.in);
        System.out.println("1. Zie alle docenten");
        System.out.println("2. Zoek docent op");
        System.out.println("3. Voeg nieuw docent toe");
        System.out.println("4. Terug");
        System.out.println("0. Exit");
    }

    private void displayAlleDocenten(){
        GetMethodsProxy testProxy = new GetMethodsProxy();
        //docentService = new DocentService();
        //List<Docent> docentList = docentService.getAllDocenten();
        List <Docent> docentList1 = testProxy.getAllDocenten();
        /*docentList.forEach( docent -> {
            System.out.println("|Naam : "+ docent.getVoornaam() + " " + docent.getNaam() + "| |" + "In dienst: " + docent.getDatumIndienst()
                    + "| |" + "Vakcategorie: " + docent.getCategorie());

        });*/

        docentList1.forEach( docent -> {
            System.out.println("|Naam : "+ docent.getVoornaam() + " " + docent.getNaam() + "| |" + "In dienst: " + docent.getDatumIndienst()
                    + "| |" + "Vakcategorie: " + docent.getCategorie());

        });
    }

    public void zoekDocent(){
        System.out.println("1. Bekijken");
        System.out.println("2. Verander docent");
        System.out.println("0. Terug");

        int opt;
        scanner = new Scanner(System.in);
        do {
            opt = scanner.nextInt();
            scanner.nextLine();
            switch (opt) {
                case 1:
                    System.out.println("Voornaam: ");
                    String voornaam = scanner.nextLine();
                    System.out.println("Achternaam: ");
                    String achternaam = scanner.nextLine();
                    docentService = new DocentService();
                    Docent selectDocent = docentService.getSpecificDocent(voornaam, achternaam);
                    System.out.println("||Naam: " + selectDocent.getVoornaam() + " " + selectDocent.getNaam() + "| |" +
                            "In dienst: " + selectDocent.getDatumIndienst() + "| |" + "Vakcategorie: " + selectDocent.getCategorie());
                    System.out.println("|| Onderdelen ||");
                    onderdeelService = new OnderdeelService();
                    List<Onderdeel> onderdeelList = onderdeelService.getOnderdelenByDocent(selectDocent.getId());
                    for (int i = 0; i<onderdeelList.size(); i++){
                        System.out.println('\t' + onderdeelList.get(i).getNaam());
                    }
                    System.out.println("");
                    System.out.println("1. Bekijken");
                    System.out.println("2. Verander docent");
                    System.out.println("0. Terug");
                    break;

                case 2:
                    System.out.println("Zoek voornaam: ");
                    String zoekvoornaam = scanner.nextLine();
                    System.out.println("Zoek achternaam: ");
                    String zoekachternaam = scanner.nextLine();
                    docentService = new DocentService();
                    Docent updateDocent = docentService.getSpecificDocent(zoekvoornaam, zoekachternaam);

                    System.out.println("Voer nieuw voornaam in: ");
                    String nvoornaam = scanner.nextLine();
                    System.out.println("Voer nieuw achternaam in: ");
                    String nachternaam = scanner.nextLine();
                    System.out.println("Voer datum vandaag in: ");
                    String ndatum = scanner.nextLine();

                    docentService.changeDocent(nachternaam, nvoornaam, ndatum, updateDocent.getId());
                    System.out.println("");
                    System.out.println("1. Bekijken");
                    System.out.println("2. Verander docent");
                    System.out.println("0. Terug");
                    break;

                case 0:
                    DocentPage();

                default: {

                }
            }
        } while (opt != 0);

    }

    private void newDocent() {
        scanner = new Scanner(System.in);
        Docent docent = new Docent();
        docentService = new DocentService();
        onderdeelService = new OnderdeelService();

        System.out.println("Enter voornaam: ");
        docent.setVoornaam(scanner.nextLine());

        System.out.println("Enter achternaam: ");
        docent.setNaam(scanner.nextLine());

        System.out.println("Enter datum in dienst: ");
        docent.setDatumIndienst(scanner.nextLine());

        System.out.println("Enter vakcategorie: ");
        docent.setCategorie(scanner.nextLine());

        System.out.println("Docent van onderdeel:");
        String antwoord = scanner.nextLine();
        Onderdeel getOnderdeel = onderdeelService.getOnderdeelByName(antwoord);

        docentService.insertDocent(docent);
        getOnderdeel.setDocent(docent);
        onderdeelService.insertOnderdeel(getOnderdeel);

        DocentPage();
    }
}
