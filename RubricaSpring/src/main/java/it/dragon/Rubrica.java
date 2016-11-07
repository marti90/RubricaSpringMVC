package it.dragon;

import java.util.ArrayList;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
public class Rubrica {
	
	private String nome="";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_rubrica;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="rubrica",cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private List<Voce> listaVoci = new ArrayList<Voce>();
	
	public Rubrica(){
		
	}
	
	public Rubrica(String nome) {
	
		this.setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getId_rubrica() {
		return id_rubrica;
	}

	public void setId_rubrica(long id_rubrica) {
		this.id_rubrica = id_rubrica;
	}
	

	public List<Voce> getListaVoci() {
		return listaVoci;
	}

	public void setListaVoci(List<Voce> listaVoci) {
		this.listaVoci = listaVoci;
	}
	
	public void addVoce(Voce v){
		this.listaVoci.add(v);
	}
	
}