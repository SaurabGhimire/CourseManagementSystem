package com.cs544.project.adapter;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class AbstractGenericDTOConverter<D extends AbstractDto, E>
        implements GenericDTOConverter<D,E> {

    private final Class<D> dtoClass;
    private final Class<E> entityClass;

    public AbstractGenericDTOConverter(Class<D> dtoClass, Class<E> entityClass) {
        this.dtoClass = dtoClass;
        this.entityClass = entityClass;
    }

    @Override
    public E createFrom(D dto) {
        E entity = BeanUtils.instantiateClass(entityClass);
        updateEntity(entity, dto);
        return entity;
    }

    @Override
    public D createFrom(E entity) {
        D dto = BeanUtils.instantiateClass(dtoClass);
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public E updateEntity(E entity, D dto) {
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public List<D> createFromEntities(Collection<E> entities) {
        return entities.stream()
                .map(this::createFrom)
                .collect(Collectors.toList());
    }

    @Override
    public List<E> createFromDtos(Collection<D> dtos) {
        return dtos.stream()
                .map(this::createFrom)
                .collect(Collectors.toList());
    }
}
