package com.qunawan.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.qunawan.dao.SequenceDao;
import com.qunawan.entity.Sequence;

@Service
public class SequenceServiceImp implements SequenceService{
	private SequenceDao sequenceDao;
	
	@Resource(name="sequenceDaoImp")
	public void setSequenceDao(SequenceDao sequenceDao) {
		this.sequenceDao = sequenceDao;
	}

	@Transactional
	public Sequence getSeqByValue(String v) {
		// TODO Auto-generated method stub
		return sequenceDao.getSeqByValue(v);
	}

	@Transactional
	public Sequence getSeqByKeyAndType(String key, String type) {
		// TODO Auto-generated method stub
		return sequenceDao.getSeqByKeyAndType(key, type);
	}

	@Transactional
	public Sequence getSequenceById(int id) {
		// TODO Auto-generated method stub
		return sequenceDao.getSequenceById(id);
	}
	
}
