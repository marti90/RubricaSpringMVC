package it.dragon.dao;

import it.dragon.HibernateUtility;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.dragon.Rubrica;

public class RubricaDAO {
	
	public Rubrica readRubricaConId(long r_id){
		
		Rubrica r = null;
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
	        tx=session.getTransaction();
	        tx.begin();
	        
	        r=session.get(Rubrica.class, r_id);
	        
	        tx.commit(); 
            
	    }catch(Exception ex){
	         tx.rollback();

	    }finally{
	         session.close();
	    }
	    
		return r;
		
	}
		

	public Rubrica readRubricaConNome(String nome){
		
        Rubrica r = null;
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
	
		try{
	        tx=session.getTransaction();
            tx.begin();
	        
			Query query = session.createQuery("from RubricaModel where nome =:nomeInserito");
			query.setString("nomeInserito",nome);
	        r =  (Rubrica) query.uniqueResult();
	       
	        tx.commit(); 
            
	    }catch(Exception ex){
	         tx.rollback();

	    }finally{
	         session.close();
	    }
	    return r;
		
	}
	
	public boolean createRubrica(Rubrica r){
	
		boolean res = false;
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
		       tx=session.getTransaction();
		       tx.begin();
		        
		       session.persist(r);
		        
		       tx.commit(); 
		       res = true;
	            
	     }catch(Exception ex){
		       tx.rollback();

	     }finally{
		       session.close();
	     }
		
		return res;
	}
	
    public boolean deleteRubrica(Rubrica r){
    	
    	boolean res = false;
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
		       tx=session.getTransaction();
		       tx.begin();
		        
		       session.delete(r);
		        
		       tx.commit(); 
		       res = true;
	            
	     }catch(Exception ex){
		       tx.rollback();

	     }finally{
		       session.close();
	     }
		
		return res;
    }
    
    public boolean aggiornaRubrica(Rubrica r){
    	boolean res = false;
		Session session=HibernateUtility.openSession();
		Transaction tx=null;
		
		try{
		       tx=session.getTransaction();
		       tx.begin();
		        
		       session.update(r);
		        
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
