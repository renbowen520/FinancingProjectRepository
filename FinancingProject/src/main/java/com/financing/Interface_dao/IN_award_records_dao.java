package com.financing.Interface_dao;

import java.util.List;

import com.financing.bean.Award_records;

public interface IN_award_records_dao {
	void save(Award_records award_records);
	List<Award_records> listaward_records();
}
