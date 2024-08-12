package app.service;

import app.entity.Carro;
import app.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {


    @Autowired
    private CarroRepository carroRepository;

    public String save(Carro carro){
        this.verificarNomeCarro(carro.getNome(),carro.getAno());
        this.carroRepository.save(carro);
        return "Carro salvo com sucesso.";
    }

    public boolean verificarNomeCarro(String nome, int ano){
        if(nome.equals("Jeep Compass") && ano < 2006){
            throw new RuntimeException();
        }
        return true;
    }
    public String update(Carro carro, Long id){

        this.verificarNomeCarro(carro.getNome(),carro.getAno());

        carro.setId(id);
        this.carroRepository.save(carro);
        return "Carro atualizado com sucesso.";
    }

    public String delete(Long id){
        this.carroRepository.deleteById(id);
        return "Carro deletado com sucesso.";
    }




    public List<Carro> listAll(){
        List<Carro> lista = carroRepository.findAll();
        return lista;
    }

    public Carro findById(Long id){


        Carro carro = this.carroRepository.findById(id).get();
        return carro;
    }

}
