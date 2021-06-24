package mk.webfactory.demo.task.bitcoinConverter.service;

import mk.webfactory.demo.task.bitcoinConverter.domain.base.BaseEntity;

import java.util.List;

public interface GenericDomainService<T extends BaseEntity> {

    void save(T t);
    T findById(Integer id);
    List<T>  findAll();
    void delete(T t);

}
