package com.myapp.pengeluaranku.validator;

import static org.junit.Assert.assertEquals;

import com.myapp.pengeluaranku.domain.Pengeluaran;
import com.myapp.pengeluaranku.repository.PengeluaranRepository;
import com.myapp.pengeluaranku.vo.PengeluaranRequestVO;

import org.junit.After;
import org.junit.Before;
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

    PengeluaranRequestVO vo = new PengeluaranRequestVO();
    @After
    public void init(){
        vo = new PengeluaranRequestVO();
    }

    // 1. Name is Null
    @Test
    public void nameIsNull(){
        final PengeluaranRequestVO vo = new PengeluaranRequestVO();
        final String expected = "Name can't be empty";
        final String actual = pengeluaranValidator.validateAdd(vo);
        assertEquals(expected, actual);
    }

    // 2. Name is Empty
    @Test
    public void nameIsEmpty() {
        final String name = "";
        final PengeluaranRequestVO vo = new PengeluaranRequestVO();
        vo.setName(name);
        final String expected = "Name can't be empty";
        final String actual = pengeluaranValidator.validateAdd(vo);
        assertEquals(expected, actual);
    }

    // 3. Name duplicate
    @Test
    public void nameDuplicate() {
        final PengeluaranRequestVO vo = new PengeluaranRequestVO();
        vo.setName("Makan Sate");
        vo.setCode("M");
        vo.setType("K");
        final Pengeluaran model = new Pengeluaran();
        model.setName(vo.getName());
        BDDMockito.given(pengeluaranRepository.findByName(vo.getName())).willReturn(model);

        final String expected = "Name already exist";
        final String actual = pengeluaranValidator.validateAdd(vo);
        assertEquals(expected, actual);
    }

    // 4. Type is null
    @Test
    public void typeIsNull() {
        final PengeluaranRequestVO vo = new PengeluaranRequestVO();
        vo.setName("Makan Sate");
        final String expected = "Type can't be empty";
        final String actual = pengeluaranValidator.validateAdd(vo);
        assertEquals(expected, actual);
    }

    // 5. Type is empty
    @Test
    public void typeIsEmpty() {
        final PengeluaranRequestVO vo = new PengeluaranRequestVO();
        vo.setName("Makan Sate");
        vo.setType("");
        final String expected = "Type can't be empty";
        final String actual = pengeluaranValidator.validateAdd(vo);
        assertEquals(expected, actual);
    }

    // 6. Code is null
    @Test
    public void codeIsNull() {
        final PengeluaranRequestVO vo = new PengeluaranRequestVO();
        vo.setName("Makan Sate");
        vo.setType("K");
        final String expected = "Code can't be empty";
        final String actual = pengeluaranValidator.validateAdd(vo);
        assertEquals(expected, actual);
    }

    // 7. Code is empty
    @Test
    public void codeIsEmpty() {
        final PengeluaranRequestVO vo = new PengeluaranRequestVO();
        vo.setName("Makan Sate");
        vo.setType("K");
        vo.setCode("");
        final String expected = "Code can't be empty";
        final String actual = pengeluaranValidator.validateAdd(vo);
        assertEquals(expected, actual);
    }

    // Edit
    // 1. edit uuid is empty
    @Test
    public void editUuidIsEmpty() {
        final String expected = "Uuid can't be empty";
        final String actual = pengeluaranValidator.validateEditBadRequest(null, "");
        assertEquals(expected, actual);

    }

    // 2. edit uuid is null
    @Test
    public void editUuidIsNull() {
        final String expected = "Uuid can't be empty";
        final String actual = pengeluaranValidator.validateEditBadRequest(null, null);
        assertEquals(expected, actual);

    }

    // 3. edit name is empty
    @Test
    public void editNameIsEmpty() {
        vo.setName("");
        final String expected = "Name can't be empty";
        final String actual = pengeluaranValidator.validateEditBadRequest(vo, "uuid");
        assertEquals(expected, actual);

    }

    // 4. edit name is null
    @Test
    public void editNameIsNull() {
        
        final String expected = "Name can't be empty";
        final String actual = pengeluaranValidator.validateEditBadRequest(vo, "uuid");
        assertEquals(expected, actual);

    }

    // 5. edit code is null
    @Test
    public void editCodeIsNull() {
        vo.setName("name");
        final String expected = "Code can't be empty";
        final String actual = pengeluaranValidator.validateEditBadRequest(vo, "uuid");
        assertEquals(expected, actual);

    }

    // 6. edit code is empty
    @Test
    public void editCodeIsEmpty() {
        vo.setName("name");
        vo.setCode("");
        final String expected = "Code can't be empty";
        final String actual = pengeluaranValidator.validateEditBadRequest(vo, "uuid");
        assertEquals(expected, actual);

    }

    // 7. edit type is empty
    @Test
    public void editTypeIsEmpty() {
        vo.setName("name");
        vo.setCode("code");
        vo.setType("");
        final String expected = "Type can't be empty";
        final String actual = pengeluaranValidator.validateEditBadRequest(vo, "uuid");
        assertEquals(expected, actual);

    }

    // 8. edit type is empty
    @Test
    public void editTypeIsNull() {
        vo.setName("name");
        vo.setCode("code");
        final String expected = "Type can't be empty";
        final String actual = pengeluaranValidator.validateEditBadRequest(vo, "uuid");
        assertEquals(expected, actual);

    }

    // 9. edit uuid not found
    @Test
    public void editUuidNotFound(){
        String uuid ="uuid";
        BDDMockito.given(pengeluaranRepository.findByUuid(uuid)).willReturn(null);
        String expected ="Pengeluaran Not Found";
        String actual = pengeluaranValidator.validateEditNotFound(vo, uuid);
        assertEquals(expected, actual);
    }






}