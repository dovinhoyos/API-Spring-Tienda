package edu.tienda.core.services;

import edu.tienda.core.domain.Producto;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("MEMORY")
@ConditionalOnProperty(value = "productos.estrategia", havingValue = "EN_MEMORIA")
public class ProductoServiceImp implements IProductoService{

    List<Producto> productos = Arrays.asList(
            new Producto(1, "Macbook Air M2", 999.99, 5),
            new Producto(2, "Mouse Logitech 10000 dpis", 99.99, 10),
            new Producto(3, "Teclado mecanico Logitech", 299.99, 8)
    );

    public List<Producto> getProductos(){
        return productos;
    }
}
