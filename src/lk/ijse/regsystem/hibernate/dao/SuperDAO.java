package lk.ijse.regsystem.hibernate.dao;

import lk.ijse.regsystem.hibernate.entity.SuperEntity;

import java.util.ArrayList;
import java.util.List;

public interface SuperDAO<Entity extends SuperEntity, ID> {
    public boolean add(Entity entity)throws Exception;

    public boolean update(Entity entity)throws Exception;

    public boolean delete(ID id)throws Exception;

    public Entity find(ID id)throws Exception;

    public List<Entity> getAll()throws Exception;

    public int getCount() throws Exception;
}
