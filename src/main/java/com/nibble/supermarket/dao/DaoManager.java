package com.nibble.supermarket.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoManager {
    // Instancia de la clase
    private static DaoManager instance = null;

    // Fábrica de Gestores de Entidades
    private final EntityManagerFactory emf;

    // DAO
    private ClienteJpaController clientes = null;
    private ProductoJpaController productos = null;
    private EmpleadoJpaController empleados = null;
    private TurnoJpaController turnos = null;
    private TicketJpaController tickets = null;
    private LineaJpaController lineas = null;
    private PromocionJpaController promociones = null;

    // Constructor privado
    public DaoManager() {
        this.emf = Persistence.createEntityManagerFactory("nibble-pu");
    }

    // Método para obtener la instancia de la clase
    public static DaoManager getInstance() {
        if (instance == null) {
            instance = new DaoManager();
        }
        return instance;
    }

    // Métodos para obtener los DAO

    public ClienteJpaController getClienteDao() {
        if (clientes == null) {
            clientes = new ClienteJpaController(emf);
        }
        return clientes;
    }

    public ProductoJpaController getProductoDao() {
        if (productos == null) {
            productos = new ProductoJpaController(emf);
        }
        return productos;
    }

    public EmpleadoJpaController getEmpleadoDao() {
        if (empleados == null) {
            empleados = new EmpleadoJpaController(emf);
        }
        return empleados;
    }

    public TurnoJpaController getTurnoDao() {
        if (turnos == null) {
            turnos = new TurnoJpaController(emf);
        }
        return turnos;
    }

    public TicketJpaController getTicketDao() {
        if (tickets == null) {
            tickets = new TicketJpaController(emf);
        }
        return tickets;
    }

    public LineaJpaController getLineaDao() {
        if (lineas == null) {
            lineas = new LineaJpaController(emf);
        }
        return lineas;
    }

    public PromocionJpaController getPromocionDao() {
        if (promociones == null) {
            promociones = new PromocionJpaController(emf);
        }
        return promociones;
    }

}