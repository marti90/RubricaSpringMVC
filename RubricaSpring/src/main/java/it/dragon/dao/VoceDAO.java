package it.dragon.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.dragon.HibernateUtility;
import it.dragon.Rubrica;
import it.dragon.Voce;
public class VoceDAO {
	
	public boolean createVoce(Voce v){
		
		boolean res = false;
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
		       tx=session.getTransaction();
		       tx.begin();
		        
		       session.persist(v);
		        
		       tx.commit(); 
		       res = true;
	            
	     }catch(Exception ex){
		       tx.rollback();

	     }finally{
		       session.close();
	     }
		
		return res;
	}
	
	public Voce readVoceConId(long id_voce){
		
		Voce v = null;
		
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
		       tx=session.getTransaction();
		       tx.begin();
		        
		       v=session.get(Voce.class,  id_voce);
		        
		       tx.commit(); 
		       
	            
	     }catch(Exception ex){
		       tx.rollback();

	     }finally{
		       session.close();
	     }
		
		return v;
	}
	
	public Voce readVoce(String nome, String cognome, long id_rubrica)
	{
		Voce v=null;
		Session session =HibernateUtility.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		Query query=session.createQuery("from VoceModel where RubricaModel_id_rubrica=:idInserito and nome=:nomeInserito and cognome=:cognomeInserito");
		query.setLong("idInserito", id_rubrica);
		query.setString("nomeInserito", nome);
		query.setString("cognomeInserito", cognome);
		v=(Voce) query.uniqueResult();
		 
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return v;
    }
	
	public boolean aggiornaVoce(Voce v){
		
		boolean res = false;
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
		       tx=session.getTransaction();
		       tx.begin();
		        
		       session.update(v);
		        
		       tx.commit(); 
		       res = true;
	            
	     }catch(Exception ex){
		       tx.rollback();

	     }finally{
		       session.close();
	     }
		
		return res;
	}
	
	public List<Voce> getVociPerUnaRubrica(String nome){
		
		Rubrica r = null;
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
	        tx=session.getTransaction();
	        tx.begin();
	        
	        Query query = session.createQuery("from RubricaModel where nome =:nomeInserito");
	        query.setString("nomeInserito", nome);
	        r = (Rubrica) query.uniqueResult();
	        
	        tx.commit(); 
            
	    }catch(Exception ex){
	         tx.rollback();

	    }finally{
	         session.close();
	    }
	    
		return r.getListaVoci();
		
	}
	
    public boolean deleteVoce(Voce v){
    	
    	boolean res = false;
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
		       tx=session.getTransaction();
		       tx.begin();
		        
		       session.delete(v);
		        
		       tx.commit(); 
		       res = true;
	            
	     }catch(Exception ex){
		       tx.rollback();

	     }finally{
		       session.close();
	     }
		
		return res;
    }

}
