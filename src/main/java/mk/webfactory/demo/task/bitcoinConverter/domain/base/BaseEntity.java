package mk.webfactory.demo.task.bitcoinConverter.domain.base;

import java.io.Serializable;
import java.util.Comparator;

public abstract class  BaseEntity<T extends  BaseEntity> implements Comparator<T>, Serializable {

    private Integer id;
    private String name;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compare(T t, T t1) {
        return t.getId() - t1.getId();
    }
}
