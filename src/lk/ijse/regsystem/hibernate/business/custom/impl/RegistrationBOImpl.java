package lk.ijse.regsystem.hibernate.business.custom.impl;

import lk.ijse.regsystem.hibernate.business.custom.RegistrationBo;
import lk.ijse.regsystem.hibernate.dao.custom.RegistrationDAO;
import lk.ijse.regsystem.hibernate.dao.custom.impl.RegistrationDAOImpl;
import lk.ijse.regsystem.hibernate.dto.RegistrationDTO;
import lk.ijse.regsystem.hibernate.entity.Registration;

public class RegistrationBOImpl implements RegistrationBo {
    RegistrationDAO registrationDAO = new RegistrationDAOImpl();
    @Override
    public boolean add(RegistrationDTO registrationDTO) {
        return registrationDAO.add(new Registration(registrationDTO.getRegNo(),registrationDTO.getRegisteredDate(),registrationDTO.getStudent(),registrationDTO.getPrograms()));

    }
}
