package models;

public class FollowingTraining {
//DATAMEBERS	
	private int userID;
	private int traingSessionId;
	private boolean isApproved;
	private boolean isCancelled;
	private boolean isDeclined;
/*
SIGNED UP : isApproved=true, isCancelled=false, isDeclined=false || isApproved=true, isCancelled=true, isDeclined=true
AWAITING CONFIRMATION: isApproved=false, isCancelled=false, isDeclined=false || isApproved=true, isCancelled=true, isDeclined=false
DECLINED: isApproved=false, isCancelled=false, isDeclined=true
SIGNED OUT: isApproved=false, isCancelled=true, isDeclined=false
*/
	
//METHODS
	public FollowingTraining(int userID, int traingSessionId, boolean isApproved, boolean isCancelled,
			boolean isDeclined) {
		super();
		this.userID = userID;
		this.traingSessionId = traingSessionId;
		this.isApproved = isApproved;
		this.isCancelled = isCancelled;
		this.isDeclined = isDeclined;
	}
	public FollowingTraining() {}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getTraingSessionId() {
		return traingSessionId;
	}
	public void setTraingSessionId(int traingSessionId) {
		this.traingSessionId = traingSessionId;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	public boolean isCancelled() {
		return isCancelled;
	}
	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}
	public boolean isDeclined() {
		return isDeclined;
	}
	public void setDeclined(boolean isDeclined) {
		this.isDeclined = isDeclined;
	}
	
	

}
