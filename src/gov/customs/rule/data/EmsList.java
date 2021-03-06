package gov.customs.rule.data;

// Generated Aug 6, 2015 1:59:26 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * EmsList generated by hbm2java
 */
public class EmsList implements java.io.Serializable {

	private EmsListId id;
	private String copGNo;
	private String codeTs;
	private String classMark;
	private String GName;
	private String GModel;
	private String unit;
	private String unit1;
	private String unit2;
	private String countryCode;
	private String sourceMark;
	private BigDecimal decPrice;
	private String curr;
	private BigDecimal decPriceRmb;
	private BigDecimal factor1;
	private BigDecimal factor2;
	private BigDecimal factorWt;
	private BigDecimal factorRate;
	private BigDecimal qty;
	private BigDecimal maxQty;
	private BigDecimal firstQty;
	private String IEType;
	private String useType;
	private String note1;
	private String note2;
	private String note;
	private String modifyMark;
	private String GMerge;
	private String GTrade;
	private String qtyMark;
	private BigDecimal incAmount;
	private BigDecimal incQty;
	private BigDecimal incWt;
	private BigDecimal cutAmount;
	private BigDecimal cutQty;
	private BigDecimal cutWt;
	private BigDecimal cmAmount;
	private BigDecimal cmQty;
	private BigDecimal cmWt;
	private BigDecimal clrIncQty;
	private BigDecimal clrCutQty;
	private String dutyMode;
	private BigDecimal dutyRate;
	private BigDecimal chkPrice;
	private String processMark;
	private String entryId;
	private Date limitDate;
	private String etlMark;
	private BigDecimal usdPrice;
	private BigDecimal apprAmt;

	public EmsList() {
	}

	public EmsList(EmsListId id) {
		this.id = id;
	}

	public EmsList(EmsListId id, String copGNo, String codeTs,
			String classMark, String GName, String GModel, String unit,
			String unit1, String unit2, String countryCode, String sourceMark,
			BigDecimal decPrice, String curr, BigDecimal decPriceRmb,
			BigDecimal factor1, BigDecimal factor2, BigDecimal factorWt,
			BigDecimal factorRate, BigDecimal qty, BigDecimal maxQty,
			BigDecimal firstQty, String IEType, String useType, String note1,
			String note2, String note, String modifyMark, String GMerge,
			String GTrade, String qtyMark, BigDecimal incAmount,
			BigDecimal incQty, BigDecimal incWt, BigDecimal cutAmount,
			BigDecimal cutQty, BigDecimal cutWt, BigDecimal cmAmount,
			BigDecimal cmQty, BigDecimal cmWt, BigDecimal clrIncQty,
			BigDecimal clrCutQty, String dutyMode, BigDecimal dutyRate,
			BigDecimal chkPrice, String processMark, String entryId,
			Date limitDate, String etlMark, BigDecimal usdPrice,
			BigDecimal apprAmt) {
		this.id = id;
		this.copGNo = copGNo;
		this.codeTs = codeTs;
		this.classMark = classMark;
		this.GName = GName;
		this.GModel = GModel;
		this.unit = unit;
		this.unit1 = unit1;
		this.unit2 = unit2;
		this.countryCode = countryCode;
		this.sourceMark = sourceMark;
		this.decPrice = decPrice;
		this.curr = curr;
		this.decPriceRmb = decPriceRmb;
		this.factor1 = factor1;
		this.factor2 = factor2;
		this.factorWt = factorWt;
		this.factorRate = factorRate;
		this.qty = qty;
		this.maxQty = maxQty;
		this.firstQty = firstQty;
		this.IEType = IEType;
		this.useType = useType;
		this.note1 = note1;
		this.note2 = note2;
		this.note = note;
		this.modifyMark = modifyMark;
		this.GMerge = GMerge;
		this.GTrade = GTrade;
		this.qtyMark = qtyMark;
		this.incAmount = incAmount;
		this.incQty = incQty;
		this.incWt = incWt;
		this.cutAmount = cutAmount;
		this.cutQty = cutQty;
		this.cutWt = cutWt;
		this.cmAmount = cmAmount;
		this.cmQty = cmQty;
		this.cmWt = cmWt;
		this.clrIncQty = clrIncQty;
		this.clrCutQty = clrCutQty;
		this.dutyMode = dutyMode;
		this.dutyRate = dutyRate;
		this.chkPrice = chkPrice;
		this.processMark = processMark;
		this.entryId = entryId;
		this.limitDate = limitDate;
		this.etlMark = etlMark;
		this.usdPrice = usdPrice;
		this.apprAmt = apprAmt;
	}

	public EmsListId getId() {
		return this.id;
	}

	public void setId(EmsListId id) {
		this.id = id;
	}

	public String getCopGNo() {
		return this.copGNo;
	}

	public void setCopGNo(String copGNo) {
		this.copGNo = copGNo;
	}

	public String getCodeTs() {
		return this.codeTs;
	}

	public void setCodeTs(String codeTs) {
		this.codeTs = codeTs;
	}

	public String getClassMark() {
		return this.classMark;
	}

	public void setClassMark(String classMark) {
		this.classMark = classMark;
	}

	public String getGName() {
		return this.GName;
	}

	public void setGName(String GName) {
		this.GName = GName;
	}

	public String getGModel() {
		return this.GModel;
	}

	public void setGModel(String GModel) {
		this.GModel = GModel;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUnit1() {
		return this.unit1;
	}

	public void setUnit1(String unit1) {
		this.unit1 = unit1;
	}

	public String getUnit2() {
		return this.unit2;
	}

	public void setUnit2(String unit2) {
		this.unit2 = unit2;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getSourceMark() {
		return this.sourceMark;
	}

	public void setSourceMark(String sourceMark) {
		this.sourceMark = sourceMark;
	}

	public BigDecimal getDecPrice() {
		return this.decPrice;
	}

	public void setDecPrice(BigDecimal decPrice) {
		this.decPrice = decPrice;
	}

	public String getCurr() {
		return this.curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

	public BigDecimal getDecPriceRmb() {
		return this.decPriceRmb;
	}

	public void setDecPriceRmb(BigDecimal decPriceRmb) {
		this.decPriceRmb = decPriceRmb;
	}

	public BigDecimal getFactor1() {
		return this.factor1;
	}

	public void setFactor1(BigDecimal factor1) {
		this.factor1 = factor1;
	}

	public BigDecimal getFactor2() {
		return this.factor2;
	}

	public void setFactor2(BigDecimal factor2) {
		this.factor2 = factor2;
	}

	public BigDecimal getFactorWt() {
		return this.factorWt;
	}

	public void setFactorWt(BigDecimal factorWt) {
		this.factorWt = factorWt;
	}

	public BigDecimal getFactorRate() {
		return this.factorRate;
	}

	public void setFactorRate(BigDecimal factorRate) {
		this.factorRate = factorRate;
	}

	public BigDecimal getQty() {
		return this.qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public BigDecimal getMaxQty() {
		return this.maxQty;
	}

	public void setMaxQty(BigDecimal maxQty) {
		this.maxQty = maxQty;
	}

	public BigDecimal getFirstQty() {
		return this.firstQty;
	}

	public void setFirstQty(BigDecimal firstQty) {
		this.firstQty = firstQty;
	}

	public String getIEType() {
		return this.IEType;
	}

	public void setIEType(String IEType) {
		this.IEType = IEType;
	}

	public String getUseType() {
		return this.useType;
	}

	public void setUseType(String useType) {
		this.useType = useType;
	}

	public String getNote1() {
		return this.note1;
	}

	public void setNote1(String note1) {
		this.note1 = note1;
	}

	public String getNote2() {
		return this.note2;
	}

	public void setNote2(String note2) {
		this.note2 = note2;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getModifyMark() {
		return this.modifyMark;
	}

	public void setModifyMark(String modifyMark) {
		this.modifyMark = modifyMark;
	}

	public String getGMerge() {
		return this.GMerge;
	}

	public void setGMerge(String GMerge) {
		this.GMerge = GMerge;
	}

	public String getGTrade() {
		return this.GTrade;
	}

	public void setGTrade(String GTrade) {
		this.GTrade = GTrade;
	}

	public String getQtyMark() {
		return this.qtyMark;
	}

	public void setQtyMark(String qtyMark) {
		this.qtyMark = qtyMark;
	}

	public BigDecimal getIncAmount() {
		return this.incAmount;
	}

	public void setIncAmount(BigDecimal incAmount) {
		this.incAmount = incAmount;
	}

	public BigDecimal getIncQty() {
		return this.incQty;
	}

	public void setIncQty(BigDecimal incQty) {
		this.incQty = incQty;
	}

	public BigDecimal getIncWt() {
		return this.incWt;
	}

	public void setIncWt(BigDecimal incWt) {
		this.incWt = incWt;
	}

	public BigDecimal getCutAmount() {
		return this.cutAmount;
	}

	public void setCutAmount(BigDecimal cutAmount) {
		this.cutAmount = cutAmount;
	}

	public BigDecimal getCutQty() {
		return this.cutQty;
	}

	public void setCutQty(BigDecimal cutQty) {
		this.cutQty = cutQty;
	}

	public BigDecimal getCutWt() {
		return this.cutWt;
	}

	public void setCutWt(BigDecimal cutWt) {
		this.cutWt = cutWt;
	}

	public BigDecimal getCmAmount() {
		return this.cmAmount;
	}

	public void setCmAmount(BigDecimal cmAmount) {
		this.cmAmount = cmAmount;
	}

	public BigDecimal getCmQty() {
		return this.cmQty;
	}

	public void setCmQty(BigDecimal cmQty) {
		this.cmQty = cmQty;
	}

	public BigDecimal getCmWt() {
		return this.cmWt;
	}

	public void setCmWt(BigDecimal cmWt) {
		this.cmWt = cmWt;
	}

	public BigDecimal getClrIncQty() {
		return this.clrIncQty;
	}

	public void setClrIncQty(BigDecimal clrIncQty) {
		this.clrIncQty = clrIncQty;
	}

	public BigDecimal getClrCutQty() {
		return this.clrCutQty;
	}

	public void setClrCutQty(BigDecimal clrCutQty) {
		this.clrCutQty = clrCutQty;
	}

	public String getDutyMode() {
		return this.dutyMode;
	}

	public void setDutyMode(String dutyMode) {
		this.dutyMode = dutyMode;
	}

	public BigDecimal getDutyRate() {
		return this.dutyRate;
	}

	public void setDutyRate(BigDecimal dutyRate) {
		this.dutyRate = dutyRate;
	}

	public BigDecimal getChkPrice() {
		return this.chkPrice;
	}

	public void setChkPrice(BigDecimal chkPrice) {
		this.chkPrice = chkPrice;
	}

	public String getProcessMark() {
		return this.processMark;
	}

	public void setProcessMark(String processMark) {
		this.processMark = processMark;
	}

	public String getEntryId() {
		return this.entryId;
	}

	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

	public Date getLimitDate() {
		return this.limitDate;
	}

	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}

	public String getEtlMark() {
		return this.etlMark;
	}

	public void setEtlMark(String etlMark) {
		this.etlMark = etlMark;
	}

	public BigDecimal getUsdPrice() {
		return this.usdPrice;
	}

	public void setUsdPrice(BigDecimal usdPrice) {
		this.usdPrice = usdPrice;
	}

	public BigDecimal getApprAmt() {
		return this.apprAmt;
	}

	public void setApprAmt(BigDecimal apprAmt) {
		this.apprAmt = apprAmt;
	}

}
