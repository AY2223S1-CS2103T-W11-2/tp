---
layout: page
title: User Guide
---

ProfNUS is a **desktop application which helps SOC Professors who have many modules with many students/TAs to manage.** It is optimized for users who prefer CLI over GUI so that frequent tasks can be done faster by typing in commands.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `ProfNUS.jar` from [here](https://github.com/AY2223S1-CS2103T-W11-2/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your ProfNUS application.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all students and teaching assistants.

   * **`add`**`n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 i/A0837092R t/@john_doe c/CS2030S cg/CS2030S:Tut07`: Adds a student named `John Doe` to the ProfNUS application.

   * **`delstu`**`3` : Deletes the 3rd student shown in the current list of students.

   * **`clear`** : Deletes all students, teaching assistants, modules and schedules.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

### Viewing help : `help`

Shows a message explaining how to access the help page.

Format: `help`


### Adding a student/teaching assistant: `add`

Adds a student/teaching assistant to the module.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​ [c/MODULE]…​ [ta/TAMODULE]…​ [cg/CLASSGROUPS]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A student can have any number of tags, modules, ta modules and class groups (including 0).
</div>

Examples:
* `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01`
* `add n/Adam Doink e/ad4md01nk@example.com a/Kent Ridge Hall p/1234567 c/CS1101S cg/CS1101S:Tut07`
* `add n/David Lim e/ad4md01nk@example.com a/Tembusu College p/82738419 c/CS2030S ta/CS1101S cg/CS1101S:Tut07`


### Adding a module: `madd`

Adds a module to the ProfNUS.

Format: `madd n/MODULE NAME c/MODULE CODE d/MODULE DESCRIPTION [t/TAG]…​ `

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags or modules(including 0)
</div>

Examples:
* `madd n/Introduction to SWE c/CS2103T d/Teach students SWE principles and practices t/ModuleCoordinator`
* `madd n/Introduction to Cybersecurity c/CS2107 d/Cryptography practices t/NEW t/URGENT`

### Listing all students : `list`

Shows a list of all the students and teaching assistants in ProfNUS with their contact information in the application.

Format: `list`

Examples:

![list](images/userguide/list.png)


### Viewing list of modules : `mlist`

Shows a list of all modules in the ProfNUS application.
You can click on each module to view more details about the module.

![mlist](images/userguide/mlist.png)

Format: `mlist`

### Viewing more details of a module in the list of modules : `vtarget`

You can also choose to use a CLI-command to get more information about a module in the ProfNUS application
at your specified `INDEX`.
More information such as name of the module and module description,
as well as any tags given to the module will be displayed.

Format: `vtarget INDEX`

Examples: `vtarget 3`

### Viewing module details : `mview`

Shows a list of students and tutors in the module.

![mlist](images/userguide/mview.png)

Format: `mview [c/MODULE_CODE]`

* Views the list of students and tutors at the specified `MODULE_CODE`.

Examples:
*  `mview c/CS1101S` Views the list of students and tutors in CS1101S.

### Editing a student : `editstu`

Edits an existing student in the ProfNUS application.

Format: `editstu INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​ [c/MODULE]…​ [ta/TAMODULE]…​ [cg/CLASSGROUPS]…​`

* Edits the student at the specified `INDEX`. The index refers to the index number shown in the displayed student list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, modules, ta modules and class groups, the existing information of the student will be removed i.e adding of tags is not cumulative.
* You can remove all the student’s tags by typing `t/` without
    specifying any tags after it.

Examples:
*  `editstu 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st student to be `91234567` and `johndoe@example.com` respectively.
*  `editstu 2 n/Betsy Crower ta/` Edits the name of the 2nd student to be `Betsy Crower` and clears all ta modules.


### Editing a teaching assistant : `editta`

Edits an existing teaching assistant in the ProfNUS application.

Format: `editta INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​ [c/MODULE]…​ [ta/TAMODULE]…​ [cg/CLASSGROUPS]…​`

* Edits the teaching assistant at the specified `INDEX`. The index refers to the index number shown in the displayed teaching assistant list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, modules, ta modules and class groups, the existing information of the teaching assistant will be removed i.e adding of tags is not cumulative.
* You can remove all the teaching assistant’s modules by typing `c/` without
  specifying any modules after it.

Examples:
*  `editta 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st teaching assistant to be `91234567` and `johndoe@example.com` respectively.
*  `editta 2 n/Betsy Crower ta/` Edits the name of the 2nd teaching assistant to be `Betsy Crower` and clears all ta modules.


### Locating students by name: `find`

Finds students/teaching assistants whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `find John` returns `john` and `John Doe`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>

### Deleting a student : `delstu`

Deletes the specified student from the ProfNUS application.

Format: `delstu INDEX`

* Deletes the student at the specified `INDEX`.
* The index refers to the index number shown in the displayed student list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd student in the list of students.
* `find Betsy` followed by `delete 1` deletes the 1st student in the results of the `find` command.

### Deleting a teaching assistant : `delta`

Deletes the specified teaching assistant from the ProfNUS application.

Format: `delta INDEX`

* Deletes the teaching assistant at the specified `INDEX`.
* The index refers to the index number shown in the displayed teaching assistant list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delta 2` deletes the 2nd teaching assistant in the list of teaching assistants.
* `find Betsy` followed by `delta 1` deletes the 1st teaching assistant in the results of the `find` command.

### Deleting a module: `mdel`

Deletes a module stored in the ProfNUS.

Format: `mdel c/MODULE CODE`

Examples:
* `mdel c/CS2103T`

### Add a teaching schedule `sadd`

Adds a schedule of a module in the ProfNUS.

**Format**: `sadd m/MODULE_CODE w/WEEKDAY ct/PERIOD cc/CLASS_TYPE cv/VENUE `

- Adds a schedule with the module it belongs to, the weekday, the time period, the type of the class, and the venue.
- `MODULE_CODE` needs to abide by the [Module Code Format of NUS](https://www.nus.edu.sg/registrar/docs/info/nusbulletin/AY201213_GeneralInformation.pdf)
- The `WEEKDAY` should be one of `Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`, `Saturday` and `Sunday`.
- The `PERIOD` includes the start time and the end time which are both in the format of the *modern 24-hour clock*.
- The `CLASS_TYPE` should be one of `lec`, `tut`, `lab`, and `rec`, which represent lecture, tutorial, laborartory, and reflection respectively.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
Please make sure you have added the module with `MODULE_CODE` before you add any schedules with `MODULE_CODE`. Otherwise, ProfNUS will consider the command to be invalid.
</div>

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If the schedule to be added conflicts with any existing schedule, the ProfNUS will not perform any operation.
</div>


**Example**: `sadd m/CS2103T w/Wednesday ct/11:00-12:00 cc/tut cv/Zoom`


### Edit a schedule `sedit`

Edits a schedule in the ProfNUS.

**Format**: `sedit INDEX [m/MODULE_CODE] [w/WEEKDAY] [ct/PERIOD] [cc/CLASS_TYPE] [cv/VENUE] `

- The `INDEX` needs to be a positive integer and refers to the index number shown in the displayed schedule list.
- At least one of the optional fields must be provided.
- All optional fileds must abide by the requirements given in the feature ***Add a schedule `sadd`***, if any.

**Example**: `sedit 3 w/Wednesday ct/09:00-10:00 cv/COM2-0218`


### Delete a schedule `sdelete`

Deletes a schedule from the ProfNUS.

**Format**: `sdelete INDEX`

- The `INDEX` needs to be a positive integer and refers to the index number shown in the displayed schedule list.

**Example**: `sdelete 2`


### Clear your teaching schedule: `sclear`

Clears some selected schedules/all schedules from the ProfNUS.

**Format**: `sclear`
**Format**: `sclear [m/MODULE_CODE] [m/MORE_MODULE_CODES]`

- If only one single command `sclear`, it will clear all schedules.
- `[m/MODULE_CODE]` can be optional or more than one.
- `sclear [m/MODULE_CODE_1] [m/MODULE_CODE_2]` will clear all `MODULE_CODE_1` and `MODULE_CODE_2` schedules.
- If all `[m/MODULE_CODE]` don't exist, it will not clear any schedules.

**Example**: `sclear m/CS2103T m/CS2103`



### View your teaching schedule: `view`

Shows the list of some selected schedules/all schedules from the ProfNUS.

**Format**: `view`
**Format**: `view [m/MODULE_CODE] [m/MORE_MODULE_CODES] [w/WEEKDAY] [w/MORE_WEEKDAYS]`

- If only one single command `view`, it will show the list all schedules.
- `[m/MODULE_CODE]`and`[w/WEEKDAY]`can be optional or more than one.
- `view [m/MODULE_CODE_1] [m/MODULE_CODE_2] [w/WEEKDAY] [w/WEEKDAY_2]` will show all schedules of `MODULE_CODE_1`and`MODULE_CODE_2` as well as schedules either on `WEEKDAY` or `WEEKDAY_2`.
- If all `[m/MODULE_CODE]` don't exist or they have no schedules, it will show empty list.

**Example**: `view m/CS2103T m/CS2103`

### View your teaching schedule: `tview`

Shows the timetable of all schedules from the ProfNUS.

**Format**: `tview`
**Example**: `tview`

### Clearing all entries : `clear`

Clears all entries from the ProfNUS application.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

ProfNUS data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data
ProfNUS data are saved as a JSON file `[JAR file location]/data/profnus.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, ProfNUS will discard all data and start with an empty data file at the next run.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous ProfNUS home folder.

--------------------------------------------------------------------------------------------------------------------


## Command summary

| Action                                | Format                                                                                                             | Example                                                                                                                                                                     |
|---------------------------------------|--------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| add a student/teaching assistant      | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​ [c/MODULE]…​ [ta/TAMODULE]…​ [cg/CLASSGROUPS]…​`            | `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` <br> `add n/Adam Doink t/TA e/ad4md01nk@example.com a/Kent Ridge Hall p/1234567 m/CS1101S` |
| edit a student                        | `editstu INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​ [c/MODULE]…​ [ta/TAMODULE]…​ [cg/CLASSGROUPS]…​` | `editstu 1 p/91234567 e/johndoe@example.com` <br> `editstu 2 n/Betsy Crower c/`                                                                                             |
| edit a teaching assistant             | `editta INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​ [c/MODULE]…​ [ta/TAMODULE]…​ [cg/CLASSGROUPS]…​`  | `editta 1 p/97384723 e/davidlim@example.com` <br> `editta 2 n/Beth ta/CS2030S`                                                                                              |
| delete a student                      | `delstu INDEX`                                                                                                     | `delstu 1`                                                                                                                                                                  |
| delete a teaching assistant           | `delta INDEX`                                                                                                      | `delta 1`                                                                                                                                                                   |
| clear                                 | `clear`                                                                                                            | `clear`                                                                                                                                                                     |
| add a module                          | `madd`                                                                                                             | `madd CS2100`                                                                                                                                                               |
| list all students/teaching assistants | `list`                                                                                                             | `list`                                                                                                                                                                      |
| list all modules                      | `mlist`                                                                                                            | `mlist`                                                                                                                                                                     |
| view the teaching schedule            | `view schedule [-w WEEKDAY] [-m MODULE_CODE] [-d DATE] [-h] [-v]`                                                  | `view schedule -w Monday -m CS2103T` <br>`view schedule -d 2022-09-12` <br> `view schedule -h`                                                                              |
| find a student/teaching assistant     | `find KEYWORD [MORE_KEYWORD]`                                                                                      | `find Adam Do`                                                                                                                                                              |
| help                                  | `help`                                                                                                             | `help`                                                                                                                                                                      |
| exit                                  | `exit`                                                                                                             | `exit`                                                                                                                                                                      |

