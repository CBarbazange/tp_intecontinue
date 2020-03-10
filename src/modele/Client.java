package modele;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private String nom;

    @Basic
    private String prenom;

    @OneToOne
    @JoinColumn(name = "id_contrat")
    private Contrat contrat;
}
