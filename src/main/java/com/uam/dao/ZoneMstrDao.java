package com.uam.dao;

import java.util.List;

import com.uam.entity.ZoneMstr;

public interface ZoneMstrDao {

	public List<ZoneMstr> fetchZoneByCircleMstrId(int circleMstrId);
}
