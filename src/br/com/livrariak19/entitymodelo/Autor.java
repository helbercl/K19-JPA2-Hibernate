package br.com.livrariak19.entitymodelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

import sun.nio.cs.Surrogate.Generator;

@Entity
@Table(name="tb_autor")
public class Autor {
    @Id
    @GeneratedValue
    @Column(name="id_author")
    private Long id;
    @Column(name="name_author")
    @NotNull
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
