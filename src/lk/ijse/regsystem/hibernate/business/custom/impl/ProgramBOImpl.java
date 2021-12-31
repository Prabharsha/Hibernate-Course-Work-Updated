package lk.ijse.regsystem.hibernate.business.custom.impl;

import lk.ijse.regsystem.hibernate.business.custom.ProgramBO;
import lk.ijse.regsystem.hibernate.dao.DAOFactory;
import lk.ijse.regsystem.hibernate.dao.DAOType;
import lk.ijse.regsystem.hibernate.dao.custom.impl.ProgramDAOImpl;
import lk.ijse.regsystem.hibernate.dto.ProgramDTO;
import lk.ijse.regsystem.hibernate.entity.Program;

import java.util.ArrayList;
import java.util.List;

public class ProgramBOImpl implements ProgramBO {

    ProgramDAOImpl programDAO = DAOFactory.getInstance().getDAO(DAOType.PROGRAM);

    @Override
    public boolean add(ProgramDTO programDTO) {
        return programDAO.add(new Program(
                programDTO.getId(),
                programDTO.getProgramName(),
                programDTO.getDuration(),
                programDTO.getFee()
        ));
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(ProgramDTO programDTO) {
        return false;
    }

    @Override
    public List<ProgramDTO> getAll() {

        List<Program> allProgram = programDAO.getAll();
        ArrayList<ProgramDTO> dtoList = new ArrayList<>();

        for (Program program : allProgram) {
            dtoList.add(new ProgramDTO(
                    program.getId(),
                    program.getProgramName(),
                    program.getDuration(),
                    program.getFee()
            ));
        }
        return dtoList;
    }

    @Override
    public Program find(String name) throws Exception {
        Program program = programDAO.find(name);
        if (program != null) {
            return program;
        } else {
            return null;
        }
    }
}
