package seedu.address.logic.commands.schedule;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MODULE_OF_SCHEDULE;

import java.util.ArrayList;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.module.ModuleCode;

/**
 * Clears all schedules which satisfies selection requirements.
 */
public class ClearScheduleCommand extends Command {
    public static final String COMMAND_WORD = "sclear";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Clears all schedules which satisfy all selection "
            + "requirements.\n"
            + "Format: sclear [ " + PREFIX_MODULE_OF_SCHEDULE + "MODULE_CODE] [" + PREFIX_MODULE_OF_SCHEDULE
            + " MORE_MODULE_CODES]" + "\n"
            + "Example: " + COMMAND_WORD + PREFIX_MODULE_OF_SCHEDULE + " cs2103t\n";
    public static final String MESSAGE_CLEAR_ALL_SCHEDULES_SUCCESS = "Clear those schedules successfully!";

    private final ArrayList<ModuleCode> modulesToClear;

    public ClearScheduleCommand() {
        modulesToClear = null;
    }

    /**
     * Constructor of ClearScheduleCommand
     * @param modulesToClear List of ModuleCode to clear.
     */
    public ClearScheduleCommand(ArrayList<ModuleCode> modulesToClear) {
        this.modulesToClear = new ArrayList<>();
        this.modulesToClear.addAll(modulesToClear);
    }
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.clearSchedules(modulesToClear);
        return new CommandResult(MESSAGE_CLEAR_ALL_SCHEDULES_SUCCESS,
                false, false, false, false,
                false, true, false);
    }
}
