package proxy;

import entity.Docent;
import entity.Student;
import entity.courses.Opleiding;

import java.util.ArrayList;
import java.util.List;

public class GetMethodsProxy implements IGetMethodsService {
    private GetMethods getMethods = null;
    private List<Docent> allDocentenCache = new ArrayList<>();

   // public DocentProxy(){
        //this.docentMethods = new DocentMethods();
    //}

    @Override
    public List<Docent> getAllDocenten() {
        if(getMethods == null || allDocentenCache.isEmpty()){
            getMethods = new GetMethods();
            allDocentenCache = getMethods.getAllDocenten();
            System.out.println("niet uit cache");
        }
            //System.out.println("wel uit cache");

        return allDocentenCache;
    }

   /* @Override
    public List<Student> getAllStudenten() {
        return null;
    }

    @Override
    public List<Opleiding> getAlleOpleidingen() {
        return null;
    }*/

}
