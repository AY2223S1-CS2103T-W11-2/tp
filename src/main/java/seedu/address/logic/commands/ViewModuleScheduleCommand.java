package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MODULE_OF_SCHEDULE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_WEEKDAY;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_SCHEDULES;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.module.schedule.ScheduleContainsKeywordsPredicate;

/**
 * Views all slots in the schedule which satisfies selection requirements
 */
public class ViewModuleScheduleCommand extends Command {

    public static final String COMMAND_WORD = "view";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Views all schedules which satisfy all selection "
            + "requirements.\n"
            + "Format: view [ " + PREFIX_WEEKDAY + "WEEKDAY] [ " + PREFIX_WEEKDAY + "MORE_WEEKDAYS] ["
            + PREFIX_MODULE_OF_SCHEDULE + "MODULE_CODE] [" + PREFIX_MODULE_OF_SCHEDULE + " MORE_MODULE_CODES]" + "\n"
            + "Example: " + COMMAND_WORD + " \n"
            + "Example: " + COMMAND_WORD + " " + PREFIX_WEEKDAY + " Friday " + PREFIX_MODULE_OF_SCHEDULE + " cs2103t\n";

    private final ScheduleContainsKeywordsPredicate predicate;

    public ViewModuleScheduleCommand() {
        this.predicate = null;
    }

    public ViewModuleScheduleCommand(ScheduleContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        if (this.predicate == null) {
            model.updateFilteredScheduleList(PREDICATE_SHOW_ALL_SCHEDULES);
        } else {

            model.updateFilteredScheduleList(predicate);
        }
        return new CommandResult(String.format(
                String.format(Messages.MESSAGE_SCHEDULES_LISTED_OVERVIEW, model.getFilteredScheduleList().size())),
                false, false, false, false,
                false, true);
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof ViewModuleScheduleCommand
                && predicate.equals(((ViewModuleScheduleCommand) other).predicate));
    }

}
