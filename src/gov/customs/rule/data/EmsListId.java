package gov.customs.rule.data;

// Generated Aug 6, 2015 1:59:26 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * EmsListId generated by hbm2java
 */
public class EmsListId implements java.io.Serializable {

	private String emsNo;
	private String GType;
	private BigDecimal GNo;
	private BigDecimal modifyTimes;

	public EmsListId() {
	}

	public EmsListId(String emsNo, String GType, BigDecimal GNo,
			BigDecimal modifyTimes) {
		this.emsNo = emsNo;
		this.GType = GType;
		this.GNo = GNo;
		this.modifyTimes = modifyTimes;
	}

	public String getEmsNo() {
		return this.emsNo;
	}

	public void setEmsNo(String emsNo) {
		this.emsNo = emsNo;
	}

	public String getGType() {
		return this.GType;
	}

	public void setGType(String GType) {
		this.GType = GType;
	}

	public BigDecimal getGNo() {
		return this.GNo;
	}

	public void setGNo(BigDecimal GNo) {
		this.GNo = GNo;
	}

	public BigDecimal getModifyTimes() {
		return this.modifyTimes;
	}

	public void setModifyTimes(BigDecimal modifyTimes) {
		this.modifyTimes = modifyTimes;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EmsListId))
			return false;
		EmsListId castOther = (EmsListId) other;

		return ((this.getEmsNo() == castOther.getEmsNo()) || (this.getEmsNo() != null
				&& castOther.getEmsNo() != null && this.getEmsNo().equals(
				castOther.getEmsNo())))
				&& ((this.getGType() == castOther.getGType()) || (this
						.getGType() != null && castOther.getGType() != null && this
						.getGType().equals(castOther.getGType())))
				&& ((this.getGNo() == castOther.getGNo()) || (this.getGNo() != null
						&& castOther.getGNo() != null && this.getGNo().equals(
						castOther.getGNo())))
				&& ((this.getModifyTimes() == castOther.getModifyTimes()) || (this
						.getModifyTimes() != null
						&& castOther.getModifyTimes() != null && this
						.getModifyTimes().equals(castOther.getModifyTimes())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getEmsNo() == null ? 0 : this.getEmsNo().hashCode());
		result = 37 * result
				+ (getGType() == null ? 0 : this.getGType().hashCode());
		result = 37 * result
				+ (getGNo() == null ? 0 : this.getGNo().hashCode());
		result = 37
				* result
				+ (getModifyTimes() == null ? 0 : this.getModifyTimes()
						.hashCode());
		return result;
	}

}
