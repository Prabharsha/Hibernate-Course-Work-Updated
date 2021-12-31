package lk.ijse.regsystem.hibernate.business;

import lk.ijse.regsystem.hibernate.business.custom.impl.ProgramBOImpl;
import lk.ijse.regsystem.hibernate.business.custom.impl.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return (null == boFactory) ? boFactory = new BOFactory() : boFactory;
    }

    public <T extends SuperBO> T getBO(BOType boType){
        switch (boType){
            case STUDENT:
                return (T) new StudentBOImpl();
            case PROGRAM:
                return (T) new ProgramBOImpl();
            default:
                return null;
        }
    }
}
