package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.module.Module;
import seedu.address.model.module.schedule.Schedule;

/**
 * Panel containing the list of modules.
 */
public class ModuleListPanel extends UiPart<Region> {
    private static final String FXML = "ModuleListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ModuleListPanel.class);

    @FXML
    private ListView<Module> moduleListView;
    @FXML
    private ListView<Module> targetModuleView;
    @FXML
    private ListView<Schedule> scheduleListView;

    /**
     * Creates a {@code ModuleListPanel} with the given {@code ObservableList}.
     */
    public ModuleListPanel(ObservableList<Module> moduleList, ObservableList<Schedule> scheduleList) {
        super(FXML);
        moduleListView.setItems(moduleList);
        moduleListView.setCellFactory(listView -> new ModuleListPanel.ModuleListViewCell());
        logger.info("=================[Modules loaded]=================");
        moduleListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Module moduleInterested = moduleListView.getSelectionModel().getSelectedItem();
                ObservableList<Module> list = FXCollections.observableArrayList();
                ObservableList<Schedule> schedules = FXCollections.observableArrayList();
                list.add(moduleInterested);
                moduleInterested.getSchedules().forEach(x -> schedules.add(x));
                targetModuleView.setItems(list);
                targetModuleView.setCellFactory(listView ->
                        new ModulePanel.ModuleViewCell());
                scheduleListView.setItems(schedules);
                scheduleListView.setCellFactory(listView ->
                        new ScheduleListPanel.ScheduleListViewCell());
            }
        });
    }

    @FXML
    public void handleMouseClick(MouseEvent me) {
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Module} using a {@code ModuleCard}.
     */
    class ModuleListViewCell extends ListCell<Module> {

        private EventHandler<MouseEvent> oneClickHandler;
        public ModuleListViewCell() {
            oneClickHandler = new EventHandler<MouseEvent>() {
                // Prevents the list from being updated upon clicking on null area
                @Override
                public void handle(MouseEvent event) {
                }
            };
        }
        @Override
        protected void updateItem(Module module, boolean empty) {
            super.updateItem(module, empty);

            if (empty || module == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new ModuleCard(module, getIndex() + 1).getRoot());
            }
        }
    }

}
