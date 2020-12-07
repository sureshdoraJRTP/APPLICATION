package com.tcs.ies.dc.service;

import java.util.List;

import com.tcs.ies.dc.domain.DCCase;

public interface DCCaseService {

	public DCCase searchAppId(String id);
	public DCCase saveCase(DCCase dc);

}
