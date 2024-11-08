package edu.tienda.core.controllers;

import edu.tienda.core.domain.Producto;
import edu.tienda.core.services.IProductoService;
import edu.tienda.core.services.ProductoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private IProductoService productoService;

    @GetMapping
    public ResponseEntity<?> getProductos(){

        List<Producto> productos = productoService.getProductos();

        return ResponseEntity.ok(productos);
    }
}
