package br.com.crescer.pojos;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PESSOA")
    @SequenceGenerator(name = "SEQ_PESSOA", sequenceName = "SEQ_PESSOA", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_PESSOA")
    private Long id;
    @Basic(optional = false)
    @Column(name = "NM_PESSOA")
    private String nome;
    @Temporal(value = TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "DT_NASCIMENTO_PESSOA")
    private Date nascimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
    
    public Pessoa(){}

    public Pessoa(String nome, Date nascimento) {
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public Pessoa(Long id, String nome, Date nascimento) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
    }
    
    
    
    
}