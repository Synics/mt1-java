package com.cloud.assignment.assignment1.service.base;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public class BaseService<Model, Entity, ID> {
    private JpaRepository<Entity, ID> repository;
    private Class<Model> modelClass;
    private Class<Entity> entityClass;
    private ModelMapper modelMapper = new ModelMapper();

    public BaseService(Class<Model> modelClass, Class<Entity> entityClass, JpaRepository<Entity, ID> repository){
        this.modelClass = modelClass;
        this.entityClass = entityClass;
        this.repository = repository;
    }

    public Model create(Model mdl) {
        Entity entity = modelMapper.map(mdl, entityClass);
        return modelMapper.map(this.repository.save(entity), modelClass);
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    public Model getById(ID id) {
        Entity entity = repository.findById(id).get();
        return modelMapper.map(entity, modelClass);
    }

    public List<Model> getAll() {
        List<Model> models = new ArrayList<>();

        for(Entity entity : repository.findAll()) {
           models.add(modelMapper.map(entity, modelClass));
        }

        return models;
    }

    public Model update(Model mdl) {
        Entity updatedEntity = repository.saveAndFlush(modelMapper.map(mdl, entityClass));
        return modelMapper.map(updatedEntity, modelClass);
    }

    public ModelMapper getModelMapper() {
        return this.modelMapper;
    }
}
