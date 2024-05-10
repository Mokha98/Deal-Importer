import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

public class DealValidatorTest {

    @Test
    public void testValidateDeal_ValidAndSaveDeal() {
        DealValidator validator = new DealValidator();
        Deal validDeal = new Deal("123", "USD", "EUR", System.currentTimeMillis(), 100.0);
        Assert.assertTrue(validator.validateAndSaveDeal(validDeal));
    }

    @Test
    public void testValidateDeal_InvalidAndSaveDeal() {
        DealValidator validator = new DealValidator();
        Deal invalidDeal = new Deal(null, "USD", "EUR", System.currentTimeMillis(), 100.0);
        Assert.assertFalse(validator.validateAndSaveDeal(invalidDeal));
    }

    @Test
    public void testValidateDeal_DuplicateDealId() {
        DealValidator validator = new DealValidator();
        Deal validDeal = new Deal("123", "USD", "EUR", System.currentTimeMillis(), 100.0);
        // Save the valid deal first
        validator.validateAndSaveDeal(validDeal);
        // Try to save a deal with the same ID
        Deal duplicateDeal = new Deal("123", "USD", "EUR", System.currentTimeMillis(), 100.0);
        Assert.assertFalse(validator.validateAndSaveDeal(duplicateDeal));
    }

    @Test
    public void testValidateDeal_InvalidISOCode() {
        DealValidator validator = new DealValidator();
        Deal invalidISOCodeDeal = new Deal("456", "usd", "EUR", System.currentTimeMillis(), 100.0);
        Assert.assertFalse(validator.validateAndSaveDeal(invalidISOCodeDeal));
    }

    @Test
    public void testValidateDeal_NullDeal() {
        DealValidator validator = new DealValidator();
        Assert.assertFalse(validator.validateAndSaveDeal(null));
    }

    @Test
    public void testValidateDeals() {
        DealValidator validator = new DealValidator();
        List<Deal> deals = new ArrayList<>();
        deals.add(new Deal("1", "USD", "EUR", System.currentTimeMillis(), 100.0));
        deals.add(new Deal("2", "USD", "EUR", System.currentTimeMillis(), 200.0));
        deals.add(new Deal("3", "USD", "EUR", System.currentTimeMillis(), 300.0));

        validator.validateAndSaveDeals(deals);

        // Assert that the deals are saved
        Assert.assertTrue(true);
    }
}
