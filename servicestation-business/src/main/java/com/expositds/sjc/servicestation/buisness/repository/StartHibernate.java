package com.expositds.sjc.servicestation.buisness.repository;

import java.util.GregorianCalendar;
import java.util.Map;

import org.hibernate.Session;

import com.expositds.sjc.servicestation.buisness.repository.entity.AffilateEntity;
import com.expositds.sjc.servicestation.buisness.repository.entity.OrderEntity;
import com.expositds.sjc.servicestation.buisness.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.buisness.repository.hibernate.HibernateUtil;

public class StartHibernate {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//SiteAggregatorEntity sa = new SiteAggregatorEntity();
		//SiteUserEntity su = new SiteUserEntity("Петя");
		//CredentialEntity cr = new CredentialEntity("petrovich", "petrovich");
		//PersonEntity psn = new PersonEntity("Петрович");
		//MechanicProfileEntity mpr = new MechanicProfileEntity();
		//StationEntity st = new StationEntity("Южная автосервисная станция", "south");
		//StationProfileEntity stpr = new StationProfileEntity();
		OrderEntity ord = new OrderEntity("Сильная вибрация при скорости больше 80 км//ч", new GregorianCalendar());
		//AffilateEntity afl = new AffilateEntity("altufievo");
		//AffilateProfileEntity afpr = new AffilateProfileEntity();
		//PartOrderEntity po = new PartOrderEntity();
		//PartEntity prt = new PartEntity("TRW-67904", "Тормозные колодки задние");
		//ServiceEntity srv = new ServiceEntity("ТС-3", "Замена передних тормозных колодок");
		//ClientNotificationEntity clnt = new ClientNotificationEntity("Выполнение заказа переносится на неопределённый срок. Ожидаем запчастей.");
		//SiteUserEntity su = (SiteUserEntity) session.get(SiteUserEntity.class, 1L);
		//CommentEntity cmt = new CommentEntity("Грамотный специалист. Рекомендую.", su, true);
		//MarkEntity mrk = new MarkEntity(4, su);
		
		//SiteAggregatorEntity sa = (SiteAggregatorEntity) session.get(SiteAggregatorEntity.class, 1L);
		//CredentialEntity cr = (CredentialEntity) session.get(CredentialEntity.class, 1L);
		//SiteUserEntity su = (SiteUserEntity) session.get(SiteUserEntity.class, 1L);
		//PersonEntity psn = (PersonEntity) session.get(PersonEntity.class, 1L);
		//MechanicProfileEntity mpr = (MechanicProfileEntity) session.get(MechanicProfileEntity.class, 1L);
		StationEntity st = (StationEntity) session.get(StationEntity.class, 1L);
		AffilateEntity afl = (AffilateEntity) session.get(AffilateEntity.class, 1L);
		//AffilateProfileEntity afpr = (AffilateProfileEntity) session.get(AffilateProfileEntity.class, 1L);
		//OrderEntity ord = (OrderEntity) session.get(OrderEntity.class, 1L);
		//ClientNotificationEntity clnt = (ClientNotificationEntity) session.get(ClientNotificationEntity.class, 1L);
		//PartEntity prt = (PartEntity) session.get(PartEntity.class, 1L);
		//ServiceEntity srv = (ServiceEntity) session.get(ServiceEntity.class, 1L);
		//PartOrderEntity ptodr = (PartOrderEntity) session.get(PartOrderEntity.class, 1L);
		//StationProfileEntity stpr = (StationProfileEntity) session.get(StationProfileEntity.class, 1L);
		//MechanicProfileEntity mpr = (MechanicProfileEntity) session.get(MechanicProfileEntity.class, 1L);
		
		//sa.getLogins().add("pit");
		//sa.getSiteUsers().put(cr, su);
		//sa.getMechanicPofiles().put(psn, mpr);
		//sa.getStationProfiles().put(st, stpr);
		//sa.getOrders().put(ord, st);
		//st.getAffilates().put(afl, afpr);
		Map<OrderEntity, AffilateEntity> orders = st.getOrders();
		orders.put(ord, afl);
		//st.getEmployees().put(psn, Position.MECHANIC);
		//st.getPersons().put(cr, psn);
		//st.getLogins().add("petrovich");
		//afl.getOrders().add(ord);
		//afl.getPartOrders().put(po, psn);
		//afl.getPersons().add(psn);
		//afl.getParts().put(prt, 33);
		//afl.getServices().put(srv, 15);
		//afpr.getRent().put(new GregorianCalendar(2015, 11, 1), 100);
		//ord.setNotification(clnt);
		//ord.getParts().put(prt, 2);
		//ord.getServices().add(srv);
		//ord.getOrderServicesPriceList().put(srv, 12);
		//ptodr.getParts().put(prt, 2);
		//stpr.getMarks().add(mrk);
		//mpr.getComments().add(cmt);
		//psn.getSalary().put(new GregorianCalendar(2015, 0, 22), 120);
		//su.getOrders().put(ord, st);
		
		//session.saveOrUpdate(prt);
		//session.saveOrUpdate(mpr);
		//session.saveOrUpdate(cr);
		session.save(ord);
		session.update(st);
		//session.saveOrUpdate(stpr);
		//session.saveOrUpdate(sa);
		
		session.getTransaction().commit();
		session.close();

	}

}
