package com.myapp.pengeluaranku.validator;

import static org.junit.Assert.assertEquals;

import com.myapp.pengeluaranku.repository.PengeluaranRepository;
import com.myapp.pengeluaranku.vo.TransaksiReqVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransaksiValidatorTest{
@Autowired
TransaksiValidator transaksiValidator;
@MockBean
PengeluaranRepository pengeluaranRepository;
    @Test
    public void nameIsEmpty(){
        TransaksiReqVO vo = new TransaksiReqVO();
        vo.setAmount(2000);
        vo.setDetailTransaksi("detailTransaksi");
        String actual = transaksiValidator.validateTransaksi(vo);
        String expected = "Name can't be empty";
        assertEquals(actual, expected);
}
    @Test
    public void amountIsEmpty(){
        TransaksiReqVO vo = new TransaksiReqVO();
        vo.setName("Makan");
        vo.setDetailTransaksi("detailTransaksi");
        String actual = transaksiValidator.validateTransaksi(vo);
        String expected = "Amount can't be empty";
        assertEquals(actual, expected);
    }
    @Test
    public void nameNotFound(){
        TransaksiReqVO vo = new TransaksiReqVO();
        String name = "RandomMakanzdaeg";
        vo.setName(name);
        vo.setAmount(2000);
        vo.setDetailTransaksi("detailTransaksi");
        String actual = transaksiValidator.validateTransaksi(vo);
        BDDMockito.given(pengeluaranRepository.findByName(name)).willReturn(null);
        String expected = "Pengeluaran not found";
        assertEquals(actual, expected);
    }
}