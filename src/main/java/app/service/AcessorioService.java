package app.service;

import app.entity.Acessorio;
import app.entity.Marca;
import app.repository.AcessorioRepository;
import app.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcessorioService {

    @Autowired
    private AcessorioRepository acessorioRepository;

    public String save(Acessorio acessorio){
        this.acessorioRepository.save(acessorio);
        return "Acessorio salvo com sucesso.";
    }


    public String update(Acessorio acessorio, Long id){
        acessorio.setId(id);
        this.acessorioRepository.save(acessorio);
        return "Acessorio atualizado com sucesso.";
    }


    public String delete(Long id){
        this.acessorioRepository.deleteById(id);
        return "Acessorio deletado com sucesso.";
    }

    public List<Acessorio> listAll(){
        List<Acessorio> acessorios = acessorioRepository.findAll();
        return acessorios;
    }

    public Acessorio findById(Long id){
        Acessorio acessorio = this.acessorioRepository.findById(id).get();
        return acessorio;
    }
}
