package com.myapp.pengeluaranku.mapper;

import com.myapp.pengeluaranku.domain.Pengeluaran;
import com.myapp.pengeluaranku.vo.PengeluaranRequestVO;
import com.myapp.pengeluaranku.vo.PengeluaranResponseVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-28T16:24:34+0700",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class PengeluaranMapperImpl implements PengeluaranMapper {

    @Override
    public PengeluaranResponseVO toVO(Pengeluaran model) {
        if ( model == null ) {
            return null;
        }

        PengeluaranResponseVO pengeluaranResponseVO = new PengeluaranResponseVO();

        if ( model.getName() != null ) {
            pengeluaranResponseVO.setName( model.getName() );
        }
        if ( model.getUuid() != null ) {
            pengeluaranResponseVO.setUuid( model.getUuid() );
        }
        if ( model.getCode() != null ) {
            pengeluaranResponseVO.setCode( model.getCode() );
        }
        if ( model.getType() != null ) {
            pengeluaranResponseVO.setType( model.getType() );
        }

        return pengeluaranResponseVO;
    }

    @Override
    public Pengeluaran toModel(PengeluaranRequestVO vo) {
        if ( vo == null ) {
            return null;
        }

        Pengeluaran pengeluaran = new Pengeluaran();

        if ( vo.getName() != null ) {
            pengeluaran.setName( vo.getName() );
        }
        if ( vo.getType() != null ) {
            pengeluaran.setType( vo.getType() );
        }
        if ( vo.getCode() != null ) {
            pengeluaran.setCode( vo.getCode() );
        }

        return pengeluaran;
    }

    @Override
    public List<PengeluaranResponseVO> toVO(List<Pengeluaran> models) {
        if ( models == null ) {
            return null;
        }

        List<PengeluaranResponseVO> list = new ArrayList<PengeluaranResponseVO>( models.size() );
        for ( Pengeluaran pengeluaran : models ) {
            list.add( toVO( pengeluaran ) );
        }

        return list;
    }

    @Override
    public List<Pengeluaran> toModel(List<PengeluaranRequestVO> vos) {
        if ( vos == null ) {
            return null;
        }

        List<Pengeluaran> list = new ArrayList<Pengeluaran>( vos.size() );
        for ( PengeluaranRequestVO pengeluaranRequestVO : vos ) {
            list.add( toModel( pengeluaranRequestVO ) );
        }

        return list;
    }
}
