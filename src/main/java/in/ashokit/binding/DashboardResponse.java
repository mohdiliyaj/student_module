package in.ashokit.binding;

public class DashboardResponse {
	private Integer totalAttempts;
	private Long passedAttempts;
	private Long failedAttempts;
	private Double overAllPercentage;
	
	public Integer getTotalAttempts() {
		return totalAttempts;
	}
	public void setTotalAttempts(Integer totalAttempts) {
		this.totalAttempts = totalAttempts;
	}
	public Long getPassedAttempts() {
		return passedAttempts;
	}
	public void setPassedAttempts(Long passedAttempts) {
		this.passedAttempts = passedAttempts;
	}
	public Long getFailedAttempts() {
		return failedAttempts;
	}
	public void setFailedAttempts(Long failedAttempts) {
		this.failedAttempts = failedAttempts;
	}
	public Double getOverAllPercentage() {
		return overAllPercentage;
	}
	public void setOverAllPercentage(Double overAllPercentage) {
		this.overAllPercentage = overAllPercentage;
	}
}
