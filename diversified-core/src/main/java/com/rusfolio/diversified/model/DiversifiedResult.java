package com.rusfolio.diversified.model;


public class DiversifiedResult {

	private DiversifiedResultType result;

	public DiversifiedResultType getResult() {
		return result;
	}
	
	public enum DiversifiedResultType{
		NOT_DIVERSIFIED
	}

	public void setResult(DiversifiedResultType resultType) {
		this.result = resultType;
	}

}
