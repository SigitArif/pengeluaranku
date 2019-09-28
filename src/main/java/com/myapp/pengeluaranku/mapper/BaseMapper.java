package com.myapp.pengeluaranku.mapper;

import java.util.List;

public interface BaseMapper<M, V> {


  V toVO(M model);
  M toModel(V vo);
  List<V> toVO(List<M> models);
  List<M> toModel(List<V> vos);

}