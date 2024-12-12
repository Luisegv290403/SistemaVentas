package com.sistemaventas.sistema.venta.Services.Services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sistemaventas.sistema.venta.DTO.ServicesDto.ServicesDto;
import com.sistemaventas.sistema.venta.DTO.ServicesDto.ServicesResponseDto;
import com.sistemaventas.sistema.venta.entities.Apartment.Apartment;
import com.sistemaventas.sistema.venta.entities.Service.Services;
import com.sistemaventas.sistema.venta.entities.ServicesAparament.ServicesAparment;
import com.sistemaventas.sistema.venta.repositories.Apartment.ApartmentRepository;
import com.sistemaventas.sistema.venta.repositories.ServicesAparament.ServicesAparmentRepository;
import com.sistemaventas.sistema.venta.repositories.ServicesRepository.ServicesRepository;

@Service
public class ServiceService {
    
    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private ServicesAparmentRepository servicesAparmentRepository;

    @Autowired
    private ApartmentRepository apartmentRepository;

    public ResponseEntity<?> addServices(ServicesDto servicesDto) {

        try {

            // Crear el servicio
            Services services = new Services();
            services.setName(servicesDto.getName());
            services = servicesRepository.save(services); // Guardar servicio en DB
            int aux = 0;

            // Asociar departamentos
            for (Long apartmentId : servicesDto.getApartmentId()) {
                // Verificar si el departamento existe
                Apartment apartment = apartmentRepository.findById(apartmentId)
                        .orElseThrow(() -> new RuntimeException("This apartment not found with ID: " + apartmentId));

                // Crear la relación en la tabla intermedia
                ServicesAparment servicesAparment = new ServicesAparment();
                servicesAparment.setService(services);
                servicesAparment.setApartment(apartment);

                servicesAparment.setDescription(servicesDto.getDescription()[aux]);
                servicesAparment.setPrecie(servicesDto.getPrecie()[aux]);
                servicesAparment.setState(servicesDto.isState()[aux]);

                // Guardar la relación
                servicesAparmentRepository.save(servicesAparment);
                aux++;
            }

            // Si todo se guardó correctamente
            return ResponseEntity.status(HttpStatus.CREATED).body("El servicio fue guardado correctamente.");
        } catch (RuntimeException ex) {
            // Manejar errores de negocio
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        } catch (Exception ex) {
            // Manejar errores genéricos
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error inesperado.");
        }

    }

    public ResponseEntity<?> getServices() {
        try {
            // Transformar los datos desde el repositorio hacia el DTO
            List<ServicesResponseDto> servicesList = servicesRepository.findAll().stream()
                    .flatMap(service -> service.getServicesAparments().stream()
                            .map(apartment -> new ServicesResponseDto(
                                    service.getId_service(),
                                    service.getName(),
                                    apartment.getDescription(),
                                    apartment.isState(),
                                    apartment.getApartment().getName(), // Puedes agregar lógica para definir este campo
                                                                        // si es
                                                                        // necesario
                                    apartment.getPrecie()// Convertir precio a String
                            ))).collect(Collectors.toList());

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicesList);

        } catch (RuntimeException e){
            
            return ResponseEntity.badRequest().body("Hubo un error en la request" + e.getMessage());
        } catch (Exception e) {

            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error inexperado" + e.getMessage());
        }

    }

    public ResponseEntity<?> updateServices(Long id, ServicesDto servicesDto) {
        try {
            // Buscar ServicesAparment por ID
            Optional<ServicesAparment> servicesAparmentOpt = servicesAparmentRepository.findById(id);
            if (servicesAparmentOpt.isEmpty()) {
                return ResponseEntity.badRequest().body("No se encontró el ServicesAparment con el ID proporcionado.");
            }

            ServicesAparment servicesAparment = servicesAparmentOpt.get();

            // Buscar el Service relacionado
            Optional<Services> serviceOpt = servicesRepository.findById(servicesAparment.getService().getId_service());
            if (serviceOpt.isEmpty()) {
                return ResponseEntity.badRequest().body("No se encontró el Service relacionado.");
            }

            Services service = serviceOpt.get();

            // Actualizar los datos del Service
            service.setName(servicesDto.getName());
            servicesRepository.save(service);

            // Actualizar los datos del ServicesAparment
            servicesAparment.setService(service);
            servicesAparment.setDescription(Arrays.asList(servicesDto.getDescription()).stream().findFirst().get());
            servicesAparment.setPrecie(Arrays.stream(servicesDto.getPrecie()).findFirst().get());
            servicesAparment.setState(servicesDto.isState()[0]);

            // Guardar cambios en ServicesAparment
            servicesAparmentRepository.save(servicesAparment);

            return ResponseEntity.ok().body("Todo está editado correctamente.");

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("hubo un error en la request" + e.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error inexperado");
        }

    }

    public ResponseEntity<?> delateServices(Long id) {

        try {
            ServicesAparment sOptional = servicesAparmentRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Services aparament no encontrado" + id));
            servicesAparmentRepository.deleteById(sOptional.getId());

            return ResponseEntity.ok().body("Se elimino el servicio de un apartamento");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("hubo un error en la request" + e.getMessage());

        } catch (Exception ex) {
            // Manejar errores genéricos
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error inesperado.");
        }

    }
}
