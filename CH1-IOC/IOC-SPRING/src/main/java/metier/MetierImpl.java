package metier;
import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier{
    // @Qualifier("dao")
    @Autowired
    private IDao dao;
    @Override
    public double calcul() {
        double temp = dao.getData();//n'importe quel source:classe
        double res=temp*540/Math.cos(temp*Math.PI);
        return res;
    }
    public MetierImpl() {

    }
    public MetierImpl(IDao dao) {
        this.dao = dao;
    }


    //permet d'injecter dans la variable dao un obj d'une classe qui implemente l'interface IDao
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
