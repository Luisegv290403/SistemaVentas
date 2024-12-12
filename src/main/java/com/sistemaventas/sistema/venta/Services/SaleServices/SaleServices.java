package com.sistemaventas.sistema.venta.Services.SaleServices;



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
import com.sistemaventas.sistema.venta.entities.User.UserAparament;
import com.sistemaventas.sistema.venta.repositories.ClientRepository.ClienteRepository;
import com.sistemaventas.sistema.venta.repositories.SaleRepository.SaleRepository;
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
    public ResponseEntity<?> addSale(SaleDto saleDto) {
        try {
            // Buscar usuario-apartamento
            UserAparament userApartment = userAparamentRepository
                    .findById(saleDto.getUserApartments())
                    .orElseThrow(() -> new IllegalArgumentException("UserApartment not found"));

            // Procesar detalles de la venta
            List<DetSale> detSales = new ArrayList<>();
            double total = 0.0;
            for (DetSaleDto detSaleDto : saleDto.getDetSales()) {
                if (detSaleDto.getServicesAparment() == null) {
                    throw new IllegalArgumentException("ServiceApartment cannot be null");
                }

                double price = detSaleDto.getServicesAparment().getPrecie();
                double subTotal = price * detSaleDto.getQuantity();
                double subTotalIgv = subTotal + (subTotal * 0.18);

                DetSale detSale = new DetSale();
                detSale.setVenta(null); // Relación será establecida después
                detSale.setQuantity(detSaleDto.getQuantity());
                detSale.setServicesAparment(detSaleDto.getServicesAparment());
                detSale.setUnitPrice(price);
                detSale.setSubTotal(subTotal);
                detSale.setSubTotalIgv(subTotalIgv);

                detSales.add(detSale);
                total += subTotalIgv; // Acumular total con IGV
            }

            // Crear y guardar la venta
            Sale sale = new Sale(
                    saleDto.getTypeComprobant(),
                    saleDto.getDate(),
                    generateNrComprobant(),
                    saleDto.getClient(),
                    userApartment,
                    total,
                    detSales
            );

            detSaleRepository.saveAll(detSales); // Guardar detalles en lote
            saleRepository.save(sale);

            return ResponseEntity.ok().body("Venta registrada correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al registrar la venta: " + e.getMessage());
        }
    }

    private String generateNrComprobant() {
        return "FAC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

        /*
    public ResponseEntity<?> getSales(){
        List<SaleResponseDto> saleDtos = saleRepository.findAll().stream().map(sale -> new SaleResponseDto(sale.getId(),sale.getTypeComprobant(), sale.getDate(), sale.getNrComprobant(), sale.getClient(), sale.getUserApartments().getId(), sale.getTotal())).collect(Collectors.toList());
        return ResponseEntity.ok().body(saleDtos);
    }*/
}
