package edu.tienda.core.controllers;

import edu.tienda.core.configurations.ConfigurationsParameters;
import edu.tienda.core.domain.Producto;
import edu.tienda.core.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosRestController {

    @Autowired
//    @Qualifier("MEMORY")
    @Lazy
    private ProductoService productoService;
    @Autowired
    private ConfigurationsParameters configurationsParameters;

    @GetMapping
    public ResponseEntity<?> getProductos(){

        System.out.println("params: " + configurationsParameters.toString());

        List<Producto> productos = productoService.getProductos();

        return ResponseEntity.ok(productos);
    }
}
