package com.hrms.hrms.adapters;

import java.rmi.RemoteException;



import com.hrms.hrms.entities.concretes.Candidates;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;


public class MernisAdapter{
	
	
	public boolean TCKontrol(Candidates candidate) {
		
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
