package com.qunawan.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qunawan.entity.Sequence;

@Repository
public class SequenceDaoImp implements SequenceDao{
	
	private SessionFactory sessionFacotry;
	
	@Resource(name="sessionFactory")
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		this.sessionFacotry = sessionFacotry;
	}

	public Session getSession(){
		return sessionFacotry.getCurrentSession();
	}
	
	@Override
	public Sequence getSeqByValue(String v) {
		// TODO Auto-generated method stub
		String hql = "FROM Sequence s WHERE s.value = ?";
		return (Sequence) getSession().createQuery(hql).setParameter(0, v).uniqueResult();
	}

	@Override
	public Sequence getSeqByKeyAndType(String key, String type) {
		// TODO Auto-generated method stub
		String hql = "FROM Sequence s WHERE s.keying = ? AND s.type = ?";
		return (Sequence) getSession().createQuery(hql).setParameter(0, key).setParameter(1, type).uniqueResult();
	}

	@Override
	public Sequence getSequenceById(int id) {
		// TODO Auto-generated method stub
		return (Sequence) getSession().get(Sequence.class, id);
	}
	
}
