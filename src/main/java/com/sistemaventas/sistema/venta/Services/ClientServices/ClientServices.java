package com.sistemaventas.sistema.venta.Services.ClientServices;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.sistemaventas.sistema.venta.DTO.ClientDto.ClientDtoResponse;
import com.sistemaventas.sistema.venta.DTO.ClientDto.ClienteDto;
import com.sistemaventas.sistema.venta.entities.Client.Client;
import com.sistemaventas.sistema.venta.repositories.ClientRepository.ClienteRepository;

@Service
public class ClientServices {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    public ResponseEntity<?> getClient(){
        List<ClientDtoResponse> cList = clienteRepository.findAll().stream().map(user -> new ClientDtoResponse(
            user.getId(), user.getName(), user.getDni(), user.getCellphone(), user.getAddress() , user.getRuc(), user.getEmail())).collect(Collectors.toList());

        if(!cList.isEmpty()){
            return ResponseEntity.ok().body(cList);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("hubo un error");
    }

    public ResponseEntity<?> addClient(ClienteDto clienteDto){
        
        try {
            Client client = new Client(clienteDto.getName(), clienteDto.getDni(), clienteDto.getCellphone(), clienteDto.getAddress(), clienteDto.getRuc(), clienteDto.getEmail());
            clienteRepository.save(client);
            return ResponseEntity.status(HttpStatus.CREATED).body(client);
        } catch (Exception e) {
            
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public ResponseEntity<?> editClient(Long id, ClienteDto clienteDto){
        Client client = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Hubo un error al buscar al cliente con: " + id) );    
        
        client.setName(clienteDto.getName());
        client.setEmail(clienteDto.getEmail());
        client.setCellphone(clienteDto.getCellphone());
        client.setRuc(clienteDto.getRuc());
        client.setDni(clienteDto.getDni());
        client.setAddress(clienteDto.getAddress());

        clienteRepository.save(client);
        return ResponseEntity.ok().body(client);
    }

    public ResponseEntity<?> deleteClient(Long id){
        try{
            clienteRepository.deleteById(id);
            return ResponseEntity.ok().body("Usuario eliminado correctamente");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
