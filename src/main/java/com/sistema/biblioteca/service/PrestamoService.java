package com.sistema.biblioteca.service;

import com.sistema.biblioteca.entity.Factura;
import com.sistema.biblioteca.entity.Libro;
import com.sistema.biblioteca.entity.Prestamo;
import com.sistema.biblioteca.repository.LibroRepository;
import com.sistema.biblioteca.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

@Service
public class PrestamoService {
    private PrestamoRepository prestamoRepository;
    private LibroRepository libroRepository;
    @Autowired
    public PrestamoService(PrestamoRepository prestamoRepository, LibroRepository libroRepository) {
        this.prestamoRepository = prestamoRepository;
        this.libroRepository = libroRepository;
    }
    public Prestamo save(Prestamo prestamo) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate fechaPrestamo = LocalDate.parse(dateFormat.format(calendar.getTime()));

        //Let's add 10 days for the expected return of the books
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        LocalDate fechaDevolucionEsperada = LocalDate.parse(dateFormat.format(calendar.getTime()));

        //Now, we have to determine the total to be invoiced on the invoice
        Double totalPagar = 0.0;

        for (Libro libro : prestamo.getLibrosList()) {
            if(!libro.getPrestamosList().contains(prestamo)) {
                libro.getPrestamosList().add(prestamo);//We need to relate every book with the specific loan
            }
            totalPagar += libro.getValorAlquiler() - ((libro.getValorAlquiler() * libro.getPorcentajeDescuento()) / 100);
            //And we need to reduce by one the total of copies available for one book
            libro.setCantidad(libro.getCantidad() - 1);
        }

        //And finally we got what we need to build our Factura object
        Factura factura = new Factura();
        factura.setFecha(fechaPrestamo);
        factura.setTotalpagar(totalPagar);

        //So we start to set the missing information on the Loan
        prestamo.setFechaInicio(fechaPrestamo);
        prestamo.setFechaDevolucionEsperada(fechaDevolucionEsperada);
        prestamo.setFactura(factura);

        //We save the loan
        Prestamo savedPrestamo = prestamoRepository.save(prestamo);

        //We save each book only once after the loan has been saved
        for (Libro libro : prestamo.getLibrosList()) {
            libroRepository.save(libro);
        }

        return savedPrestamo;
    }
}
