package com.financing.Interface_service;

import java.util.List;

import com.financing.bean.Award_records;

public interface IN_award_records_service {
void  save(Award_records award_records);
List<Award_records> listAward_records();
}
