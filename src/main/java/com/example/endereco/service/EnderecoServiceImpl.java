package com.example.endereco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.endereco.model.Endereco;
import com.example.endereco.repository.EnderecoRepository;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    LocalizacaoService localizacaoService;

    public Endereco atualizar(Long id, Endereco newEndereco) {

        System.out.println(newEndereco.getZipcode());
        return enderecoRepository.findById(id)
                .map(endereco -> {
                    endereco.setStreetName(newEndereco.getStreetName());
                    endereco.setNumber(newEndereco.getNumber());
                    endereco.setComplement(newEndereco.getComplement());
                    endereco.setNeighbourhood(newEndereco.getNeighbourhood());
                    endereco.setCity(newEndereco.getCity());
                    endereco.setState(newEndereco.getState());
                    endereco.setCountry(newEndereco.getCountry());
                    endereco.setZipcode(newEndereco.getZipcode());
                    endereco.setLatitude(newEndereco.getLatitude() == 0 ? localizacaoService.latitude() : newEndereco.getLatitude());
                    endereco.setLongitude(newEndereco.getLongitude() == 0 ? localizacaoService.longitude() : newEndereco.getLongitude());
                    return enderecoRepository.save(endereco);
                })
                .orElseGet(() -> {
                    newEndereco.setId(id);
                    return enderecoRepository.save(newEndereco);
                });
    }
}