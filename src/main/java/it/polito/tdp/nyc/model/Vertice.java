package it.polito.tdp.nyc.model;

import java.util.Objects;
import java.util.Set;

public class Vertice {
	String NTACode;
	Set<String> SSID;
	public Vertice(String nTACode, Set<String> sSID) {
		super();
		NTACode = nTACode;
		SSID = sSID;
	}
	public String getNTACode() {
		return NTACode;
	}
	public void setNTACode(String nTACode) {
		NTACode = nTACode;
	}
	public Set<String> getSSID() {
		return SSID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(NTACode, SSID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertice other = (Vertice) obj;
		return Objects.equals(NTACode, other.NTACode) && Objects.equals(SSID, other.SSID);
	}


	
 }
