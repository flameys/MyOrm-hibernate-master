package proxy;

import configuration.JPAConfiguration;
import entity.Docent;
import repository.DocentRepository;

import java.util.List;

public class GetMethods implements IGetMethodsService {
    private DocentRepository docentRepository;

    public GetMethods(){this.docentRepository = new DocentRepository(JPAConfiguration.getEntityManager());}

    @Override
    public List<Docent> getAllDocenten() {
        return docentRepository.getDocenten();
    }

}
