package scanner;

import entity.Student;
import entity.StudentDetail;
import entity.courses.Onderdeel;
import service.OnderdeelService;
import service.StudentDetailService;
import service.StudentService;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class StudentScanner {
    private static Scanner scanner;
    private static StudentService studentService = new StudentService();
    private static StudentDetailService studentDetailService = new StudentDetailService();
    private static OnderdeelService onderdeelService = new OnderdeelService();
    private static StartApp start = new StartApp();

    public void StudentPage(){
        mainMenu();

        int option;
        scanner = new Scanner(System.in);
        do {
            option = scanner.nextInt();
            switch (option) {
                case 1: //zie alle studenten
                    displayAlleStudenten();
                    mainMenu();
                    break;

                case 2: //zoek student op
                    zoekStudent();
                    System.out.println("");
                    mainMenu();
                    break;

                case 3: //voeg student toe
                    newStudent();
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
        System.out.println("1. Zie alle studenten");
        System.out.println("2. Zoek student op");
        System.out.println("3. Voeg nieuw student toe");
        System.out.println("4. Terug");
        System.out.println("0. Exit");
    }

    public void zoekStudent(){
        System.out.println("1. Bekijken");
        System.out.println("2. Wijzigen");
        System.out.println("3. Deleten");
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
                    Student getStudent = studentService.getStudentByName(voornaam, achternaam);
                    System.out.println("||Naam: " + getStudent.getVoornaam() + " " + getStudent.getAchternaam() + "| |" +
                            "StudentID: " + getStudent.getStudentID() + "| |" + "Geboortedatum: " + getStudent.getStudentDetail().getGeboorteDatum() +
                            "| |" + "Adres: " + getStudent.getStudentDetail().getAdress() + "| |" + "Telefoonnummer: " + getStudent.getStudentDetail().getTelefoon_nummer());
                    System.out.println("");
                    List<Onderdeel> onderdeelList = studentService.getOnderdeelVanStudent(voornaam, achternaam);
                    System.out.println("|| Onderdelen ||");
                    onderdeelList.forEach(onderdeel -> {
                        System.out.println(onderdeel.getNaam());
                    });
                    System.out.println(" ");
                    System.out.println("1. Bekijken");
                    System.out.println("2. Wijzigen");
                    System.out.println("3. Deleten");
                    System.out.println("0. Terug");
                    break;

                case 2:
                    System.out.println("Voornaam: ");
                    String updVoornaam = scanner.nextLine();
                    System.out.println("Achternaam: ");
                    String updAchternaam = scanner.nextLine();
                    Student updateStudent = studentService.getStudentByName(updVoornaam, updAchternaam);
                    System.out.println("||Naam: " + updateStudent.getVoornaam() + " " + updateStudent.getAchternaam() + "| |" + "StudentID: " + updateStudent.getStudentID() +
                            "| |" + "Geboortedatum: " + updateStudent.getStudentDetail().getGeboorteDatum() + "| |" + "Adres: " + updateStudent.getStudentDetail().getAdress() +
                            "| |" + "Telefoonnummer: " + updateStudent.getStudentDetail().getTelefoon_nummer());

                    String telWijzigen = "Telefoonnummer";
                    String adrWijzigen = "Adres";
                    System.out.println(telWijzigen + " of " + adrWijzigen);
                    String answer = scanner.nextLine();
                    if (telWijzigen.equalsIgnoreCase(answer)){
                        System.out.println("Voer nieuw telefoonnummer in:");
                        String nummer = scanner.nextLine();
                        studentDetailService.updateStudentdetailTel(nummer,updateStudent.getId());
                    }
                    if (adrWijzigen.equalsIgnoreCase(answer)){
                        System.out.println("Voer nieuw adres in:");
                        String adres = scanner.nextLine();
                        studentDetailService.updateStudentdetailAdres(adres, updateStudent.getId());
                    }
                    System.out.println(" ");
                    System.out.println("1. Bekijken");
                    System.out.println("2. Wijzigen");
                    System.out.println("3. Deleten");
                    System.out.println("0. Terug");
                    break;

                case 3:
                    System.out.println("Voornaam: ");
                    String delvoornaam = scanner.nextLine();
                    System.out.println("Achternaam: ");
                    String delachternaam = scanner.nextLine();
                    studentService.deleteStudent(delvoornaam, delachternaam);
                    System.out.println(delvoornaam + " " + delachternaam + " is weggewist.");
                    System.out.println(" ");
                    System.out.println("1. Bekijken");
                    System.out.println("2. Wijzigen");
                    System.out.println("3. Deleten");
                    System.out.println("0. Terug");
                    break;

                case 0:
                    StudentPage();

                default: {

                }
            }
        } while (opt != 0);

    }

    private void newStudent(){
        scanner = new Scanner(System.in);
        Student student = new Student();
        StudentDetail detail = new StudentDetail();

        System.out.println("Enter voornaam:");
        student.setVoornaam(scanner.nextLine());

        System.out.println("Enter achternaam:");
        student.setAchternaam(scanner.nextLine());

        System.out.println("Enter studentenID:");
        student.setStudentID(scanner.nextLine());

        System.out.println("Enter geboortedatum:");
        detail.setGeboorteDatum(scanner.nextLine());

        System.out.println("Enter adres:");
        detail.setAdress(scanner.nextLine());

        System.out.println("Enter telefoonnummer:");
        detail.setTelefoon_nummer(scanner.nextLine());

        System.out.println("Enter inschrijvingsdatum:");
        detail.setEnrolledDate(scanner.nextLine());

        studentDetailService.createStudentDetail(detail);
        student.setStudentDetail(detail);

        System.out.println("In onderdeel:");
        String onderdeelnaam = scanner.nextLine();
        Onderdeel inOnderdeel = onderdeelService.getOnderdeelByName(onderdeelnaam);
        student.getOnderdelen().add(inOnderdeel);

        studentService.insertStudent(student);
        System.out.println(studentService.getStudentByName(student.getVoornaam(), student.getAchternaam()) +
                "is toegevoegd");
        StudentPage();
    }

    private void displayAlleStudenten(){

        List<Student> studentList = studentService.getAllStudents();
        studentList.forEach( student -> {
            System.out.println("|Naam : "+ student.getVoornaam() + " " + student.getAchternaam() + "| |" + "StudentID: " + student.getStudentID()
                    + "| |" + "Geboortedatum: " + student.getStudentDetail().getGeboorteDatum() + "| |" + "Adres: " + student.getStudentDetail().getAdress() +
                    "| |" +"Telefoonnummer: " + student.getStudentDetail().getTelefoon_nummer());

            });
    }


}
