package com.cg.productij.service.color;

import com.cg.productij.model.Color;
import com.cg.productij.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class ColorService implements IColorSevice{
    @Autowired
    public ColorRepository colorRepository;
    @Override
    public List<Color> findAll() {
        return colorRepository.findAll();
    }

    @Override
    public Optional<Color> findById(Long id) {
        return colorRepository.findById(id);
    }

    @Override
    public void save(Color color) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
