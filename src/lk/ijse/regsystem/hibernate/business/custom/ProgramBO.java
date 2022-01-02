package lk.ijse.regsystem.hibernate.business.custom;

import lk.ijse.regsystem.hibernate.business.SuperBO;
import lk.ijse.regsystem.hibernate.dto.ProgramDTO;
import lk.ijse.regsystem.hibernate.entity.Program;

import java.util.List;

public interface ProgramBO extends SuperBO {
    public boolean add(Program program) throws Exception;

    public boolean delete(String id) throws Exception;

    public boolean update(Program program) throws Exception;

    public List<Program> getAll() throws Exception;

    public Program find(String id) throws Exception;

    public int getCount() throws Exception;
}

