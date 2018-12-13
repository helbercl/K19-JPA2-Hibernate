package br.com.livrariak19.entitymodelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="tb_editora")
public class Editora {
    
 
    
    private static final String GENERATOR = "GeneratorPublishingHouse";

    @Id
    @SequenceGenerator(name = "GENERATOR",sequenceName = "sq_category", initialValue = 1, allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    @Column(name = "id_publishing_house")    
    private Integer id;
    
    // length tamanho do campo , nulllable possui valor nulo ou não,unique se pode ter valor repetido,
    // precision determina dígitos de um número decimal a serem armazenadas
    // scale determina o numero de casas decimais de um numero decimal
    @Column (name="name_publishing_house" , nullable=false,unique=true,length=80)
    @NotNull
    private String name;
    @Column (name="mail_publishing_house",  nullable=false,unique=true)
    @NotNull
    private String email;
    
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
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

}
