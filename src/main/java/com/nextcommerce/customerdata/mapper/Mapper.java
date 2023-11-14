package com.nextcommerce.customerdata.mapper;

import java.util.List;

public interface Mapper<D,M> {
    D toDto(M m);
    M toModel(D d);
    Iterable<D> toDtos(Iterable<M> m);
    Iterable<M> toModels(Iterable<D> d);

}
