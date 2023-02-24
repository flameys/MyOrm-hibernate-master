package scanner;

import entity.Docent;
import entity.courses.ModuleDuur;
import entity.courses.Onderdeel;
import entity.courses.Opleiding;
import entity.courses.Richting;
import service.*;

import java.util.List;
import java.util.Scanner;

public class OpleidingScanner {
    private static Scanner scanner;
    private static OpleidingService opleidingService;
    private static RichtingService richtingService;
    private static ModuleService moduleService;
    private static OnderdeelService onderdeelService;
    private static StartApp start = new StartApp();

    public void OpleidingPage(){
        mainMenu();

        int option;
        scanner = new Scanner(System.in);
        do {
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    displayAlleOpleidingen();
                    mainMenu();
                    break;

                case 2:
                    zoekOpleiding();
                    System.out.println("");
                    mainMenu();
                    break;

                case 3:
                    newOnderdeel();
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
        System.out.println("1. Zie opleidingen");
        System.out.println("2. Zoek onderdeel op");
        System.out.println("3. Voeg nieuw onderdeel toe");
        System.out.println("4. Terug");
        System.out.println("0. Exit");

    }

    public void displayAlleOpleidingen(){
        opleidingService = new OpleidingService();
        richtingService = new RichtingService();
        moduleService = new ModuleService();

        List<Opleiding> opleidingList = opleidingService.getAllOpleidingen();

        for (Opleiding opleiding: opleidingList){
            System.out.println("\n|| Naam: "+opleiding.getNaam() + " ||");
            System.out.println("-------------------------------------------------------------------------");

            List<Richting> richtingList = richtingService.getAllRichtingOpleiding(opleiding.getId());
            for (Richting richting: richtingList){
                System.out.println("\n|| Richting: " + richting.getNaam() + " ||");
                //System.out.println("-------------------------------------------------------------------------");
                //System.out.println(richting.getNaam() + '\n');

                List<ModuleDuur> moduleList = moduleService.getModules(richting.getId());
                for (ModuleDuur getModule: moduleList){
                    System.out.println("");
                    System.out.println("|| Module ||" + "\t" + "|| Duur ||");
                    System.out.println("--------------------------------------");
                    System.out.println(" " + getModule.getNaam() + "\t||\t" + getModule.getDuur() + '\n');
                    List<Onderdeel> onderdeelList = getModule.getOnderdelen();
                    for (int i = 0; i < onderdeelList.size(); i++){
                        Onderdeel getOnderdeelAt = onderdeelList.get(i);
                        System.out.println(getOnderdeelAt.getNaam());

                    }
                }
            }
        }
    }

    public void newOnderdeel(){
        scanner = new Scanner(System.in);
        onderdeelService = new OnderdeelService();
        richtingService = new RichtingService();
        DocentService docentService = new DocentService();
        Onderdeel onderdeel = new Onderdeel();

        System.out.println("Enter onderdeel:");
        onderdeel.setNaam(scanner.nextLine());

        System.out.println("Enter Richting:");
        String richtingnaam = scanner.nextLine();
        Richting richting = richtingService.getSpecificRichting(richtingnaam);
        System.out.println("Enter module:");
        String moduleNaam = scanner.nextLine();
        moduleService = new ModuleService();
        //ModuleDuur addInModule = moduleService.getSpecificModule(moduleNaam);
        List<ModuleDuur> getAllMs = moduleService.getModules(richting.getId());
        for (int i=0; i<getAllMs.size(); i++){
            ModuleDuur currentModule = getAllMs.get(i);
            if (moduleNaam.equals(currentModule.getNaam())){
                onderdeel.setModule(currentModule);
            }
        }


        System.out.println("Enter docent voornaam:");
        String voornaam = scanner.nextLine();
        System.out.println("Enter docent achternaam:");
        String achternaam = scanner.nextLine();
        Docent docent = docentService.getSpecificDocent(voornaam,achternaam);
        onderdeel.setDocent(docent);

        onderdeelService.insertOnderdeel(onderdeel);

        OpleidingPage();
    }

    public void zoekOpleiding(){
        opleidingService = new OpleidingService();
        richtingService = new RichtingService();
        moduleService = new ModuleService();
        onderdeelService = new OnderdeelService();

        scanner = new Scanner(System.in);
        System.out.println("1. Bekijken");
        System.out.println("2. Deleten");
        System.out.println("0. Terug");
        System.out.println("");



        int opt;
        do {
            opt = scanner.nextInt();
            scanner.nextLine();
            switch (opt) {
                case 1:
                    System.out.println("Opleiding:");
                    String oplNaam = scanner.nextLine();
                    Opleiding getOpleiding = opleidingService.getOneOpleiding(oplNaam);


                    System.out.println("Richting: ");
                    String richtingNaam = scanner.nextLine();
                    List<Richting> getRichtingen = richtingService.getAllRichtingOpleiding(getOpleiding.getId());
                    for(int i = 0; i<getRichtingen.size(); i++){
                        String rIterator = getRichtingen.get(i).getNaam();
                        //System.out.println(rIterator);

                        if (rIterator.equals(richtingNaam)){
                            Richting result = getRichtingen.get(i);
                            System.out.println(result.getNaam());

                            System.out.println("Module:");
                            String moduleNaam = scanner.nextLine();
                            List<ModuleDuur> getModules = moduleService.getModules(result.getId());
                            for (int n = 0; n<getModules.size(); n++){
                                String nIterator = getModules.get(n).getNaam();
                                //System.out.println(nIterator);


                                if (nIterator.equals(moduleNaam)){
                                    ModuleDuur mResult = getModules.get(n);
                                    System.out.println(mResult.getNaam());
                                    List<Onderdeel> onderdeelList = mResult.getOnderdelen();
                                    for(int u = 0; u<onderdeelList.size(); u++){
                                        System.out.println(onderdeelList.get(u).getNaam());
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    System.out.println("");
                    System.out.println("1. Bekijken");
                    System.out.println("2. Deleten");
                    System.out.println("0. Terug");
                    break;

                case 2:
                    System.out.println("Delete onderdeel:");
                    String delOnderdeel = scanner.nextLine();


                    onderdeelService.deleteOnderdeel(delOnderdeel);
                    System.out.println("");
                    System.out.println("1. Bekijken");
                    System.out.println("2. Deleten");
                    System.out.println("0. Terug");
                    break;

                case 0:
                    OpleidingPage();

                default: {

                }
            }
        } while (opt != 0);}




}
