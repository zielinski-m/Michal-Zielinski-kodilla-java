package com.kodilla.hibernate.invoice.dao;


import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private ProductDao productDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Product_1");
        productDao.save(product1);

        Item item1 = new Item(BigDecimal.valueOf(2500), 2, BigDecimal.valueOf(1200), product1);
        Item item2 = new Item(BigDecimal.valueOf(3600), 10, BigDecimal.valueOf(1500), product1);

        Invoice invoice = new Invoice("FV-2023/07");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);

        //When
        invoiceDao.save(invoice);

        //Then
        int invoiceId = invoice.getId();
        Optional<Invoice> readInvoice = invoiceDao.findById(invoiceId);
        assertTrue(readInvoice.isPresent());

        //CleanUp
        invoiceDao.deleteAll();
    }

    @Test
    void testFindInvoiceByNumber() {
        //Given
        Product product1 = new Product("Product_1");
        productDao.save(product1);

        Item item1 = new Item(BigDecimal.valueOf(2500), 2, BigDecimal.valueOf(1200), product1);
        Item item2 = new Item(BigDecimal.valueOf(3600), 10, BigDecimal.valueOf(1500), product1);

        Invoice invoice = new Invoice("FV-2023/07");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoiceDao.save(invoice);

        //When
        List<Invoice> readInvoices = invoiceDao.findByNumber("FV-2023/07");

        //Then
        assertEquals(1, readInvoices.size());

        //CleanUp
        invoiceDao.deleteAll();
    }
}
