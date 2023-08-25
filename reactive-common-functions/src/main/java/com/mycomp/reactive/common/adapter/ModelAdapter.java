package com.mycomp.reactive.common.adapter;

public interface ModelAdapter<E, M> {

    E toEntityMinimal(M model);
    E toEntity(M model);
    M toModel(E entity);
}
