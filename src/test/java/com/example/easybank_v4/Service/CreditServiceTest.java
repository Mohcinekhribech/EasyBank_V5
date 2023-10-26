package com.example.easybank_v4.Service;

import com.example.easybank_v4.DAO.CreditDao;
import com.example.easybank_v4.DTO.Client;
import com.example.easybank_v4.DTO.Credit;
import com.example.easybank_v4.Services.CreditService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import java.time.LocalDate;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.mockito.Mock;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

public class CreditServiceTest {
    CreditService creditService;
    @Mock
    CreditDao creditDao;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        creditService = new CreditService(creditDao);
    }

    @Test
    public void testAdd(){
        Client c= new Client();
        c.setCode("code1");
        Credit credit = new Credit(5, LocalDate.now(), 500.0, c , 5000.05, "PENDING");
        when(creditService.saveCredit(credit)).thenReturn(Optional.of(credit));
        Optional<Credit> result = creditService.saveCredit(credit);
        assertTrue(result.isPresent());
        assertEquals(credit,result.get());
        verify(creditDao).save(credit);
    }

    @Test
    public void acceptCreditTest()
    {
        Client c= new Client();
        Credit credit = new Credit(5, LocalDate.now(), 500.0, c , 5000.05, "APPROVED");
        when(creditService.acceptCredit(credit)).thenReturn(Optional.of(credit));
        Optional<Credit> result = creditService.acceptCredit(credit);
        assertTrue(result.isPresent());
        assertEquals("APPROVED",result.get().getCreditEtat());
        assertEquals(credit.getCreditEtat(),result.get().getCreditEtat());
        verify(creditDao).update(credit);
    }
    @Test
    public void refuseCreditTest()
    {
        Client c= new Client();
        Credit credit = new Credit(5, LocalDate.now(), 500.0, c , 5000.05, "REFUSED");
        when(creditService.refuseCredit(credit)).thenReturn(Optional.of(credit));
        Optional<Credit> result = creditService.refuseCredit(credit);
        assertTrue(result.isPresent());
        assertEquals("REFUSED",result.get().getCreditEtat());
        assertEquals(credit.getCreditEtat(),result.get().getCreditEtat());
        verify(creditDao).update(credit);
    }

    @Test
    public void getall(){
        List<Credit> listdemande= new ArrayList<>();
        listdemande.add(new Credit());
        listdemande.add(new Credit());
        when(creditService.showAllCredit()).thenReturn(listdemande);
        List<Credit> result = creditService.showAllCredit();
        assertEquals(result.size(),2);
        verify(creditDao).showAll();
    }

    @Test
    public void findById(){
        Credit credit= new Credit();
        when(creditService.findByIdCredit("lcode")).thenReturn(Optional.of(credit));
        Optional<Credit> res = creditService.findByIdCredit("lcode");
        assertEquals(res.isPresent(),true);
        verify(creditDao).findById("lcode");
    }
}
