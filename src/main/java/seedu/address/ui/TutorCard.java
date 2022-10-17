package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Student;

/**
 * An UI component that displays information of a {@code Tutor}.
 */
public class TutorCard extends UiPart<Region> {
    private static final String FXML = "TutorListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Student tutor;

    @javafx.fxml.FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label email;
    @FXML
    private Label studentID;
    @FXML
    private Label telegram;
    @FXML
    private FlowPane tags;
    @FXML
    private FlowPane studentModuleInfo;

    /**
     * Creates a {@code StudentCode} with the given {@code Student} and index to display.
     */
    public TutorCard(Student tutor, int displayedIndex) {
        super(FXML);
        this.tutor = tutor;
        id.setText(displayedIndex + ". ");
        name.setText(tutor.getName().fullName);
        phone.setText("Phone: " + tutor.getPhone().value);
        address.setText("Address: " + tutor.getAddress().value);
        email.setText("Email: " + tutor.getEmail().value);
        tutor.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
        studentID.setText("(" + tutor.getId() + ")");
        telegram.setText("Telegram: " + tutor.getTelegramHandle());
        tutor.getStudentModuleInfo().stream()
                .sorted(Comparator.comparing(moduleCode -> moduleCode.fullCode))
                .forEach(moduleCode -> studentModuleInfo.getChildren().add(new Label(moduleCode.fullCode)));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof TutorCard)) {
            return false;
        }

        // state check
        TutorCard card = (TutorCard) other;
        return id.getText().equals(card.id.getText())
                && tutor.equals(card.tutor);
    }
}
