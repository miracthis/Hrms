package com.hrms.hrms.adapters;
import java.rmi.RemoteException;
import com.hrms.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;


public class MernisAdapter{
	
	
	public boolean TCKontrol(Candidate candidate) {
		
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
