package io.github.carlosaugusto516.clientes.rest;

import io.github.carlosaugusto516.clientes.model.entity.Cliente;
import io.github.carlosaugusto516.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControler {
         private ClienteRepository repository;
        @Autowired
        public ClienteControler(ClienteRepository repository){
            this.repository = repository;
        }
        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        @ResponseBody
        public Cliente salvar (@RequestBody @Valid Cliente cliente){
            return repository.save(cliente);
        }
        @GetMapping("{id}")
        public Cliente acharPorID (@PathVariable Integer id) {
            return repository
                    .findById(id)
                    .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );

        }
        @DeleteMapping("{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deletar (@PathVariable Integer id) {
            repository
                    .findById(id)
                    .map (cliente -> {
                        repository.delete(cliente);
                        return Void.TYPE;
                    })
                    .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado") );
        }
        @PutMapping("{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void atualizar (@PathVariable Integer id,@RequestBody @Valid Cliente clienteAtualizado) {
            repository
                    .findById(id)
                    .map (cliente -> {
                        clienteAtualizado.setId(cliente.getId());
                        return repository.save(clienteAtualizado);
                    })
                    .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado") );
   }

}
