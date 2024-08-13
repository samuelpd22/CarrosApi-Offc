package app.service;

import app.entity.Carro;
import app.entity.Marca;
import app.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public String save(Marca marca){
        this.marcaRepository.save(marca);
        return "Carro salvo com sucesso.";
    }


    public String update(Marca marca, Long id){
        marca.setId(id);
        this.marcaRepository.save(marca);
        return "Marca atualizada com sucesso.";
    }


    public String delete(Long id){
        this.marcaRepository.deleteById(id);
        return "Marca deletada com sucesso.";
    }

    public List<Marca> listAll(){
        List<Marca> marca = marcaRepository.findAll();
        return marca;
    }

    public Marca findById(Long id){
        Marca marca = this.marcaRepository.findById(id).get();
        return marca;
    }
}




