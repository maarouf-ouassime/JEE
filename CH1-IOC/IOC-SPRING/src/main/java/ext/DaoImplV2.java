package ext;

import dao.IDao;
import org.springframework.stereotype.Component;

public class DaoImplV2 implements IDao {

    @Override
    public double getData() {
        /*
         * Version WS
         */
        System.out.println("version web service");
        double data = 12;
        return data;
    }
}
