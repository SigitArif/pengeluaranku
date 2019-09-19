package com.myapp.pengeluaranku.mapper;

import java.util.List;

public interface BaseMapper<M, V> {
  V toVO(M model);
  M toModel(V vo);
  List<V> toListVO(List<M> models);
  List<M> toListModel(List<V> vos);
}