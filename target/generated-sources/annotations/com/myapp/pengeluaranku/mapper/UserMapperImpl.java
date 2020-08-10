package com.myapp.pengeluaranku.mapper;

import com.myapp.pengeluaranku.domain.User;
import com.myapp.pengeluaranku.vo.UserReqVO;
import com.myapp.pengeluaranku.vo.UserResVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-10T08:02:05+0700",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 11.0.8 (Ubuntu)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResVO toVO(User model) {
        if ( model == null ) {
            return null;
        }

        UserResVO userResVO = new UserResVO();

        if ( model.getName() != null ) {
            userResVO.setName( model.getName() );
        }
        if ( model.getAddress() != null ) {
            userResVO.setAddress( model.getAddress() );
        }
        if ( model.getPhone() != null ) {
            userResVO.setPhone( model.getPhone() );
        }
        if ( model.getEmail() != null ) {
            userResVO.setEmail( model.getEmail() );
        }
        if ( model.getUuid() != null ) {
            userResVO.setUuid( model.getUuid() );
        }

        return userResVO;
    }

    @Override
    public User toModel(UserReqVO vo) {
        if ( vo == null ) {
            return null;
        }

        User user = new User();

        if ( vo.getName() != null ) {
            user.setName( vo.getName() );
        }
        if ( vo.getAddress() != null ) {
            user.setAddress( vo.getAddress() );
        }
        if ( vo.getPhone() != null ) {
            user.setPhone( vo.getPhone() );
        }
        if ( vo.getEmail() != null ) {
            user.setEmail( vo.getEmail() );
        }

        return user;
    }

    @Override
    public List<UserResVO> toVO(List<User> models) {
        if ( models == null ) {
            return null;
        }

        List<UserResVO> list = new ArrayList<UserResVO>( models.size() );
        for ( User user : models ) {
            list.add( toVO( user ) );
        }

        return list;
    }

    @Override
    public List<User> toModel(List<UserReqVO> vos) {
        if ( vos == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( vos.size() );
        for ( UserReqVO userReqVO : vos ) {
            list.add( toModel( userReqVO ) );
        }

        return list;
    }
}
