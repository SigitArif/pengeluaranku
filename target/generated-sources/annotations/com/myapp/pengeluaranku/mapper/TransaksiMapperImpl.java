package com.myapp.pengeluaranku.mapper;

import com.myapp.pengeluaranku.domain.Transaksi;
import com.myapp.pengeluaranku.vo.TransaksiReqVO;
import com.myapp.pengeluaranku.vo.TransaksiResVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-21T13:28:59+0700",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class TransaksiMapperImpl implements TransaksiMapper {

    @Override
    public TransaksiResVO toVO(Transaksi model) {
        if ( model == null ) {
            return null;
        }

        TransaksiResVO transaksiResVO = new TransaksiResVO();

        if ( model.getUuid() != null ) {
            transaksiResVO.setUuid( model.getUuid() );
        }
        if ( model.getAmount() != null ) {
            transaksiResVO.setAmount( model.getAmount() );
        }
        if ( model.getDetailTransaksi() != null ) {
            transaksiResVO.setDetailTransaksi( model.getDetailTransaksi() );
        }

        return transaksiResVO;
    }

    @Override
    public Transaksi toModel(TransaksiReqVO vo) {
        if ( vo == null ) {
            return null;
        }

        Transaksi transaksi = new Transaksi();

        if ( vo.getAmount() != null ) {
            transaksi.setAmount( vo.getAmount() );
        }
        if ( vo.getDetailTransaksi() != null ) {
            transaksi.setDetailTransaksi( vo.getDetailTransaksi() );
        }

        return transaksi;
    }

    @Override
    public List<TransaksiResVO> toVO(List<Transaksi> models) {
        if ( models == null ) {
            return null;
        }

        List<TransaksiResVO> list = new ArrayList<TransaksiResVO>( models.size() );
        for ( Transaksi transaksi : models ) {
            list.add( toVO( transaksi ) );
        }

        return list;
    }

    @Override
    public List<Transaksi> toModel(List<TransaksiReqVO> vos) {
        if ( vos == null ) {
            return null;
        }

        List<Transaksi> list = new ArrayList<Transaksi>( vos.size() );
        for ( TransaksiReqVO transaksiReqVO : vos ) {
            list.add( toModel( transaksiReqVO ) );
        }

        return list;
    }
}
