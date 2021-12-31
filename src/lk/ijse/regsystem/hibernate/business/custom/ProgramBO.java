package lk.ijse.regsystem.hibernate.business.custom;

import lk.ijse.regsystem.hibernate.business.SuperBO;
import lk.ijse.regsystem.hibernate.dto.ProgramDTO;
import lk.ijse.regsystem.hibernate.entity.Program;
import lk.ijse.regsystem.hibernate.entity.Student;

import java.util.List;

public interface ProgramBO extends SuperBO {
    public boolean add(ProgramDTO programDTO) throws Exception;

    public boolean delete(String id) throws Exception;

    public boolean update(ProgramDTO programDTO) throws Exception;

    public List<ProgramDTO> getAll() throws Exception;

    public Program find(String id) throws Exception;
}
