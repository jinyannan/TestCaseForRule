package gov.customs.jm.data;

// Generated Jul 8, 2015 9:23:16 AM by Hibernate Tools 3.4.0.CR1

/**
 * RuleSystem generated by hbm2java
 */
public class RuleSystem implements java.io.Serializable {

	private long id;
	private Long domainId;
	private String subcode;
	private String subname;

	public RuleSystem() {
	}

	public RuleSystem(long id) {
		this.id = id;
	}

	public RuleSystem(long id, Long domainId, String subcode, String subname) {
		this.id = id;
		this.domainId = domainId;
		this.subcode = subcode;
		this.subname = subname;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Long domainId) {
		this.domainId = domainId;
	}

	public String getSubcode() {
		return this.subcode;
	}

	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}

	public String getSubname() {
		return this.subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

}