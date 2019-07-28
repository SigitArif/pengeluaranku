package com.myapp.pengeluaranku.validator;

import static org.junit.Assert.assertEquals;

import com.myapp.pengeluaranku.domain.Pengeluaran;
import com.myapp.pengeluaranku.repository.PengeluaranRepository;
import com.myapp.pengeluaranku.vo.PengeluaranRequestVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PengeluaranValidatorTests{
    @Autowired
    PengeluaranValidator pengeluaranValidator;
    @MockBean
    PengeluaranRepository pengeluaranRepository;
    // 1. Name is Null
    @Test
    public void nameIsNull(){
    PengeluaranRequestVO vo = new PengeluaranRequestVO();
    String expected = "Name can't be empty";
    String actual = pengeluaranValidator.validateAdd(vo);
    assertEquals(expected, actual);
}
    // 2. Name is Empty
    @Test
    public void nameIsEmpty(){
    String name = "";
    PengeluaranRequestVO vo = new PengeluaranRequestVO();
    vo.setName(name);
    String expected = "Name can't be empty";
    String actual = pengeluaranValidator.validateAdd(vo);
    assertEquals(expected, actual);
    }

    // 3. Name duplicate
    @Test
    public void nameDuplicate(){
        PengeluaranRequestVO vo = new PengeluaranRequestVO();
        vo.setName("Makan Sate");
        vo.setCode("M");
        vo.setType("K");
        Pengeluaran model = new Pengeluaran();
        model.setName(vo.getName());
        BDDMockito.given(pengeluaranRepository.findByName(vo.getName()))
		.willReturn(model);
        
        String expected = "Name already exist";
        String actual = pengeluaranValidator.validateAdd(vo);
        assertEquals(expected, actual);
    }
    // 4. Type is null
    @Test
    public void typeIsNull(){
        PengeluaranRequestVO vo = new PengeluaranRequestVO();
        vo.setName("Makan Sate");
        String expected = "Type can't be empty";
        String actual = pengeluaranValidator.validateAdd(vo);
        assertEquals(expected, actual);
    }
    // 5. Type is empty
    @Test
    public void typeIsEmpty(){
        PengeluaranRequestVO vo = new PengeluaranRequestVO();
        vo.setName("Makan Sate");
        vo.setType("");
        String expected = "Type can't be empty";
        String actual = pengeluaranValidator.validateAdd(vo);
        assertEquals(expected, actual);
    }
    // 6. Code is null
    @Test
    public void codeIsNull(){
        PengeluaranRequestVO vo = new PengeluaranRequestVO();
        vo.setName("Makan Sate");
        vo.setType("K");
        String expected = "Code can't be empty";
        String actual = pengeluaranValidator.validateAdd(vo);
        assertEquals(expected, actual);
    }
    // 7. Code is empty
    @Test
    public void codeIsEmpty(){
        PengeluaranRequestVO vo = new PengeluaranRequestVO();
        vo.setName("Makan Sate");
        vo.setType("K");
        vo.setCode("");
        String expected = "Code can't be empty";
        String actual = pengeluaranValidator.validateAdd(vo);
        assertEquals(expected, actual);
    }


}