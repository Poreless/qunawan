package com.qunawan.dao;

import com.qunawan.entity.Sequence;

public interface SequenceDao {
	public Sequence getSeqByValue(String v);
	public Sequence getSeqByKeyAndType(String key, String type);
	public Sequence getSequenceById(int id);
}
