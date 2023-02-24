package service;

import entity.Docent;
import entity.Student;
import entity.StudentDetail;
import entity.courses.ModuleDuur;
import entity.courses.Onderdeel;
import entity.courses.Opleiding;
import entity.courses.Richting;

public class InvoerService {
    private static StudentService studentService = new StudentService();
    private static StudentDetailService studentDetailService = new StudentDetailService();
    private static DocentService docentService = new DocentService();

    // COURSES
    private static OpleidingService opleidingService = new OpleidingService();
    private static RichtingService richtingService = new RichtingService();
    private static ModuleService moduleService = new ModuleService();
    private static OnderdeelService onderdeelService = new OnderdeelService();

    public void regStudenten(){
        Student student1 = new Student();
        student1.setVoornaam("Mickey");
        student1.setAchternaam("Mouse");
        student1.setStudentID("MM01");

        StudentDetail detailSt1 = new StudentDetail();
        detailSt1.setEnrolledDate("07-10-2019");
        detailSt1.setAdress("eenstraat #3");
        detailSt1.setGeboorteDatum("16-07-2009");
        detailSt1.setTelefoon_nummer("12345");

        studentDetailService.createStudentDetail(detailSt1);
        student1.setStudentDetail(detailSt1);
        studentService.insertStudent(student1);
    //----------------------------------------------

        Student student2 = new Student();
        student2.setVoornaam("Minni");
        student2.setAchternaam("Mouse");
        student2.setStudentID("MM02");

        StudentDetail detailSt2 = new StudentDetail();
        detailSt2.setEnrolledDate("07-10-2019");
        detailSt2.setAdress("eenstraat #3");
        detailSt2.setGeboorteDatum("16-07-2009");
        detailSt2.setTelefoon_nummer("23456");

        studentDetailService.createStudentDetail(detailSt2);
        student2.setStudentDetail(detailSt2);
        studentService.insertStudent(student2);
    //------------------------------------------------------

        Student student3 = new Student();
        student3.setVoornaam("Dora");
        student3.setAchternaam("the Explorer");
        student3.setStudentID("DE01");

        StudentDetail detailSt3 = new StudentDetail();
        detailSt3.setEnrolledDate("08-10-2017");
        detailSt3.setAdress("tweestraat #11");
        detailSt3.setGeboorteDatum("13-04-2006");
        detailSt3.setTelefoon_nummer("34567");

        studentDetailService.createStudentDetail(detailSt3);
        student3.setStudentDetail(detailSt3);
        studentService.insertStudent(student3);
    //-------------------------------------------------------

        Student student4 = new Student();
        student4.setVoornaam("Coraline");
        student4.setAchternaam("Jones");
        student4.setStudentID("CJ01");

        StudentDetail detailSt4 = new StudentDetail();
        detailSt4.setEnrolledDate("10-10-2020");
        detailSt4.setAdress("driestraat #9");
        detailSt4.setGeboorteDatum("15-02-2010");
        detailSt4.setTelefoon_nummer("45678");

        studentDetailService.createStudentDetail(detailSt4);
        student4.setStudentDetail(detailSt4);
        studentService.insertStudent(student4);
    //-----------------------------------------------------

        Student student5 = new Student();
        student5.setVoornaam("Donald");
        student5.setAchternaam("Duck");
        student5.setStudentID("DD01");

        StudentDetail detailSt5 = new StudentDetail();
        detailSt5.setEnrolledDate("06-10-2020");
        detailSt5.setAdress("vierstraat #41");
        detailSt5.setGeboorteDatum("27-09-2009");
        detailSt5.setTelefoon_nummer("567891");

        studentDetailService.createStudentDetail(detailSt5);
        student5.setStudentDetail(detailSt5);
        studentService.insertStudent(student5);
    }

    public void regDocenten(){
        Docent docent1 = new Docent();
        docent1.setVoornaam("Gio");
        docent1.setNaam("Gotu");
        docent1.setDatumIndienst("23-04-2018");
        docent1.setCategorie("Gamelan");
        docentService.insertDocent(docent1);
    //--------------------------------------------------
        Docent docent6 = new Docent();
        docent6.setVoornaam("Bwi");
        docent6.setNaam("Dipo");
        docent6.setDatumIndienst("14-03-2017");
        docent6.setCategorie("Gamelan");
        docentService.insertDocent(docent6);
    //-----------------------------------------------------
        Docent docent2 = new Docent();
        docent2.setVoornaam("Kade");
        docent2.setNaam("Biu");
        docent2.setDatumIndienst("03-11-2016");
        docent2.setCategorie("Dans");
        docentService.insertDocent(docent2);
    //---------------------------------------------------
        Docent docent4 = new Docent();
        docent4.setVoornaam("Essie");
        docent4.setNaam("Farel");
        docent4.setDatumIndienst("26-05-2014");
        docent4.setCategorie("Dans");
        docentService.insertDocent(docent4);
    //------------------------------------------------
        Docent docent5 = new Docent();
        docent5.setVoornaam("Mia");
        docent5.setNaam("Jino");
        docent5.setDatumIndienst("04-03-2015");
        docent5.setCategorie("Dans");
        docentService.insertDocent(docent5);
    //-----------------------------------------------------
        Docent docent3 = new Docent();
        docent3.setVoornaam("Psy");
        docent3.setNaam("Astro");
        docent3.setDatumIndienst("12-07-2018");
        docent3.setCategorie("Taal");
        docentService.insertDocent(docent3);
    //-------------------------------------------------------
        Docent docent7 = new Docent();
        docent7.setVoornaam("Anish");
        docent7.setNaam("Yas");
        docent7.setDatumIndienst("24-09-2018");
        docent7.setCategorie("Taal");
        docentService.insertDocent(docent7);

    }

    public void regOpleidingen() {
        Opleiding dans = new Opleiding();
        dans.setNaam("Javaanse Klassieke Dans");
        opleidingService.createOpleiding(dans);

        Richting dr1 = new Richting();
        dr1.setNaam("Yogyakarta Style (Jogja)");
        dr1.setOpleiding(dans);
        richtingService.insertRichting(dr1);

        ModuleDuur rm1_1 = new ModuleDuur();
        rm1_1.setNaam("Beginner");
        rm1_1.setDuur("2 maanden");
        rm1_1.setRichting(richtingService.getSpecificRichting("Yogyakarta Style (Jogja)"));
        moduleService.insertModule(rm1_1);

        Onderdeel mo1 = new Onderdeel();
        mo1.setNaam("Tari Nawang Sekar");
        ModuleDuur findM1 = moduleService.getSpecificModule("Beginner");
        mo1.setDocent(docentService.getSpecificDocent("Mia", "Jino"));
        findM1.addOnderdeel(mo1);
        onderdeelService.insertOnderdeel(mo1);

        ModuleDuur rm1_2 = new ModuleDuur();
        rm1_2.setNaam("Intermediate");
        rm1_2.setDuur("3 maanden");
        rm1_2.setRichting(richtingService.getSpecificRichting("Yogyakarta Style (Jogja)"));
        moduleService.insertModule(rm1_2);

        Onderdeel mo2 = new Onderdeel();
        mo2.setNaam("Tari Kenya Tinembe");
        ModuleDuur findM2 = moduleService.getSpecificModule("Intermediate");
        mo2.setDocent(docentService.getSpecificDocent("Mia", "Jino"));
        findM2.addOnderdeel(mo2);
        onderdeelService.insertOnderdeel(mo2);


        ModuleDuur rm1_3 = new ModuleDuur();
        rm1_3.setNaam("Advanced");
        rm1_3.setDuur("5 maanden");
        rm1_3.setRichting(richtingService.getSpecificRichting("Yogyakarta Style (Jogja)"));
        moduleService.insertModule(rm1_3);

        Onderdeel mo3 = new Onderdeel();
        mo3.setNaam("Tari Golek Ayun Ayun");
        ModuleDuur findM3 = moduleService.getSpecificModule("Advanced");
        mo3.setDocent(docentService.getSpecificDocent("Mia", "Jino"));
        findM3.addOnderdeel(mo3);
        onderdeelService.insertOnderdeel(mo3);
//----------------------------------------------------------------

        Richting dr2 = new Richting();
        dr2.setNaam("Surakarta Style (Solo)");
        dr2.setOpleiding(dans);
        richtingService.insertRichting(dr2);

        ModuleDuur rm2_1 = new ModuleDuur();
        rm2_1.setNaam("Beginner");
        rm2_1.setDuur("3 maanden");
        rm2_1.setRichting(richtingService.getSpecificRichting("Surakarta Style (Solo)"));
        moduleService.insertModule(rm2_1);

        Onderdeel mo1_1 = new Onderdeel();
        mo1_1.setNaam("Tari Bondhan");
        ModuleDuur findM4 = moduleService.getSpecificModuleById(4);
        mo1_1.setDocent(docentService.getSpecificDocent("Essie", "Farel"));
        findM4.addOnderdeel(mo1_1);
        onderdeelService.insertOnderdeel(mo1_1);

        ModuleDuur rm2_2 = new ModuleDuur();
        rm2_2.setNaam("Intermediate");
        rm2_2.setDuur("5 maanden");
        rm2_2.setRichting(richtingService.getSpecificRichting("Surakarta Style (Solo)"));
        moduleService.insertModule(rm2_2);

        Onderdeel mo1_2 = new Onderdeel();
        mo1_2.setNaam("Tari Dolanan");
        ModuleDuur findM5 = moduleService.getSpecificModuleById(5);
        mo1_2.setDocent(docentService.getSpecificDocent("Essie", "Farel"));
        findM5.addOnderdeel(mo1_2);
        onderdeelService.insertOnderdeel(mo1_2);

        Onderdeel mo1_3 = new Onderdeel();
        mo1_3.setNaam("Tari Gambyong ");
        ModuleDuur findM6 = moduleService.getSpecificModuleById(5);
        mo1_3.setDocent(docentService.getSpecificDocent("Essie", "Farel"));
        findM6.addOnderdeel(mo1_3);
        onderdeelService.insertOnderdeel(mo1_3);

        ModuleDuur rm2_3 = new ModuleDuur();
        rm2_3.setNaam("Advanced");
        rm2_3.setDuur("5 maanden");
        rm2_3.setRichting(richtingService.getSpecificRichting("Surakarta Style (Solo)"));
        moduleService.insertModule(rm2_3);

        Onderdeel mo2_1 = new Onderdeel();
        mo2_1.setNaam("Tari Golek Sri Rejeki");
        ModuleDuur findM7 = moduleService.getSpecificModuleById(6);
        mo2_1.setDocent(docentService.getSpecificDocent("Essie", "Farel"));
        findM7.addOnderdeel(mo2_1);
        onderdeelService.insertOnderdeel(mo2_1);

        Onderdeel mo2_2 = new Onderdeel();
        mo2_2.setNaam("Tari Golek Manis");
        ModuleDuur findM8 = moduleService.getSpecificModuleById(6);
        mo2_2.setDocent(docentService.getSpecificDocent("Essie", "Farel"));
        findM8.addOnderdeel(mo2_2);
        onderdeelService.insertOnderdeel(mo2_2);
//--------------------------------------------------------------------------------------------
        Richting dr3 = new Richting();
        dr3.setNaam("Balinese Style");
        dr3.setOpleiding(dans);
        richtingService.insertRichting(dr3);

        ModuleDuur rm3_1 = new ModuleDuur();
        rm3_1.setNaam("Beginner");
        rm3_1.setDuur("3 maanden");
        rm3_1.setRichting(richtingService.getSpecificRichting("Balinese Style"));
        moduleService.insertModule(rm3_1);

        Onderdeel mo3_1 = new Onderdeel();
        mo3_1.setNaam("Tari Pendet");
        ModuleDuur findM9 = moduleService.getSpecificModuleById(7);
        mo3_1.setDocent(docentService.getSpecificDocent("Kade", "Biu"));
        findM9.addOnderdeel(mo3_1);
        onderdeelService.insertOnderdeel(mo3_1);

        ModuleDuur rm3_2 = new ModuleDuur();
        rm3_2.setNaam("Intermediate");
        rm3_2.setDuur("5 maanden");
        rm3_2.setRichting(richtingService.getSpecificRichting("Balinese Style"));
        moduleService.insertModule(rm3_2);

        Onderdeel mo3_2 = new Onderdeel();
        mo3_2.setNaam("Tari Manuk Rawa");
        ModuleDuur findM10 = moduleService.getSpecificModuleById(8);
        mo3_2.setDocent(docentService.getSpecificDocent("Kade", "Biu"));
        findM10.addOnderdeel(mo3_2);
        onderdeelService.insertOnderdeel(mo3_2);

        Onderdeel mo3_3 = new Onderdeel();
        mo3_3.setNaam("Tari Panji Semirang");
        ModuleDuur findM11 = moduleService.getSpecificModuleById(8);
        mo3_3.setDocent(docentService.getSpecificDocent("Kade", "Biu"));
        findM11.addOnderdeel(mo3_3);
        onderdeelService.insertOnderdeel(mo3_3);

        ModuleDuur rm3_3 = new ModuleDuur();
        rm3_3.setNaam("Advanced");
        rm3_3.setDuur("4 maanden");
        rm3_3.setRichting(richtingService.getSpecificRichting("Balinese Style"));
        moduleService.insertModule(rm3_3);

        Onderdeel mo3_4 = new Onderdeel();
        mo3_4.setNaam("Tari Condong");
        ModuleDuur findM12 = moduleService.getSpecificModuleById(9);
        mo3_4.setDocent(docentService.getSpecificDocent("Kade", "Biu"));
        findM12.addOnderdeel(mo3_4);
        onderdeelService.insertOnderdeel(mo3_4);
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        Opleiding taal = new Opleiding();
        taal.setNaam("Javaanse & Indonesische Taal");
        opleidingService.createOpleiding(taal);

        Richting tr1 = new Richting();
        tr1.setNaam("Bahasa Indonesia (Indonesische taal)");
        tr1.setOpleiding(taal);
        richtingService.insertRichting(tr1);

        ModuleDuur tm1_1 = new ModuleDuur();
        tm1_1.setNaam("Beginner");
        tm1_1.setDuur("2 maanden");
        tm1_1.setRichting(richtingService.getSpecificRichting("Bahasa Indonesia (Indonesische taal)"));
        moduleService.insertModule(tm1_1);

        Onderdeel tmo1 = new Onderdeel();
        tmo1.setNaam("Permula A1 & A2");
        ModuleDuur findM13 = moduleService.getSpecificModuleById(10);
        tmo1.setDocent(docentService.getSpecificDocent("Anish", "Yas"));
        findM13.addOnderdeel(tmo1);
        onderdeelService.insertOnderdeel(tmo1);

        ModuleDuur tm1_2 = new ModuleDuur();
        tm1_2.setNaam("Intermediate");
        tm1_2.setDuur("2 maanden");
        tm1_2.setRichting(richtingService.getSpecificRichting("Bahasa Indonesia (Indonesische taal)"));
        moduleService.insertModule(tm1_2);

        Onderdeel tmo1_1 = new Onderdeel();
        tmo1_1.setNaam("Menengah B1 & B2");
        ModuleDuur findM14 = moduleService.getSpecificModuleById(11);
        tmo1_1.setDocent(docentService.getSpecificDocent("Anish", "Yas"));
        findM14.addOnderdeel(tmo1_1);
        onderdeelService.insertOnderdeel(tmo1_1);

        ModuleDuur tm1_3 = new ModuleDuur();
        tm1_3.setNaam("Advanced");
        tm1_3.setDuur("4 maanden");
        tm1_3.setRichting(richtingService.getSpecificRichting("Bahasa Indonesia (Indonesische taal)"));
        moduleService.insertModule(tm1_3);

        Onderdeel tmo1_2 = new Onderdeel();
        tmo1_2.setNaam("Mahir C1 & C2");
        ModuleDuur findM15 = moduleService.getSpecificModuleById(12);
        tmo1_2.setDocent(docentService.getSpecificDocent("Anish", "Yas"));
        findM15.addOnderdeel(tmo1_2);
        onderdeelService.insertOnderdeel(tmo1_2);
//----------------------------------------------------------------------------------------------
        Richting tr2 = new Richting();
        tr2.setNaam("Basa Jawa (Javaanse taal)");
        tr2.setOpleiding(taal);
        richtingService.insertRichting(tr2);

        ModuleDuur tm2_1 = new ModuleDuur();
        tm2_1.setNaam("Beginner & Intermediate");
        tm2_1.setDuur("6 maanden");
        tm2_1.setRichting(richtingService.getSpecificRichting("Basa Jawa (Javaanse taal)"));
        moduleService.insertModule(tm2_1);

        Onderdeel tmo2_1 = new Onderdeel();
        tmo2_1.setNaam("Ngoko");
        ModuleDuur findM16 = moduleService.getSpecificModuleById(13);
        tmo2_1.setDocent(docentService.getSpecificDocent("Psy", "Astro"));
        findM16.addOnderdeel(tmo2_1);
        onderdeelService.insertOnderdeel(tmo2_1);

        ModuleDuur tm2_2 = new ModuleDuur();
        tm2_2.setNaam("Advanced");
        tm2_2.setDuur("8 maanden");
        tm2_2.setRichting(richtingService.getSpecificRichting("Basa Jawa (Javaanse taal)"));
        moduleService.insertModule(tm2_2);

        Onderdeel tmo2_2 = new Onderdeel();
        tmo2_2.setNaam("Krama");
        ModuleDuur findM17 = moduleService.getSpecificModuleById(14);
        tmo2_2.setDocent(docentService.getSpecificDocent("Psy", "Astro"));
        findM17.addOnderdeel(tmo2_2);
        onderdeelService.insertOnderdeel(tmo2_2);

        ModuleDuur tm2_3 = new ModuleDuur();
        tm2_3.setNaam("Expert");
        tm2_3.setDuur("1 jaar en 7 maanden");
        tm2_3.setRichting(richtingService.getSpecificRichting("Basa Jawa (Javaanse taal)"));
        moduleService.insertModule(tm2_3);

        Onderdeel tmo2_3 = new Onderdeel();
        tmo2_3.setNaam("HaNaCaRaKa");
        ModuleDuur findM18 = moduleService.getSpecificModuleById(15);
        tmo2_3.setDocent(docentService.getSpecificDocent("Psy", "Astro"));
        findM18.addOnderdeel(tmo2_3);
        onderdeelService.insertOnderdeel(tmo2_3);
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        Opleiding gamelan = new Opleiding();
        gamelan.setNaam("Javaanse Muziekstijl & Storytelling");
        opleidingService.createOpleiding(gamelan);

        Richting gr1 = new Richting();
        gr1.setNaam("Karawitan Klenengan: Classical gamelan & vocal music");
        gr1.setOpleiding(gamelan);
        richtingService.insertRichting(gr1);

        ModuleDuur gm1_1 = new ModuleDuur();
        gm1_1.setNaam("Level 1");
        gm1_1.setDuur("3 maanden");
        gm1_1.setRichting(richtingService.getSpecificRichting("Karawitan Klenengan: Classical gamelan & vocal music"));
        moduleService.insertModule(gm1_1);

        Onderdeel tmo3_1 = new Onderdeel();
        tmo3_1.setNaam("Theorie Pelog gamelan");
        ModuleDuur findM19 = moduleService.getSpecificModuleById(16);
        tmo3_1.setDocent(docentService.getSpecificDocent("Gio", "Gotu"));
        findM19.addOnderdeel(tmo3_1);
        onderdeelService.insertOnderdeel(tmo3_1);

        Onderdeel tmo3_2 = new Onderdeel();
        tmo3_2.setNaam("Saron, Demung en Slenthem");
        ModuleDuur findM20 = moduleService.getSpecificModuleById(16);
        tmo3_2.setDocent(docentService.getSpecificDocent("Gio", "Gotu"));
        findM20.addOnderdeel(tmo3_2);
        onderdeelService.insertOnderdeel(tmo3_2);

        ModuleDuur gm1_2 = new ModuleDuur();
        gm1_2.setNaam("Level 2");
        gm1_2.setDuur("3 maanden");
        gm1_2.setRichting(richtingService.getSpecificRichting("Karawitan Klenengan: Classical gamelan & vocal music"));
        moduleService.insertModule(gm1_2);

        Onderdeel tmo3_3 = new Onderdeel();
        tmo3_3.setNaam("Peking, Kenong en Gong-Kempul");
        ModuleDuur findM21 = moduleService.getSpecificModuleById(17);
        tmo3_3.setDocent(docentService.getSpecificDocent("Gio", "Gotu"));
        findM21.addOnderdeel(tmo3_3);
        onderdeelService.insertOnderdeel(tmo3_3);

        ModuleDuur gm1_3 = new ModuleDuur();
        gm1_3.setNaam("Level 3");
        gm1_3.setDuur("5 maanden");
        gm1_3.setRichting(richtingService.getSpecificRichting("Karawitan Klenengan: Classical gamelan & vocal music"));
        moduleService.insertModule(gm1_3);

        Onderdeel tmo3_4 = new Onderdeel();
        tmo3_4.setNaam("Bonang Penerus");
        ModuleDuur findM22 = moduleService.getSpecificModuleById(18);
        tmo3_4.setDocent(docentService.getSpecificDocent("Gio", "Gotu"));
        findM22.addOnderdeel(tmo3_4);
        onderdeelService.insertOnderdeel(tmo3_4);

        Onderdeel tmo3_5 = new Onderdeel();
        tmo3_5.setNaam("Bonang Barong");
        ModuleDuur findM23 = moduleService.getSpecificModuleById(18);
        tmo3_5.setDocent(docentService.getSpecificDocent("Gio", "Gotu"));
        findM23.addOnderdeel(tmo3_5);
        onderdeelService.insertOnderdeel(tmo3_5);
//----------------------------------------------------------------------------------------
        Richting gr2 = new Richting();
        gr2.setNaam("Wayang Kulit");
        gr2.setOpleiding(gamelan);
        richtingService.insertRichting(gr2);

        ModuleDuur gm2_1 = new ModuleDuur();
        gm2_1.setNaam("Level 1");
        gm2_1.setDuur("4 maanden");
        gm2_1.setRichting(richtingService.getSpecificRichting("Wayang Kulit"));
        moduleService.insertModule(gm2_1);

        Onderdeel gmo1_1 = new Onderdeel();
        gmo1_1.setNaam("Theorie Wayang Slendro ");
        ModuleDuur findM24 = moduleService.getSpecificModuleById(19);
        gmo1_1.setDocent(docentService.getSpecificDocent("Bwi", "Dipo"));
        findM24.addOnderdeel(gmo1_1);
        onderdeelService.insertOnderdeel(gmo1_1);

        Onderdeel gmo1_2 = new Onderdeel();
        gmo1_2.setNaam("Wayang storytelling");
        ModuleDuur findM25 = moduleService.getSpecificModuleById(19);
        gmo1_2.setDocent(docentService.getSpecificDocent("Bwi", "Dipo"));
        findM25.addOnderdeel(gmo1_2);
        onderdeelService.insertOnderdeel(gmo1_2);

        ModuleDuur gm2_2 = new ModuleDuur();
        gm2_2.setNaam("Level 2");
        gm2_2.setDuur("5 maanden");
        gm2_2.setRichting(richtingService.getSpecificRichting("Wayang Kulit"));
        moduleService.insertModule(gm2_2);

        Onderdeel gmo2_1 = new Onderdeel();
        gmo2_1.setNaam("Gendér");
        ModuleDuur findM26 = moduleService.getSpecificModuleById(20);
        gmo2_1.setDocent(docentService.getSpecificDocent("Bwi", "Dipo"));
        findM26.addOnderdeel(gmo2_1);
        onderdeelService.insertOnderdeel(gmo2_1);

        Onderdeel gmo2_2 = new Onderdeel();
        gmo2_2.setNaam("Kendhang");
        ModuleDuur findM27 = moduleService.getSpecificModuleById(20);
        gmo2_2.setDocent(docentService.getSpecificDocent("Bwi", "Dipo"));
        findM27.addOnderdeel(gmo2_2);
        onderdeelService.insertOnderdeel(gmo2_2);
    }

    public void regStudentOnderdeel(){
        Onderdeel findO1 = onderdeelService.getOnderdeelByName("Permula A1 & A2");
        Onderdeel findO2 = onderdeelService.getOnderdeelByName("Theorie Pelog gamelan");
        Onderdeel findO3 = onderdeelService.getOnderdeelByName("Tari Pendet");
        Onderdeel find04 = onderdeelService.getOnderdeelByName("Tari Nawang Sekar");
        Onderdeel findO5 = onderdeelService.getOnderdeelByName("Ngoko");
        Onderdeel findO6 = onderdeelService.getOnderdeelByName("Theorie Wayang Slendro ");
        Onderdeel findO7 = onderdeelService.getOnderdeelByName("Krama");

        Student findMickey = studentService.getStudentByName("Mickey", "Mouse");
        findMickey.getOnderdelen().add(findO1);
        findMickey.getOnderdelen().add(findO2);
        studentService.insertStudent(findMickey);

        Student findDora = studentService.getStudentByName("Dora", "the Explorer");
        findDora.getOnderdelen().add(findO3);
        studentService.insertStudent(findDora);

        Student findMinni = studentService.getStudentByName("Minni", "Mouse");
        findMinni.getOnderdelen().add(findO3);
        studentService.insertStudent(findMinni);

        Student findCoraline = studentService.getStudentByName("Coraline", "Jones");
        findCoraline.getOnderdelen().add(find04);
        findCoraline.getOnderdelen().add(findO1);
        findCoraline.getOnderdelen().add(findO5);
        studentService.insertStudent(findCoraline);

        Student findDonald = studentService.getStudentByName("Donald", "Duck");
        findDonald.getOnderdelen().add(findO6);
        findDonald.getOnderdelen().add(findO7);
        studentService.insertStudent(findDonald);

    }

}
