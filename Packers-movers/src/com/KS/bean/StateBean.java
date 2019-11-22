package com.KS.bean;

public class StateBean {
	private String stateId;
	private String stateName;
	public StateBean()
	{
		
	}
	
	StateBean(String stateId,String stateName)
	{
		this.stateId=stateId;
		this.stateName=stateName;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return stateId+" "+stateName;
	}
}
