import scanner.StartApp;
import service.*;

public class Main {

    public static void main(String[] args) {

        InvoerService invoer = new InvoerService();
        invoer.regStudenten();
        invoer.regDocenten();
        invoer.regOpleidingen();
        invoer.regStudentOnderdeel();

        StartApp begin = new StartApp();
        begin.runApp();









    }
}
