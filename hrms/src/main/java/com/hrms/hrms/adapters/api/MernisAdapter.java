package com.hrms.hrms.adapters.api;
import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import com.hrms.hrms.adapters.service.VerifyApiService;
import com.hrms.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisAdapter implements VerifyApiService<Candidate>{
	

	@Override
	public boolean ApiControl(Candidate candidate) {
		KPSPublicSoapProxy kpsPublic;
		try {
			kpsPublic = new KPSPublicSoapProxy();
			boolean durum = kpsPublic.TCKimlikNoDogrula(
					Long.parseLong(candidate.getNationalIdentity()), 
							candidate.getName().toUpperCase(), 
							candidate.getSurname().toUpperCase(), 
							Integer.parseInt(candidate.getBirth_year()));
			return durum;
		} catch (RemoteException | NumberFormatException e1) {
			e1.printStackTrace();
		}
			return false;
	}

}
