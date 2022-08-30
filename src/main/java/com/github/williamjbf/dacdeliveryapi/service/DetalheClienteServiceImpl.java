package com.github.williamjbf.dacdeliveryapi.service;

import com.github.williamjbf.dacdeliveryapi.cliente.DetalheClienteData;
import com.github.williamjbf.dacdeliveryapi.cliente.model.Cliente;
import com.github.williamjbf.dacdeliveryapi.cliente.repository.ClienteRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetalheClienteServiceImpl implements UserDetailsService {

    private final ClienteRepository repository;

    public DetalheClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Cliente> cliente = repository.findByEmail(username);
        if(!cliente.isPresent()){
            throw new UsernameNotFoundException("Usuário [" + username+"] não encontrado.");
        }
        return new DetalheClienteData(cliente);
    }
}
