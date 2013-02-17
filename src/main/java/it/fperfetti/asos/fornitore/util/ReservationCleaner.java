package it.fperfetti.asos.fornitore.util;

import it.fperfetti.asos.fornitore.model.Detail;
import it.fperfetti.asos.fornitore.model.Event;
import it.fperfetti.asos.fornitore.model.Order;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReservationCleaner implements Runnable {

	private static ReservationCleaner instance;
	
	protected ReservationCleaner(){}
	
	public static ReservationCleaner getInstance(){
		if(instance==null){ instance = new ReservationCleaner(); }
		return instance;
	}
	
	@Override
	public void run() {
		System.out.println("Cleaning");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Order> orders = session.createQuery(
					"from Order as order where order.confimated = :confirmated")
					.setBoolean("confirmated", false)
					.list();
			System.out.println("checking");
			for(Order o: orders){
				System.out.println("validando oggetto " + o.getId());
				if(!o.isValidOrder()){
					System.out.println("oggetto non più valido");
					/* Ripristino i biglietti*/
					for(Detail d: o.getDetails()){							
						Event e = d.getEvent();
						System.out.println("aggiorno evento " + e.getTitle());
						int quantity = d.getQuantity();
						e.setAvailability(e.getAvailability()+quantity);
						session.update(e);
						System.out.println("elimino dettaglio " + d.getId());
						session.delete(d);
					}
					System.out.println("elimino ordine " + o.getId());
					session.delete(o);
				}
			}
			tx.commit();
		}
		catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}	
	}

}
