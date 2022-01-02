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
    public boolean add(Program program) {
        return programDAO.add(new Program(
                program.getId(),
                program.getProgramName(),
                program.getDuration(),
                program.getFee()
        ));
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(Program program) {
        return false;
    }

    @Override
    public List<Program> getAll() {
        System.out.println("1");
        List<Program> allProgram = programDAO.getAll();
        List<Program> List = new ArrayList<>();

        for (Program program : allProgram) {
            List.add(new Program(
                    program.getId(),
                    program.getProgramName(),
                    program.getDuration(),
                    program.getFee()
            ));

        }
        return List;

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

    @Override
    public int getCount() throws Exception {
        return 0;
    }
}
