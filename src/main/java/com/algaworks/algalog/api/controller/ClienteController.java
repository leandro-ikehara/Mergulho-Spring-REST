package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController
{
    @GetMapping("/clientes")
    public List<Cliente> listar()
    {
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Leandro");
        cliente1.setTelefone("11 96363-8282");
        cliente1.setEmail("leandro@email.com");

        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Ana Paula");
        cliente2.setTelefone("11 95454-7373");
        cliente2.setEmail("anapaula@email.com");

        return Arrays.asList(cliente1, cliente2);
    }
}
