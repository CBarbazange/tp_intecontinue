package modele;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_contrat;

    @Basic
    private float marge_contract;

    @Basic
    private Date date_signature;

}
