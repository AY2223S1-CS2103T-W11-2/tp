package seedu.address.logic.commands.schedules;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalSchedules.getTypicalProfNusWithSchedules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.CommandTestUtil;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.commands.schedule.ViewScheduleCommand;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.module.schedule.ScheduleContainsKeywordsPredicate;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ViewScheduleCommand.
 */
public class ViewScheduleCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalProfNusWithSchedules(), new UserPrefs());
        expectedModel = new ModelManager(model.getProfNus(), new UserPrefs());
    }

    @Test
    public void equals() {
        ScheduleContainsKeywordsPredicate firstPredicate =
                new ScheduleContainsKeywordsPredicate(Collections.singletonList("first"));
        ScheduleContainsKeywordsPredicate secondPredicate =
                new ScheduleContainsKeywordsPredicate(Collections.singletonList("second"));

        Set<String> first = new HashSet<>();
        first.add("first");

        Set<String> second = new HashSet<>();
        second.add("second");

        ViewScheduleCommand viewFirstCommand = new ViewScheduleCommand(firstPredicate, first);
        ViewScheduleCommand viewFirstCommandCopy = new ViewScheduleCommand(firstPredicate, first);
        ViewScheduleCommand viewSecondCommand = new ViewScheduleCommand(secondPredicate, second);
        ViewScheduleCommand viewEmptyCommand = new ViewScheduleCommand();
        ViewScheduleCommand viewEmptyCommandCopy = new ViewScheduleCommand();


        // same object -> returns true
        assertTrue(viewFirstCommand.equals(viewFirstCommand));
        assertTrue(viewEmptyCommand.equals(viewEmptyCommand));

        // same values -> returns true
        assertTrue(viewFirstCommand.equals(viewFirstCommandCopy));
        assertTrue(viewEmptyCommand.equals(viewEmptyCommandCopy));

        // different types -> returns false
        assertFalse(viewFirstCommand.equals(1));

        // null -> returns false
        assertFalse(viewFirstCommand.equals(null));

        // different predicate -> returns false
        assertFalse(viewFirstCommand.equals(viewSecondCommand));

    }

    @Test
    public void execute_weekDayPredicate_showScheduleOfWeekdays() {
        ArrayList<String> weekdays = new ArrayList<>();
        weekdays.add("Monday");
        weekdays.add("Friday");
        ArrayList<String> weekdaysTwo = new ArrayList<>();
        weekdays.add("Monday");
        weekdays.add("Wednesday");
        Set<String> noModules = new HashSet<>();

        ScheduleContainsKeywordsPredicate weekdayPredicate =
                new ScheduleContainsKeywordsPredicate(weekdays);

        ScheduleContainsKeywordsPredicate weekdayPredicateTwo =
                new ScheduleContainsKeywordsPredicate(weekdaysTwo);

        assertCommandSuccess(
                new ViewScheduleCommand(weekdayPredicate, noModules), model,
                new CommandResult(String.format(
                        String.format(Messages.MESSAGE_SCHEDULES_LISTED_OVERVIEW,
                                model.getFilteredScheduleList().size())),
                        false, false, false, false,
                        false, false, true, false, false),
                expectedModel);

        assertCommandSuccess(
                new ViewScheduleCommand(weekdayPredicateTwo, noModules), model,
                new CommandResult(String.format(
                        String.format(Messages.MESSAGE_SCHEDULES_LISTED_OVERVIEW,
                                model.getFilteredScheduleList().size())),
                        false, false, false, false,
                        false, false, true, false, false),
                expectedModel);

    }

    @Test
    public void execute_moduleCodePredicate_showScheduleOfModules() {
        ArrayList<String> modulesList = new ArrayList<>();
        modulesList.add("CS2102");
        Set<String> modulesSet = new HashSet<>();
        modulesSet.add("CS2102");


        ScheduleContainsKeywordsPredicate modulePredicate =
                new ScheduleContainsKeywordsPredicate(modulesList);

        expectedModel.updateFilteredScheduleList(modulePredicate);
        CommandResult expectedResult = new CommandResult(String.format(
                String.format(Messages.MESSAGE_SCHEDULES_LISTED_OVERVIEW,
                        expectedModel.getFilteredScheduleList().size())),
                false, false, false, false,
                false, false, true, false, false);

        assertCommandSuccess(
                new ViewScheduleCommand(modulePredicate, modulesSet), model,
                expectedResult, expectedModel);

    }

    @Test
    public void execute_scheduleListIsNotFiltered_showsSameList() {
        CommandTestUtil.assertCommandSuccess(new ViewScheduleCommand(), model,
                new CommandResult(String.format(String.format(
                        Messages.MESSAGE_SCHEDULES_LISTED_OVERVIEW, model.getFilteredScheduleList().size())),
                false, false, false, false,
                false, false, true, false, false),
                expectedModel);
    }

    @Test
    public void execute_emptyProfNus_success() {
        Model curModel = new ModelManager();
        Model curExpectedModel = new ModelManager();
        CommandResult expectedCommandResult = new CommandResult(String.format(
                String.format(Messages.MESSAGE_SCHEDULES_LISTED_OVERVIEW, curModel.getFilteredScheduleList().size())),
                false, false, false, false,
                false, false, true, false, false);
        assertCommandSuccess(new ViewScheduleCommand(), curModel, expectedCommandResult, curExpectedModel);
    }

    @Test
    public void execute_emptyInput_showAllSchedules() {
        assertCommandSuccess(new ViewScheduleCommand(), model,
                new CommandResult(String.format(String.format(
                        Messages.MESSAGE_SCHEDULES_LISTED_OVERVIEW, model.getFilteredScheduleList().size())),
                        false, false, false, false, false,
                        false, true, false, false), expectedModel);
    }

    @Test
    public void execute_nonExistModule_throwCommandException() {

        ArrayList<String> modulesList = new ArrayList<>();
        modulesList.add("AB1111");
        Set<String> modulesSet = new HashSet<>();
        modulesSet.add("AB1111");


        ScheduleContainsKeywordsPredicate modulePredicate =
                new ScheduleContainsKeywordsPredicate(modulesList);
        ViewScheduleCommand viewScheduleCommand = new ViewScheduleCommand(modulePredicate, modulesSet);

        assertThrows(CommandException.class, () -> viewScheduleCommand.execute(model));

    }

}
