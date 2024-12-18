package com.sistemaventas.sistema.venta.Services.SaleServices;



import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.sistemaventas.sistema.venta.DTO.DetSale.DetSaleDto;
import com.sistemaventas.sistema.venta.entities.DetSale.DetSale;
import com.sistemaventas.sistema.venta.repositories.DetSaleRepository.DetSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sistemaventas.sistema.venta.DTO.SaleDto.SaleDto;
import com.sistemaventas.sistema.venta.DTO.SaleDto.SaleResponseDto;
import com.sistemaventas.sistema.venta.entities.Client.Client;
import com.sistemaventas.sistema.venta.entities.Sale.Sale;
import com.sistemaventas.sistema.venta.entities.ServicesAparament.ServicesAparment;
import com.sistemaventas.sistema.venta.entities.User.UserAparament;
import com.sistemaventas.sistema.venta.repositories.ClientRepository.ClienteRepository;
import com.sistemaventas.sistema.venta.repositories.SaleRepository.SaleRepository;
import com.sistemaventas.sistema.venta.repositories.ServicesAparament.ServicesAparmentRepository;
import com.sistemaventas.sistema.venta.repositories.UserRepository.UserAparamentRepository;

@Service
public class SaleServices {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private UserAparamentRepository userAparamentRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private DetSaleRepository detSaleRepository;
    
    @Autowired
    private ServicesAparmentRepository servicesAparmentRepository;


    public ResponseEntity<?> addSale(SaleDto saleDto) {
        try {
            List<DetSale> detSales = new ArrayList<>();

            Client client = new Client(saleDto.getClient().getName(), saleDto.getClient().getDni(), saleDto.getClient().getCellphone(), saleDto.getClient().getAddress(), saleDto.getClient().getRuc(), saleDto.getClient().getEmail());
            client = clienteRepository.save(client);

            UserAparament userAparament = userAparamentRepository.findById(saleDto.getUserApartments()).orElseThrow(()-> new Exception("no hay un userAparment con ese id: " + saleDto.getUserApartments()));
            double total = 0;

            for(DetSaleDto detSaleDto : saleDto.getDetSales()){
                ServicesAparment servicesAparment = servicesAparmentRepository.findById(detSaleDto.getServicesAparment()).orElseThrow(()-> new Exception("No hay servicesAparment con el id: " + detSaleDto.getServicesAparment()));

                DetSale detSale = new DetSale();
                detSale.setQuantity(detSaleDto.getQuantity());
                detSale.setUnitPrice(servicesAparment.getPrecie());
                detSale.setServicesAparment(servicesAparment);
                detSale.setSubTotal(servicesAparment.getPrecie() * detSaleDto.getQuantity());
                detSale.setSubTotalIgv(((servicesAparment.getPrecie() * detSaleDto.getQuantity()) * 0.18));

                total += ((servicesAparment.getPrecie() * detSaleDto.getQuantity()) + ((servicesAparment.getPrecie() * detSaleDto.getQuantity()) * 0.18)); 

                detSales.add(detSale);
            }



            Sale sale = new Sale();
            sale.setNrComprobant(generateNrComprobant());
            sale.setClient(client);
            sale.setDate(saleDto.getDate());
            sale.setTypeComprobant(saleDto.getTypeComprobant());
            sale.setUserApartments(userAparament);
            sale.setTotal(total);
            

            for(DetSale detSale : detSales){
                detSale.setVenta(sale);
            }
            sale.setDetSales(detSales);
            
            saleRepository.save(sale);
            return ResponseEntity.ok().body("Venta registrada correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al registrar la venta: " + e.getMessage());
        }
    }

    private String generateNrComprobant() {
        return "FAC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

}
