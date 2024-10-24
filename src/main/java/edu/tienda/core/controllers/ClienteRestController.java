package edu.tienda.core.controllers;

import edu.tienda.core.domain.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteRestController {

    private List<Cliente> clientes = new ArrayList<>(Arrays.asList(
            new Cliente("rango1058", "1058", "Santiago"),
            new Cliente("el_pepe", "pipita06", "Felipe"),
            new Cliente("rich1006", "9610", "Richard")
    ));

    @GetMapping
    public ResponseEntity<?> getClientes(){
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getClientes(@PathVariable String username){
        return ResponseEntity.ok(clientes.stream()
                .filter(cliente -> cliente.getUsername().equalsIgnoreCase(username))
                .findFirst().orElseThrow());
    }

    @PostMapping
    public ResponseEntity<?> createCliente(@RequestBody Cliente cliente){
        clientes.add(cliente);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(cliente.getUsername())
                .toUri();

        return ResponseEntity.created(location).body(cliente);
    }

    @PutMapping
    public ResponseEntity<?> updateCliente (@RequestBody @NonNull Cliente cliente) {
        Cliente clienteEncontrado = clientes.stream()
                .filter(cli -> cli.getUsername().equalsIgnoreCase(cliente.getUsername()))
                .findFirst().orElseThrow();

        clienteEncontrado.setPassword(cliente.getPassword());
        clienteEncontrado.setNombre(cliente.getNombre());

        return ResponseEntity.ok(clienteEncontrado);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity deleteCliente(@PathVariable String username){

        Cliente clienteEncontrado = clientes.stream()
                .filter(cliente -> cliente.getUsername().equalsIgnoreCase(username))
                .findFirst().orElseThrow();

        clientes.remove(clienteEncontrado);

        return ResponseEntity.noContent().build();
    }

}
