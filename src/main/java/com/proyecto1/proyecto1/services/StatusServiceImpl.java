package com.proyecto1.proyecto1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto1.proyecto1.persistance.models.Status;
import com.proyecto1.proyecto1.persistance.repository.StatusRepository;

@Service
public class StatusServiceImpl implements StatusServiceI {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Status> getAllStatus() {
        return statusRepository.findAll(); // Recupera todos los estados de la base de datos
    }

    @Override
    public Status createStatus(Status status) {
        return statusRepository.save(status); // Guarda un nuevo estado en la base de datos
    }

    @Override
    public void deleteStatus(Integer id) {
        statusRepository.deleteById(id); // Elimina el estado con el ID proporcionado
    }

    @Override
    public boolean existsStatusById(Integer id) {
        return statusRepository.existsById(id); // Verifica si un estado con el ID existe
    }
    
}
