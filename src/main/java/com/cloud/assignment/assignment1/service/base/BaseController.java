package com.cloud.assignment.assignment1.service.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BaseController<Model, Entity, ID> {
    private BaseService<Model, Entity, ID> service;

    public BaseController(BaseService<Model, Entity, ID> service){
        this.service = service;
    }

    @CrossOrigin
    @PostMapping
    @ResponseBody
    public ResponseEntity<Model> create(@RequestBody Model mdl) {
        return new ResponseEntity<>(this.service.create(mdl), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping
    @ResponseBody
    public ResponseEntity<Model> deleteById(@PathVariable(value = "id") ID id) {
        this.service.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Model> getById (@PathVariable(value = "id") ID id) {
        return new ResponseEntity<>(this.service.getById(id), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Model>> getAll() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping
    @ResponseBody
    public ResponseEntity<Model> update(@RequestBody Model mdl) {
        return new ResponseEntity<>(this.service.update(mdl), HttpStatus.OK);
    }
}
