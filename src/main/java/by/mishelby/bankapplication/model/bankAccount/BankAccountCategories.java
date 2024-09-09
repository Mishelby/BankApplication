package by.mishelby.bankapplication.model.bankAccount;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Data
@Component
public class BankAccountCategories {
    private Set<String> categories = Set.of(
            "Transfer", "Health", "Education", "Game", "Withdrawal" , "Replenishment"
    );

    public boolean isValidCategory(String category) {
        return categories.contains(category);
    }

    public Set<String> getCategories(Set<String> categories) {
        Set<String> result = new HashSet<>();
        for (String category : categories) {
            if (isValidCategory(category)) {
                result.add(category);
            }
        }
        return result;
    }
}
