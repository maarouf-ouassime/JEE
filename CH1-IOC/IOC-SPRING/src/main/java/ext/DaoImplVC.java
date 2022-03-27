package ext;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component
public class DaoImplVC implements IDao {
    @Override
    public double getData() {
        System.out.println("versions capteurs");
        double temp = 80;

        return temp;
    }
}
