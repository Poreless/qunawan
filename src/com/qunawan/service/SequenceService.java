package com.qunawan.service;

import com.qunawan.entity.Sequence;

public interface SequenceService {
	public Sequence getSeqByValue(String v);
	public Sequence getSeqByKeyAndType(String key, String type);
	public Sequence getSequenceById(int id);
}
