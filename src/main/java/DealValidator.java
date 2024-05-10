import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DealValidator {

    private final DealDAO dealDAO;
    private static final Logger logger = Logger.getLogger(DealValidator.class.getName());

    public DealValidator() {
        dealDAO = new DealDAO();
    }

    public boolean validateAndSaveDeal(Deal deal) {
        if (isValidDeal(deal)) {
            dealDAO.saveDeal(deal);
            return true;
        }
        return false;
    }

    private boolean isValidDeal(Deal deal) {
        if (deal == null) {
            logger.log(Level.WARNING, "Deal object is null.");
            return false;
        }

        if (isAnyFieldNullOrEmpty(deal)) {
            logger.log(Level.WARNING, "Invalid deal fields.");
            return false;
        }

        if (dealDAO.doesDealExist(deal.getDealUniqueId())) {
            logger.log(Level.WARNING, "Duplicate deal ID found: " + deal.getDealUniqueId());
            return false;
        }

        if (!isValidISOCode(deal.getFromCurrencyISOCode()) || !isValidISOCode(deal.getToCurrencyISOCode())) {
            logger.log(Level.WARNING, "Invalid ISO code format.");
            return false;
        }

        return true;
    }

    private boolean isAnyFieldNullOrEmpty(Deal deal) {
        return deal.getDealUniqueId() == null || deal.getDealUniqueId().isEmpty() ||
                deal.getFromCurrencyISOCode() == null || deal.getFromCurrencyISOCode().isEmpty() ||
                deal.getToCurrencyISOCode() == null || deal.getToCurrencyISOCode().isEmpty() ||
                deal.getDealTimestamp() <= 0 || deal.getDealAmount() <= 0;
    }

    public void validateAndSaveDeals(List<Deal> deals) {
        List<Deal> validDeals = deals.stream()
                .filter(this::isValidDeal)
                .collect(Collectors.toList());

        dealDAO.saveDeals(validDeals);
    }


    private boolean isValidISOCode(String isoCode) {
        return isoCode.matches("[A-Z]{3}");
    }
}
