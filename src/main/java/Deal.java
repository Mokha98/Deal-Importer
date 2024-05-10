public class Deal {
    private String dealUniqueId;
    private String fromCurrencyISOCode;
    private String toCurrencyISOCode;
    private long dealTimestamp;
    private double dealAmount;

    // Constructors, getters, and setters
    public String getDealUniqueId() {
        return dealUniqueId;
    }

    public void setDealUniqueId(String dealUniqueId) {
        this.dealUniqueId = dealUniqueId;
    }

    public String getFromCurrencyISOCode() {
        return fromCurrencyISOCode;
    }

    public void setFromCurrencyISOCode(String fromCurrencyISOCode) {
        this.fromCurrencyISOCode = fromCurrencyISOCode;
    }

    public String getToCurrencyISOCode() {
        return toCurrencyISOCode;
    }

    public void setToCurrencyISOCode(String toCurrencyISOCode) {
        this.toCurrencyISOCode = toCurrencyISOCode;
    }

    public long getDealTimestamp() {
        return dealTimestamp;
    }

    public void setDealTimestamp(long dealTimestamp) {
        this.dealTimestamp = dealTimestamp;
    }

    public double getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(double dealAmount) {
        this.dealAmount = dealAmount;
    }

    public Deal(String dealUniqueId, String fromCurrencyISOCode, String toCurrencyISOCode, long dealTimestamp, double dealAmount) {
        this.dealUniqueId = dealUniqueId;
        this.fromCurrencyISOCode = fromCurrencyISOCode;
        this.toCurrencyISOCode = toCurrencyISOCode;
        this.dealTimestamp = dealTimestamp;
        this.dealAmount = dealAmount;
    }


}
