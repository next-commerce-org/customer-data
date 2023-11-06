package com.nextcommerce.customerdata.mapper;

import java.util.List;

public interface Mapper<D,M> {
    D toDto(M m);
    M toModel(D d);
    List<D> toDtos(List<M> m);
    List<M> toModels(List<D> d);

}
